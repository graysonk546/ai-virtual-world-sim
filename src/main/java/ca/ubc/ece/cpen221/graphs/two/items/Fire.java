package ca.ubc.ece.cpen221.graphs.two.items;

import ca.ubc.ece.cpen221.graphs.two.Actor;
import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.Util;
import ca.ubc.ece.cpen221.graphs.two.World;
import ca.ubc.ece.cpen221.graphs.two.commands.Command;
import ca.ubc.ece.cpen221.graphs.two.commands.WaitCommand;

import javax.swing.*;

public class Fire implements Item, Actor {
    private final static ImageIcon fireImage = Util.loadImage("fire.gif");
    private final static int COOLDOWN = 1;
    private final static int INITIAL_ENERGY = 20;
    private final static int STRENGTH = 1;
    private int energy;
//    private boolean isDead
    private Location location;

    /*
     Abstraction Function:
        fireImage: the image of fire displayed on the map
        energy: the health of the fire
        STRENGTH: the fire's ability to prevent other items from destroying it
        COOLDOWN: the number of time steps for the fire to decrease in energy
        location: Where the fire is located in the world
     */
    /*
    Representation Invariant:
        energy >= 0
        location with world bounds
     */

    /**
     * Start fire at <code> location </code>. The location must be valid and
     * empty
     *
     * @param location : the location where this fire will be created
     */
    public Fire(Location location) {
        this.location = location;
        this.energy = INITIAL_ENERGY;
    }

    @Override
    public ImageIcon getImage() {
        return fireImage;
    }

    @Override
    public String getName() {
        return "fire";
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public int getPlantCalories() {
        return 0;
    }

    @Override
    public int getMeatCalories() {
        return 0;
    }

    @Override
    public void loseEnergy(int energy) {
        this.energy -= energy;
    }

    @Override
    public boolean isDead() {
        return this.energy <= 0;
    }


    @Override
    public int getStrength() {
        return STRENGTH;
    }

    @Override
    public int getCoolDownPeriod() {
        return COOLDOWN;
    }

    @Override
    public Command getNextAction(World world) {
        int roll = Util.randomNumber(10, 0);
        if(roll < 7) loseEnergy(1);
        return new WaitCommand();
    }
}
