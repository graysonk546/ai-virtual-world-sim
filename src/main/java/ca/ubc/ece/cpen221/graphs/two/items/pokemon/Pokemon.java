package ca.ubc.ece.cpen221.graphs.two.items.pokemon;

import ca.ubc.ece.cpen221.graphs.two.Actor;
import ca.ubc.ece.cpen221.graphs.two.items.MoveableItem;

public interface Pokemon extends MoveableItem, Actor {
    /**
     * observer method for getting the experience of the pokemon
     * @return integer representing current experience points of the pokemon
     */
    int getExperience();

    /**
     * mutator method for adding experience to the pokemon
     * @param experience points to add
     */
    void addExperience(int experience);

    /**
     * producer method for evolving pokemon evolves the pokemon to it's next stage
     * @return pokemon representing the next pokemon in the evolution hierarchy
     */
    Pokemon evolve();

    /**
     * observer method for getting the experience points required to evolve the pokemon
     * @return integer representing the experience point requirement for the pokemon to evolve
     */
    public int getEvoXP();

    /**
     * observer method for getting the view range of the pokemon
     * @return integer representing the view range of the pokemon
     */
    public int getViewRange();

    /**
     *observer method for getting the kill range of the pokemon
     * @return integer representing the kill range of the pokemon
     */
    public int getKillRange();

}
