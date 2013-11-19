import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class AdjacencyListGraph implements Graph {
    @SuppressWarnings("rawtypes")
    private Map vertices_;
    @SuppressWarnings("rawtypes")
    private List edges_;
    private boolean directed_;
    private int count;
    private boolean hasCycle_;
    private List<List<Vertex>> components_;

    public AdjacencyListGraph() {
        this(false);
    }

    @SuppressWarnings("rawtypes")
    public AdjacencyListGraph(boolean directed) {
        vertices_ = new TreeMap();
        edges_ = new LinkedList();
        directed_ = directed;
        hasCycle_ = false;
        components_ = new ArrayList<>();
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

    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("rawtypes")
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

    @SuppressWarnings("rawtypes")
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

    @SuppressWarnings("rawtypes")
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

    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("rawtypes")
    public Iterator getAdjacentVertices(Vertex v) {
        return v.getAdjacentVertices();
    }

    @SuppressWarnings("rawtypes")
    public Iterator getAdjacentVertices(Object vertexName) {
        Vertex v = (Vertex) vertices_.get(vertexName);
        if (v != null)
            return v.getAdjacentVertices();
        return null;
    }

    @SuppressWarnings("rawtypes")
    public Iterator getEdges(Vertex v) {
        return v.getEdges();
    }

    @SuppressWarnings("rawtypes")
    public Iterator getEdges(Object vertexName) {
        Vertex v = (Vertex) vertices_.get(vertexName);
        if (v != null)
            return v.getEdges();
        return null;
    }

    @SuppressWarnings("rawtypes")
    public Iterator getVertices() {
        return vertices_.values().iterator();
    }

    @SuppressWarnings("rawtypes")
    public Iterator getEdges() {
        return edges_.iterator();
    }

    @Override
    public boolean hasCycle() {
        DFS();
        return hasCycle_;
    }

    private void resetMarker() {
        for (Object v : vertices_.values()) {
            ((Vertex) v).setMarker(0);
            ((Vertex) v).setMarked(false);
        }
        count = 0;
    }

    public void DFS() {
        resetMarker();
        for (Object v : vertices_.values()) {
            if (((Vertex) v).getMarker() == 0) {
                dfs((Vertex) v, null);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void dfs(Vertex v, Vertex parent) {
        count += 1;
        System.out.println("visiting vertex "
                + v.getAttribute("Name").toString());
        v.setMarker(count);
        Iterator<Vertex> iterator = v.getAdjacentVertices();
        TreeMap<Object, Vertex> tmpMap = new TreeMap<>();
        while (iterator.hasNext()) {
            Vertex tmp = iterator.next();
            tmpMap.put(tmp.getAttribute("Name"), tmp);
        }
        for (Object x : tmpMap.keySet()) {
            if (tmpMap.get(x).getMarker() == 0) {
                dfs(tmpMap.get(x), v);
            } else if (parent != null
                    && !tmpMap.get(x).getAttribute("Name")
                            .equals(parent.getAttribute("Name"))) {
                if (directed_) {
                    if (!tmpMap.get(x).isMarked()) {
                        hasCycle_ = true;
                    } else {
                        Iterator<Edge> it = getEdges(x);
                        while (it.hasNext()) {
                            Edge e = it.next();
                            if (e.getDestination() == v) {
                                hasCycle_ = true;
                                break;
                            }
                        }
                    }
                } else {
                    hasCycle_ = true;
                }
            }
        }
        v.setMarked(true);
    }

    public void BFS() {
        resetMarker();
        for (Object v : vertices_.values()) {
            if (((Vertex) v).getMarker() == 0) {
                bfs((Vertex) v);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void bfs(Vertex v) {
        // TODO Auto-generated method stub
        count += 1;
        System.out.println("visiting vertex "
                + v.getAttribute("Name").toString());
        v.setMarker(count);
        Queue<Vertex> q = new ArrayDeque<>();
        List<Vertex> comList = new ArrayList<>();
        q.add(v);
        comList.add(v);
        Vertex w;
        while (!q.isEmpty()) {
            w = q.peek();
            Iterator<Vertex> iterator = w.getAdjacentVertices();
            TreeMap<Object, Vertex> tmpMap = new TreeMap<>();
            while (iterator.hasNext()) {
                Vertex tmp = iterator.next();
                tmpMap.put(tmp.getAttribute("Name"), tmp);
            }
            for (Object x : tmpMap.keySet()) {
                if (tmpMap.get(x).getMarker() == 0) {
                    count++;
                    Vertex current = tmpMap.get(x);
                    System.out.println("visiting vertex "
                            + current.getAttribute("Name").toString());
                    current.setMarker(count);
                    q.add(current);
                    comList.add(current);
                }
            }
            q.remove();
        }
        components_.add(comList);
    }

    @Override
    public void countComponent() {
        components_.clear();
        BFS();
        for (int i = 0; i < components_.size(); i++) {
            System.out.print("component " + (i + 1) + ": { ");
            for (Vertex v : components_.get(i)) {
                System.out.print(v.getAttribute("Name") + " ");
            }
            System.out.print("}");
            System.out.println();
        }
    }

    @SuppressWarnings("rawtypes")
    public final String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("{\n");
        for (Iterator i = vertices_.values().iterator(); i.hasNext();)
            sb.append("   " + i.next() + "\n");
        sb.append("}");
        return sb.toString();
    }
}
