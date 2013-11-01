import java.util.LinkedList;

class Test {
    public static void main(String[] args) {
        Graph g = new AdjacencyListGraph();
        Vertex a = g.addVertex("a");
        Vertex b = g.addVertex("b");
        Vertex c = g.addVertex("c");
        Vertex d = g.addVertex("d");
        Vertex e = g.addVertex("e");
        Edge ab = g.addEdge(a, b);
        Edge ac = g.addEdge(a, c);
        Edge ad = g.addEdge(a, d);
        Edge be = g.addEdge(b, e);
        Edge ce = g.addEdge(c, e);
        Edge de = g.addEdge(d, e);
        System.out.println(g);
        System.out.println(a.degree());
        System.out.println();

        Graph g1 = new AdjacencyListGraph(true);
        Vertex A0 = g1.addVertex("0");
        Vertex A1 = g1.addVertex("1");
        Vertex A2 = g1.addVertex("2");
        Vertex A3 = g1.addVertex("3");
        Vertex A4 = g1.addVertex("4");
        g1.addEdge(A0, A1);
        g1.addEdge(A0, A3);
        g1.addEdge(A0, A4);
        g1.addEdge(A1, A2);
        g1.addEdge(A1, A4);
        g1.addEdge(A2, A3);
        g1.addEdge(A3, A4);
        System.out.println(g1);
        System.out.println("indegree[1] = " + A1.indegree());
        System.out.println("outdegree[1] = " + A1.outdegree());
        System.out.println();

        Graph g2 = new AdjacencyListGraph();
        Vertex B0 = g2.addVertex("0");
        Vertex B1 = g2.addVertex("1");
        Vertex B2 = g2.addVertex("2");
        Vertex B3 = g2.addVertex("3");
        g2.addEdge(B0, B1);
        g2.addEdge(B1, B2);
        g2.addEdge(B2, B3);
        System.out.println(g2);
        System.out.println("degree[1] = " + B1.degree());
        System.out.println();

        Graph g3 = new AdjacencyListGraph();
        Vertex C0 = g3.addVertex("0");
        Vertex C1 = g3.addVertex("1");
        Vertex C2 = g3.addVertex("2");
        Vertex C3 = g3.addVertex("3");
        Vertex C4 = g3.addVertex("4");
        Vertex C5 = g3.addVertex("5");
        g3.addEdge(C0, C2);
        g3.addEdge(C0, C4);
        g3.addEdge(C1, C3);
        g3.addEdge(C1, C5);
        g3.addEdge(C2, C4);
        g3.addEdge(C3, C5);
        System.out.println(g3);
        System.out.println();
    }
}
