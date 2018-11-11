package Chapter02_AlgorithmAnalysis;

public class GCD {
  public static long gcd(long m, long n) {
    long rem;
    while (n != 0) {
      rem = m % n;
      m = n;
      n = rem;
    }
    return m;
  }
}
