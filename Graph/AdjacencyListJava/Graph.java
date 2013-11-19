import java.util.Iterator;

interface Graph {
    public int getVertexCount();

    public int getEdgeCount();

    public boolean isDirected();

    public Edge addEdge(Vertex v, Vertex w);

    public Edge addEdge(Edge e);

    public Edge removeEdge(Vertex v, Vertex w);

    public Edge removeEdge(Edge e);

    public boolean hasEdge(Vertex v, Vertex w);

    public Vertex addVertex(Object vertexName);

    public Vertex addVertex(Object vertexName, Vertex v);

    public Vertex removeVertex(Vertex v);

    public Vertex removeVertex(Object vertexName);

    public Vertex getVertex(Object vertexName);

    @SuppressWarnings("rawtypes")
    public Iterator getAdjacentVertices(Vertex v);

    @SuppressWarnings("rawtypes")
    public Iterator getAdjacentVertices(Object vertexName);

    @SuppressWarnings("rawtypes")
    public Iterator getEdges(Vertex v);

    @SuppressWarnings("rawtypes")
    public Iterator getEdges(Object vertexName);

    @SuppressWarnings("rawtypes")
    public Iterator getVertices();

    @SuppressWarnings("rawtypes")
    public Iterator getEdges();

    public void DFS();

    public void BFS();

    public void countComponent();

    public boolean hasCycle();
}
