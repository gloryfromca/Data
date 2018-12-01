package Chapter05_Hash;

import java.util.Random;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SeparateChainingHashTableTest {
  SeparateChainingHashTable<Employee> separateChainingHashTable;
  Employee backEnd;
  Employee frontEnd = new Employee("chandler", 22, 13000.0);
  Random random = new Random();

  @Before
  public void setUp() throws Exception {
    separateChainingHashTable = new SeparateChainingHashTable<>();
    backEnd = new Employee("zhang", 23, 15000.0);
    separateChainingHashTable.insert(backEnd);
  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void insert() {

    separateChainingHashTable.insert(frontEnd);
    Assert.assertEquals(separateChainingHashTable.contains(frontEnd), true);
  }

  @Test
  public void remove() {
    separateChainingHashTable.remove(backEnd);
    Assert.assertEquals(separateChainingHashTable.contains(backEnd), false);
  }

  @Test
  public void contains() {
    Assert.assertEquals(separateChainingHashTable.contains(backEnd), true);

  }

  @Test
  public void makeEmpty() {
    Assert.assertEquals(separateChainingHashTable.isEmpty(), false);
    separateChainingHashTable.makeEmpty();
    Assert.assertEquals(separateChainingHashTable.isEmpty(), true);
  }

  @Test
  public void printHashTable() {
    separateChainingHashTable.insert(frontEnd);
    separateChainingHashTable.printHashTable();
  }

  @Test
  public void isPrime() {
    Assert.assertEquals(SeparateChainingHashTable.isPrime(100), false);
    Assert.assertEquals(SeparateChainingHashTable.isPrime(101), true);
    Assert.assertEquals(SeparateChainingHashTable.isPrime(107), true);
  }

  @Test
  public void nextPrime() {
    Assert.assertEquals(SeparateChainingHashTable.nextPrime(102), 103);
    Assert.assertEquals(SeparateChainingHashTable.nextPrime(202), 211);
  }

  @Test
  public void reHash() {
    separateChainingHashTable.makeEmpty();
    Integer SizeOfBegin = separateChainingHashTable.getHashTableSize();
    Assert.assertEquals(true, 101 == SizeOfBegin);
    for (int i = 0; i < 200; i++) {
      Integer randomInteger = random.nextInt(10000);
      separateChainingHashTable.insert(new Employee(randomInteger.toString()));
    }
    Assert.assertEquals(true, SizeOfBegin < separateChainingHashTable.getHashTableSize());

  }
}
