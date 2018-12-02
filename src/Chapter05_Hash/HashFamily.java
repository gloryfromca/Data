package Chapter05_Hash;

import java.util.Random;

public interface HashFamily<T> {
  int hash(T x, int which);

  int getNumberOfFunctions();

  void generateNewFunctions();

  int[] getMULTIPLIERS();

}


class StringHashFamily implements HashFamily<String> {
  private final Random random = new Random();
  private final int[] MULTIPLIERS;

  public StringHashFamily(int d) {
    MULTIPLIERS = new int[d];
    generateNewFunctions();
  }

  @Override
  public int[] getMULTIPLIERS() {
    return MULTIPLIERS;
  }

  @Override
  public int getNumberOfFunctions() {
    return MULTIPLIERS.length;
  }

  @Override
  public void generateNewFunctions() {
    for (int i = 0; i < MULTIPLIERS.length; i++) {
      MULTIPLIERS[i] = random.nextInt();
    }

  }

  @Override
  public int hash(String x, int which) {
    final int multiplier = MULTIPLIERS[which];
    Integer hashVal = 0;
    for (int i = 0; i < x.length(); i++) {
      hashVal = multiplier * hashVal + x.charAt(i);
    }
    return hashVal;
  }


}
