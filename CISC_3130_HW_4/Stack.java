private class Stack {

  Node head;

  Node newNode;

  int size;

  void push(int val) {

    newNode = new Node(val);

    newNode.next = head;

    head = newNode;

    size += 1;

    System.out.print("\nNew Node pushed to Stack.\n");

  }

  void pop() {

    System.out.printf("\nRemoved Node Value: %d\n", head.val);

    head = head.next;

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

  @Override

  public String toString() {

    if (isEmpty()) {

      return "The stack is empty!";

    }

    String str = "\n";

    Node currentNode = head;

    str += String.format("[ %d", currentNode.val);

    currentNode = currentNode.next;

    while (currentNode.next != null) {

      str += String.format(", %d", currentNode.val);

      currentNode = currentNode.next;

    }

    return str += String.format(", %d ]\n", currentNode.val);

  }

}
