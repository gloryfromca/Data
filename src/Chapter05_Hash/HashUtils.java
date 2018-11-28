package Chapter05_Hash;

public class HashUtils {

  Integer tableSize;

  public HashUtils(Integer tableSize) {
    this.tableSize = tableSize;
  }

  public int simpleHash(String key) {
    Integer hashVal = 0;
    for (int i = 0; i < key.length(); i++) {
      hashVal += key.charAt(i);
    }
    return hashVal % this.tableSize;
  }

  public int hornerHash(String key) {
    Integer hashVal = 0;
    for (int i = 0; i < key.length(); i++) {
      hashVal += 37 * hashVal + key.charAt(i);
    }

    hashVal %= this.tableSize;
    if (hashVal < 0) {
      hashVal += this.tableSize;
    }
    return hashVal;

  }

}
