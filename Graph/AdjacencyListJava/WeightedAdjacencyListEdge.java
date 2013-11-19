/**
 * 
 */

/**
 * @author leon
 * 
 */
public class WeightedAdjacencyListEdge extends AdjacencyListEdge {

    /**
     * @param v
     * @param w
     */
    private final int weight_;

    public WeightedAdjacencyListEdge(Vertex v, Vertex w, int weight) {
        super(v, w);
        this.weight_ = weight;
    }

    public int getWeight_() {
        return weight_;
    }

}
