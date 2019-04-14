package Chapter09_Graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
  public int inDegree = 0;
  public int topNum = 0;
  String name;
  List<Edge> toList;
  List<Edge> fromList;

  Vertex(String name) {
    toList = new ArrayList<>();
    fromList = new ArrayList<>();
    this.name = name;
  }

  public void addToList(Edge edge) {
    // in edge, this is located in To position.
    toList.add(edge);
  }

  public void addFromList(Edge edge) {
    fromList.add(edge);
  }

  @Override
  public String toString() {
    return name;
  }


}
