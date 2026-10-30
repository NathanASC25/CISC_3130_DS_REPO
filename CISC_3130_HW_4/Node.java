class Node {

  Node next;

  // No prev pointer for Node by default

  String val;

  public Node(String val) {

    this.val = val;

  }

  @Override

  public String toString() {

    Node current = this;

    String str = "\n";

    while (current.next != null) {

      str += String.format("%d -> ", current.val);

      current = current.next;

    }

    return str += String.format("%d \n", current.val);

  }

}
