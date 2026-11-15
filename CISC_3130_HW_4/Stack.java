class Stack {

  Node head;

  Node newNode;

  int size;

  void push(MusicPlayer.song val) {

    newNode = new Node(val);

    newNode.next = head;

    head = newNode;

    size += 1;

    // System.out.print("\nNew Node pushed to Stack.\n");

  }
/* OLD POP METHOD
  void pop() {

    System.out.printf("\nRemoved Node Value: %d\n", head.val);

    head = head.next;

  } */

  // NEW POP METHOD

  Node pop() {

    Node temp = head;

    head = head.next;

    return temp;

  }

  void peek() {

    System.out.printf("\nTop item's value: %d\n", head.val);

  }

  boolean isEmpty() {

    return head == null;

  }

  void size() {

    System.out.printf("\nThe stack has %d elements.\n", size);

  }

  // String Array representation of stack
  
  /* OLD toString() METHOD

  @Override

  public String toString() {

    if (isEmpty()) {

      return "The stack is empty!";

    }

    String str = "\n";

    Node currentNode = head;

    str += String.format("[ %s", currentNode.val);

    currentNode = currentNode.next;

    while (currentNode.next != null) {

      str += String.format(", %s", currentNode.val);

      currentNode = currentNode.next;

    }

    return str += String.format(", %s ]\n", currentNode.val);

  } */

  // NEW toString() METHOD

  @Override

  public String toString() {

    if (isEmpty()) {

      return "The stack is empty!";

    }

    String str = "\n";

    Node currentNode = head;

    str += String.format("[ %s", currentNode.val.title());

    currentNode = currentNode.next;

    while (currentNode.next != null) {

      str += String.format(", %s", currentNode.val.title());

      currentNode = currentNode.next;

    }

    return str += String.format(", %s ]\n", currentNode.val.title());

  }

}
