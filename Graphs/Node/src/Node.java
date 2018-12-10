import java.util.*;

public class Node {

  Integer val;
  Vector<Node> neighbours;

  public Node(Integer val, Vector<Node> neighbours) {
    this.val = val;
    this.neighbours = neighbours;
  }
}
