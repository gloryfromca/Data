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


public class DijkstraVertex {
  Map<DijkstraVertex, Double> toMapping;

  boolean known;
  double dist;
  DijkstraVertex path;

  DijkstraVertex() {
    toMapping = new HashMap<>();
  }

  public void addTo(DijkstraVertex dijkstraVertex, int dist) {
    this.toMapping.put(dijkstraVertex, (double) dist);
  }

}
