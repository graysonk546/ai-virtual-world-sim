package ca.ubc.ece.cpen221.graphs.two.items.vehicles;

import ca.ubc.ece.cpen221.graphs.two.*;
import ca.ubc.ece.cpen221.graphs.two.ai.VehicleAI;
import ca.ubc.ece.cpen221.graphs.two.commands.Command;
import ca.ubc.ece.cpen221.graphs.two.commands.MoveCommand;
import ca.ubc.ece.cpen221.graphs.two.commands.WaitCommand;
import ca.ubc.ece.cpen221.graphs.two.items.Item;
import ca.ubc.ece.cpen221.graphs.two.items.LivingItem;

import javax.swing.*;

public class Motorcycle implements Vehicle{
    private static final int INITIAL_ENERGY = 100;
    private static final int MAX_ENERGY = 120;
    private static final int VIEW_RANGE = 10;
    private static final int MAXIMUM_COOLDOWN = 4;
    private static final int MAXIMUM_TURNING_SPEED = 3;
    private static final int TURN_CHANCE = 20;
    private static final int MINIMUM_COOLDOWN = 1;
    private static final int STRENGTH_MULTIPLIER = 800; //[200-800]
    private static final int DANGEROUS_SPEED = 2;

    private static final ImageIcon motorcycleImage = Util.loadImage("motorcycles.gif");

    private final VehicleAI ai;
    private Location location;
    private int energy;
    private int cooldown;
    private int strength;
    private Direction currentDirection;
    private boolean isAccelerating = true;
    private boolean isBraking;

        /*
    Abstraction Function:
        Motorcycle is represented by the cooldown, truckImage, strength.
        Speed of vehicle = 1/cooldown
        Maximum speed = 1/MINIMUM_COOLDOWN
        Minimum speed = 1/MAXIMUM_COOLDOWN
        Momentum of vehicle = strength
        Safe speed to turn = 1/MAXIMUM_TURNING_SPEED
        Dangerous speed where it risks crashing = 1/DANGEROUS_SPEED
        location of vehicle on map = location
        View Range in front of vehicle = VIEW_RANGE
        Structural integrity of vehicle = energy

     */

    /*
    Representation Invariant:
        MINIMUM_COOLDOWN <= cooldown <= MAXIMUM_COOLDOWN
        energy < 0
        location should be within world bounds
     */

    public Motorcycle(Location initialLocation){
        this.ai = new VehicleAI();
        this.location = initialLocation;
        this.energy = INITIAL_ENERGY;
        this.cooldown = MAXIMUM_COOLDOWN;
        currentDirection = Util.getRandomDirection();
        this.strength = STRENGTH_MULTIPLIER/MAXIMUM_COOLDOWN;
    }

    @Override
    public Command getNextAction(World world) {
        return ai.getNextAction(world, this);
    }

    @Override
    public int getViewRange() {
        return VIEW_RANGE;
    }

    @Override
    public Direction getDirection() {
        return currentDirection;
    }

    @Override
    public int getMaxTurnSpeed() {
        return MAXIMUM_TURNING_SPEED;
    }

    @Override
    public int getTurnChance() {
        return TURN_CHANCE;
    }

    @Override
    public int getMinCooldown() {
        return MINIMUM_COOLDOWN;
    }

    @Override
    public int getMaxCooldown() {
        return MAXIMUM_COOLDOWN;
    }

    @Override
    public boolean getIsAccelerating() {
        return isAccelerating;
    }

    @Override
    public boolean getIsBraking() {
        return isBraking;
    }

    @Override
    public int getDangerousSpeed() {
        return DANGEROUS_SPEED;
    }

    @Override
    public int getStrengthMultiplier() {
        return STRENGTH_MULTIPLIER;
    }

    @Override
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    @Override
    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    @Override
    public void setAccelerating(boolean accelerating) {
        isAccelerating = accelerating;
    }

    @Override
    public void setBraking(boolean braking) {
        isBraking = braking;
    }

    @Override
    public int getCoolDownPeriod() {
        return cooldown;
    }

    @Override
    public void moveTo(Location targetLocation) {
        location = targetLocation;
    }

    @Override
    public int getMovingRange() {
        return 1;
    }

    @Override
    public ImageIcon getImage() {
        return motorcycleImage;
    }

    @Override
    public String getName() {
        return "Motorcycle";
    }

    @Override
    public Location getLocation() {
        return new Location(location);
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void loseEnergy(int energy) {
        this.energy =- energy;
    }

    @Override
    public boolean isDead() {
        return energy <= 0;
    }

    @Override
    public int getPlantCalories() {
        return 0;
    }

    @Override
    public int getMeatCalories() {
        return 0;
    }
}
