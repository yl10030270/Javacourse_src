class Test {
    public static void main(String[] args) {

        WeightedListGraph g2 = new WeightedListGraph();
        Vertex a = g2.addVertex("a");
        Vertex b = g2.addVertex("b");
        Vertex c = g2.addVertex("c");
        Vertex d = g2.addVertex("d");
        Vertex e = g2.addVertex("e");
        g2.addEdge(a, b, 5);
        g2.addEdge(a, e, 2);
        g2.addEdge(a, c, 7);
        g2.addEdge(c, e, 4);
        g2.addEdge(b, e, 3);
        g2.addEdge(e, d, 5);
        g2.addEdge(c, d, 4);
        g2.addEdge(b, d, 6);
        WeightedListGraph tmp = g2.prim(a);
        System.out.println(tmp.toString());
        System.out.println();

        WeightedListGraph g = new WeightedListGraph();
        Vertex ga = g.addVertex("a");
        Vertex gb = g.addVertex("b");
        Vertex gc = g.addVertex("c");
        Vertex gd = g.addVertex("d");
        Vertex ge = g.addVertex("e");
        Vertex gf = g.addVertex("f");
        Vertex gg = g.addVertex("g");
        Vertex gh = g.addVertex("h");
        Vertex gi = g.addVertex("i");
        Vertex gj = g.addVertex("j");
        Vertex gk = g.addVertex("k");
        Vertex gl = g.addVertex("l");
        g.addEdge(ga, gb, 3);
        g.addEdge(ga, gc, 5);
        g.addEdge(ga, gd, 4);
        g.addEdge(gb, ge, 3);
        g.addEdge(gb, gf, 6);
        g.addEdge(gc, gd, 2);
        g.addEdge(gd, ge, 1);
        g.addEdge(ge, gf, 2);
        g.addEdge(gc, gg, 4);
        g.addEdge(gd, gh, 5);
        g.addEdge(ge, gi, 4);
        g.addEdge(gf, gj, 5);
        g.addEdge(gg, gh, 3);
        g.addEdge(gh, gi, 6);
        g.addEdge(gi, gj, 3);
        g.addEdge(gh, gk, 7);
        g.addEdge(gg, gk, 6);
        g.addEdge(gi, gl, 5);
        g.addEdge(gj, gl, 9);
        g.addEdge(gk, gl, 8);
        tmp = g.prim(ga);
        System.out.println(tmp.toString());
        System.out.println();
    }
}
