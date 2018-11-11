package Chapter03_ListStackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class RemoveInListTest {

  ArrayList<Integer> a1 = new ArrayList<>();
  LinkedList<Integer> a2 = new LinkedList<>();
  private long l;
  private Logger logger = Logger.getLogger(RemoveInList.class.toString());
  int length = 200000;

  @Before
  public void setUp() throws Exception {
    for (int i = 0; i < length; i++) {
      a1.add(i);
      a2.add(i);
    }
    l = System.currentTimeMillis();
    logger.info("Begin");
  }

  @After
  public void tearDown() throws Exception {
    l = System.currentTimeMillis() - l;
    logger.info("Time Consumed: " + l + " ms");

  }

  @Test
  public void removeEventVer1Array() {
    /**
     * O(n^2)
     */

    List<Integer> result1 = RemoveInList.removeEventVer1(a1);

  }


  @Test
  public void removeEventVer1Linked() {
    /**
     * O(n^3)
     */
    List<Integer> result2 = RemoveInList.removeEventVer1(a2);
  }

  @Test
  public void removeEventVer2Array() {
    /**
     * O(n^2)
     */

    List<Integer> result1 = RemoveInList.removeEventVer2(a1);

  }


  @Test
  public void removeEventVer2Linked() {
    /**
     * O(n)
     */
    List<Integer> result1 = RemoveInList.removeEventVer2(a2);

  }

}
