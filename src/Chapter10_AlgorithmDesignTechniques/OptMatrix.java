package Chapter10_AlgorithmDesignTechniques;

public class OptMatrix {
  public static void optMatrix(int[] c, long[][] m, int[][] lastChange) {
    int n = c.length - 1;

    for (int left = 1; left <= n; left++) {
      m[left][left] = 0;
    }

    for (int k = 1; k < n; k++) {
      for (int left = 1; left <= n - k; left++) {
        int right = left + k;
        m[left][right] = Long.MAX_VALUE - 10000 * 10000;
        for (int i = left; i < right; i++) {
          long currentCost = m[left][i] + m[i + 1][right] + c[left - 1] * c[i] * c[right];
          if (currentCost < m[left][right]) {
            m[left][right] = currentCost;
            lastChange[left][right] = i;
          }

        }

      }

    }

  }

}
