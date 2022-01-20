package ca.ubc.ece.cpen221.graphs.two.ai;

import ca.ubc.ece.cpen221.graphs.two.Direction;
import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.Util;
import ca.ubc.ece.cpen221.graphs.two.World;
import ca.ubc.ece.cpen221.graphs.two.commands.Command;
import ca.ubc.ece.cpen221.graphs.two.commands.MoveCommand;
import ca.ubc.ece.cpen221.graphs.two.commands.WaitCommand;
import ca.ubc.ece.cpen221.graphs.two.items.Item;
import ca.ubc.ece.cpen221.graphs.two.items.vehicles.Vehicle;

public class VehicleAI extends AbstractAI{

    /*
    Abstraction Function:
        The AI logic used by all vehicles that are added to the world. Vehicles behave and find
        direction based on their speed, and it interacts with other items by either destroying the
        object if the object has lower strength, or being destroyed if the object has greater
        strength.
     */

    public VehicleAI() { }

    /**
     * Determines the vehicle's next action based on the vehicle's current speed and its adjacent
     * locations. Returns a command at each time step of the world.
     *
     * @param world the world to which the vehicle has been added
     * @param vehicle the vehicle who's next action will be returned
     * @return the next command on which the vehicle will act
     */
    @Override
    public Command getNextAction(World world, Vehicle vehicle) {
        navigate(world, vehicle);
        manageSpeed(vehicle);
        Direction currentDirection = vehicle.getDirection();
        int cooldown = vehicle.getCoolDownPeriod();
        int dangerousSpeed = vehicle.getDangerousSpeed();

        Location targetLocation = new Location(vehicle.getLocation(), currentDirection);
        if (Util.isValidLocation(world, targetLocation)){
            if (Util.isLocationEmpty(world, targetLocation))
                return new MoveCommand(vehicle, targetLocation);
            else{
                Item itemAtLocation = Util.itemAtLocation(world, targetLocation);
                int targetStrength = itemAtLocation.getStrength();

                //Destroy everything of lower strength regardless of speed
                if (targetStrength < vehicle.getStrength()){
                    itemAtLocation.loseEnergy(Integer.MAX_VALUE);
                    return new MoveCommand(vehicle, targetLocation);
                }
                //at high speeds, the car will die if hitting things of greater than or equal strength
                else if(cooldown <= dangerousSpeed){
                    if(targetStrength == vehicle.getStrength()){
                        itemAtLocation.loseEnergy(Integer.MAX_VALUE);
                        vehicle.loseEnergy(Integer.MAX_VALUE);
                        return new MoveCommand(vehicle, targetLocation);                }
                    else{
                        vehicle.loseEnergy(Integer.MAX_VALUE);
                    }
                }
                //At low speeds, the car will wait if hitting things of greater than or equal strength
                else if(cooldown > dangerousSpeed){
                    return new WaitCommand();
                }

            }
        }
        return new WaitCommand();
    }

    /**
     * Manages the speed of the vehicle.
     * Also changes the strength of the vehicle to increase when increasing speed and decrease when decreasing speed
     * Vehicle speeds up by lowering its cooldown
     * Vehicle slows down by increasing its cooldown
     * @param vehicle vehicle to manage speed
     */
    private void manageSpeed(Vehicle vehicle) {
        boolean isAccelerating = vehicle.getIsAccelerating();
        boolean isBraking = vehicle.getIsBraking();
        int strengthMultiplier = vehicle.getStrengthMultiplier();
        int cooldown = vehicle.getCoolDownPeriod();
        int minCooldown = vehicle.getMinCooldown();
        int maxCooldown = vehicle.getMaxCooldown();
        if(isAccelerating && cooldown > minCooldown){
            vehicle.setCooldown(cooldown-1);
            vehicle.setStrength(strengthMultiplier/cooldown);
        }
        else if(isBraking && cooldown < maxCooldown){
            vehicle.setCooldown(cooldown+1);
            vehicle.setStrength(strengthMultiplier/cooldown);
        }
    }

    /**
     * Determines when the vehicle should turn
     * Determines when the vehicle should speed up or slow down
     * If vehicle is heading towards edge of map, turn left or right
     * Randomly make vehicle turn based on chance
     * Randomly make vehicle speed or slow
     * @param world base world
     * @param vehicle vehicle to navigate
     */
    private void navigate(World world, Vehicle vehicle) {
        Location location = vehicle.getLocation();
        Direction currentDirection = vehicle.getDirection();
        int viewRange = vehicle.getViewRange();
        int turnChance = vehicle.getTurnChance();
        Location locationInView = new Location(location, currentDirection, viewRange);
        if(!Util.isValidLocation(world, locationInView)){
            brake(vehicle);
            turn(1, vehicle);
        }
        else{
            randomizeSpeed(vehicle);
            turn(turnChance, vehicle);
        }
    }

    /**
     * Change the vehicle's acceleration booleans to correspond with accelerating
     * @param vehicle vehicle to accelerate
     */
    private void accelerate(Vehicle vehicle) {
        vehicle.setAccelerating(true);
        vehicle.setBraking(false);
    }

    /**
     * Change the vehicle's acceleration booleans to correspond with decelerating
     * @param vehicle vehicle to decelerate
     */
    private void brake(Vehicle vehicle) {
        vehicle.setBraking(true);
        vehicle.setAccelerating(false);
    }

    /**
     * Change direction that the vehicle is travelling in based on chance
     *
     * Precondition: turnChance > 0
     * @param turnChance an integer that determines how likely the vehicle will turn. Higher turnChance means less likely
     * @param vehicle vehicle to turn
     */
    private void turn(int turnChance, Vehicle vehicle) {
        Direction currentDirection = vehicle.getDirection();
        int turnChanceNum = Util.randomNumber(turnChance, 0);
        if(canTurn(vehicle) && turnChanceNum == 0){
            int directionNum = Util.randomNumber(2, 0);
            if (currentDirection == Direction.EAST || currentDirection == Direction.WEST){
                if(directionNum == 1) vehicle.setCurrentDirection(Direction.NORTH);
                else vehicle.setCurrentDirection(Direction.SOUTH);
            }
            else if(currentDirection == Direction.NORTH || currentDirection == Direction.SOUTH){
                if(directionNum == 1) vehicle.setCurrentDirection(Direction.WEST);
                else vehicle.setCurrentDirection(Direction.EAST);
            }
        }
    }

    /**
     * Determines if vehicle can turn based on its speed and max turning speed
     * @param vehicle vehicle to check if it can turn
     * @return True if vehicle can turn, false otherwise
     */
    private boolean canTurn(Vehicle vehicle)
    {
        return vehicle.getMaxTurnSpeed() <= vehicle.getCoolDownPeriod();
    }

    /**
     * Based on chance, the vehicle will accelerate or brake
     * will only brake if vehicle is at top speed
     * will only accelerate if vehicle is at minimum speed
     * @param vehicle vehicle to randomize speed
     */
    private void randomizeSpeed(Vehicle vehicle) {
        int cooldown = vehicle.getCoolDownPeriod();
        int minCooldown = vehicle.getMinCooldown();
        int maxCooldown = vehicle.getMaxCooldown();
        int toggleAcceleration = Util.randomNumber(30, 1);
        if (toggleAcceleration == 1 && cooldown == minCooldown){
            brake(vehicle);
        }
        else if((toggleAcceleration == 1 ||toggleAcceleration == 2) && cooldown == maxCooldown){
            accelerate(vehicle);
        }
    }
}
