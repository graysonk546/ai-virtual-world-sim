package ca.ubc.ece.cpen221.graphs.two.commands;

import ca.ubc.ece.cpen221.graphs.two.Location;
import ca.ubc.ece.cpen221.graphs.two.World;
import ca.ubc.ece.cpen221.graphs.two.items.pokemon.Pokemon;

/**
 * Evolve command called by pokemon.
 * This command evolves the pokemon calling it
 * Used when pokemon has enough experience to evolve
 */
public final class EvolveCommand implements Command {

    private final Pokemon pokemon;
    private final Location location;

    public EvolveCommand(Pokemon pokemon, Location location) {
        this.pokemon = pokemon;
        this.location = location;
    }

    @Override
    public void execute(World world) {
        Pokemon evolution = pokemon.evolve();
        evolution.moveTo(location);
        world.addItem(evolution);
        world.addActor(evolution);
    }

}
