package Chapter07_Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleQuickSort<T extends Comparable<? super T>> implements SortBase<T> {
  @Override
  public void sort(T[] a) {
    ArrayList<T> aList = new ArrayList<>(Arrays.asList(a));
    sort(aList);
    a = aList.toArray(a);
  }

  public void sort(List<T> a) {
    if (a.size() > 1) {
      List<T> smaller = new ArrayList<>();
      List<T> same = new ArrayList<>();
      List<T> larger = new ArrayList<>();
      T chosenItem = a.get(a.size() / 2);
      for (T item : a) {
        if (item.compareTo(chosenItem) == 0) {
          same.add(item);
        } else if (item.compareTo(chosenItem) < 0) {
          smaller.add(item);
        } else {
          larger.add(item);
        }
      }

      sort(smaller);
      sort(larger);

      a.clear();
      a.addAll(smaller);
      a.addAll(same);
      a.addAll(larger);

    }

  }


}
