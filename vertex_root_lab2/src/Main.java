import java.util.Arrays;
import java.util.List;

class Main
{
    public static void DFS(Graph graph, int v, boolean[] discovered)
    {
        discovered[v] = true;
        for (int u: graph.adjList.get(v))
        {
            if (!discovered[u]) {
                DFS(graph, u, discovered);
            }
        }
    }

    public static int findRootVertex(Graph graph, int nodes)
    {
        boolean[] visited = new boolean[nodes];
        int v = 0;
        for (int i = 0; i < nodes; i++)
        {
            if (!visited[i])
            {
                DFS(graph, i, visited);
                v = i;
            }
        }
        Arrays.fill(visited, false);
        DFS(graph, v, visited);
        for (int i = 0; i < nodes; i++)
        {
            if (!visited[i]) {
                return -1;
            }
        }
        return v;
    }

    public static void main(String[] args)
    {
        List<Link> edges = Arrays.asList(new Link(0, 1), new Link(1, 2),
                new Link(2, 3), new Link(3, 0), new Link(4, 3),
                new Link(4, 5), new Link(5, 0));

        int nodes = 6;

        // creating a graph
        Graph graph = new Graph(edges, nodes);

        // creating graphManager tha will write down solution
        GraphManager graphManager = new GraphManager();
        graphManager.writeToFile(findRootVertex(graph, nodes));
    }
}
