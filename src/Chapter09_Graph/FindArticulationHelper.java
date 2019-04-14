package Chapter09_Graph;

import java.util.ArrayList;
import java.util.List;

class ArticulationVertex extends Vertex {

  int num;
  int low;
  boolean visited;
  ArticulationVertex parent;

  ArticulationVertex(String name) {
    super(name);
    num = -1;
    low = -1;
    visited = false;
    parent = null;
  }
}


public class FindArticulationHelper {
  int counter;
  ArticulationVertex start;
  List<ArticulationVertex> result;

  FindArticulationHelper(ArticulationVertex start) {
    this.start = start;
    counter = 0;
    result = new ArrayList<>();
  }

  public void findArt() {
    /**
     * Additionally, it needs to check if root node exists more one son.
     */
    findArt(start);
  }

  private void findArt(ArticulationVertex v) {
    v.visited = true;
    v.num = v.low = ++counter;
    for (Edge edge : v.fromList) {
      ArticulationVertex w = (ArticulationVertex) edge.getDependee();
      if (!w.visited) {
        w.parent = v;
        findArt(w);
        if (w.low >= v.num) {
          result.add(v);
        }
        v.low = minInt(v.low, w.low);
      } else if (v.parent != w) {
        v.low = minInt(v.low, w.num);
      }

    }

  }

  private int minInt(int a, int b) {
    if (a > b) {
      return b;
    }
    return a;

  }

}
