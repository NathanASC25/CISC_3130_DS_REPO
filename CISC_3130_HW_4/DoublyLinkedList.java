private class DoublyLinkedList {

  Node head;

  Node tail;

  Node newNode;

  int size;

  private void append(int val) {

    newNode = new Node(val);

    if (head == null) {

      head = newNode;

      size += 1;

      return;

    }

    Node current = head;

    while (current.next != null) {

      current.prev = current;

      current = current.next;

    }

    current.next = newNode;

    size += 1;

    System.out.print("\nNew Node added to list!\n");

  }

  private void prepend(int indexOfNode, int val) {

    newNode = new Node(val);

    if (indexOfNode == 0) {

      newNode.next = head;

      head = newNode;

      size += 1;

      System.out.print("\nNew Node added to list!\n");

      return;

    }

    Node current = head;

    Node temp;

    int index = 0;

    while (index < indexOfNode - 1) {

      current = current.next;

      index += 1;

    }

    temp = current.next;

    current.next = newNode;

    newNode.next = temp;

    size += 1;

    System.out.print("\nNew Node added to list!\n");

  }

  private void delete(int indexOfNode) {

    if (indexOfNode == 0) {

      head = head.next;
 
      size -= 1;

      System.out.print("\nNode removed from list!\n");

      return;

    }

    int index = 0;

    Node current = head;

    while (index < indexOfNode - 1) {

      current = current.next;

      index += 1;

    }

    current.next = current.next.next;

    size -= 1;

    System.out.print("\nNode removed from list!\n");

  }

  private void size() {

    System.out.printf("\nThe list has %d elements.\n", size);

  }

  @Override

  public String toString() {

    Node current = head;

    String str = String.format("\n[ %d", current.val);

    current = current.next;

    while (current.next != null) {

      str += String.format(", %d", current.val);

      current = current.next;

    }

    return str += String.format(", %d ]\n", current.val);

  }

}
