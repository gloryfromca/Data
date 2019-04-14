package Chapter09_Graph;

import java.util.HashMap;
import java.util.Map;

class DijkstraVertexItem implements Comparable<DijkstraVertexItem> {
  double dist;
  DijkstraVertex dijkstraVertex;

  DijkstraVertexItem(double dist, DijkstraVertex dijkstraVertex) {
    this.dist = dist;
    this.dijkstraVertex = dijkstraVertex;
  }

  @Override
  public int compareTo(DijkstraVertexItem o) {
    return (int) (this.dist - o.dist);
  }

}


public class DijkstraVertex extends Vertex {
  Map<DijkstraVertex, Double> toMapping;

  boolean known;
  double dist;
  DijkstraVertex path;

  DijkstraVertex(String name) {
    super(name);
    toMapping = new HashMap<>();
  }

  public Edge addTo(DijkstraVertex dijkstraVertex, int dist) {
    this.toMapping.put(dijkstraVertex, (double) dist);
    return new Edge(dijkstraVertex, this, dist);
  }

}
