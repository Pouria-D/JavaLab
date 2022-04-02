public class Test
{
    public static void main(String[] args)
    {
        Graph G = new Graph();
        Node u1 = new Node();
        Node u2 = new Node();
        Edge e1 = new DirectedEdge(new Node[]{u1, u2});
        //Edge e2 = new Edge();//error
        System.out.println(u1.getInDegree());
        System.out.println(u1.getOutDegree());
        System.out.println(u2.getInDegree());
        System.out.println(u2.getOutDegree());
        
    }
}