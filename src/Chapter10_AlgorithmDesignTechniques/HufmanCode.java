package Chapter10_AlgorithmDesignTechniques;

import java.util.HashMap;
import java.util.Map;
import Chapter06_Heap.BinaryHeap;

public class HufmanCode {

  static class Node implements Comparable<Node> {
    Node left;
    Node right;
    Integer count;
    Character aChar;
    Boolean isLeft;

    public Node(int count, char aChar) {
      this.count = count;
      this.aChar = aChar;
    }

    public Node(Node left, Node right) {
      this.left = left;
      this.left.isLeft = true;
      this.right = right;
      this.right.isLeft = false;
      this.count = this.left.count + this.right.count;
    }

    public boolean isLeaf() {
      return aChar != null;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    @Override
    public int compareTo(Node o) {
      return count - o.count;
    }
  }

  private String text;
  private HashMap<Character, String> encodeMapping;
  private HashMap<String, Character> reverseEncodeMapping;

  public HufmanCode(String text) {
    this.setTextAndBuild(text);
  }

  public void setTextAndBuild(String text) {
    this.text = text;
    this.encodeMapping = this.buildEncodeTable(text);
    this.reverseEncodeMapping = this.getReversedEncodeMapping(this.encodeMapping);
  }

  public String encode(String text) {
    StringBuilder result = new StringBuilder();
    for (Character character : text.toCharArray()) {
      result.append(this.encodeMapping.get(character));
    }
    return result.toString();
  }

  public String decode(String encodeText) {
    StringBuilder result = new StringBuilder();
    int start = 0;
    int end = 1;
    int encodeTextLength = encodeText.length();
    while (start < encodeTextLength) {
      for (; reverseEncodeMapping.get(encodeText.substring(start, end)) == null; end++) {
      }
      result.append(reverseEncodeMapping.get(encodeText.substring(start, end)));
      start = end;
      end = start + 1;
    }
    return result.toString();

  }

  private HashMap<String, Character> getReversedEncodeMapping(
      HashMap<Character, String> encodeMapping) {
    HashMap<String, Character> result = new HashMap<>();
    for (Map.Entry<Character, String> entry : encodeMapping.entrySet()) {
      result.put(entry.getValue(), entry.getKey());
    }
    return result;
  }

  private HashMap<Character, String> buildEncodeTable(String text) {
    Node tries = this.buildTries(text);
    HashMap<Character, String> encodeMapping = new HashMap<>();
    _buildEncodeTable(tries, new StringBuilder(), encodeMapping);
    return encodeMapping;
  }


  private void _buildEncodeTable(Node tries, StringBuilder currentEncode,
      HashMap<Character, String> encodeMapping) {
    String currentCode;
    if (tries.isLeft == null) {
      currentCode = "";
    } else if (tries.isLeft) {
      currentCode = "0";
    } else {
      currentCode = "1";
    }
    StringBuilder newCurrentEncode = currentEncode.append(currentCode);

    if (tries.isLeaf()) {
      encodeMapping.put(tries.aChar, newCurrentEncode.toString());
    } else {
      _buildEncodeTable(tries.left, new StringBuilder(newCurrentEncode), encodeMapping);
      _buildEncodeTable(tries.right, new StringBuilder(newCurrentEncode), encodeMapping);
    }

  }


  private Node buildTries(String text) {
    HashMap<Character, Integer> charMapping = new HashMap<>();
    BinaryHeap<Node> nodeBinaryHeap = new BinaryHeap<>();

    for (char aChar : text.toCharArray()) {
      Integer count = charMapping.putIfAbsent(aChar, 1);
      if (count != null) {
        charMapping.put(aChar, count + 1);
      }
    }

    for (Map.Entry<Character, Integer> entry : charMapping.entrySet()) {
      Character character = entry.getKey();
      Integer count = entry.getValue();

      Node node = new Node(count, character);
      nodeBinaryHeap.insert(node);
    }

    while (nodeBinaryHeap.getCurrentSize() > 1) {
      Node minNode = nodeBinaryHeap.deleteMin();
      Node secondMinNode = nodeBinaryHeap.deleteMin();
      nodeBinaryHeap.insert(new Node(minNode, secondMinNode));
    }
    return nodeBinaryHeap.deleteMin();
  }


}
