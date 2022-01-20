package ca.ubc.ece.cpen221.graphs.one;

import ca.ubc.ece.cpen221.graphs.core.Vertex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwitterAnalysis {

    AdjacencyListGraph<Integer> twitterGraph = new AdjacencyListGraph<Integer>();
    /*
        Construct an object to analyze the dataset in
        the file with the given filename. You should
        write clear specs for this method.
    */
    public TwitterAnalysis(String fileName) {

        try{

            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String currentLine;

            while((currentLine = in.readLine()) != null){

                int i = 0;

                StringBuilder user1 = new StringBuilder();
                while(currentLine.charAt(i) != ' '){
                    user1.append(currentLine.charAt(i));
                    i++;
                }

                i = i + 4;

                StringBuilder user2 = new StringBuilder();
                while(i < currentLine.length()){
                    user2.append(currentLine.charAt(i));
                    i++;
                }

                Vertex<Integer> vertex1 = new Vertex<Integer>(user1.toString(),0);
                Vertex<Integer> vertex2 = new Vertex<Integer>(user2.toString(),0);

                if(!twitterGraph.containsVertex(vertex1)){
                    twitterGraph.addVertex(vertex1);
                }

                if(!twitterGraph.containsVertex(vertex2)){
                    twitterGraph.addVertex(vertex2);
                }

                twitterGraph.addEdge(vertex1, vertex2);
            }

        } catch(IOException e){
            System.out.println("Exception thrown, invalid file name");
        }
    }

    /**
     * Given two users A and B, returns a set of users in which both A and B follow, if there are no common
     * influencers an empty set is returned
     * @param userA a user in the dataset
     * @param userB a user in the dataset
     * @return  set of users in which both A and B follow
     */
    public Set<String> commonInfluencers(String userA, String userB) {
        Vertex<Integer> v1 = null;
        Vertex<Integer> v2 = null;
        for (Vertex<Integer> v : twitterGraph.getVertices()) {
            if (v.getLabel().equals(userA)) {
                v1 = v;
            }
            if (v.getLabel().equals(userB)) {
                v2 = v;
            }
        }
        List<Vertex<Integer>> commonUpstreamVertices = Algorithms.commonUpstreamVertices(twitterGraph, v1, v2);
        List<String> resultList = new ArrayList<>();
        for(Vertex<Integer> vertex : commonUpstreamVertices) {
            resultList.add(vertex.getLabel());
        }
        Set<String> result = new HashSet<>(resultList);
        return result;
    }

    /**
     * For any two users in the twitter dataset, for user A who tweets a message, return the minimum
     * number of retweets required by the consecutive followers of user A such that the message will
     * appear in the feed of user B.
     *
     * @param userA the user in the dataset who tweets the message
     * @param userB the user in the dataset who will receive the message in their feed
     * @return the number of retweets required by the consecutive followers of user A or Integer.MAX_VALUE
     * if the users are not connected through consecutive followers
     */
    public int numRetweets(String userA, String userB) {
        Vertex<Integer> v1 = null;
        Vertex<Integer> v2 = null;
        for (Vertex<Integer> v : twitterGraph.getVertices()) {
            if (v.getLabel().equals(userA)) {
                v1 = v;
            }
            if (v.getLabel().equals(userB)) {
                v2 = v;
            }
        }
        int retweets = Algorithms.distance(twitterGraph,v1,v2);
        if (retweets == Integer.MAX_VALUE) {
            return retweets;
        } else if (retweets == 0) {
            return 0;
        } else {
            return retweets - 1;
        }
    }

    public static void main(String[] args){
        /*
            main() should take four arguments:
            - The first argument should be a filename for a file holding
              a Twitter dataset.
            - The second should be one of "commonInfluencers" or "numRetweets".
            - The next two arguments should be identifiers for userA and userB.
            Then main() should invoke the appropriate method and write the result to
            standard output (often, the terminal). For "numRetweets", the output to
            standard output should be just the int. For "commonInfluencers", each
            of the influencers should be written to standard output, one per line,
            with no other text.
         */
        TwitterAnalysis graph = new TwitterAnalysis(args[0]);

        if(args[1].equals("commonInfluencers")){
            System.out.println(graph.commonInfluencers(args[2], args[3]));
        }
        else if (args[1].equals("numRetweets")){
            System.out.println(graph.numRetweets(args[2], args[3]));
        }
    }
}
