package Chapter10_AlgorithmDesignTechniques;

public class RandomGenerator {
  private static final int A = 48271;
  private static final int M = 2147483647;
  private static final int Q = M / A;
  private static final int R = M % A;
  private int state;

  public RandomGenerator(int seed) {
    state = seed;
  }

  public int randomInt() {
    int tmpState = A * (state % Q) - R * (state / Q);
    if (tmpState >= 0) {
      state = tmpState;
    } else {
      state = tmpState + M;
    }
    return state;

  }

}
