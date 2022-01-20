package ca.ubc.ece.cpen221.graphs.two.items.animals;

import ca.ubc.ece.cpen221.graphs.two.ArenaWorld;
import ca.ubc.ece.cpen221.graphs.two.Food;
import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.Util;
import ca.ubc.ece.cpen221.graphs.two.World;
import ca.ubc.ece.cpen221.graphs.two.ai.AI;
import ca.ubc.ece.cpen221.graphs.two.commands.Command;
import ca.ubc.ece.cpen221.graphs.two.items.LivingItem;

import javax.swing.ImageIcon;

public class Rhino implements ArenaAnimal {

    private static final int INITIAL_ENERGY = 300;
    private static final int MAX_ENERGY = 600;
    private static final int STRENGTH = 2000;
    private static final int VIEW_RANGE = 7;
    private static final int MIN_BREEDING_ENERGY = 500;
    private static final int COOLDOWN = 5;
    private static final ImageIcon rhinoImage = Util.loadImage("rhino_final.gif");

    private final AI ai;

    private Location location;
    private int energy;

    /*
    Abstraction Function:
        Rhinos are represented as a herbivorous ArenaAnimal in the world with the following fields:
            INITIAL_ENERGY: the energy with which rhinos are spawned in the instantiation of the
            world
            MAX_ENERGY: the maximum energy contained in a rhino
            STRENGTH: the strength of a rhino
            VIEW_RANGE: the view range of a rhino in Manhattan distance
            MIN_BREEDING_ENERGY: the minimum energy required to breed
            COOLDOWN: the number of time steps between actions
            rhinoImage: the image of the rhino to be displayed in the UI
            ai: the AI implementation of the rhino
            location: the current location of the rhino on the grid
            energy: the current energy of the rhino

     Representation Invariants:
         - Rhino must have energy > 0, otherwise this.isDead() returns true
         - this.ai is not null
         - Util.isValidLocation(world, this.location) is true for the world that is being run
         - Util.isLocationEmpty(world, this.location) is false for the world that is being run
         - this.getPlantCalories() = 0
     */

    public Rhino(AI rhinoAI, Location initialLocation) {
        this.ai = rhinoAI;
        this.location = initialLocation;
        this.energy = INITIAL_ENERGY;

    }

    @Override
    public int getMaxEnergy() {
        return MAX_ENERGY;
    }

    @Override
    public int getViewRange() {
        return VIEW_RANGE;
    }

    @Override
    public int getMinimumBreedingEnergy() {
        return MIN_BREEDING_ENERGY;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public LivingItem breed() {
        Rhino child = new Rhino(ai, location);
        child.energy = energy / 2;
        this.energy = energy / 2;
        return child;
    }

    @Override
    public void eat(Food food) {
        energy = Math.min(MAX_ENERGY, energy + food.getPlantCalories());
    }

    @Override
    public int getCoolDownPeriod() {
        return COOLDOWN;
    }

    @Override
    public Command getNextAction(World world) {
        Command nextAction = ai.getNextAction(world, this);
        this.energy--; // Loses 1 energy regardless of action.
        return nextAction;
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
        return rhinoImage;
    }

    @Override
    public String getName() {
        return "Rhino";
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public int getStrength() {
        return STRENGTH;
    }

    @Override
    public void loseEnergy(int energy) {
        this.energy = this.energy - energy;
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
        return energy;
    }

}
