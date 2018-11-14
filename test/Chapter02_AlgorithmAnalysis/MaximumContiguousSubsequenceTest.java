package Chapter02_AlgorithmAnalysis;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumContiguousSubsequenceTest {
  /**
   * you must assign row length of 2-D array.
   */
  int[][] sequences = new int[3][];

  @Before
  public void setUp() throws Exception {
    this.sequences[0] = new int[] {1, -2, 4, -3, -5, 10};
    this.sequences[1] = new int[] {1, 2, -4, -3, -5, 2, -1};
    this.sequences[2] = new int[] {1, 4, 4, -3, -5, 12, -1};
    System.out.println("ONE TEST BEGIN!");
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("ONE TEST OVER!");
  }

  @Test
  public void maxSumResc() {
    for (int[] sequence : this.sequences) {
      int left = 0;
      int right = sequence.length - 1;
      int result1 = MaximumContiguousSubsequence1.maxSumResc(sequence, left, right);
      int result2 = MaximumContiguousSubsequence2.maxSumResc(sequence, left, right);
      System.out.println("result1:" + result1);
      System.out.println("result2:" + result2);
      Assert.assertEquals(result1, result2);

    }


  }
}
