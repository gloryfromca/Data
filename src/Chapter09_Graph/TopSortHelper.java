package Chapter09_Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

class CycleFoundException extends Exception {

}


class TopSortHelper {
  void TopSort(List<Edge> edges) throws CycleFoundException {
    ArrayList<Vertex> q = new ArrayList<>();
    HashSet<Vertex> allVertexs = new HashSet<>();

    for (Edge edge : edges) {
      Vertex dependee = edge.getDependee();
      Vertex dependency = edge.getDependency();
      allVertexs.add(dependee);
      allVertexs.add(dependency);
      dependee.indegree++;
    }
    int NUM_VERTICES = allVertexs.size();

    for (Vertex vertex : allVertexs) {
      if (vertex.indegree == 0) {
        q.add(vertex);
      }
    }

    int count = 0;
    while (!q.isEmpty()) {
      Vertex first = q.remove(0);
      first.topNum = ++count;

      for (Edge edge : first.fromList) {
        Vertex dependee = edge.getDependee();
        if (--dependee.indegree == 0) {
          q.add(dependee);
        }
      }
    }
    if (count != NUM_VERTICES) {
      throw new CycleFoundException();
    }

  }

  private ArrayList<Vertex> getVerticesFromEdges(List<Edge> edges) {
    HashSet<Vertex> allVertexs = new HashSet<>();

    for (Edge edge : edges) {
      Vertex dependee = edge.getDependee();
      Vertex dependency = edge.getDependency();
      allVertexs.add(dependee);
      allVertexs.add(dependency);
    }
    return new ArrayList<>(allVertexs);
  }

  void printTopSortResult(List<Edge> edges) {
    ArrayList<Vertex> vertices = getVerticesFromEdges(edges);
    printTopSortResult(vertices);
  }

  private void printTopSortResult(ArrayList<Vertex> vertices) {
    vertices.sort(new Comparator<Vertex>() {
      @Override
      public int compare(Vertex o1, Vertex o2) {
        return o1.topNum - o2.topNum;
      }
    });

    ArrayList<String> names = new ArrayList<>();
    for (Vertex vertex : vertices) {
      names.add(vertex.name);
    }
    String delimiter = " --> ";
    String sortRersult = String.join(delimiter, names);
    System.out.println(sortRersult);
  }
}
