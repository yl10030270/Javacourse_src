import java.util.Iterator;

interface Vertex extends Decorator {
    public void addEdge(Edge e);

    public void removeEdge(Edge e);

    public int degree();

    public int indegree();

    public int outdegree();

    public void increaseIndegree();
    
    public void decreaseIndegree();

    public Iterator getEdges();

    public Iterator getAdjacentVertices();
}
