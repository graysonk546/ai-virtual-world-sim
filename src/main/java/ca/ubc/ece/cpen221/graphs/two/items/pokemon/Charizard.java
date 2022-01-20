package ca.ubc.ece.cpen221.graphs.two.items.pokemon;

import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.Util;

import javax.swing.*;

/*
Class description:
    - Charizard class represents a pokemon called Charizard that is a member of the Charmander family of Pokemon
    - Charizard cannot evolve as it represents the most senior member of the Charmander hierarchy
    - Charizard's movements are still geared towards gaining more experience points
 */
public class Charizard extends CharmanderFamily {

    //relevant constants to Charizard
    private static final int COOL_DOWN = 5;
    private static final int EVO_XP = Integer.MAX_VALUE;
    private static final int VIEW_RANGE = 10;
    private static final int KILL_RANGE = 2;
    private static final int MOVING_RANGE = 2;
    private static final ImageIcon charizardImage = Util.loadImage("charizard[7768].gif");

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

    public Charizard(Location initialLocation,int initialEnergy,int initialXP) {
        super(initialLocation,initialEnergy,initialXP);
    }

    //actor methods
    @Override
    public int getCoolDownPeriod(){
        return COOL_DOWN;
    }

    //item methods
    @Override
    public ImageIcon getImage(){
        return charizardImage;
    }

    @Override
    public String getName(){
        return "Charizard";
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
