package Chapter07_Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SortBaseTest {


  @Parameterized.Parameters
  public static Collection<Object[]> differentClass() {
    Collection<Object[]> params = new ArrayList() {};
    params.add(new Object[] {InsertionSort.class});
    params.add(new Object[] {HeapSort.class});
    params.add(new Object[] {MergeSort.class});
    params.add(new Object[] {ShellSort.class});
    return params;
  }

  SortBase<Integer> a;
  Integer[] testNums;
  Random random = new Random();
  private static final int DEFAULT_TEST_NUMS = 1000;

  public SortBaseTest(Class theSortClass) throws Exception {
    a = (SortBase<Integer>) theSortClass.newInstance();
  }

  @Before
  public void setUp() {
    testNums = new Integer[DEFAULT_TEST_NUMS];
    for (int i = 0; i < DEFAULT_TEST_NUMS; i++) {
      testNums[i] = random.nextInt(DEFAULT_TEST_NUMS);
    }
  }

  @Test
  public void sort() {
    a.sort(testNums);
    for (int i = 1; i < testNums.length; i++) {
      Assert.assertEquals(true, testNums[i] >= testNums[i - 1]);
    }
  }
}
