class LinkedListDS {

  public static void main(String[] args) {

    LinkedList linkedList = new LinkedList();

    LinkedList linkedList_1 = new LinkedList();

    linkedList.append(6);

    linkedList.append(7);

    linkedList_1.append(8);

    linkedList_1.append(9);

    System.out.print(linkedList);

    System.out.print(linkedList_1);

    linkedList_1.prepend(1, 2);

    System.out.print(linkedList_1);

    linkedList_1.prepend(0, 1);

    System.out.print(linkedList_1);

    linkedList_1.prepend(0, 0);

    System.out.print(linkedList_1);

    linkedList_1.prepend(2, 7);

    System.out.print(linkedList_1);

    linkedList_1.delete(0);

    System.out.print(linkedList_1);

    linkedList_1.delete(2);

    System.out.print(linkedList_1);

    linkedList_1.size();

  }

  private static class Node {

    int val;

    Node next;

    public Node(int val) {

      this.val = val;

    }

  }

  static class LinkedList {

    private Node head;

    private Node newNode;

    private int size;

    private void append(int val) {

      newNode = new Node(val);

      if (head == null) {

        head = newNode;

        size += 1;

        return;

      }

      Node current = head;

      while (current.next != null) {

        current = current.next;

      }

      current.next = newNode;

      size += 1;

      System.out.print("\nNew Node added to list!\n");

    }

    private void prepend(int indexOfNode, int val) {

      newNode = new Node(val);

      Node current = head;

      if (indexOfNode == 0) {

        newNode.next = head;

	head = newNode;

        size += 1;

	System.out.print("\nNew Node added to list!\n");

        return;

      }

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

}
