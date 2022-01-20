package ca.ubc.ece.cpen221.graphs.two.items.pokemon;

import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.Util;

import javax.swing.*;

/*
Class description:
    - Charmander class represents a pokemon called Charmander that is a member of the Charmander family of Pokemon
    - Charmander evolves to become Charmeleon once a threshold xp of 400 is met
    - Charmander's movements are still geared towards gaining more xp (seeks to kill other items in the world)
 */
public class Charmander extends CharmanderFamily {

    private static final int INITIAL_ENERGY = 500;
    private static final int COOL_DOWN = 10;
    private static final int INITIAL_XP = 0;
    private static final int EVO_XP = 400;
    private static final int VIEW_RANGE = 8;
    private static final int KILL_RANGE = 3;
    private static final int MOVING_RANGE = 2;
    private static final ImageIcon charmanderImage = Util.loadImage("charmander[7770].gif");

    /*
    Abstraction Function:
        - INITIAL_ENERGY represents the initial energy of the Charmander
        - COOL_DOWN represents the number of time steps before Charmander can perform another action
        - INITIAL_XP represents the initial experience points of the Charmander upon creation
        - EVO_EXP represents the experience points required for the Charmander to evolve into a Charmeleon
        - VIEW_RANGE represents the view range of the Charmander within the world
        - KILL_RANGE represents the range within which the Charmander can kill other items in the world
        - MOVING_RANGE represents the number of tiles in the world that the Charmander can move over per time step
        - charmanderImage represents the image of charmander used for visualization in the world GUI

     Rep Invariant:
        - Maintains the rep invariant of the super class CharmanderFamily
     */

    public Charmander(Location initialLocation) {
        super(initialLocation,INITIAL_ENERGY, INITIAL_XP);
    }

    //actor methods
    @Override
    public int getCoolDownPeriod(){
        return COOL_DOWN;
    }

    //item methods
    @Override
    public ImageIcon getImage(){
        return charmanderImage;
    }

    @Override
    public String getName(){
        return "Charmander";
    }

    @Override
    public int getMovingRange(){
        return MOVING_RANGE;
    }

    @Override
    public int getEvoXP(){
        return EVO_XP;
    }

    @Override
    public int getViewRange(){
        return VIEW_RANGE;
    }

    @Override
    public int getKillRange(){
        return KILL_RANGE;
    }
}
