public class UndirectedEdge extends Edge
{
    UndirectedEdge()
    {
        V = new Node[2];
        isDirected = false;
    }

    UndirectedEdge(Node[] input)
    {
        V = new Node[2];
        setNodes(input);
        isDirected = false;
    }

    void setNodes(Node[] ?)
    {
        V = input;
        input[0].addEdge(this);
        input[1].addEdge(this);
    }
    
    Node[] getNodes()
    {
        return V;
    }
}