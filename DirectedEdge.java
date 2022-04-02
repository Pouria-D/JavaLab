public class DirectedEdge extends Edge
{
    DirectedEdge()
    {
        V = new Node[2];
        isDirected = true;
    }

    DirectedEdge(Node input0, Node input1)
    {
        V = new Node[2];
        setNodes(input0, input1);
        isDirected = true;
    }

    void setNodes(Node input0, Node input1)
    {
        V[0] = input0;
        V[1] = input1;
        input0.addEdge(this);
        input1.addEdge(this);
    }
    
    Node[] getNodes()
    {
        return V;
    }
}