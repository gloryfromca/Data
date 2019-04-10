package Chapter09_Graph;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TopSortHelperTest {
  Vertex a;
  Vertex b;
  Vertex c;
  Vertex d;
  Vertex e;
  List<Edge> edges;
  TopSortHelper topSortHelper;
  Edge edge1;
  Edge edge2;
  Edge edge3;
  Edge edge4;
  Edge edge5;
  Edge edge6;
  Edge edge7;
  Edge edge8;

  @Before
  public void setUp() throws Exception {
    a = new Vertex("A");
    b = new Vertex("B");
    c = new Vertex("C");
    d = new Vertex("D");
    e = new Vertex("E");
    edge1 = new Edge(b, a);
    edge2 = new Edge(c, b);
    edge3 = new Edge(c, d);
    edge4 = new Edge(e, d);
    edge5 = new Edge(e, b);
    edge6 = new Edge(d, a);
    edge7 = new Edge(c, e);
    edge8 = new Edge(e, c);
    topSortHelper = new TopSortHelper();
  }


  @Test
  public void topSort1() throws Exception {
    edges = new ArrayList<>();
    edges.add(edge1);
    edges.add(edge2);
    edges.add(edge3);
    edges.add(edge4);
    edges.add(edge5);
    topSortHelper.TopSort(edges);
    for (Edge edge : edges) {
      assert edge.getDependee().topNum > edge.getDependency().topNum;
    }
    topSortHelper.printTopSortResult(edges);

  }

  @Test
  public void topSort2() throws Exception {
    edges = new ArrayList<>();
    edges.add(edge1);
    edges.add(edge6);
    edges.add(edge7);
    edges.add(edge8);
    try {
      topSortHelper.TopSort(edges);
    } catch (CycleFoundException e1) {
      System.out.println("Cycle Found!");
    } catch (Exception e2) {
      throw e2;
    }
    edges.remove(edge7);
    edges.remove(edge8);

    for (Edge edge : edges) {
      assert edge.getDependee().topNum > edge.getDependency().topNum;
    }
    topSortHelper.printTopSortResult(edges);
  }
}
