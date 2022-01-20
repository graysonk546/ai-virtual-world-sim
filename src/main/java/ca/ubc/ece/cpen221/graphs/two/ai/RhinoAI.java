package ca.ubc.ece.cpen221.graphs.two.ai;

import ca.ubc.ece.cpen221.graphs.two.ArenaWorld;
import ca.ubc.ece.cpen221.graphs.two.Direction;
import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.Util;
import ca.ubc.ece.cpen221.graphs.two.commands.BreedCommand;
import ca.ubc.ece.cpen221.graphs.two.commands.Command;
import ca.ubc.ece.cpen221.graphs.two.commands.EatCommand;
import ca.ubc.ece.cpen221.graphs.two.commands.MoveCommand;
import ca.ubc.ece.cpen221.graphs.two.commands.WaitCommand;
import ca.ubc.ece.cpen221.graphs.two.items.Item;
import ca.ubc.ece.cpen221.graphs.two.items.LivingItem;
import ca.ubc.ece.cpen221.graphs.two.items.animals.ArenaAnimal;
import ca.ubc.ece.cpen221.graphs.two.items.animals.Rhino;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RhinoAI extends AbstractAI {

    /*
    Abstraction Function:
        The AI logic used by all rhinos that are added to the world. Rhinos behave on a priority
        list in its getNextAction method. From highest priority to lowest:
            1. If the rhino's energy is above the minimum breeding energy, it will breed.
            2. If there is grass adjacent to the rhino it will eat it.
            3. If there is grass in the view range of the rhino, it will move towards the closest
               instance, using the checkMoves method.
            4. Otherwise, it will move in a random direction
            5. If it cannot move in a random direction, it will stand still.
        - MIN_BREEDING_ENERGY is the minimum breeding energy of all rhino objects
        - VIEW_RANGE is the view range of all rhino objects
     */

    public RhinoAI() { }

    /**
     * Determines the rhino's next action based on the objects that are within its view range. They
     * will always breed if their energy has reached the minimum energy that a rhino needs to breed.
     * It moves towards grass if it sees it in its view range.
     * Returns a command at each time step of the world.
     *
     * @param world the world in which the rhino has been added
     * @param animal the rhino who's next action will be returned
     * @return the next command on which the rhino will act
     */
    @Override
    public Command getNextAction(ArenaWorld world, ArenaAnimal animal) {
        Set<Item> surroundingItems = world.searchSurroundings(animal);
        Location current = animal.getLocation();
        int minBreedingEnergy = animal.getMinimumBreedingEnergy();
        int viewRange = animal.getViewRange();

        if (animal.getEnergy() > minBreedingEnergy) {
            int x = current.getX();
            int y = current.getY();
            List<Location> neighbouringLocations = new ArrayList<>();
            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    Location newLoc = new Location(i, j);
                    if (this.isLocationEmpty(world, animal, newLoc) &&
                        Util.isValidLocation(world, newLoc)) {
                        neighbouringLocations.add(newLoc);
                    }
                }
            }
            if (neighbouringLocations.size() != 0) {
                for (Location l : neighbouringLocations) {
                    return new BreedCommand(animal, l);
                }
            }
        }

        List<List<Item>> itemsInRange = new ArrayList<>();
        for (int i = 0; i < viewRange; i++) {
            List<Item> listToAdd = new ArrayList<>();
            itemsInRange.add(listToAdd);
        }

        for (Item i : surroundingItems) {
            if (i.getName().equals("grass")) {
                int range = current.getDistance(i.getLocation());
                itemsInRange.get(range - 1).add(i);
            }
        }

        for (int i = 0; i < itemsInRange.size(); i++) {
            if (i == 0) {
                for (Item item1 : itemsInRange.get(i)) {
                    return new EatCommand(animal, item1);
                }
            } else {
                for (Item item1 : itemsInRange.get(i)) {
                    return checkMoves(world, animal, item1,
                        current.getDistance(item1.getLocation()));
                }
            }
        }
        Direction dir = Util.getRandomDirection();
        Location targetLocation = new Location(animal.getLocation(), dir);
        if (Util.isValidLocation(world, targetLocation) &&
            this.isLocationEmpty(world, animal, targetLocation)) {
            return new MoveCommand(animal, targetLocation);
        }
        return new WaitCommand();
    }

    /**
     * Given an item, checkMoves determines the next location the rhino should move to get closer
     * to the item.
     *
     * @param world base world
     * @param animal rhino to move
     * @param i item to move towards
     * @param distance distance between the rhino and the item
     * @return MoveCommand towards the given item
     */
    private Command checkMoves(ArenaWorld world, ArenaAnimal animal, Item i, int distance) {
        Location up = new Location(animal.getLocation(), Direction.NORTH);
        if (up.getDistance(i.getLocation()) < distance
            && Util.isValidLocation(world, up)
            && this.isLocationEmpty(world, animal, up)) {
            return new MoveCommand(animal, up);
        }
        Location right = new Location(animal.getLocation(), Direction.EAST);
        if (right.getDistance(i.getLocation()) < distance
            && Util.isValidLocation(world, right)
            && this.isLocationEmpty(world, animal, right)) {
            return new MoveCommand(animal, right);
        }
        Location down = new Location(animal.getLocation(), Direction.SOUTH);
        if (down.getDistance(i.getLocation()) < distance
            && Util.isValidLocation(world, down)
            && this.isLocationEmpty(world, animal, down)) {
            return new MoveCommand(animal, down);
        }
        Location left = new Location(animal.getLocation(), Direction.WEST);
        if (left.getDistance(i.getLocation()) < distance
            && Util.isValidLocation(world, left)
            && this.isLocationEmpty(world, animal, left)) {
            return new MoveCommand(animal, left);
        }
        return new WaitCommand();
    }

}


