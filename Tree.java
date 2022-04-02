public class Tree extends DirectedGraph
{
    void addEdge(Edge e)
    {
        if (e.V[1].getInDegree() == 1)
        {
            System.out.println("This edge can not be added to the tree.");
            return;
        }
        super.addEdge(e);
    }

    Node getFather(Node input)
    {
        for (int i = 0; i < E.length; i++)
            if (E[i].V[1] == input)
                return E[i].V[0];
        return null;
    }

    Node[] getChildren()
    {
        int cnt = 0;
        for (int i = 0; i < E.length; i++)
            if (E[i].V[0] == input)
                cnt++;
        Node[] res = new Node[tmp];
        for (int i = 0; i < E.length; i++)
            if (E[i].V[0] == input)
                res[--tmp] = E[i].V[1];
        return res;
    }

    Node[] getAncestors(node input)
    {
        Node tmp1 = getFather(input);
        if (tmp == null)
            return new Node[0];
        Node[] tmp2 = getAncestors(tmp1);
        Node[] res = new Node[tmp2.length + 1];
        res[0] = tmp1;
        for (int i = 1; i < tmp2.length; i++)
            res[i] = tmp2[i - 1];
        return res;
    }

    Edge[] getPath(Node[] input)
    {
        Node[] tmp1 = getAncestors(input[0]);
        for (int i = 0; i < tmp.length; i++)
            if (tmp[i] == input[1])
            {
                Edge[] tmp2 = getPath({input[1], input[0]});
                Edge[] res = new Edge[tmp2.length];
                for (int j = 0; j < tmp2.length; j++)
                    res[j] = tmp2[tmp2.length - 1 - j];
                return res;
            }
        tmp1 = getAncestors(input[1]);
        for (int i = 0; i < tmp1.length; i++)
            if (tmp1[i] == input[0])
            {
                Node[] tmp3 = new Node[i + 1];
                tmp3[0] = input[1];
                for (int j = 0; j < i; j++)
                    tmp3[j + 1] = tmp1[i];
                Edge[] res = new Edge[i];
                for (int j = 0; j < i; j++)
                    for (int k = 0; k < E.length; k++)
                        if (E[k].V[0] == tmp3[j + 1]  &&  E[k].V[1] == tmp3[j])
                        {
                            res[j] = E[k];
                            break;
                        }
            }
        return null;
    }
}
