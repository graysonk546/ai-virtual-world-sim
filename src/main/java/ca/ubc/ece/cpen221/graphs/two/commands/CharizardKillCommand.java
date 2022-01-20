package ca.ubc.ece.cpen221.graphs.two.commands;

import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.Util;
import ca.ubc.ece.cpen221.graphs.two.World;
import ca.ubc.ece.cpen221.graphs.two.items.Fire;
import ca.ubc.ece.cpen221.graphs.two.items.Item;
import ca.ubc.ece.cpen221.graphs.two.items.pokemon.Pokemon;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

/**
 * killCommand specific to Charizard. Light its entire kill range on fire.
 * replace all items in kill range with fire
 * set fire to all empty spaces in kill range
 * Collect experience from items
 */
public class CharizardKillCommand extends KillCommand {

    private Pokemon pokemon;
    private Set<Item> itemList;
    private int killRange;
    private Set<Location> itemLocations;

    /**
     * Constructor where <code>item</code> is the LivingItem that is breeding
     * and <code>target</code> is the location where the child will appear. The
     * child must be born at an empty location adjacent to the parent.
     *
     * Constructor where item is the pokemon using the killCommand and victim is the
     * item that is getting destroyed
     * @param pokemon  the pokemon using kill command
     * @param itemList the list of items that we be killed
     */
    public CharizardKillCommand(Pokemon pokemon, Set<Item> itemList) {
        this.pokemon = pokemon;
        this.itemList = itemList;
        this.killRange = pokemon.getKillRange();
        this.itemLocations = new HashSet<Location>();
        for(Item item : itemList){
            if(!item.getLocation().equals(pokemon.getLocation()) && !item.getName().equals("fire")) {
                itemLocations.add(item.getLocation());
            }
        }
    }

    @Override
    public void execute(World world) throws InvalidCommandException {
        pokemon.addExperience(purgeArea(pokemon, world, itemList));

        for (int distance = 1; distance <= killRange; distance++){
            int x1, x2;
            for (int y = -distance; y <= distance; y++) {
                x1 = distance - Math.abs(y);
                x2 = -(distance - Math.abs(y));

                if (Util.isValidLocation(world, new Location(pokemon.getLocation().getX() + x1, pokemon.getLocation().getY() + y))
                    && Util.isLocationEmpty(world, new Location(pokemon.getLocation().getX() + x1, pokemon.getLocation().getY() + y))){
                    Fire fire1 = new Fire(new Location(pokemon.getLocation().getX() + x1, pokemon.getLocation().getY() + y));
                    world.addItem(fire1);
                    world.addActor(fire1);
                }
                if (Util.isValidLocation(world, new Location(pokemon.getLocation().getX() + x2, pokemon.getLocation().getY() + y))
                    && Util.isLocationEmpty(world, new Location(pokemon.getLocation().getX() + x2, pokemon.getLocation().getY() + y))){
                    Fire fire1 = new Fire(new Location(pokemon.getLocation().getX() + x2, pokemon.getLocation().getY() + y));
                    world.addItem(fire1);
                    world.addActor(fire1);
                }
            }
        }
    }
}
