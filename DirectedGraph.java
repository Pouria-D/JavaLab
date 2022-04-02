public class DirectedGraph extends Graph
{
    void addEdge(Edge e)
    {
        if (!e.isDirected)
        {
            System.out.println("You can not add a undirected edge to a directed graph.");
            return;
        }
        super.addEdge(e);
    }
}
