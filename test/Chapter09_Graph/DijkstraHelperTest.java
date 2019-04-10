package Chapter09_Graph;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DijkstraHelperTest {
  ArrayList<DijkstraVertex> dijkstraVertices;
  DijkstraHelper dijkstraHelper;
  DijkstraVertex a;
  DijkstraVertex b;
  DijkstraVertex c;
  DijkstraVertex d;
  DijkstraVertex e;
  DijkstraVertex f;
  DijkstraVertex g;

  @Before
  public void setUp() throws Exception {
    a = new DijkstraVertex();
    b = new DijkstraVertex();
    c = new DijkstraVertex();
    d = new DijkstraVertex();
    e = new DijkstraVertex();
    f = new DijkstraVertex();
    g = new DijkstraVertex();
    a.addTo(b, 2);
    a.addTo(d, 1);
    b.addTo(d, 3);
    b.addTo(d, 10);
    c.addTo(a, 4);
    c.addTo(f, 5);
    d.addTo(c, 2);
    d.addTo(f, 8);
    d.addTo(g, 4);
    d.addTo(e, 2);
    e.addTo(g, 6);
    g.addTo(f, 1);

    dijkstraVertices = new ArrayList<>();
    dijkstraVertices.add(a);
    dijkstraVertices.add(b);
    dijkstraVertices.add(c);
    dijkstraVertices.add(d);
    dijkstraVertices.add(e);
    dijkstraVertices.add(f);
    dijkstraVertices.add(g);

    dijkstraHelper = new DijkstraHelper(dijkstraVertices);
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
}
