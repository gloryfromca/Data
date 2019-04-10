package Chapter09_Graph;

public class Edge {

  private Vertex dependency;
  private Vertex dependee;

  Edge(Vertex dependee, Vertex dependency) {
    this.dependee = dependee;
    this.dependency = dependency;
    this.dependee.addToList(this);
    this.dependency.addFromList(this);
  }

  public Vertex getDependee() {
    return dependee;
  }

  public Vertex getDependency() {
    return dependency;
  }

}
