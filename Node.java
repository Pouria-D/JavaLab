public class Node
{
    Edge[] E;

    Node()
    {
        E = new Edge[0];
    }

    int getInDegree()
    {
        int res = 0;
        for (int i = 0; i < E.length; i++)
        {
            if (E[i].isDirected)
            {
                if (E[i].V[1] == this)
                    res++;
            }
            else
                for (int j = 0; j < 2; j++)
                    if (E[i].V[j] == this)
                        res++;
        }
        return res;
    }

    int getOutDegree()
    {
        int res = 0;
        for (int i = 0; i < E.length; i++)
        {
            if (E[i].isDirected)
            {
                if (E[i].V[0] == this)
                    res++;
            }
            else
                for (int j = 0; j < 2; j++)
                    if (E[i].V[j] == this)
                        res++;
        }
        return res;
    }

    void addEdge(Edge e)
    {
        Edge[] tmp = new Edge[E.length + 1];
        for (int i = 0; i < E.length; i++)
            tmp[i] = E[i];
        tmp[E.length] = e;
        E = tmp;
    }

    void deleteEdge(Edge e)
    {
        for (int i = 0; i < E.length; i++)
            if (E[i] == e)
            {
                Edge[] tmp = new Edge[E.length - 1];
                for (int j = 0; j < i - 1; j++)
                    tmp[j] = E[j];
                for (int j = i + 1; j < E.length; j++)
                    tmp[j - 1] = E[j];
                E = tmp;
                return;
            }
        System.out.println("These node and edge do not intersect.");///////////////
    }

    Edge[] getEdges()
    {
        return E;
    }
}