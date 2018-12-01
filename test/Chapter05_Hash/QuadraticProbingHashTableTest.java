package Chapter05_Hash;

import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class QuadraticProbingHashTableTest {
  QuadraticProbingHashTable<QuadraticEmployee> quadraticHashTable;
  QuadraticEmployee backEnd;
  QuadraticEmployee frontEnd;
  Random random = new Random();

  @Before
  public void setUp() throws Exception {
    quadraticHashTable = new QuadraticProbingHashTable(QuadraticEmployee.class);
    backEnd = new QuadraticEmployee("zhang", 23, 15000.0);
    quadraticHashTable.insert(backEnd);
    frontEnd = new QuadraticEmployee("chandler", 22, 13000.0);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void insert() {

    quadraticHashTable.insert(frontEnd);
    Assert.assertEquals(quadraticHashTable.contains(frontEnd), true);
  }

  @Test
  public void remove() {
    quadraticHashTable.remove(backEnd);
    Assert.assertEquals(quadraticHashTable.contains(backEnd), false);
  }

  @Test
  public void contains() {
    Assert.assertEquals(quadraticHashTable.contains(backEnd), true);

  }

  @Test
  public void makeEmpty() {
    Assert.assertEquals(quadraticHashTable.isEmpty(), false);
    quadraticHashTable.makeEmpty();
    Assert.assertEquals(quadraticHashTable.isEmpty(), true);
  }

  @Test
  public void printHashTable() {
    quadraticHashTable.insert(frontEnd);
    quadraticHashTable.printHashTable();
  }

  @Test
  public void reHash() {
    quadraticHashTable.makeEmpty();
    Integer SizeOfBegin = quadraticHashTable.getHashTableSize();
    Assert.assertEquals(true, 11 == SizeOfBegin);
    for (int i = 0; i < 20; i++) {
      Integer randomInteger = random.nextInt(10000);
      QuadraticEmployee quadraticEmployee = new QuadraticEmployee(randomInteger.toString());
      quadraticHashTable.insert(quadraticEmployee);
    }
    Assert.assertEquals(true, SizeOfBegin < quadraticHashTable.getHashTableSize());

  }

}
