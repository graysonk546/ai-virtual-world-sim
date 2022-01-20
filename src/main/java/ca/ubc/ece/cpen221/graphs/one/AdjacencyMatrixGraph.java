package ca.ubc.ece.cpen221.graphs.one;

import ca.ubc.ece.cpen221.graphs.core.Graph;
import ca.ubc.ece.cpen221.graphs.core.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/******************************************************************************
 *  Dependencies: Graph.java Vertex.java
 *
 *  A data type that represents a Graph using Adjacency Matrices.
 *
 ******************************************************************************/

public class AdjacencyMatrixGraph<T> implements Graph<T> {

    private final ArrayList<Vertex<T>> vertices;
    private final ArrayList<ArrayList<Integer>> adjacencyMatrix;

        /* Abstraction Function:
            - The number of vertices in a graph = vertices.size()

            - Vertex in the graph = vertices.get(i)
            where i is the order at which the vertex was added to the graph
            Example: first vertex added: i = 0
            Example: fifth vertex added: i = 4

            - If there is an edge from vertex A to vertex B = adjacencyMatrix.get(A).get(B)
            where 1 represents an edge and 0 represents no edge
     */

    /* Representation Invariant:
            - vertices contains no duplicate elements
            - adjacencyMatrix must be V x V dimensions for a graph with V vertices
            - for adjacency matrix, all values from top left diagonal to bottom right must be 0 (vertex can't have an edge
              to itself)
            - adjacencyMatrix.get(A).get(B) != adjacencyMatrix.get(B).get(A) (graph is directed)
     */


    public static final boolean DEBUG = false;

    public AdjacencyMatrixGraph() {

        adjacencyMatrix = new ArrayList<>();
        vertices = new ArrayList<>();

        if (DEBUG) {
            checkRep();
        }
    }

    @Override
    public void addVertex(Vertex<T> v) {
        vertices.add(v);
        ArrayList<Integer> newRow = new ArrayList<>();
        for (ArrayList<Integer> matrix : adjacencyMatrix) {
            matrix.add(0);
            newRow.add(0);
        }
        newRow.add(0);

        adjacencyMatrix.add(newRow);

        if (DEBUG) {
            checkRep();
        }
    }

    @Override
    public void addEdge(Vertex<T> v1, Vertex<T> v2) {
        int row = vertices.indexOf(v1);
        int col = vertices.indexOf(v2);
        adjacencyMatrix.get(row).set(col, 1);

        if (DEBUG) {
            checkRep();
        }
    }

    @Override
    public boolean edgeExists(Vertex<T> v1, Vertex<T> v2) {

        int row = vertices.indexOf(v1);
        int col = vertices.indexOf(v2);
        return adjacencyMatrix.get(row).get(col) == 1;
    }

    @Override
    public List<Vertex<T>> getNeighbors(Vertex<T> v) {
        List<Vertex<T>> neighbours = new ArrayList<>();
        int vertexIndex = vertices.indexOf(v);
        for (int i = 0; i < adjacencyMatrix.size(); i++){
            if (adjacencyMatrix.get(vertexIndex).get(i) == 1){
                neighbours.add(vertices.get(i));
            }
        }
        return neighbours;
    }

    @Override
    public List<Vertex<T>> getVertices() {
        List<String> Stringcopy = new ArrayList<>();
        List<Vertex<T>> copy = new ArrayList<>();
        for (Vertex<T> v: vertices){
            Stringcopy.add(v.toString());
        }
        Collections.sort(Stringcopy);

        for (String s : Stringcopy){
            for (Vertex<T> v: vertices){
                if(s.equals(v.getLabel())){
                    copy.add(v);
                }
            }
        }
        return copy;
    }

    public void checkRep() {
        List<Vertex<T>> newList = new ArrayList<>();
        for (Vertex<T> v : vertices) {
            assert(!newList.contains(v));
            newList.add(v);
        }
        int length = adjacencyMatrix.size();
        for (List<Integer> list : adjacencyMatrix) {
            assert(list.size() == length);
        }
        for (int i = 0; i < length; i++) {
            assert(adjacencyMatrix.get(i).get(i) == 0);
            for (int j = 0; j < length; j++) {
                assert(!(adjacencyMatrix.get(i).get(j) == 1 && adjacencyMatrix.get(j).get(i) == 1));
            }
        }
    }
}


