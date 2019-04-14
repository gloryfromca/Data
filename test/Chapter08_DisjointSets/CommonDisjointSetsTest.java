package Chapter08_DisjointSets;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CommonDisjointSetsTest {

  List<TestItem> testItemList;
  CommonDisjointSets<TestItem> commonDisjointSets;
  TestItem a1;
  TestItem a2;
  TestItem a3;

  class TestItem {


  }

  @Before
  public void setUp() throws Exception {
    a1 = new TestItem();
    a2 = new TestItem();
    a3 = new TestItem();
    testItemList = new ArrayList<>();
    testItemList.add(a1);
    testItemList.add(a2);
    testItemList.add(a3);
    commonDisjointSets = new CommonDisjointSets<>(testItemList);
  }

  @Test
  public void find() {
    Assert.assertEquals(commonDisjointSets.find(a1), 0);
    Assert.assertEquals(commonDisjointSets.find(a2), 1);
    Assert.assertEquals(commonDisjointSets.find(a3), 2);
    commonDisjointSets.union(a1, a2);
    Assert.assertEquals(commonDisjointSets.find(a2), 0);
    Assert.assertEquals(commonDisjointSets.find(a3), 2);
    commonDisjointSets.union(a3, a1);
    Assert.assertEquals(commonDisjointSets.find(a1), 2);
    Assert.assertEquals(commonDisjointSets.find(a2), 2);
  }

  @Test
  public void union() {
    commonDisjointSets.union(a1, a2);
    commonDisjointSets.union(a1, a3);
    Assert.assertEquals(commonDisjointSets.find(a1), 0);
    Assert.assertEquals(commonDisjointSets.find(a2), 0);
    Assert.assertEquals(commonDisjointSets.find(a3), 0);
  }

  @Test
  public void findRoot() {
    commonDisjointSets.union(a1, a2);
    commonDisjointSets.union(a1, a3);
    Assert.assertEquals(commonDisjointSets.findRoot(a2), a1);
    Assert.assertEquals(commonDisjointSets.findRoot(a3), a1);

  }

}
