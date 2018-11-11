package Chapter02_AlgorithmAnalysis;

public class MaximumContiguousSubsequence1 implements MaximumContiguousSubsequence {


  public static int maxSumResc(int[] a, int left, int right) {
    if (left == right) {
      return a[left];
    }

    int center = (left + right) / 2;

    int leftMaxSumResc = maxSumResc(a, left, center);
    int rightMaxSumResc = maxSumResc(a, center + 1, right);

    int leftBorderMaxSum = 0;
    int leftBorderTempSum = 0;
    for (int i = center; i >= left; i--) {
      leftBorderTempSum += a[i];
      if (leftBorderTempSum > leftBorderMaxSum) {
        leftBorderMaxSum = leftBorderTempSum;
      }
    }
    int rightBorderMaxSum = 0;
    int rightBorderTempSum = 0;
    for (int i = center + 1; i <= right; i++) {
      rightBorderTempSum += a[i];
      if (rightBorderTempSum > rightBorderMaxSum) {
        rightBorderMaxSum = rightBorderTempSum;
      }
    }
    /**
     * you must use Interface.staticFunc to call interface's static function.
     */
    return MaximumContiguousSubsequence.max3(leftMaxSumResc, rightMaxSumResc,
        rightBorderMaxSum + leftBorderMaxSum);

  }

  public static void main(String[] args) {
    int[] a = {1, -2, 3, -1, 5, -14, 1};
    int left = 0;
    int right = a.length - 1;
    int result = maxSumResc(a, left, right);
    System.out.println(result);
  }
}
