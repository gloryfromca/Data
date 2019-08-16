package Chapter12_AdvancedDataStructuresAndImplementation;

import java.util.Arrays;

public class SuffixArray {

  private static int computeLCP(String a, String b) {
    int i = 0;

    while (a.length() > i && b.length() > i && a.charAt(i) == b.charAt(i)) {
      i++;
    }
    return i;
  }

  public static void createSuffixArray(String str, int[] SA, int[] LCP) {
    if (SA.length != str.length() || LCP.length != str.length()) {
      throw new IllegalArgumentException();
    }

    int N = str.length();

    String[] suffixes = new String[N];

    for (int i = 0; i < N; i++) {
      suffixes[i] = str.substring(i);
    }

    Arrays.sort(suffixes);

    for (int i = 0; i < N; i++) {
      SA[i] = N - suffixes[i].length();
    }

    for (int i = 1; i < N; i++) {
      LCP[i] = computeLCP(suffixes[i], suffixes[i - 1]);
    }

  }

}
