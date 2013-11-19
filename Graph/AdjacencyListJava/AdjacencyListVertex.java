import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

class AdjacencyListVertex implements Vertex {
    public static final String name = "Name";
    @SuppressWarnings("rawtypes")
    private List edges_;
    private int indegreee_;
    private boolean marked;
    private int marker;

    @SuppressWarnings("rawtypes")
    public AdjacencyListVertex(Object n) {
        setAttribute(name, n);
        edges_ = new LinkedList();
        indegreee_ = 0;
        marked = false;
        marker = 0;
    }

    @SuppressWarnings("unchecked")
    public void addEdge(Edge e) {
        edges_.add(e);
    }

    @SuppressWarnings("rawtypes")
    public void removeEdge(Edge e) {
        for (Iterator i = edges_.iterator(); i.hasNext();)
            if (e == (Edge) i.next()) {
                i.remove();
                break;
            }
    }

    @SuppressWarnings("rawtypes")
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

    @SuppressWarnings("rawtypes")
    public Iterator getAdjacentVertices() {
        return new AdjIterator(this);
    }

    @SuppressWarnings("rawtypes")
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

    @SuppressWarnings("rawtypes")
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
    @SuppressWarnings("rawtypes")
    private final Map attributes_ = new HashMap();

    public final boolean hasAttribute(Object key) {
        return attributes_.containsKey(key);
    }

    public final Object getAttribute(Object key) {
        return attributes_.get(key);
    }

    @SuppressWarnings("unchecked")
    public final void setAttribute(Object key) {
        attributes_.put(key, null);
    }

    @SuppressWarnings("unchecked")
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

    @Override
    public boolean isMarked() {
        return marked;
    }

    @Override
    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    @Override
    public int getMarker() {
        return marker;
    }

    @Override
    public void setMarker(int marder) {
        this.marker = marder;
    }
}
