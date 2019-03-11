package Chapter08_DisjointSets;

import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BaseDisjointSetsTest {

  BaseDisjointSets baseDisjointSets;

  @Parameterized.Parameters
  public static Collection<Object[]> differentClass() {
    Collection<Object[]> params = new ArrayList() {};
    params.add(new Object[] {BaseDisjointSets.class});
    params.add(new Object[] {DisjointSets.class});
    return params;
  }

  public BaseDisjointSetsTest(Class DisjointSetsClass) throws Exception {
    baseDisjointSets = (BaseDisjointSets) DisjointSetsClass.newInstance();
  }


  @Test
  public void UnionAndFind1() {
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        if (i == j) {
          Assert.assertEquals(true, baseDisjointSets.find(i) == j);
        } else {
          Assert.assertEquals(true, baseDisjointSets.find(i) != j);
        }
      }
    }
  }

  @Test
  public void UnionAndFind2() throws Exception {

    baseDisjointSets.union(1, 0);
    baseDisjointSets.union(4, 1);
    int rootNumber = 0;
    if (baseDisjointSets instanceof DisjointSets) {
      rootNumber = 1;
    }

    Assert.assertEquals(true, baseDisjointSets.find(1) == rootNumber);
    Assert.assertEquals(true, baseDisjointSets.find(4) == rootNumber);


    baseDisjointSets.union(4, 5);
    baseDisjointSets.union(5, 4);
    try {
      Assert.assertEquals(true, baseDisjointSets.find(4) == 5);
    } catch (StackOverflowError e) {
      System.out.println(e);
    }
  }
}
