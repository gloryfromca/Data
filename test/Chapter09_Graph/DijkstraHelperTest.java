package Chapter09_Graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DijkstraHelperTest {
  private ArrayList<DijkstraVertex> dijkstraVertices;
  private DijkstraHelper dijkstraHelper;
  private DijkstraVertex a;
  private DijkstraVertex b;
  private DijkstraVertex c;
  private DijkstraVertex d;
  private DijkstraVertex e;
  private DijkstraVertex f;
  private DijkstraVertex g;
  private List<Edge> edges;

  private Edge edge1;
  private Edge edge2;
  private Edge edge3;
  private Edge edge4;
  private Edge edge5;
  private Edge edge6;
  private Edge edge7;
  private Edge edge8;
  private Edge edge9;
  private Edge edge10;
  private Edge edge11;
  private Edge edge12;

  @Before
  public void setUp() throws Exception {
    edges = new ArrayList<>();
    dijkstraVertices = new ArrayList<>();
    dijkstraHelper = new DijkstraHelper(dijkstraVertices);

    a = new DijkstraVertex("a");
    b = new DijkstraVertex("b");
    c = new DijkstraVertex("c");
    d = new DijkstraVertex("d");
    e = new DijkstraVertex("e");
    f = new DijkstraVertex("f");
    g = new DijkstraVertex("g");

    edge1 = a.addTo(b, 2);
    edge2 = a.addTo(d, 1);
    edge3 = b.addTo(d, 3);
    edge4 = b.addTo(e, 10);
    edge5 = c.addTo(a, 4);
    edge6 = c.addTo(f, 5);
    edge7 = d.addTo(c, 2);
    edge8 = d.addTo(f, 8);
    edge9 = d.addTo(g, 4);
    edge10 = d.addTo(e, 2);
    edge11 = e.addTo(g, 6);
    edge12 = g.addTo(f, 1);

    dijkstraVertices.add(a);
    dijkstraVertices.add(b);
    dijkstraVertices.add(c);
    dijkstraVertices.add(d);
    dijkstraVertices.add(e);
    dijkstraVertices.add(f);
    dijkstraVertices.add(g);

    edges.add(edge1);
    edges.add(edge2);
    edges.add(edge3);
    edges.add(edge4);
    edges.add(edge5);
    edges.add(edge6);
    edges.add(edge7);
    edges.add(edge8);
    edges.add(edge9);
    edges.add(edge10);
    edges.add(edge11);
    edges.add(edge12);

  }

  @Test
  public void dijkstra() throws Exception {
    dijkstraHelper.Dijkstra(a);
    Assert.assertEquals((int) a.dist, 0);
    Assert.assertEquals((int) b.dist, 2);
    Assert.assertEquals((int) c.dist, 3);
    Assert.assertEquals((int) d.dist, 1);
    Assert.assertEquals((int) e.dist, 3);
    Assert.assertEquals((int) f.dist, 6);
    Assert.assertEquals((int) g.dist, 5);

  }

  @Test
  public void prim() throws Exception {
    dijkstraHelper.prim(a);
    Assert.assertEquals((int) a.dist, 0);
    Assert.assertEquals((int) b.dist, 2);
    Assert.assertEquals((int) c.dist, 2);
    Assert.assertEquals((int) d.dist, 1);
    Assert.assertEquals((int) e.dist, 2);
    Assert.assertEquals((int) f.dist, 1);
    Assert.assertEquals((int) g.dist, 4);
  }

  @Test
  public void kruskal() {
    List<Edge> result = dijkstraHelper.kruskal(edges);
    for (Edge edge : result) {
      System.out.println(edge);
    }
    Assert.assertTrue(result.contains(edge1));
    Assert.assertTrue(result.contains(edge2));
    Assert.assertTrue(result.contains(edge7));
    Assert.assertTrue(result.contains(edge9));
    Assert.assertTrue(result.contains(edge10));
    Assert.assertTrue(result.contains(edge12));

  }

}
