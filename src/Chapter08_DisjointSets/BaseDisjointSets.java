package Chapter08_DisjointSets;

public class BaseDisjointSets {

  protected int[] s;

  public BaseDisjointSets() {
    this(10);
  }

  public BaseDisjointSets(int numElements) {
    s = new int[numElements];
    for (int i = 0; i < numElements; i++) {
      s[i] = -1;
    }

  }

  public void union(int root1, int root2) throws Exception {
    s[root1] = root2;
  }

  public Boolean isRoot(int root) {
    return s[root] < 0;
  }

  public int find(int x) {
    if (s[x] < 0) {
      return x;
    } else {
      return find(s[x]);
    }

  }

}
