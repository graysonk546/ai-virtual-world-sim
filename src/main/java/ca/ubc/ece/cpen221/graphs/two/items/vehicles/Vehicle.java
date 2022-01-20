package ca.ubc.ece.cpen221.graphs.two.items.vehicles;

import ca.ubc.ece.cpen221.graphs.two.Actor;
import ca.ubc.ece.cpen221.graphs.two.Direction;
import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.World;
import ca.ubc.ece.cpen221.graphs.two.items.LivingItem;
import ca.ubc.ece.cpen221.graphs.two.items.MoveableItem;

/**
 * Abstractions for vehicles that have properties of MoveableItems.
 * Vehicles can move only to adjacent spaces.
 * Vehicles can accelerate, decelerate, and turn.
 * Vehicles die if they hit something of greater or equal strength
 */
public interface Vehicle extends MoveableItem, Actor {

    /**
     * Returns the range of the vehicle's vision. The range is dependent on the direction that the vehicle is moving.
     * If the vehicle has a view range of 8, and the vehicle is moving north, then the view range will be a
     * vertical 3*8 rectangle. Similarly, if the If the vehicle has a view range of 9, and the vehicle is moving west,
     * then the view range will be a horizontal 3*9 rectangle
     *
     * @return the view range of the vehicle
     */
    int getViewRange();

    /**
     * return current direction vehicle is travelling
     * @return current direction vehicle is travelling
     */
    Direction getDirection();

    /**
     * get nax turn speed of vehicle
     * @return nax turn speed of vehicle
     */
    int getMaxTurnSpeed();

    /**
     * Get the turn chance of the vehicle
     * @return the turn chance of the vehicle
     */
    int getTurnChance();

    /**
     * get minimum cooldown of vehicle
     * @return minimum cooldown of vehicle
     */
    int getMinCooldown();

    /**
     * get maximum cooldown of vehicle
     * @return maximum cooldown of vehicle
     */
    int getMaxCooldown();

    /**
     * get the accelerating value of vehicle
     * @return the accelerating value of vehicle
     */
    boolean getIsAccelerating();

    /**
     * get the braking value of vehicle
     * @return the braking value of vehicle
     */
    boolean getIsBraking();

    /**
     * get the dangerous speed of the vehicle
     * @return the dangerous speed of the vehicle
     */
    int getDangerousSpeed();

    /**
     * get strength multiplier of the vehicle
     * @return strength multiplier of the vehicle
     */
    int getStrengthMultiplier();

    /**
     * Set the cooldown of the vehicle
     * precondition: cooldown > 0
     * @param cooldown
     */
    void setCooldown(int cooldown);

    /**
     * Set the strength of the vehicle
     * precondition: strength > 0
     * @param strength
     */
    void setStrength(int strength);

    /**
     * Set direction of vehicle
     * @param currentDirection
     */
    void setCurrentDirection(Direction currentDirection);

    /**
     * set accelerating value of vehicle
     * @param accelerating
     */
    void setAccelerating(boolean accelerating);

    /**
     * Set braking value of the vehicle
     * @param braking
     */
    void setBraking(boolean braking);
}
