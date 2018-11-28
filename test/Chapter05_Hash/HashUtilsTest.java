package Chapter05_Hash;

import java.util.ArrayList;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;


public class HashUtilsTest {
  HashUtils utils;
  Random random;
  ArrayList<String> arrayList;

  @Before
  public void setUp() {
    Integer tableSize = 107;
    Integer stringLength = 3;

    utils = new HashUtils(tableSize);
    random = new Random();
    arrayList = new ArrayList<>();

    for (Integer i = 0; i < tableSize; i++) {
      String string = "";
      for (Integer j = 0; j < stringLength; j++) {
        Integer randInt = random.nextInt(26 * 2);
        string = string + (char) (randInt + 65);
      }
      arrayList.add(string);
    }
  }

  @Test
  public void simpleHash() {
    for (int i = 0; i < this.arrayList.size(); i++) {
      Integer hashCode = utils.simpleHash(this.arrayList.get(i));
      System.out.println(hashCode);
    }
  }

  @Test
  public void hornerHash() {
    for (int i = 0; i < this.arrayList.size(); i++) {
      Integer hashCode = utils.hornerHash(this.arrayList.get(i));
      System.out.println(hashCode);
    }
  }
}
