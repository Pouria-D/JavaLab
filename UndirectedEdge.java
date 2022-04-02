public class UndirectedEdge extends Edge
{
    UndirectedEdge()
    {
        V = new Node[2];
        isDirected = false;
    }

    UndirectedEdge(Node input0, Node input1)
    {
        V = new Node[2];
        setNodes(input0, input1);
        isDirected = false;
    }

    void setNodes(Node input1, Node input2)
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