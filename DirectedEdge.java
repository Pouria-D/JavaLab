public class DirectedEdge extends Edge
{
    DirectedEdge()
    {
        V = new Node[2];
        isDirected = true;
    }

    DirectedEdge(Node[] input)
    {
        V = new Node[2];
        setNodes(input);
        isDirected = true;
    }

    void setNodes(Node[] input)
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