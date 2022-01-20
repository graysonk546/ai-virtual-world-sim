package ca.ubc.ece.cpen221.graphs.two;

import ca.ubc.ece.cpen221.graphs.two.ai.ArenaAnimalAI;
import ca.ubc.ece.cpen221.graphs.two.ai.FoxAI;
import ca.ubc.ece.cpen221.graphs.two.ai.RabbitAI;
import ca.ubc.ece.cpen221.graphs.two.ai.RhinoAI;
import ca.ubc.ece.cpen221.graphs.two.core.WorldImpl;
import ca.ubc.ece.cpen221.graphs.two.core.WorldUI;
import ca.ubc.ece.cpen221.graphs.two.items.Gardener;
import ca.ubc.ece.cpen221.graphs.two.items.Grass;
import ca.ubc.ece.cpen221.graphs.two.items.animals.ArenaAnimal;
import ca.ubc.ece.cpen221.graphs.two.items.animals.Fox;
import ca.ubc.ece.cpen221.graphs.two.items.animals.Gnat;
import ca.ubc.ece.cpen221.graphs.two.items.animals.Rabbit;
import ca.ubc.ece.cpen221.graphs.two.items.pokemon.Charmander;
import ca.ubc.ece.cpen221.graphs.two.items.pokemon.Pokemon;

import ca.ubc.ece.cpen221.graphs.two.items.animals.Rhino;

import ca.ubc.ece.cpen221.graphs.two.items.vehicles.Car;
import ca.ubc.ece.cpen221.graphs.two.items.vehicles.Motorcycle;
import ca.ubc.ece.cpen221.graphs.two.items.vehicles.Truck;


import javax.swing.*;


import javax.swing.SwingUtilities;


/**
 * The Main class initializes a world with some {@link Grass}, {@link Rabbit}s,
 * {@link Fox}es, {@link Gnat}s, {@link Gardener}, etc.
 * <p>
 * You may modify or add Items/Actors to the World.
 */
public class Main {

    static final int X_DIM = 40;
    static final int Y_DIM = 40;
    static final int SPACES_PER_GRASS = 7;
    static final int INITIAL_GRASS = X_DIM * Y_DIM / SPACES_PER_GRASS;
    static final int INITIAL_GNATS = INITIAL_GRASS / 4;
    static final int INITIAL_RABBITS = INITIAL_GRASS / 4;
    static final int INITIAL_FOXES = INITIAL_GRASS / 32;
    static final int INITIAL_CARS = INITIAL_GRASS / 100;
    static final int INITIAL_POKEMON = INITIAL_GRASS / 100;
    static final int INITIAL_TRUCKS = INITIAL_GRASS / 150;
    static final int INITIAL_MOTORCYCLES = INITIAL_GRASS / 64;
    static final int INITIAL_RHINOS = 3;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().createAndShowWorld();
            }
        });
    }

    public void createAndShowWorld() {
        World world = new WorldImpl(X_DIM, Y_DIM);
        initialize(world);
        new WorldUI(world).show();
    }

    public void initialize(World world) {
        addGrass(world);
        world.addActor(new Gardener());

        addGnats(world);
        addRabbits(world);
        addFoxes(world);
        addRhinos(world);
        addCars(world);
        addTrucks(world);
        addMotorcycle(world);
        addPokemon(world);
        // TODO: You may add your own creatures here!
    }

    private void addGrass(World world) {
        for (int i = 0; i < INITIAL_GRASS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            world.addItem(new Grass(loc));
        }
    }

    private void addGnats(World world) {
        for (int i = 0; i < INITIAL_GNATS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Gnat gnat = new Gnat(loc);
            world.addItem(gnat);
            world.addActor(gnat);
        }
    }

    private void addFoxes(World world) {
        FoxAI foxAI = new FoxAI();
        for (int i = 0; i < INITIAL_FOXES; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Fox fox = new Fox(foxAI, loc);
            world.addItem(fox);
            world.addActor(fox);
        }
    }

    private void addRabbits(World world) {
        RabbitAI rabbitAI = new RabbitAI();
        for (int i = 0; i < INITIAL_RABBITS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Rabbit rabbit = new Rabbit(rabbitAI, loc);
            world.addItem(rabbit);
            world.addActor(rabbit);
        }
    }

    private void addRhinos(World world) {
        RhinoAI rhinoAI = new RhinoAI();
        for (int i = 0; i < INITIAL_RHINOS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Rhino rhino = new Rhino(rhinoAI, loc);
            world.addItem(rhino);
            world.addActor(rhino);
        }
    }

    private void addCars(World world) {
        for (int i = 0; i < INITIAL_CARS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Car car = new Car(loc);
            world.addItem(car);
            world.addActor(car);
        }
    }

    private void addTrucks(World world) {
        for (int i = 0; i < INITIAL_TRUCKS; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Truck truck = new Truck(loc);
            world.addItem(truck);
            world.addActor(truck);
        }
    }

    private void addMotorcycle(World world) {
        for (int i = 0; i < INITIAL_MOTORCYCLES; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Motorcycle motorcycle = new Motorcycle(loc);
            world.addItem(motorcycle);
            world.addActor(motorcycle);
        }
    }


    private void addPokemon(World world) {
        for (int i = 0; i < INITIAL_POKEMON; i++) {
            Location loc = Util.getRandomEmptyLocation(world);
            Pokemon charmander = new Charmander(loc);
            world.addItem(charmander);
            world.addActor(charmander);
        }
    }


}