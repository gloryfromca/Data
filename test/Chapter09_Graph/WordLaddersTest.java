package Chapter09_Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class WordLaddersTest {


  Map<String, List<String>> adjacentWords;

  @Before
  public void setUp() {
    adjacentWords = new HashMap<>();
    LinkedList<String> amList = new LinkedList<>();
    adjacentWords.put("am", amList);
    amList.add("an");
    amList.add("cm");
    amList.add("af");

    LinkedList<String> anList = new LinkedList<>();
    adjacentWords.put("an", anList);
    anList.add("dn");
    anList.add("ao");
    anList.add("as");

    LinkedList<String> asList = new LinkedList<>();
    adjacentWords.put("as", asList);
    asList.add("az");
    asList.add("ao");

    LinkedList<String> aoList = new LinkedList<>();
    adjacentWords.put("ao", aoList);
    aoList.add("ad");
    aoList.add("oo");

  }

  @Test
  public void findChain() throws Exception {
    List<String> result = WordLadders.findChain(adjacentWords, "am", "oo");
    for (String str : result) {
      System.out.println(str);
    }
  }
}
