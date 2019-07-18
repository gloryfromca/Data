package Chapter10_AlgorithmDesignTechniques;

public class Fibonacci {

  public static int fibonacci(int n) {
    if (n <= 1) {
      return 1;
    }
    int nextToLast = 1;
    int last = 1;
    int result = 0;
    for (int i = 2; i <= n; i++) {
      result = nextToLast + last;
      nextToLast = last;
      last = result;
    }
    return result;

  }
}
