/**
 * 
 */

/**
 * @author leon
 * 
 */
public class GraphTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AdjGraph g1 = new AdjGraph(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 3);
        g1.addEdge(0, 4);
        g1.addEdge(1, 2);
        g1.addEdge(1, 4);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println(g1);
        System.out.println();
        System.out.println("degree[0] = " + g1.degree(0));
        System.out.println();
        AdjGraph g2 = new AdjGraph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        System.out.println(g2);
        System.out.println();
        AdjGraph g3 = new AdjGraph(6);
        g3.addEdge(0, 2);
        g3.addEdge(0, 4);
        g3.addEdge(1, 3);
        g3.addEdge(1, 5);
        g3.addEdge(2, 4);
        g3.addEdge(3, 5);
        System.out.println(g3);
        System.out.println();
    }
    

}
