package ca.ubc.ece.cpen221.graphs.two.commands;

import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.World;
import ca.ubc.ece.cpen221.graphs.two.items.Fire;
import ca.ubc.ece.cpen221.graphs.two.items.Item;
import ca.ubc.ece.cpen221.graphs.two.items.pokemon.Pokemon;

import java.util.HashSet;
import java.util.Set;

/**
 * Kill command specific to Charmeleon. This killCommand will "set the targets on fire"
 * Replace each destroyed item with a "fire" item
 * Collect experience from items
 */
public class CharmeleonKillCommand extends KillCommand {
    private Pokemon pokemon;
    private Set<Item> itemList;
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
    public CharmeleonKillCommand(Pokemon pokemon, Set<Item> itemList) {
        this.pokemon = pokemon;
        this.itemList = itemList;
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

        for(Location location : itemLocations){
            Fire fire = new Fire(location);
            world.addItem(fire);
            world.addActor(fire);
        }

    }

}
