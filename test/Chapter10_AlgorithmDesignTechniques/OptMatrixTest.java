package Chapter10_AlgorithmDesignTechniques;

import org.junit.Assert;
import org.junit.Test;

public class OptMatrixTest {

  @Test
  public void optMatrix() {
    int[] c = new int[] {50, 10, 40, 30, 5};
    int n = c.length - 1;
    long[][] m = new long[n + 1][n + 1];
    int[][] lastChange = new int[n + 1][n + 1];
    OptMatrix.optMatrix(c, m, lastChange);
    Assert.assertEquals((int) m[1][n], 10500);
  }
}
