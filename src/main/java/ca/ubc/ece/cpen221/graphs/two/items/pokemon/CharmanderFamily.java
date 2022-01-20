package ca.ubc.ece.cpen221.graphs.two.items.pokemon;

import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.World;
import ca.ubc.ece.cpen221.graphs.two.ai.PokemonAI;
import ca.ubc.ece.cpen221.graphs.two.commands.Command;

import javax.swing.*;

/*
Class description:
    - CharmanderFamily represents a generic version of all pokemon that evolve from charmander
    - members of the CharmanderFamily inherit the characteristics of pokemon (namely the ability to evolve)
    - members of the CharmanderFamily seek other items in the world to destroy these items and gain xp
 */
public abstract class CharmanderFamily implements Pokemon {

    //relevant constants to CharmanderFamily
    private static final int STRENGTH = Integer.MAX_VALUE;

    //instance variables consistent with all members of the charmander family
    private int energy;
    private int experiencePoints;
    private Location location;
    private final PokemonAI ai;

    /*
    Abstraction Function:
        - STRENGTH represents the static energy of the instance of charmanderFamily
        - this.energy represents the energy an instance of the charmanderFamily
        - this.experiencePoints represents the XP an instance of charmanderFamily has
        - this.location represents the location of the instance of charmanderFamily within the world
        - this.ai represents the intelligence that governs the movements of members of charmanderFamily

    Rep Invariant:
        - location is not null and represents a valid location within the world
        - ai is not null and points to an instance of pokemon ai
        - energy is > 0 or method isDead returns true and instance is removed from the world
     */

    public CharmanderFamily(Location initialLocation, int energy, int experiencePoints){
        this.energy = energy;
        this.experiencePoints = experiencePoints;
        location = initialLocation;
        ai = new PokemonAI();
    }

    //actor methods
    @Override
    public abstract int getCoolDownPeriod();

    @Override
    public Command getNextAction(World world) {
        return ai.getNextAction(world,this);
    }

    //food methods
    @Override
    public int getPlantCalories(){
        //cannot be consumed
        return 0;
    }

    @Override
    public int getMeatCalories(){
        //cannot be consumed
        return 0;
    }

    //item methods
    @Override
    public abstract ImageIcon getImage();

    @Override
    public abstract String getName();

    @Override
    public Location getLocation(){
        return new Location(location);
    }

    @Override
    public int getStrength(){
        //maximum possible strength
        return STRENGTH;
    }

    @Override
    public void loseEnergy(int energy){
        this.energy = this.energy-energy;
    }

    @Override
    public boolean isDead(){
        return energy <= 0;
    }

    //move-able item methods
    @Override
    public void moveTo(Location targetLocation){
        location = new Location(targetLocation);
    }

    @Override
    public abstract int getMovingRange();

    //pokemon methods
    @Override
    public int getExperience(){
        return experiencePoints;
    }

    @Override
    public void addExperience(int experience){
        experiencePoints += experience;
    }

    @Override
    public Pokemon evolve(){
        if(this.getName().equals("Charmander")){
            int energy = this.energy;
            this.loseEnergy(Integer.MAX_VALUE);
            return new Charmeleon(location,energy,experiencePoints);
        } else {
            int energy = this.energy;
            this.loseEnergy(Integer.MAX_VALUE);
            return new Charizard(location,energy,experiencePoints);
        }
    }

    @Override
    public abstract int getEvoXP();

    @Override
    public abstract int getViewRange();

    @Override
    public abstract int getKillRange();
}
