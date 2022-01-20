package ca.ubc.ece.cpen221.graphs.one;

import ca.ubc.ece.cpen221.graphs.core.Graph;
import ca.ubc.ece.cpen221.graphs.core.Vertex;

import java.util.*;

public class Algorithms<T> {

    /**
     * Gets the shortest distance between two vertices in a directed graph or returns Integer.MAX_VALUE if
     * the vertices are not connected.
     *
     * @param graph the graph containing a and b
     * @param a first vertex
     * @param b second vertex
     * @return the length of the shortest path from a -> b or b -> a or Integer.MAX_VALUE
     * if there is no path from a -> b or b -> a
     */
    public static <T> int distance(Graph<T> graph, Vertex<T> a, Vertex<T> b) {
        // Note that this method can be invoked as follows:
        //      Algorithms.<String>shortestDistance(g, a, b)
        // when the graph contains vertices of type Vertex<String>.
        // The compiler can also perform type inference so that we can simply use:
        //      Algorithms.shortestDistance(g, a, b)
        int distance1 = distanceHelper(0,graph.getVertices().size(),graph,0,a,b);
        if (distance1 == graph.getVertices().size()) {
            return Integer.MAX_VALUE;
        } else {
            return distance1;
        }
    }

    /**
     * Recursive helper method for the method shortestDistance. Gets the length of the shortest path from a -> b or
     * returns the size of the graph if no such path exists.
     *
     * @param count function must be called with a count value of 0
     * @param min function must be called with a min value equal to the size of the graph (graph.getVertices.size())
     * @param graph the graph for which diameter is being calculated
     * @param steps function must be called with a steps value of 0
     * @param a starting vertex
     * @param b ending vertex
     * @param <T> vertex type
     * @return length of shortest path from a -> b. If no path exists returns a length equal to the size of the graph.
     */
    private static <T> int distanceHelper(int count,int min, Graph<T> graph, int steps,
                                                   Vertex<T> a, Vertex<T> b) {

        List<Vertex<T>> neighboursList = graph.getNeighbors(a);

        if(b.equals(a)){
            return count;
        }
        if(graph.getNeighbors(a).size() == 0){
            return graph.getVertices().size();
        }
        if(steps > graph.getVertices().size()){
            return graph.getVertices().size();
        }

        int newMin;
        for(Vertex<T> v : neighboursList){
            newMin = distanceHelper(count+1,min, graph,steps+1, v, b);
            if(newMin < min){
                min = newMin;
            }
        }
        return min;
    }

    /**
     * Perform a complete depth first search of the given
     * graph. Start with the search at each vertex of the
     * graph and create a list of the vertices visited.
     * Return a set where each element of the set is a list
     * of elements seen by starting a DFS at a specific
     * vertex of the graph (the number of elements in the
     * returned set should correspond to the number of graph
     * vertices).
     *
     * @param graph graph using the interface
     * @return set where each element of the set is a list of elements seen by a starting a
     *         DFS at a specific vertex of the graph
     */
    public static <T> Set<List<Vertex<T>>> depthFirstSearch(Graph<T> graph) {
        Set<List<Vertex<T>>> result = new HashSet<>();
        List<Vertex<T>> vertices = graph.getVertices();

        for(Vertex<T> vertex : vertices){
            List<Vertex<T>> DFSSequence = new ArrayList<>();
            DFSHelper(DFSSequence, graph, vertex);
            System.out.println(DFSSequence);
            result.add(DFSSequence);
        }
        return result;
    }

    /**
     * Recursive method called for DFS. Performs DFS starting with the "startingVertex"
     * Searches through vertices in the graph and adds vertices to a list in order they are seen.
     * No return value.
     *
     * @param DFSSequence the current sequence of the DFS.
     * @param graph any directed discrete graph
     * @param startingVertex the specific starting vertex
     */
    private static <T> void DFSHelper(List<Vertex<T>> DFSSequence, Graph<T> graph, Vertex<T> startingVertex){
        DFSSequence.add(startingVertex);
        List<Vertex<T>> neighbours = graph.getNeighbors(startingVertex);
        if (neighbours.size() == 0){
            return;
        }
        List<Vertex<T>> sortedNeighbours = sortVertices(neighbours);

        for(Vertex<T> vertex : sortedNeighbours){
            if (!DFSSequence.contains(vertex)){
                DFSHelper(DFSSequence, graph, vertex);
            }
        }
    }

    /**
     * Given a List of vertices, return a new list of the same vertices in lexicographic order
     *
     * @param vertices list of vertices
     * @return new list of sorted vertices
     */
    private static <T> List<Vertex<T>> sortVertices(List<Vertex<T>> vertices){
        List<String> StringCopy = new ArrayList<>();
        List<Vertex<T>> sortedVertices = new ArrayList<>();
        for (Vertex<T> v: vertices){
            StringCopy.add(v.toString());
        }
        Collections.sort(StringCopy);

        for (String s : StringCopy){
            for (Vertex<T> v : vertices){
                if(s.equals(v.getLabel())){
                    sortedVertices.add(v);
                }
            }
        }
        return sortedVertices;
    }

