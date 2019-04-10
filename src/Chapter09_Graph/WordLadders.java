package Chapter09_Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordLadders {
  public static List<String> findChain(Map<String, List<String>> adjacentWords, String first,
      String second) throws Exception {
    Map<String, String> previousWord = new HashMap<>();
    LinkedList<String> q = new LinkedList<>();
    q.addLast(first);

    while (!q.isEmpty()) {
      String currentWord = q.removeFirst();
      List<String> adj = adjacentWords.get(currentWord);
      if (adj != null) {
        for (String to : adj) {
          if (previousWord.get(to) == null) {
            previousWord.put(to, currentWord);
            q.addLast(to);
          }

        }
      }
    }
    previousWord.put(first, null);
    return getChainFromPreviousMap(previousWord, first, second);

  }

  public static List<String> getChainFromPreviousMap(Map<String, String> previousMap, String first,
      String second) throws Exception {
    if (previousMap.get(second) == null) {
      throw new Exception();
    }

    LinkedList<String> result = new LinkedList<>();
    for (String current = second; current != null; current = previousMap.get(current)) {
      result.addFirst(current);
    }
    return result;
  }

}
