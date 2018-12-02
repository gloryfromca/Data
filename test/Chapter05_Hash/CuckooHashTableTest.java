package Chapter05_Hash;

import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CuckooHashTableTest {
  private CuckooHashTable<String> cuckooHashTable;
  private HashFamily<String> hashFamily;
  private Random random = new Random();
  private String example = "zhang";

  public CuckooHashTableTest() {
    hashFamily = new StringHashFamily(3);
    cuckooHashTable = new CuckooHashTable(hashFamily);
  }

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {
    cuckooHashTable.makeEmpty();
  }

  @Test
  public void insert() {
    cuckooHashTable.insert(example);
    Assert.assertEquals(true, cuckooHashTable.contains(example));
  }

  @Test
  public void printHashTable() {
    cuckooHashTable.insert("la");
    cuckooHashTable.insert("ra");
    cuckooHashTable.printHashTable();
  }

  @Test
  public void remove() {
    cuckooHashTable.insert(example);
    Assert.assertEquals(true, cuckooHashTable.contains(example));
    cuckooHashTable.remove(example);
    Assert.assertEquals(false, cuckooHashTable.contains(example));

  }

  @Test
  public void removeMany() {
    for (int i = 0; i < 1000; i++) {
      Integer theString = i;
      cuckooHashTable.insert(theString.toString());
    }
    for (int i = 0; i < 1000; i++) {
      Integer theString = i;
      cuckooHashTable.remove(theString.toString());
    }
    Assert.assertEquals(true, cuckooHashTable.isEmpty());

  }

  @Test
  public void contains() {
    String example2 = "hui";
    Assert.assertEquals(false, cuckooHashTable.contains(example));
    cuckooHashTable.insert(example2);
    Assert.assertEquals(true, cuckooHashTable.contains(example2));


  }

  @Test
  public void findPos() {
    Assert.assertEquals(true, cuckooHashTable.findPos(example) == -1);
    cuckooHashTable.insert(example);
    int pos = cuckooHashTable.findPos(example);
    Assert.assertTrue(cuckooHashTable.getElementOfArray(pos) == example);

  }

  @Test
  public void makeEmpty() {
    Assert.assertTrue(cuckooHashTable.isEmpty());
    cuckooHashTable.insert(example);
    Assert.assertFalse(cuckooHashTable.isEmpty());

  }

  @Test
  public void rehash1() {
    for (int i = 0; i < 5000; i++) {
      Integer randomInt = random.nextInt(50000);
      cuckooHashTable.insert(randomInt.toString());
    }
    cuckooHashTable.printHashTable();
  }

  @Test
  public void HashFamily() {
    hashFamily = new StringHashFamily(1);
    cuckooHashTable = new CuckooHashTable(hashFamily);
    int[] oldHashNumbers = cuckooHashTable.getMULTIPLIERS().clone();
    for (int i = 0; i < 10000; i++) {
      Integer randomInt = random.nextInt();
      cuckooHashTable.insert(randomInt.toString());
    }
    int[] newHashNumbers = cuckooHashTable.getMULTIPLIERS();

    Boolean isSame = true;
    for (int i = 0; i < hashFamily.getNumberOfFunctions(); i++) {
      if (oldHashNumbers[i] != newHashNumbers[i]) {
        isSame = false;
        continue;
      }
    }
    Assert.assertFalse(isSame);
  }

  @Test
  public void currentSize() {
    for (int i = 0; i < 5000; i++) {
      Integer tmp = i;
      cuckooHashTable.insert(tmp.toString());
    }
    Assert.assertTrue(cuckooHashTable.getCurrentSize() == 5000);
  }

  @Test
  public void arraySizeIsPrime() {
    for (int i = 0; i < 5000; i++) {
      Integer tmp = i;
      cuckooHashTable.insert(tmp.toString());
    }
    Assert.assertTrue(CuckooHashTable.isPrime(cuckooHashTable.getArrayLength()));
  }
}
