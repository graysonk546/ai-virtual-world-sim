package ca.ubc.ece.cpen221.graphs.one;

import ca.ubc.ece.cpen221.graphs.core.Graph;
import ca.ubc.ece.cpen221.graphs.core.Vertex;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;



/******************************************************************************
 *  Dependencies: Graph.java Vertex.java
 *
 *  A data type that represents a Graph using Adjacency Lists.
 *
 ******************************************************************************/


public class AdjacencyListGraph<T> implements Graph<T> {

    /* Abstraction Function:
            adjacency list of a graph represented by a Hashtable with keys corresponding to vertices
            and values corresponding to the neighbours of that vertex.

       Representation Invariants:
            - Keys are non-null.
            - The same key cannot have the same vertex in its ArrayList twice.
     */

    public static final boolean DEBUG = false;

    private final Hashtable<Vertex<T>, ArrayList<Vertex<T>>> AdjacencyList;

    public AdjacencyListGraph() {

        this.AdjacencyList = new Hashtable<>();

        if (DEBUG) {
            checkRep();
        }
    }

    @Override
    public void addVertex(Vertex<T> v) {
        ArrayList<Vertex<T>> arr = new ArrayList<>();
        AdjacencyList.put(v, arr);

        if (DEBUG) {
            checkRep();
        }
    }

    @Override
    public void addEdge(Vertex<T> v1, Vertex<T> v2) {
        ArrayList<Vertex<T>> v1List = AdjacencyList.get(v1);
        if (!v1List.contains(v2)) {
            v1List.add(v2);
        }
        AdjacencyList.put(v1, v1List);

        if (DEBUG) {
            checkRep();
        }
    }

    @Override
    public boolean edgeExists(Vertex<T> v1, Vertex<T> v2) {
        return AdjacencyList.get(v1).contains(v2);
    }

    @Override
    public List<Vertex<T>> getNeighbors(Vertex<T> v) {
        return AdjacencyList.get(v);
    }

    @Override
    public List<Vertex<T>> getVertices() {
        List<Vertex<T>> copy = new ArrayList<>(AdjacencyList.keySet());
        List<Vertex<T>> newCopy = new ArrayList<>();
        List<String> StringCopy = new ArrayList<>();
        for (Vertex<T> v : copy) {
            StringCopy.add(v.toString());
        }
        Collections.sort(StringCopy);

        for (String s : StringCopy){
            for (Vertex<T> v: copy){
                if(s.equals(v.getLabel())){
                    newCopy.add(v);
                }
            }
        }

        return newCopy;

    }

    public boolean containsVertex(Vertex<T> vertex){
        return this.AdjacencyList.containsKey(vertex);
    }

    public void checkRep() {
        for (Vertex<T> v : AdjacencyList.keySet()) {
            assert(v != null);
            List<Vertex<T>> newList = new ArrayList<>();
            for (Vertex<T> u : AdjacencyList.get(v)) {
                assert(!newList.contains(u));
                newList.add(u);
            }
        }
    }
}

