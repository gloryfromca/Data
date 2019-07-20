package Chapter10_AlgorithmDesignTechniques;

import org.junit.Assert;
import org.junit.Test;

public class RandomGeneratorTest {

  @Test
  public void randomInt() {
    RandomGenerator randomGenerator = new RandomGenerator(2);
    Integer[] result = new Integer[] {96542, 365211588, 435306125, 1681957627, 2009854435,
        814711366, 64320675, 1709433010, 1129173382, 1045878015};
    for (int i = 0; i < 10; i++) {
      int next = randomGenerator.randomInt();
      Assert.assertEquals(next == result[i], true);
    }
  }
}
