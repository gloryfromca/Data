package Chapter10_AlgorithmDesignTechniques;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class TurnpikeReconstructTest {

  @Test
  public void turnpike1() {
    Integer n = 6;
    Integer[] x = new Integer[n + 1];
    Integer[] distArray = new Integer[] {1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 6, 5, 7, 10, 8};
    Integer[] finalResult = new Integer[] {null, 0, 3, 5, 6, 8, 10};
    List<Integer> distList = new ArrayList<>();
    for (Integer dist : distArray) {
      distList.add(dist);
    }
    boolean result = TurnpikeReconstruct.turnpike(x, distList, n);
    Assert.assertTrue(result);
    for (int i = 1; i <= n; i++)
      Assert.assertEquals(x[i], finalResult[i]);
  }

  @Test
  public void turnpike2() {
    Integer n = 4;
    Integer[] x = new Integer[n + 1];
    Integer[] distArray = new Integer[] {10, 8, 2, 3, 7, 5};
    Integer[] finalResult = new Integer[] {null, 0, 3, 8, 10};
    List<Integer> distList = new ArrayList<>();
    for (Integer dist : distArray) {
      distList.add(dist);
    }
    boolean result = TurnpikeReconstruct.turnpike(x, distList, n);
    Assert.assertTrue(result);
    for (int i = 1; i <= n; i++) {
      Assert.assertEquals(x[i], finalResult[i]);
    }
  }

  @Test
  public void turnpike3() {
    Integer n = 4;
    Integer[] x = new Integer[n + 1];
    Integer[] distArray = new Integer[] {10, 8, 8, 6, 2, 2};
    Integer[] finalResult = new Integer[] {null, 0, 2, 8, 10};
    List<Integer> distList = new ArrayList<>();
    for (Integer dist : distArray) {
      distList.add(dist);
    }
    boolean result = TurnpikeReconstruct.turnpike(x, distList, n);
    Assert.assertTrue(result);
    for (int i = 1; i <= n; i++) {
      Assert.assertEquals(x[i], finalResult[i]);
      System.out.println(x[i]);
    }
  }
}


