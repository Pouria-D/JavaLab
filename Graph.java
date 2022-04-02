public class Graph
{
    Node[] V;
    Edge[] E;

    Graph()
    {
        V = new Node[0];
        E = new Edge[0];
    }

    Graph(Edge[] input)
    {
        for (int i = 0; i < input.length; i++)
            addEdge(input[i]);
    }

    void addEdge(Edge e)
    {
        for (int i = 0; i < E.length; i++)
            if (E[i] == e)
                return;

        Edge[] tmp = new Edge[E.length + 1];
        for (int i = 0; i < E.length; i++)
            tmp[i] = E[i];
        tmp[E.length] = e;
        E = tmp;

        boolean p = false, q = false;
        for (int j = 0; j < V.length; j++)
        {
            if (V[j] == e.V[0])
                p = true;
            if (V[j] == e.V[1])
                q = true;
        }
        if (!p)
            addNode(e.V[0]);
        if (!q  &&  e.V[0] != e.V[1])
            addNode(e.V[1]);
    }

    void deleteEdge(Edge e)
    {
        boolean p = false;
        for (int i = 0; i < E.length; i++)
            if (E[i] == e)
            {
                p = true;
                Edge[] tmp = new Edge[E.length - 1];
                for (int j = 0; j < i; j++)
                    tmp[j] = E[j];
                for (int j = i + 1; j < E.length; j++)
                    tmp[j - 1] = E[j];
                E = tmp;
                break;
            }
        if (p)
        {
            e.V[0].deleteEdge(e);
            e.V[1].deleteEdge(e);
        }
    }

    void addNode(Node input)
    {
        for (int i = 0; i < V.length; i++)
            if (V[i] == input)
                return;

        Node[] tmp1 = new Node[V.length + 1];
        for (int i = 0; i < V.length; i++)
            tmp1[i] = V[i];
        tmp1[V.length] = input;
        V = tmp1;

        for (int i = 0; i < input.E.length; i++)
        {
            Node tmp2 = input.E[i].V[0];
            if (tmp2 == input)
                tmp2 = input.E[i].V[1];
            boolean p = false;
            for (int j = 0; j < V.length; j++)
                if (V[j] == tmp2)
                {
                    p = true;
                    break;
                }
            if (p)
                addEdge(input.E[i]);
        }
    }

    void deleteNode(Node input)
    {
        for (int i = 0; i < V.length; i++)
        {
            if (V[i] == input)
            {
                tmp = new Node[V.length - 1];
                for (int j = 0; j < i; j++)
                    tmp[j] = V[j];
                for (int j = i + 1; j < V.length; j++)
                    tmp[j - 1] = V[j];
                V = tmp;
                break;
            }
        }

        for (int i = E.length - 1; i >= 0; i--)
            if (E[i].V[0] == input  ||  E[i].V[1] == input)
            {
                Edge[] tmp = new Edge[E.length - 1];
                for (int j = 0; j < i; j++)
                    tmp[j] = E[j];
                for (int j = i + 1; j < E.length; j++)
                    tmp[j - 1] = E[j];
                E = tmp;
            }
    }

    Node[] getNodes()
    {
        return V;
    }

    Edge[] getEdges()
    {
        return E;
    }
}