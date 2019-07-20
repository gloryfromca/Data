package Chapter10_AlgorithmDesignTechniques;

import java.util.ArrayList;
import java.util.List;

public class TurnpikeReconstruct {

  private static Integer findMax(List<Integer> list) {
    Integer max = -1;
    for (Integer item : list) {
      if (item > max) {
        max = item;
      }
    }
    return max;
  }

  private static Integer deleteMax(List<Integer> list) {
    Integer max = findMax(list);
    remove(list, max);
    return max;

  }

  private static void remove(List<Integer> list, Integer item) {
    list.remove(list.indexOf(item));
  }


  public static boolean turnpike(Integer[] x, List<Integer> distList, int n) {
    x[1] = 0;
    x[n] = deleteMax(distList);
    x[n - 1] = deleteMax(distList);
    remove(distList, x[n] - x[n - 1]);
    return place(x, distList, n, 2, n - 2);
  }

  private static boolean tryMatchCurrentMax(Integer[] x, List<Integer> distList, Integer n,
      Integer left, Integer right, Integer currentIndex, List<Integer> usedDistList) {
    boolean match = true;
    for (int i = 1; i <= n; i++) {
      if (i < left || i > right) {
        Integer iDist = Math.abs(x[currentIndex] - x[i]);
        if (distList.contains(iDist)) {
          remove(distList, iDist);
          usedDistList.add(iDist);
        } else {
          match = false;
          break;
        }
      }
    }
    return match;

  }

  private static boolean place(Integer[] x, List<Integer> distList, Integer n, Integer left,
      Integer right) {

    if (distList.isEmpty()) {
      return true;
    }

    Integer currentMax = findMax(distList);
    boolean match;
    List<Integer> usedDistList = new ArrayList<>();
    if (x[right] == null) {
      x[right] = currentMax;

      match = tryMatchCurrentMax(x, distList, n, left, right, right, usedDistList);
      if (match) {
        match = place(x, distList, n, left, right - 1);
      }
      if (!match) {
        // backtrack
        distList.addAll(usedDistList);
        x[right] = null;
      }
    } else {
      match = false;
    }
    usedDistList.clear();
    if (!match && x[left] == null) {
      x[left] = x[n] - currentMax;
      match = tryMatchCurrentMax(x, distList, n, left, right, left, usedDistList);
      if (match) {
        match = place(x, distList, n, left + 1, right);
      }
      if (!match) {
        distList.addAll(usedDistList);
        x[left] = null;
      }
    }

    return match;

  }

}
