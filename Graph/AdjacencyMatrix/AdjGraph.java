/**
 * 
 */

/**
 * @author leon
 * 
 */
public class AdjGraph {

    private int[][] matrix;
    private boolean directed;

    public AdjGraph(int v) {
        matrix = new int[v][v];
        directed = false;
    }

    public AdjGraph(int v, boolean directed) {
        matrix = new int[v][v];
        this.directed = directed;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    void addEdge(int u, int v) {
        if (directed) {
            matrix[u][v] = 1;
        } else {
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }
    }

    public int degree(int v) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result += matrix[v][i];
        }
        return result;
    }

    public int inDegree(int v) {
        return degree(v);
    }

    public int outDegree(int v) {
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            result += matrix[i][v];
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sBuilder.append(matrix[i][j]);
                if (j < size - 1) {
                    sBuilder.append(" ");
                }
            }
            if (i < size - 1) {
                sBuilder.append(System.getProperty("line.separator"));
            }

        }
        return sBuilder.toString();
    }
}
