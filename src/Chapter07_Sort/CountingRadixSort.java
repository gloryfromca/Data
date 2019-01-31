package Chapter07_Sort;

public class CountingRadixSort extends BaseRadixSort {

  public CountingRadixSort() {
    super();
  }

  public CountingRadixSort(Integer stringLen) {
    super(stringLen);
  }

  public void sort(String[] a) {

    int N = a.length;
    String[] buffer = new String[N];
    String[] in = a;
    String[] out = buffer;
    for (int pos = stringLen - 1; pos >= 0; pos--) {
      int[] counts = new int[BUCKETS + 1];
      for (String string : in) {
        counts[string.charAt(pos) + 1]++;
      }
      for (int i = 1; i < counts.length; i++) {
        counts[i] += counts[i - 1];
      }

      for (int i = 0; i < N; i++) {
        out[counts[in[i].charAt(pos)]++] = in[i];
      }
      String[] tmp = in;
      in = out;
      out = tmp;
    }
    if (stringLen % 2 == 1) {
      for (int i = 0; i < out.length; i++) {
        out[i] = in[i];
      }
    }

  }
}
