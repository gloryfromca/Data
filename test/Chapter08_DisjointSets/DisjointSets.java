package Chapter08_DisjointSets;

public class DisjointSets extends BaseDisjointSets {
  public void union(int root1, int root2) {
    if (s[root2] < s[root1]) {
      s[root1] = root2;
    } else {
      if (s[root1] == s[root2]) {
        s[root1]--;
      }
      s[root2] = root1;
    }

  }

  public int find(int x) {
    if (s[x] < 0) {
      return x;
    } else {
      return s[x] = find(s[x]);
    }

  }


}
