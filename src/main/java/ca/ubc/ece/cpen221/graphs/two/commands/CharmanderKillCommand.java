package ca.ubc.ece.cpen221.graphs.two.commands;

import ca.ubc.ece.cpen221.graphs.two.World;
import ca.ubc.ece.cpen221.graphs.two.items.Item;
import ca.ubc.ece.cpen221.graphs.two.items.pokemon.Pokemon;

import java.util.Set;

/**
 * killCommand Specific for Charmander. Destroy items in kill range.
 * Collect experience from items
 */
public class CharmanderKillCommand extends KillCommand{

    final private Pokemon pokemon;
    final private Set<Item> itemList;

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
    public CharmanderKillCommand(Pokemon pokemon, Set<Item> itemList) {
        this.pokemon = pokemon;
        this.itemList = itemList;
    }

    @Override
    public void execute(World world) {
        pokemon.addExperience(purgeArea(pokemon, world, itemList));
    }
}
