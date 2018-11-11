package Chapter03_ListStackAndQueue;

import java.util.Iterator;
import java.util.List;

public class RemoveInList {
  public static List<Integer> removeEventVer1(List<Integer> a) {
    int i = 0;
    while (i < a.size()) {
      if (a.get(i) % 2 == 0) {
        a.remove(i);
      } else {
        i++;
      }
    }
    return a;

  }

  public static List<Integer> removeEventVer2(List<Integer> a) {
    Iterator<Integer> ai = a.iterator();
    while (ai.hasNext()) {
      if (ai.next() % 2 == 0) {
        ai.remove();
      }
    }
    return a;
  }

}
