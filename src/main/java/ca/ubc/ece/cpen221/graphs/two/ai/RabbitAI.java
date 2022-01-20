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
import ca.ubc.ece.cpen221.graphs.two.items.animals.ArenaAnimal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Your Rabbit AI.
 */
public class RabbitAI extends AbstractAI {

    private static final int MIN_BREEDING_ENERGY = 10;
    private static final int VIEW_RANGE = 3;
    private static final int BREED_BUFFER = 49;

    /*
    Abstraction Function:
        The AI logic used by all rabbits that are added to the world. Rabbits behave on a priority
        list in its getNextAction method. From highest priority to lowest:
            1. If the rabbit's energy is above the minimum breeding energy, there is a chance that
               it will breed.
            2. If there is a fox in the view range of the rabbit, there is a chance that it will run
               away from it, using the runAway method.
            3. If there is grass adjacent to the rabbit it will eat it.
            4. If there is grass in the view range of the rabbit, it will move towards the closest
               instance, using the checkMoves method.
            5. Otherwise, it will move in a random direction
            6. If it cannot move in a random direction, it will stand still.
        - MIN_BREEDING_ENERGY is the minimum breeding energy of all rabbit objects
        - VIEW_RANGE is the view range of all rabbit objects
        - BREED_BUFFER is a constant energy buffer value that is set in order to reduce
          overpopulation of rabbits in the world.
     */

    public RabbitAI() { }

    /**
     * Determines the rabbit's next action based on the objects that are within its view range. They
     * have a chance to breed if their energy has reached the maximum energy that a rabbit can
     * store, and has a chance to run away from a fox if it has spotted it. It moves towards grass
     * if it sees it in its view range. Returns a command at each time step of the world.
     *
     * @param world the world in which the rabbit has been added
     * @param animal the rabbit who's next action will be returned
     * @return the next command on which the rabbit will act
     */
    @Override
    public Command getNextAction(ArenaWorld world, ArenaAnimal animal) {
        Set<Item> surroundingItems = world.searchSurroundings(animal);
        Location current = animal.getLocation();
        int rollBreed = Util.randomNumber(3, 0);
        if (animal.getEnergy() > MIN_BREEDING_ENERGY + BREED_BUFFER && rollBreed > 2) {
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
        for (int i = 0; i < VIEW_RANGE; i++) {
            List<Item> listToAdd = new ArrayList<>();
            itemsInRange.add(listToAdd);
        }

        for (Item i : surroundingItems) {
            if (i.getName().equals("grass")) {
                int range = current.getDistance(i.getLocation());
                itemsInRange.get(range - 1).add(i);
            }
            if (i.getName().equals("Fox")) {
                int roll = Util.randomNumber(1, 0);
                if (roll > 0) {
                    return runAway(world, animal, i, current.getDistance(i.getLocation()));
                }
            }
        }

        for (int i = 0; i < itemsInRange.size(); i++) {
            if (i == 0) {
                for (Item item1 : itemsInRange.get(i)) {
                    if (item1.getName().equals("grass")) {
                        return new EatCommand(animal, item1);
                    }
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
     * Given an item, checkMoves determines the next location the rabbit should move to get closer
     * to the item.
     *
     * @param world base world
     * @param animal rabbit to move
     * @param i item to move towards
     * @param distance distance between the rabbit and the item
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

    private Command runAway(ArenaWorld world, ArenaAnimal animal, Item i, int distance) {
        Location up = new Location(animal.getLocation(), Direction.NORTH);
        if (up.getDistance(i.getLocation()) > distance
            && Util.isValidLocation(world, up)
            && this.isLocationEmpty(world, animal, up)) {
            return new MoveCommand(animal, up);
        }
        Location right = new Location(animal.getLocation(), Direction.EAST);
        if (right.getDistance(i.getLocation()) > distance
            && Util.isValidLocation(world, right)
            && this.isLocationEmpty(world, animal, right)) {
            return new MoveCommand(animal, right);
        }
        Location down = new Location(animal.getLocation(), Direction.SOUTH);
        if (down.getDistance(i.getLocation()) > distance
            && Util.isValidLocation(world, down)
            && this.isLocationEmpty(world, animal, down)) {
            return new MoveCommand(animal, down);
        }
        Location left = new Location(animal.getLocation(), Direction.WEST);
        if (left.getDistance(i.getLocation()) > distance
            && Util.isValidLocation(world, left)
            && this.isLocationEmpty(world, animal, left)) {
            return new MoveCommand(animal, left);
        }
        return new WaitCommand();
    }
}
