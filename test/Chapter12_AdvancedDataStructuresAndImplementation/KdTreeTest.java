package Chapter12_AdvancedDataStructuresAndImplementation;

import java.util.ArrayList;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;

public class KdTreeTest {

  KdTree<Integer> kdTree = new KdTree<>();

  @Test
  public void insert() {
    kdTree.insert(new Integer[] {2, 3});
  }

  @Test
  public void findRange() {
    Random random = new Random();
    Integer[] low = new Integer[] {70, 60};
    Integer[] high = new Integer[] {120, 100};
    for (int i = 0; i < 500; i++) {
      int first = random.nextInt(200);
      int second = random.nextInt(200);
      kdTree.insert(new Integer[] {first, second});
    }
    ArrayList<Integer[]> result = new ArrayList<>();
    kdTree.findRange(low, high, result);
    for (Integer[] x : result) {
      Assert.assertTrue(x[0] >= low[0]);
      Assert.assertTrue(x[0] <= high[0]);
      Assert.assertTrue(x[1] >= low[1]);
      Assert.assertTrue(x[1] <= high[1]);
    }

  }
}
