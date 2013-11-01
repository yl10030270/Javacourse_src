import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class AdjacencyListGraph implements Graph {
    private Map vertices_;
    private List edges_;
    private boolean directed_;

    public AdjacencyListGraph() {
        this(false);
    }

    public AdjacencyListGraph(boolean directed) {
        vertices_ = new TreeMap();
        edges_ = new LinkedList();
        directed_ = directed;
    }

    public int getVertexCount() {
        return vertices_.size();
    }

    public int getEdgeCount() {
        return edges_.size();
    }

    public boolean isDirected() {
        return directed_;
    }

    public Edge addEdge(Vertex v, Vertex w) {
        Edge e = new AdjacencyListEdge(v, w);
        return addEdge(e);
    }

    public Edge addEdge(Edge e) {
        Vertex v = e.getSource();
        Vertex w = e.getDestination();
        edges_.add(e);
        v.addEdge(e);
        w.increaseIndegree();
        if (!directed_) {
            w.addEdge(e);
            v.increaseIndegree();
        }
        return e;
    }

    public Edge removeEdge(Vertex v, Vertex w) {
        Edge e = null;

        for (Iterator i = edges_.iterator(); i.hasNext();) {
            e = (Edge) i.next();
            if (e.hasVertex(v) && e.hasVertex(w)) {
                i.remove();
                v.removeEdge(e);
                w.decreaseIndegree();
                if (!directed_) {
                    w.removeEdge(e);
                    v.decreaseIndegree();
                }

                break;
            }
        }
        return e;
    }

    public Edge removeEdge(Edge e) {
        Vertex v = e.getSource();
        Vertex w = e.getDestination();
        for (Iterator i = edges_.iterator(); i.hasNext();) {
            Edge f = (Edge) i.next();
            if (e == f) {
                i.remove();
                v.removeEdge(e);
                w.decreaseIndegree();
                if (!directed_) {
                    w.removeEdge(e);
                    v.decreaseIndegree();
                }

                break;
            }
        }
        return e;
    }

    public boolean hasEdge(Vertex v, Vertex w) {
        for (Iterator i = v.getEdges(); i.hasNext();) {
            Edge e = (Edge) i.next();
            if (e.hasVertex(w))
                return true;
        }
        return false;
    }

    public Vertex addVertex(Object vertexName) {
        Vertex v = new AdjacencyListVertex(vertexName);
        addVertex(vertexName, v);
        return v;
    }

    public Vertex addVertex(Object vertexName, Vertex v) {
        vertices_.put(vertexName, v);
        return v;
    }

    public Vertex removeVertex(Vertex v) {
        // not yet implemented
        return v;
    }

    public Vertex removeVertex(Object vertexName) {
        // not yet implemented
        return (Vertex) vertices_.get(vertexName);
    }

    public Vertex getVertex(Object vertexName) {
        return (Vertex) vertices_.get(vertexName);
    }

    public Iterator getAdjacentVertices(Vertex v) {
        return v.getAdjacentVertices();
    }

    public Iterator getAdjacentVertices(Object vertexName) {
        Vertex v = (Vertex) vertices_.get(vertexName);
        if (v != null)
            return v.getAdjacentVertices();
        return null;
    }

    public Iterator getEdges(Vertex v) {
        return v.getEdges();
    }

    public Iterator getEdges(Object vertexName) {
        Vertex v = (Vertex) vertices_.get(vertexName);
        if (v != null)
            return v.getEdges();
        return null;
    }

    public Iterator getVertices() {
        return vertices_.values().iterator();
    }

    public Iterator getEdges() {
        return edges_.iterator();
    }

    public final String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("{\n");
        for (Iterator i = vertices_.values().iterator(); i.hasNext();)
            sb.append("   " + i.next() + "\n");
        sb.append("}");
        return sb.toString();
    }
}
