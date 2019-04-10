package Chapter09_Graph;

import java.util.List;
import java.util.Map;
import Chapter06_Heap.BinaryHeap;

public class DijkstraHelper {
  List<DijkstraVertex> dijkstraVertices;

  DijkstraHelper(List<DijkstraVertex> dijkstraVertices) {
    this.dijkstraVertices = dijkstraVertices;

  }

  public void Dijkstra(DijkstraVertex s) throws Exception {
    if (!contain(s)) {
      throw new Exception("Start Point not in List!");
    }
    for (DijkstraVertex dijkstraVertex : dijkstraVertices) {
      dijkstraVertex.path = null;
      dijkstraVertex.known = false;
      dijkstraVertex.dist = 1.0 / 0.0;
    }

    BinaryHeap<DijkstraVertexItem> heap = new BinaryHeap<>();

    s.dist = 0;
    for (DijkstraVertex dijkstraVertex : dijkstraVertices) {
      DijkstraVertexItem dijkstraVertexItem =
          new DijkstraVertexItem(dijkstraVertex.dist, dijkstraVertex);
      heap.insert(dijkstraVertexItem);
    }

    while (!heap.isEmpty()) {
      DijkstraVertexItem minDistVertexItem = heap.deleteMin();
      DijkstraVertex dijkstraVertex = minDistVertexItem.dijkstraVertex;
      if (!dijkstraVertex.known) {

        dijkstraVertex.known = true;
        dijkstraVertex.dist = minDistVertexItem.dist;

        Map<DijkstraVertex, Double> toMapping = dijkstraVertex.toMapping;
        for (DijkstraVertex to : toMapping.keySet()) {
          double cost = toMapping.get(to);
          if (dijkstraVertex.dist + cost < to.dist) {
            DijkstraVertexItem toDijkstraVertexItem =
                new DijkstraVertexItem(dijkstraVertex.dist + cost, to);
            heap.insert(toDijkstraVertexItem);
            to.path = dijkstraVertex;
          }

        }

      }

    }

  }

  boolean contain(DijkstraVertex s) {
    return dijkstraVertices.contains(s);
  }

}
