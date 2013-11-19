import java.util.HashMap;
import java.util.Iterator;

/**
 * 
 */

/**
 * @author leon
 * 
 */
public class WeightedListGraph extends AdjacencyListGraph {

    /**
     * 
     */
    public WeightedListGraph() {

    }

    /**
     * @param directed
     */
    public WeightedListGraph(boolean directed) {
        super(directed);
    }

    public Edge addEdge(Vertex v, Vertex w, int weight) {
        Edge e = new WeightedAdjacencyListEdge(v, w, weight);
        return addEdge(e);
    }

    private class Tuple {
        public Integer dist;
        public Vertex pred;
        public boolean visited;

        public Tuple(Integer dist, Vertex pred, boolean visited) {
            this.dist = dist;
            this.pred = pred;
            this.visited = visited;
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
    public WeightedListGraph prim(Vertex s) {
        final HashMap hm = new HashMap<Vertex, Tuple>();
        Iterator<Vertex> iterator = this.getVertices();
        while (iterator.hasNext()) {
            hm.put(iterator.next(), new Tuple(Integer.MAX_VALUE, null, false));
        }
        hm.put(s, new Tuple(0, null, false));
        for (Object x : hm.keySet()) {
            final Vertex next = minVertex(hm);
            ((Tuple) hm.get(next)).visited = true;

            final Iterator it = next.getAdjacentVertices();
            while (it.hasNext()) {
                Vertex crt = (Vertex) it.next();
                int d = Integer.MAX_VALUE;
                try {
                    d = this.getWeight(next, crt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (!((Tuple) hm.get(crt)).visited
                        && ((Tuple) hm.get(crt)).dist > d) {
                    final Tuple tmp = (Tuple) hm.get(crt);
                    tmp.dist = d;
                    tmp.pred = next;
                }
            }
        }
        return MST(hm);
    }

    private WeightedListGraph MST(HashMap<Vertex, Tuple> hm) {
        WeightedListGraph mst = new WeightedListGraph();
        for (Vertex v : hm.keySet()) {
            mst.addVertex(v.getAttribute("Name"));
        }
        for (Vertex v : hm.keySet()) {
            if (hm.get(v).pred != null) {
                mst.addEdge(mst.getVertex(v.getAttribute("Name")),
                        mst.getVertex(hm.get(v).pred.getAttribute("Name")),
                        hm.get(v).dist);
            }
        }
        return mst;
    }

    @SuppressWarnings("rawtypes")
    public int getWeight(Vertex v, Vertex w) throws Exception {
        for (Iterator i = v.getEdges(); i.hasNext();) {
            WeightedAdjacencyListEdge e = (WeightedAdjacencyListEdge) i.next();
            if (!this.isDirected()
                    && (e.getSource() == w || e.getDestination() == w))
                return e.getWeight_();
            else if (e.getDestination() == w)
                return e.getWeight_();
        }
        throw new Exception("Edge doesn't exit");
    }

    @SuppressWarnings("rawtypes")
    private Vertex minVertex(HashMap hm) { // change to a Hash Map
        int x = Integer.MAX_VALUE;
        Vertex y = null; // Change y to a Vertex type
        for (Object v : hm.keySet()) { // loop through keySet
            Tuple crnt = (Tuple) hm.get(v); // change to use tuple
            if (!crnt.visited && crnt.dist < x) {
                y = (Vertex) v;
                x = crnt.dist; // update miminal distance.
            }
        }
        return y;
    }

}
