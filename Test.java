public class Test
{
    public static void main(String[] args)
    {
        /*Graph G = new Graph();
        Node u1 = new Node();
        Node u2 = new Node();
        Edge e1 = new DirectedEdge(u1, u2);
        //Edge e2 = new Edge();//error
        System.out.println(u1.getInDegree());
        System.out.println(u1.getOutDegree());
        System.out.println(u2.getInDegree());
        System.out.println(u2.getOutDegree());*/

        /*//https://www.researchgate.net/profile/Peter-Sutovsky/publication/282261082/figure/fig3/AS:511944786677760@1499068556942/Example-of-directed-tree.png
        Tree T = new Tree();
        Node A, B, C, D, E, F, G, H, I, J, K;
        T.addEdge(new DirectedEdge(A = new Node(), B = new Node()));
        T.addEdge(new DirectedEdge(A, C = new Node()));
        T.addEdge(new DirectedEdge(A, D = new Node()));
        T.addEdge(new DirectedEdge(B, E = new Node()));
        T.addEdge(new DirectedEdge(B, F = new Node()));
        T.addEdge(new DirectedEdge(C, G = new Node()));
        T.addEdge(new DirectedEdge(C, H = new Node()));
        T.addEdge(new DirectedEdge(C, I = new Node()));
        T.addEdge(new DirectedEdge(H, J = new Node()));
        T.addEdge(new DirectedEdge(H, K = new Node()));
        for (int i = 0; i < T.V.length; i++)
            System.out.println(T.V[i].getInDegree() + " " + T.V[i].getOutDegree());*/
        
        /*//data:image/png;base64,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
        DirectedGraph DG = new DirectedGraph();
        for (int i = 0; i < 9; i++)
            DG.addNode(new Node());
        DG.addEdge(new DirectedEdge(DG.V[7], DG.V[4]));
        DG.addEdge(new DirectedEdge(DG.V[4], DG.V[4]));
        DG.addEdge(new DirectedEdge(DG.V[4], DG.V[4]));
        DG.addEdge(new DirectedEdge(DG.V[8], DG.V[0]));
        DG.addEdge(new DirectedEdge(DG.V[2], DG.V[0]));
        DG.addEdge(new DirectedEdge(DG.V[0], DG.V[6]));
        DG.addEdge(new DirectedEdge(DG.V[5], DG.V[3]));
        DG.addEdge(new DirectedEdge(DG.V[3], DG.V[1]));
        DG.addEdge(new DirectedEdge(DG.V[1], DG.V[6]));
        DG.addEdge(new DirectedEdge(DG.V[6], DG.V[3]));
        for (int i = 0; i < 9; i++)
            System.out.println(DG.V[i].getInDegree() + " " + DG.V[i].getOutDegree());*/
    
        //data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAPQAAADPCAMAAAD1TAyiAAABZVBMVEX///8AAAD+/v7///78///7+/v//f////za2tq0tLT///u3t7f8/v/09PT6//////nl5eXQ0NA7Ozv1//+9vb3g4OBISEjX19eamprw8PBjY2N6enqqqqrq6upYWFiWlpYfHx82NjbHx8dzc3NCQkIcHBwODg6Ghob///Pt//8sLCxPT0+rq6uLi4svLy9dXV3//+xra2t2dnako6Hu6+IUHClFOzPc6e7RyLIADiTG1+H06NVdTjlfcod6bFpRaHqzo4zW7/9gRDeNpbfk0rwQDSGuxuNNMiD648iFmam30Ol1Y0tBVmemlHsAEyXb+f+qvsvn2cw9JAqMgXO1xtInMTyswdMAACY9LDUYDAo5NUAlDwBHLyN4hY9RXWRNQTiaqa9fV1CiopGytMG7uKwgKjjPz8OKcngxQk3Q5P7/+9tsZ3VmgY8nOFKdkogbNjrTwsFban4pHiHfwKEeJDpcUj+MkqQDqGvNAAAagElEQVR4nO1diVsjx5Wvo7tLavqQ0H0iCZAEEiAQNtg4Yzse79obe23HM856PTPBSdabOMnk3Pz9+96raixA96i5Pt43M6AedXf96nj17mLskR7pkR7pkR7pzUhc/Xz1wkMkAEl/9A8DWogHjZ3waqAXV0xHPGSKQLPOVh6oZy7eaptiJqHHmrX4TzS87UbFTTCitmAJwrx5dLRZwV+qafagFzWt3kKD8/qwSBeGw02A3brO1h8SAbZCE1DmmAoVAS21tng7e9vtipdEbpvzFGOqG7qMecIRzIexftCobeRhgNmxw/C4VssEzHEYe9jcjIY1X2OO6HZbb5XfLp9kHJuxOufp225afASMDKey46jB6TvvsrP3frajXMFSnCduu2nxkWAVvllirhLdJ+9n3MEH73xoAT+z93jZvu22xUicbzARhuLs5x/thD8+/fjfLOwKWOj+bbcsRkLQsFmHn/z7RztqgKAVXM0+fNDScQi0RaAlyCsPHnSRCctSn/z8051gcPrxf5A8/sCn9xrPF5jHwsEvPgPQn//nFxbIZaX6wwZto6TtOeHglH/Jvvrl+U4As7v2oEUyLXPmQCJzw1a70T4PAkfinEed4yGS0P8kOF8rgHgShvAxsEAIZQUeoRYPS90isxgqlqVDQugI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
        /*//Defining the tree
        Tree T = new Tree();
        for (int i = 0; i < 10; i++)
            T.addNode(new Node());
        T.addEdge(new DirectedEdge(T.V[0], T.V[1]));
        T.addEdge(new DirectedEdge(T.V[0], T.V[2]));
        T.addEdge(new DirectedEdge(T.V[2], T.V[6]));
        T.addEdge(new DirectedEdge(T.V[1], T.V[3]));
        T.addEdge(new DirectedEdge(T.V[1], T.V[4]));
        T.addEdge(new DirectedEdge(T.V[1], T.V[5]));
        T.addEdge(new DirectedEdge(T.V[3], T.V[7]));
        T.addEdge(new DirectedEdge(T.V[4], T.V[8]));
        T.addEdge(new DirectedEdge(T.V[4], T.V[9]));*/
        /*//InDegrees and OutDegrees
        for (int i = 0; i < T.V.length; i++)
            System.out.println(T.V[i].getInDegree() + " " + T.V[i].getOutDegree());*/
        /*//Children
        for (int i = 0; i < T.V.length; i++)
        {
            System.out.print(i + ": ");
            Node[] tmp = T.getChildren(T.V[i]);
            for (int k = 0; k < T.V.length; k++)
                for (int j = 0; j < tmp.length; j++)
                    if (T.V[k] == tmp[j])
                    {
                        System.out.print(k + " ");
                        break;
                    }
            System.out.println();
        }*/
        /*//Ancestors
        for (int i = 0; i < T.V.length; i++)
        {
            System.out.print(i + ": ");
            Node[] tmp = T.getAncestors(T.V[i]);
            for (int j = 0; j < tmp.length; j++)
                for (int k = 0; k < T.V.length; k++)
                    if (T.V[k] == tmp[j])
                    {
                        System.out.print(k + " ");
                        break;
                    }
            System.out.println();
        }*/
        /*//Paths
        for (int i = 0; i < T.V.length; i++)
            for (int j = i + 1; j < T.V.length; j++)
            {
                Edge[] tmp1 = T.getPath(T.V[i], T.V[j]);
                if (tmp1 != null)
                {
                    Node[] tmp2 = new Node[tmp1.length + 1];
                    tmp2[0] = tmp1[tmp1.length - 1].V[0];
                    for (int k = tmp1.length - 1; k >= 0; k--)
                        tmp2[tmp1.length - k] = tmp1[k].V[1];
                    for (int k = 0; k < tmp2.length; k++)
                    {
                        for (int l = 0; l < T.V.length; l++)
                            if (tmp2[k] == T.V[l])
                            {
                                System.out.print(l + " ");
                                break;
                            }
                    }
                    System.out.println();
                }
            }*/
    
        //https://www.researchgate.net/profile/Christian-Blum-5/publication/220058908/figure/fig1/AS:654063926530060@1532952400669/Example-of-a-directed-tree-T-V-T-E-T.png
        /*//Defining the tree
        Tree T = new Tree();
        for (int i = 0; i < 8; i++)
            T.addNode(new Node());
        T.addEdge(new DirectedEdge(T.V[0], T.V[1]));
        T.addEdge(new DirectedEdge(T.V[1], T.V[2]));
        T.addEdge(new DirectedEdge(T.V[1], T.V[3]));
        T.addEdge(new DirectedEdge(T.V[3], T.V[4]));
        T.addEdge(new DirectedEdge(T.V[4], T.V[5]));
        T.addEdge(new DirectedEdge(T.V[4], T.V[6]));
        T.addEdge(new DirectedEdge(T.V[4], T.V[7]));*/
        /*//InDegrees and OutDegrees
        for (int i = 0; i < T.V.length; i++)
        {
            System.out.print(i + 1 + ": ");
            System.out.println(T.V[i].getInDegree() + " " + T.V[i].getOutDegree());
        }*/
        /*//Children
        for (int i = 0; i < T.V.length; i++)
        {
            System.out.print(i + 1 + ": ");
            Node[] tmp = T.getChildren(T.V[i]);
            for (int k = 0; k < T.V.length; k++)
                for (int j = 0; j < tmp.length; j++)
                    if (T.V[k] == tmp[j])
                    {
                        System.out.print(k + 1 + " ");
                        break;
                    }
            System.out.println();
        }*/
        /*//Ancestors
        for (int i = 0; i < T.V.length; i++)
        {
            System.out.print(i + 1 + ": ");
            Node[] tmp = T.getAncestors(T.V[i]);
            for (int j = 0; j < tmp.length; j++)
                for (int k = 0; k < T.V.length; k++)
                    if (T.V[k] == tmp[j])
                    {
                        System.out.print(k + 1 + " ");
                        break;
                    }
            System.out.println();
        }*/
        /*//Paths
        for (int i = 0; i < T.V.length; i++)
            for (int j = i + 1; j < T.V.length; j++)
            {
                Edge[] tmp1 = T.getPath(T.V[i], T.V[j]);
                if (tmp1 != null)
                {
                    Node[] tmp2 = new Node[tmp1.length + 1];
                    tmp2[0] = tmp1[tmp1.length - 1].V[0];
                    for (int k = tmp1.length - 1; k >= 0; k--)
                        tmp2[tmp1.length - k] = tmp1[k].V[1];
                    for (int k = 0; k < tmp2.length; k++)
                    {
                        for (int l = 0; l < T.V.length; l++)
                            if (tmp2[k] == T.V[l])
                            {
                                System.out.print(l + 1 + " ");
                                break;
                            }
                    }
                    System.out.println();
                }
            }*/
    }
}