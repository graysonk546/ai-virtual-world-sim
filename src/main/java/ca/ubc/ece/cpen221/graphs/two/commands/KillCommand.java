package ca.ubc.ece.cpen221.graphs.two.commands;

import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.Util;
import ca.ubc.ece.cpen221.graphs.two.World;
import ca.ubc.ece.cpen221.graphs.two.items.Item;
import ca.ubc.ece.cpen221.graphs.two.items.pokemon.Pokemon;

import java.util.Set;

/**
 * KillCommand is called by pokemon only. When called, the pokemon will destroy items in range and collect experience
 * points from the items
 */
public abstract class KillCommand implements Command{

    private static final int GYM_ENERGY_LOSS = 50;
    private static final int GYM_EXPERIENCE_GAIN = 100;
    private static final int CAR_EXPERIENCE_DROP = -10;

    /**
     * Destroy all items in the inputted itemList. Pokemon that is inputted collects experience from the destroyed items
     *
     * @param pokemon pokemon using KillCommand
     * @param world the base world
     * @param itemList set of items to be destroyed
     * @return
     */
    public static int purgeArea(Pokemon pokemon, World world, Set<Item> itemList) {

        int experienceGained = 0;

        for(Item item : itemList){
            if(!item.getLocation().equals(pokemon.getLocation()) && !item.getName().equals("fire")){
                experienceGained += getExperience(item);
            }
        }

        return experienceGained;
    }

    /**
     * Destroy the inputted item. Depending on the given item, add the corresponding meat/plant calories to the
     * pokemon's experience total
     * @param item the item to be destroyed
     * @return the amount of experience gained from the item to be added to the pokemons collection
     */
    private static int getExperience(Item item){
        if (item.getName().equals("Charmander") || item.getName().equals("Charmeleon")
                || item.getName().equals("Charizard")) {
            item.loseEnergy(GYM_ENERGY_LOSS);
            return GYM_EXPERIENCE_GAIN;
        } else if (item.getName().equals("Rabbit") || item.getName().equals("Fox")
                || item.getName().equals("Rhino") || item.getName().equals("Gnat")) {
            int exp = item.getMeatCalories();
            item.loseEnergy(Integer.MAX_VALUE);
            return exp;
        } else if(item.getName().equals("grass")){
            int exp = item.getPlantCalories();
            item.loseEnergy(Integer.MAX_VALUE);
            return exp;
        } else {
            item.loseEnergy(10);
            return CAR_EXPERIENCE_DROP;
        }
    }

}
