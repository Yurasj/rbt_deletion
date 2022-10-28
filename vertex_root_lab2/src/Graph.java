import java.util.ArrayList;
import java.util.List;

class Graph
{
    List<List<Integer>> adjList;
    Graph(List<Link> edges, int nodes)
    {
        adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Link edge: edges) {
            adjList.get(edge.source).add(edge.destination);
        }
    }
}