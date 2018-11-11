package Chapter02_AlgorithmAnalysis;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GCDTest {

  @Before
  public void setUp() throws Exception {}

  @After
  public void tearDown() throws Exception {}

  @Test
  public void gcd() {
    long i = GCD.gcd(66, 21);
    Assert.assertEquals(i, 3);
  }
}
