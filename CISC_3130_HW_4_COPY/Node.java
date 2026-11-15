class Node {

  Node next;

  // Previous pointer for nodes in the Doubly Linked List and Stack

  Node prev;

  MusicPlayer.song val;

  public Node(MusicPlayer.song val) {

    this.val = val;

  }

  @Override

  public String toString() {

    Node current = this;

    String str = "\n";

    while (current.next != null) {

      str += String.format("{ id: %d, title: %s, artist: %s } -> ", current.val.id(), current.val.title(), current.val.artist());

      current = current.next;

    }

    return str += String.format("{ id: %d, title: %s, artist: %s }\n", current.val.id(), current.val.title(), current.val.artist());

  }

}
