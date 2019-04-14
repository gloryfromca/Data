package Chapter09_Graph;

public class Edge implements Comparable<Edge> {

  private Vertex dependency;
  private Vertex dependee;
  int length;

  Edge(Vertex dependee, Vertex dependency) {
    this.dependee = dependee;
    this.dependency = dependency;
    this.length = 1;
    this.dependee.addToList(this);
    this.dependency.addFromList(this);
  }

  Edge(Vertex dependee, Vertex dependency, int length) {
    this(dependee, dependency);
    this.length = length;
  }


  public Vertex getDependee() {
    return dependee;
  }

  public Vertex getDependency() {
    return dependency;
  }

  @Override
  public int compareTo(Edge o) {
    return this.length - o.length;
  }

  @Override
  public String toString() {
    return dependency.name + String.format("----(%d)---->", this.length) + dependee.name;
  }
}
