package Chapter07_Sort;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class RadixSortTest {

  BaseRadixSort sortUtils;

  @Parameterized.Parameters
  public static Collection<Object[]> differentClass() {
    Collection<Object[]> params = new ArrayList() {};
    params.add(new Object[] {BaseRadixSort.class});
    params.add(new Object[] {CountingRadixSort.class});
    params.add(new Object[] {RadixSort.class});
    return params;
  }

  public RadixSortTest(Class theClass) throws Exception {
    Class[] classes = new Class[] {Integer.class};
    Constructor constructor = theClass.getConstructor(classes);
    sortUtils = (BaseRadixSort) constructor.newInstance(2);
  }

  @Test
  public void sort() {
    String[] a = new String[] {"AA", "Ab", "Cf", "EA", "FG", "Ds", "Aa", "Bd", "zz", "Zz", "ZZ"};
    sortUtils.sort(a);
    for (int i = 1; i < a.length; i++) {
      Assert.assertTrue(a[i].compareTo(a[i - 1]) > 0);
    }
  }

  @Test
  public void sortMaxLength() {
    if (sortUtils instanceof RadixSort) {
      sortUtils = new RadixSort(7);
      String[] a = new String[] {"gDab", "CfFS", "EASf", "aFG", "Ab", "Cf", "EA", "FG", "sdDs",
          "AadAs", "BdZDD12", "123", "34567", "a545", "ZZ"};
      sortUtils.sort(a);
      for (int i = 1; i < a.length; i++) {
        Assert.assertEquals(true, a[i].compareTo(a[i - 1]) > 0);
      }
    }
  }


}
