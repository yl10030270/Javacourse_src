import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

class AdjacencyListVertex implements Vertex {
    public static final String name = "Name";
    private List edges_;
    private int indegreee_;

    public AdjacencyListVertex(Object n) {
        setAttribute(name, n);
        edges_ = new LinkedList();
        indegreee_ = 0;
    }

    public void addEdge(Edge e) {
        edges_.add(e);
    }

    public void removeEdge(Edge e) {
        for (Iterator i = edges_.iterator(); i.hasNext();)
            if (e == (Edge) i.next()) {
                i.remove();
                break;
            }
    }

    public Iterator getEdges() {
        return edges_.iterator();
    }

    @Override
    public void increaseIndegree() {
        this.indegreee_++;
    }

    @Override
    public void decreaseIndegree() {
        this.indegreee_--;
    }

    public Iterator getAdjacentVertices() {
        return new AdjIterator(this);
    }

    class AdjIterator implements Iterator {
        private Iterator i_;
        private Vertex v_;

        public AdjIterator(Vertex v) {
            i_ = edges_.iterator();
            v_ = v;
        }

        public boolean hasNext() {
            return i_.hasNext();
        }

        public Object next() {
            Edge e = (Edge) i_.next();
            return e.otherVertex(v_);
        }

        public void remove() {
            i_.remove();
        }
    }

    public final String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("{ " + getAttribute(name) + ":  { ");
        for (Iterator i = getAdjacentVertices(); i.hasNext();) {
            Vertex v = (Vertex) i.next();
            sb.append(v.getAttribute(name) + " ");
        }
        sb.append("} }");
        return sb.toString();
    }

    // decorator pattern attributes and methods
    private final Map attributes_ = new HashMap();

    public final boolean hasAttribute(Object key) {
        return attributes_.containsKey(key);
    }

    public final Object getAttribute(Object key) {
        return attributes_.get(key);
    }

    public final void setAttribute(Object key) {
        attributes_.put(key, null);
    }

    public final void setAttribute(Object key, Object value) {
        attributes_.put(key, value);
    }

    public final void removeAttribute(Object key) {
        attributes_.remove(key);
    }

    @Override
    public int degree() {
        return edges_.size();
    }

    @Override
    public int indegree() {
        return indegreee_;
    }

    @Override
    public int outdegree() {
        // TODO Auto-generated method stub
        return degree();
    }
}