    /**
     * Perform a complete breadth first search of the given
     * graph. Start with the search at each vertex of the
     * graph and create a list of the vertices visited.
     * Return a set where each element of the set is a list
     * of elements seen by starting a BFS at a specific
     * vertex of the graph (the number of elements in the
     * returned set should correspond to the number of graph
     * vertices).
     *
     * @param graph any directed discrete graph
     * @return set where each element of the set is a list of elements seen by a starting a
     *         BFS at a specific vertex of the graph
     */
    public static <T> Set<List<Vertex<T>>> breadthFirstSearch(Graph<T> graph) {
        Set<List<Vertex<T>>> result = new HashSet<>();
        List<Vertex<T>> vertices = graph.getVertices();
        for(Vertex<T> vertex : vertices){
            List<Vertex<T>> BFSSequence = new ArrayList<>();
            List<Vertex<T>> startingVertex = new ArrayList<>();
            startingVertex.add(vertex);
            BFSHelper(BFSSequence, graph, startingVertex);
            result.add(BFSSequence);
        }
        return result;
    }

    /**
     * Recursive method called for BFS. Performs BFS starting with the list of starting vertices
     * Searches through neighbouring vertices in the graph and adds vertices to a list layer by layer.
     * No return value.
     *
     * @param BFSSequence the current sequence of the BFS.
     * @param graph any directed discrete graph
     * @param startingVertices list of starting vertices of which the neighbours will be acquired
     */
    private static <T> void BFSHelper(List<Vertex<T>> BFSSequence, Graph<T> graph, List<Vertex<T>> startingVertices) {
        if (startingVertices.size() == 0) {
            return;
        }
        List<Vertex<T>> nextNeighbours = new ArrayList<>();
        List<Vertex<T>> sortedVertices = sortVertices(startingVertices);
        for (Vertex<T> v : sortedVertices) {
            BFSSequence.add(v);
            if (graph.getNeighbors(v).size() != 0) {
                nextNeighbours.addAll(graph.getNeighbors(v));
            }
        }
        BFSHelper(BFSSequence, graph, nextNeighbours);
    }

    /**
     * Gets the diameter of a graph. Diameter is defined as the largest shortest path between two vertices in a graph
     *
     * @param graph graph for which diameter will be determined
     * @param <T> type of graph
     * @return diameter of the graph in question or Integer.MAX_VALUE if the diameter is infinite
     */
    public static <T> int diameter(Graph<T> graph) {

        List<Vertex<T>> verticesList = graph.getVertices();
        int maxDistance = 0;
        int distance;
        boolean indicator = true;

        for(Vertex<T> v : verticesList){
            if(graph.getNeighbors(v).size() > 0){
                indicator = false;
            }
            for(Vertex<T> w : verticesList){
                distance = distance(graph,v,w);
                if(distance == Integer.MAX_VALUE){
                    distance = verticesList.size();
                }
                if(distance > maxDistance && distance < verticesList.size()){
                    maxDistance = distance;
                }
            }
        }

        if(indicator ){
            return Integer.MAX_VALUE;
        }
        return maxDistance;
    }

    /**
     * Given a graph and two vertices a and b in the graph, the method returns a list of all vertices u such
     * that there is an edge from a to u and an edge from b to u.
     * If there are no such vertices then the method returns an empty list.
     *
     * @param G any directed discrete graph
     * @param a a vertex in the graph
     * @param b a vertex in the graph
     * @return a list of vertices that are neighbours of both a and b
     */

    public static <T> List<Vertex<T>> commonDownstreamVertices(Graph<T> G, Vertex<T> a, Vertex<T> b) {
        List<Vertex<T>> vertices = G.getVertices();
        List<Vertex<T>> result = new ArrayList<>();
        List<Vertex<T>> aNeighbours = G.getNeighbors(a);
        List<Vertex<T>> bNeighbours = G.getNeighbors(b);
        for (Vertex<T> v : vertices) {
            if (aNeighbours.contains(v) && bNeighbours.contains(v)) {
                result.add(v);
            }
        }
        return result;
    }

    /**
     * Given a graph and two vertices a and b in the graph, the method returns a list of all vertices u such
     * that there is an edge from u to a and an edge from u to b.
     * If there are no such vertices then the method returns an empty list.
     *
     * @param graph any directed discrete graph
     * @param a a vertex in the graph
     * @param b a vertex in the graph
     * @return a list of vertices of which a and b are neighbours
     */
    public static <T> List<Vertex<T>> commonUpstreamVertices(Graph<T> graph, Vertex<T> a, Vertex<T> b){
        List<Vertex<T>> result = new ArrayList<>();
        List<Vertex<T>> vertices = graph.getVertices();

        for(Vertex<T> vertex : vertices){
            List<Vertex<T>> neighbours = graph.getNeighbors(vertex);
            if(neighbours.contains(a) && neighbours.contains(b)){
                result.add(vertex);
            }
        }
        return result;
    }

}
