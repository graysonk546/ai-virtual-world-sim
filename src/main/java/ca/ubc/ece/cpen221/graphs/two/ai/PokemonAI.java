package ca.ubc.ece.cpen221.graphs.two.ai;

import ca.ubc.ece.cpen221.graphs.two.*;
import ca.ubc.ece.cpen221.graphs.two.commands.*;
import ca.ubc.ece.cpen221.graphs.two.items.Item;
import ca.ubc.ece.cpen221.graphs.two.items.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PokemonAI extends AbstractAI {

    /*
    Abstraction Function:
        General AI to control pokemon movement and targeting.
        - Pokemon will move towards items in their view range
        - Once an item is in the kill range, then the pokemon calls a kill command
        - They ignore fire and are able to walk over fire.
        - They also can attack other pokemon if they are in range and battle
     */

    public PokemonAI() { }

    /**
     * Determines the pokemon's next action based on the objects that are within its view range.
     * They will always evolve if their exp is greater than the evolution exp threshold, and will
     * move towards objects that it can kill if it spots them in its view range. Returns a
     * command at each time step of the world.
     *
     * @param world the world to which the pokemon has been added
     * @param pokemon the pokemon who's next action will be returned
     * @return the next command on which the pokemon will act
     */
    @Override
    public Command getNextAction(World world, Pokemon pokemon) {
        Location currentLocation = pokemon.getLocation();
        int viewRange = pokemon.getViewRange();
        int killRange = pokemon.getKillRange();
        Set<Item> itemKillList = world.searchSurroundings(currentLocation, killRange);
        Set<Item> filteredItemKillList = new HashSet<>();
        for(Item item : itemKillList){
            if(!item.equals(pokemon) && !item.getName().equals("fire")){
                filteredItemKillList.add(item);
            }
        }
        Set<Item> itemViewList = world.searchSurroundings(currentLocation, viewRange);
        Set<Item> filteredItemViewList = new HashSet<>();
        for(Item item : itemViewList){
            if(!item.equals(pokemon) && !item.getName().equals("fire")){
                filteredItemViewList.add(item);
            }
        }
        if (pokemon.getEvoXP() < pokemon.getExperience()) {
            return new EvolveCommand(pokemon, pokemon.getLocation());
        }
        if(filteredItemKillList.size() > 0){
                return determineKillCommand(pokemon, itemKillList);
        }
            List<List<Item>> itemsInRange = new ArrayList<>();
            for(int i = 0; i < viewRange; i++){
                List<Item> listToAdd = new ArrayList<>();
                itemsInRange.add(listToAdd);
            }

            for (Item i : filteredItemViewList) {
                if(!i.getName().equals("fire")){
                    int range = currentLocation.getDistance(i.getLocation());
                    itemsInRange.get(range - 1).add(i);
                }
            }

            for (int i = 0; i < itemsInRange.size(); i++){
                for(Item item1 : itemsInRange.get(i)){
                    return checkMoves(world, pokemon, item1,
                        currentLocation.getDistance(item1.getLocation()));
                }
            }

            return new WaitCommand();
    }

    /**
     * Given an item, checkMoves determines the next location the pokemon should move to get closer
     * to the item.
     *
     * @param world base world
     * @param pokemon pokemon to move
     * @param i item to move towards
     * @param distance distance between pokemon and item
     * @return MoveCommand towards the given item
     */
    private Command checkMoves(World world, Pokemon pokemon, Item i, int distance) {
        Location up = new Location(pokemon.getLocation(), Direction.NORTH);
        if (up.getDistance(i.getLocation()) < distance
                && Util.isValidLocation(world, up)){
            if (!Util.isLocationEmpty(world, up)) {
                fireWalk(world, up);
                return new MoveCommand(pokemon, up);
            }
            return new MoveCommand(pokemon, up);
        }
        Location right = new Location(pokemon.getLocation(), Direction.EAST);
        if (right.getDistance(i.getLocation()) < distance
                && Util.isValidLocation(world, right)){
            if (!Util.isLocationEmpty(world, right)) {
                fireWalk(world, right);
                return new MoveCommand(pokemon, right);
            }
            return new MoveCommand(pokemon, right);
        }
        Location down = new Location(pokemon.getLocation(), Direction.SOUTH);
        if (down.getDistance(i.getLocation()) < distance
                && Util.isValidLocation(world, down)){
            if (!Util.isLocationEmpty(world, down)) {
                fireWalk(world, down);
                return new MoveCommand(pokemon, down);
            }
            return new MoveCommand(pokemon, down);
        }
        Location left = new Location(pokemon.getLocation(), Direction.WEST);
        if (left.getDistance(i.getLocation()) < distance
                && Util.isValidLocation(world, left)){
            if (!Util.isLocationEmpty(world, left)) {
                fireWalk(world, left);
                return new MoveCommand(pokemon, left);
            }
            return new MoveCommand(pokemon, left);
        }
        return new WaitCommand();
    }

    /**
     * Based on the pokemon calling killCommand, return the corresponding killCommand.
     * Charmaders call CharmanderKillCommand
     * Charmeleons call CharmeleonKillCommand
     * Charizards call CharizardKillCommand
     * @param pokemon pokemon calling a killCommnad
     * @param itemKillList items in the killRange
     * @return a killCommand specific to the pokemon calling it
     */
    private static Command determineKillCommand(Pokemon pokemon, Set<Item> itemKillList){
        String name = pokemon.getName();
        if(name.equals("Charmander")){
            return new CharmanderKillCommand(pokemon,itemKillList);
        } else if(name.equals("Charmeleon")){

            return new CharmeleonKillCommand(pokemon,itemKillList);
        } else {
            return new CharizardKillCommand(pokemon, itemKillList);
        }
    }

    /**
     * Check if the item at a given location is "fire"
     * if so, destroy the fire.
     * This is used to allow pokemon to walk over fire
     * @param world base world
     * @param targetLocation location that the pokemon is moving to
     */
    private static void fireWalk(World world, Location targetLocation){
        Item fireCheck = Util.itemAtLocation(world,targetLocation);
        if(fireCheck.getName().equals("fire")){
            fireCheck.loseEnergy(Integer.MAX_VALUE);
        }
    }
}