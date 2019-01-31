package Chapter07_Sort;

import java.util.ArrayList;

public class BaseRadixSort {
  int BUCKETS = 256;
  int stringLen;

  public BaseRadixSort() {
    stringLen = 10;
  }

  public BaseRadixSort(Integer stringLen) {
    this.stringLen = stringLen;
  }

  public void sort(String[] a) {
    ArrayList<String>[] buckets = new ArrayList[BUCKETS];

    for (int i = 0; i < BUCKETS; i++) {
      buckets[i] = new ArrayList<>();
    }
    for (int pos = stringLen - 1; pos >= 0; pos--) {
      for (String string : a) {
        buckets[string.charAt(pos)].add(string);
      }
      int idx = 0;
      for (ArrayList<String> thisBucket : buckets) {
        for (String s : thisBucket) {
          a[idx++] = s;
        }
        thisBucket.clear();
      }

    }

  }
}
