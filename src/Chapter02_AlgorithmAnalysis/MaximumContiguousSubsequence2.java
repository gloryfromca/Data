package Chapter02_AlgorithmAnalysis;

public class MaximumContiguousSubsequence2 implements MaximumContiguousSubsequence {

  public static int maxSumResc(int[] a, int left, int right) {
    int maxSubsequenceSum = 0;
    left = 0;
    right = a.length - 1;
    int maxSubsequenceTempSum = 0;
    for (int j = left; j <= right; j++) {
      maxSubsequenceTempSum += a[j];
      if (maxSubsequenceSum < maxSubsequenceTempSum) {
        maxSubsequenceSum = maxSubsequenceTempSum;
      } else if (maxSubsequenceTempSum < 0) {
        maxSubsequenceTempSum = 0;
      }

    }
    return maxSubsequenceSum;
  }

  public static void main(String[] args) {

  }


}
