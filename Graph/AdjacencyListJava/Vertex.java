import java.util.Iterator;

interface Vertex extends Decorator {
    public void addEdge(Edge e);

    public void removeEdge(Edge e);

    public int degree();

    public int indegree();

    public int outdegree();

    public void increaseIndegree();

    public void decreaseIndegree();

    @SuppressWarnings("rawtypes")
    public Iterator getEdges();

    @SuppressWarnings("rawtypes")
    public Iterator getAdjacentVertices();

    public boolean isMarked();

    public void setMarked(boolean marked);

    public int getMarker();

    public void setMarker(int marder);
}
