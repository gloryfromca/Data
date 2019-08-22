package Chapter12_AdvancedDataStructuresAndImplementation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class SuffixArrayTest {

  @Parameterized.Parameters
  public static Collection<Object[]> differentClass() {
    Collection<Object[]> params = new ArrayList() {};
    params.add(new Object[] {SuffixArray.class});
    params.add(new Object[] {LinearTimeSuffixArray.class});
    return params;
  }

  Class<ISuffixArray> suffixArrayClass;

  public SuffixArrayTest(Class<ISuffixArray> SuffixArrayClass) {
    suffixArrayClass = SuffixArrayClass;
  }


  @Test
  public void createSuffixArray1() throws Exception {
    String str = "structures";
    int strLength = str.length();
    int[] SA = new int[strLength];
    int[] LCP = new int[strLength];
    int[] expectSA = new int[] {4, 8, 7, 2, 9, 0, 1, 5, 3, 6};
    int[] expectLCP = new int[] {0, 0, 0, 1, 0, 1, 0, 1, 0, 1};

    Method createSuffixArrayMethod =
        suffixArrayClass.getMethod("createSuffixArray", String.class, int[].class, int[].class);
    createSuffixArrayMethod.invoke(null, str, SA, LCP);

    Assert.assertArrayEquals(expectSA, SA);
    Assert.assertArrayEquals(expectLCP, LCP);

  }

  @Test
  public void createSuffixArray2() throws Exception {
    String str = "ABRACADABRA";
    int strLength = str.length();
    int[] SA = new int[strLength];
    int[] LCP = new int[strLength];
    int[] expectSA = new int[] {10, 7, 0, 3, 5, 8, 1, 4, 6, 9, 2};
    int[] expectLCP = new int[] {0, 1, 4, 1, 1, 0, 3, 0, 0, 0, 2};

    Method createSuffixArrayMethod =
        suffixArrayClass.getMethod("createSuffixArray", String.class, int[].class, int[].class);
    createSuffixArrayMethod.invoke(null, str, SA, LCP);

    Assert.assertArrayEquals(expectSA, SA);
    Assert.assertArrayEquals(expectLCP, LCP);

  }

}
