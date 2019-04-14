package Chapter09_Graph;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindArticulationHelperTest {
  FindArticulationHelper findArticulationHelper;

  ArticulationVertex a;
  ArticulationVertex b;
  ArticulationVertex c;
  ArticulationVertex d;
  ArticulationVertex e;
  ArticulationVertex f;
  ArticulationVertex g;

  @Before
  public void setUp() throws Exception {

    a = new ArticulationVertex("a");
    b = new ArticulationVertex("b");
    c = new ArticulationVertex("c");
    d = new ArticulationVertex("d");
    e = new ArticulationVertex("e");
    f = new ArticulationVertex("f");
    g = new ArticulationVertex("g");

    new Edge(b, a);
    new Edge(d, a);

    new Edge(a, b);
    new Edge(c, b);

    new Edge(b, c);
    new Edge(d, c);
    new Edge(g, c);

    new Edge(a, d);
    new Edge(c, d);
    new Edge(e, d);
    new Edge(f, d);

    new Edge(d, e);
    new Edge(f, e);

    new Edge(d, f);
    new Edge(e, f);

    new Edge(c, g);

  }

  @Test
  public void findArt1() {
    findArticulationHelper = new FindArticulationHelper(a);
    findArticulationHelper.findArt();
    Assert.assertTrue(findArticulationHelper.result.contains(c));
    Assert.assertTrue(findArticulationHelper.result.contains(d));
  }


  @Test
  public void findArt2() {
    findArticulationHelper = new FindArticulationHelper(d);
    findArticulationHelper.findArt();
    Assert.assertTrue(findArticulationHelper.result.contains(c));
    Assert.assertTrue(findArticulationHelper.result.contains(d));

  }

  @Test
  public void findArt3() {
    findArticulationHelper = new FindArticulationHelper(g);
    findArticulationHelper.findArt();
    Assert.assertTrue(findArticulationHelper.result.contains(c));
    Assert.assertTrue(findArticulationHelper.result.contains(d));

  }

}
