package Chapter10_AlgorithmDesignTechniques;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciTest {

  @Test
  public void fibonacci_1() {
    int result = Fibonacci.fibonacci(2);
    Assert.assertEquals(result, 2);
  }

  @Test
  public void fibonacci_2() {
    int result = Fibonacci.fibonacci(7);
    Assert.assertEquals(result, 21);
  }
}
