package Chapter09_Graph;

import Chapter06_Heap.BinaryHeap;
import Chapter08_DisjointSets.CommonDisjointSets;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

  void prim(DijkstraVertex s) throws Exception {
    /**
     * minimum spanning tree
     */

    if (!contain(s)) {
      throw new Exception("Start Point not in List!");
    }

    BinaryHeap<DijkstraVertexItem> dijkstraVertexItemBinaryHeap = new BinaryHeap<>();

    for (DijkstraVertex item : dijkstraVertices) {

      item.dist = 1.0 / 0.0;
      item.path = null;
      item.known = false;

    }

    s.dist = 0;
    for (DijkstraVertex item : dijkstraVertices) {
      dijkstraVertexItemBinaryHeap.insert(new DijkstraVertexItem(item.dist, item));
    }

    while (!dijkstraVertexItemBinaryHeap.isEmpty()) {
      DijkstraVertex minDistItem = dijkstraVertexItemBinaryHeap.deleteMin().dijkstraVertex;
      minDistItem.known = true;
      for (DijkstraVertex to : minDistItem.toMapping.keySet()) {
        double cost = minDistItem.toMapping.get(to);
        if (to.known) {
          continue;
        }
        if (cost < to.dist) {
          to.dist = cost;
          to.path = minDistItem;
          dijkstraVertexItemBinaryHeap.insert(new DijkstraVertexItem(to.dist, to));
        }
      }
    }
  }

  boolean contain(DijkstraVertex s) {
    return dijkstraVertices.contains(s);
  }

  List<Edge> kruskal(List<Edge> edges) {
    int numVertices = this.dijkstraVertices.size();
    CommonDisjointSets<DijkstraVertex> ds = new CommonDisjointSets<>(this.dijkstraVertices);
    BinaryHeap<Edge> edgeBinaryHeap = new BinaryHeap<>();
    List<Edge> result = new ArrayList<>();

    for (Edge edge : edges) {
      edgeBinaryHeap.insert(edge);
    }

    while (result.size() < numVertices - 1) {
      Edge minEdge = edgeBinaryHeap.deleteMin();
      DijkstraVertex dijkstraVertexDependee = (DijkstraVertex) minEdge.getDependee();
      DijkstraVertex dijkstraVertexDependency = (DijkstraVertex) minEdge.getDependency();

      if (ds.find(dijkstraVertexDependee) != ds.find(dijkstraVertexDependency)) {
        DijkstraVertex dependeeRoot = ds.findRoot(dijkstraVertexDependee);
        DijkstraVertex dependencyRoot = ds.findRoot(dijkstraVertexDependency);
        result.add(minEdge);
        ds.union(dependeeRoot, dependencyRoot);

      }
    }
    return result;

  }

}
