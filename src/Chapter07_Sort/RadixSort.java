package Chapter07_Sort;

import java.util.ArrayList;

public class RadixSort extends BaseRadixSort {

  private int maxLength;

  public RadixSort() {
    super();
  }

  public RadixSort(Integer stringLen) {
    this.maxLength = stringLen;
  }

  public void sort(String[] a) {
    ArrayList<String>[] wordsByLength = new ArrayList[maxLength + 1];
    ArrayList<String>[] buckets = new ArrayList[BUCKETS];
    for (int i = 0; i < wordsByLength.length; i++) {
      wordsByLength[i] = new ArrayList<>();
    }
    for (int i = 0; i < buckets.length; i++) {
      buckets[i] = new ArrayList<>();
    }
    for (String s : a) {
      wordsByLength[s.length()].add(s);
    }

    int idx = 0;
    for (ArrayList<String> wb : wordsByLength) {
      for (String s : wb) {
        a[idx++] = s;
      }
    }

    int startIndex = a.length;
    for (int pos = maxLength - 1; pos >= 0; pos--) {
      startIndex -= wordsByLength[pos + 1].size();
      for (int i = startIndex; i < a.length; i++) {
        buckets[a[i].charAt(pos)].add(a[i]);
      }
      idx = startIndex;
      for (ArrayList<String> bucket : buckets) {
        for (String s : bucket) {
          a[idx++] = s;
        }
        bucket.clear();
      }

    }

  }
}
