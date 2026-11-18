class NodeTest {

  private static class Node {

    Node next;

    int data;

    public Node(int data) {

      this.data = data;

    }

    public Node(Node node) {

      this.next = node.next;

    }

    @Override

    public String toString() {

      Node current = this;

      String str = "\n";

      while (current.next != null) {

        str += String.format("%d -> ", current.data);

        current = current.next;

      }

      return str += String.format("%d \n", current.data);

    }

  }

  public static void main(String[] args) {

    LinkedList linkedList_0 = new LinkedList();

    linkedList_0.append(7);

    linkedList_0.append(1);

    linkedList_0.append(7);

    linkedList_0.append(0);

    linkedList_0.append(7);

    linkedList_0.append(2);

    linkedList_0.append(7);

    System.out.print(linkedList_0.head);

    // Invoking removeAll method - Assigning head to new head, edge case being that an original head node could still be preserved even though considered invalid during removal
    
    linkedList_0.head = linkedList_0.removeAll(linkedList_0.head, 7);

    // Printing list after removal
    
    System.out.printf("\nAfter removal: \n%s", linkedList_0.head);

    System.out.printf("\nNew Head Value: %d\n", linkedList_0.head.data);

    //linkedList_0.head = linkedList_0.removeAll(linkedList_0.head, 1);

    //System.out.printf("\nAfter removal: \n%s", linkedList_0.head);
    
    linkedList_0.prepend(1, 3);

    System.out.print(linkedList_0.head);

  }

  static class LinkedList {

    Node head;

    private Node newNode;

    private int size;

    private void append(int data) {

      newNode = new Node(data);

      if (head == null) {

        head = newNode;

        size += 1;

        System.out.print("\nNew Node added to list!\n");

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

    private void prepend(int indexOfNode, int data) {

      newNode = new Node(data);

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

    // New removeAll method

    private static Node removeAll(Node head, int target) {

      Node current = head;

      Node prev = null;

      while (current != null) {

        if (current == head && current.data == target) {

          head = head.next;

          current = head;

	}

        else if (current.data == target) {

          prev.next = prev.next.next;

          current = prev.next;

          continue;

	}

        prev = current;

        current = current.next;

      }

      return head;

    }

    private void size() {

      System.out.printf("\nThe list has %d elements.\n", size);

    }

    @Override

    public String toString() {

      Node current = head;

      //String str = String.format("\n[ %d", current.val);

      //current = current.next;
      
      String str = "\n";

      while (current.next != null) {

        str += String.format("%d -> ", current.data);

        current = current.next;

      }

      return str += String.format("%d \n", current.data);

    }

  }

}
