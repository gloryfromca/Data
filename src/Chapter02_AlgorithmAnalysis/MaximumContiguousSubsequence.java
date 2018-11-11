package Chapter02_AlgorithmAnalysis;

public interface MaximumContiguousSubsequence {

  static int max3(int a, int b, int c) {
    /**
     * static func must have function body in interface.
     */
    if (a < b) {
      a = b;
    }
    if (a < c) {
      a = c;
    }
    return a;
  }

  static int maxSumResc(int[] a, int left, int right) {
    throw new UnsupportedOperationException();
  }
}
