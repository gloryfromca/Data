package Chapter12_AdvancedDataStructuresAndImplementation;

import org.junit.Assert;
import org.junit.Test;

public class SuffixArrayTest {

  @Test
  public void createSuffixArray() {
    String str = "structures";
    int strLength = str.length();
    int[] SA = new int[strLength];
    int[] LCP = new int[strLength];
    int[] expectSA = new int[] {4, 8, 7, 2, 9, 0, 1, 5, 3, 6};
    int[] expectLCP = new int[] {0, 0, 0, 1, 0, 1, 0, 1, 0, 1};

    SuffixArray.createSuffixArray(str, SA, LCP);

    Assert.assertArrayEquals(expectSA, SA);
    Assert.assertArrayEquals(expectLCP, LCP);

  }
}
