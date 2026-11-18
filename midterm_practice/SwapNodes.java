class SwapNodes {

  private static class Node {

    int data;

    Node next;

    public Node(int data) {

      this.data = data;

    }

    public Node swap(Node head, int x, int y) {

      if (head.next == null) {

        System.out.print("\nList too small to swap.\n");

        return head;

      }

      Node targetNode1 = null; Node targetNode2 = null;

      // tempNode1 preserves the list structure from first target node, tempNode2 for the second target node

      Node tempNode1 = null; Node tempNode2 = null;

      // postTempNode1 preserves the list nodes after the first target, postTempNode2 preserves the list nodes after the second target
 
      Node postTempNode1 = null; Node postTempNode2 = null;

      // Prev Node refers to the previous node of a node in general. prevNode1 refers to the previous node of the first target. If the first target is the head, then prevNode1 is null. prevNode2 is the previous node of the second target

      Node prev = null; Node prevNode1 = null; Node prevNode2 = null;

      Node current = head;

      boolean swapPerformed = false;

      if (head.data == x || head.data == y) {

        targetNode1 = head;

        tempNode1 = head;

        current = current.next;

        while (current != null) {

          if (current.data == x || current.data == y) {

            // Assume that the previous node is the head, the first target node, since the condition is valid within the first iteration of the loop

            if (prevNode2 == null) {

              // Save second target before switching its next pointer with the first target

              tempNode2 = current;

              head.next = current.next;
              
              // Save first target before assigning it as the second node

              tempNode1 = head;

              head = tempNode2;
             
              head.next = tempNode1;

              return head;

            }

            // Nodes have to be preserved between the head and second target

            // Case if current is the last node

            if (current.next == null) {

              tempNode1 = head;

              prevNode2.next = tempNode1;

              tempNode2.next = tempNode1.next;

              head = tempNode2;

              tempNode1.next = null;

              return head;

            }

            tempNode2 = current;

            postTempNode1 = head.next;

            postTempNode2 = current.next;

            prevNode2.next = head;

            prevNode2.next.next = postTempNode2;

            head = tempNode2;
 
            head.next = postTempNode1;

            return head;

          }

          prevNode2 = current;

          current = current.next;

          tempNode2 = current;

        }

        // If loop is complete, assume the second target node has not been found. Ambiguous case: value x or y not found

        if (head.data == x) {

          System.out.printf("\nSecond target Y Value (%d) not found.\n", y);

        }
          
        else {

          System.out.printf("\nSecond target X Value (%d) not found.\n", x);

        }

        return head;

      }

      while (current != null) {

        if ((current.data == x || current.data == y) && targetNode1 == null) {

          prevNode1 = prev;

          targetNode1 = current;

          tempNode1 = targetNode1;

          postTempNode1 = current.next;

        }

        // If second target found after first target found, perform swap

        else if (current.data == x || current.data == y && targetNode2 == null) {

          prevNode2 = prev;

          tempNode2 = current;

          postTempNode2 = current.next;

          if (current.next == null) {

            if (prevNode2 == targetNode1) {

              prevNode1.next = tempNode2;

              tempNode2.next = tempNode1;

              tempNode1.next = null;

              return head;

            }

            prevNode2.next = tempNode1;

            prevNode1.next = tempNode2;

            tempNode2.next = tempNode1.next;

            tempNode1.next = null;

           /* prevNode2.next.next = tempNode2.next;

            prevNode1.next = tempNode2;

            prevNode1.next.next = postTempNode1.next;*/

            return head;

          }

          if (prevNode2 == targetNode1) {

            prevNode1.next = postTempNode1;

            tempNode1.next = postTempNode2;

            tempNode2.next = tempNode1;

            return head;

          }

          prevNode1.next = tempNode2;

          tempNode2.next = tempNode1.next;

          prevNode2.next = tempNode1;
 
          tempNode1.next = postTempNode2;

          return head;

        }

        prev = current;

        current = current.next;

      }

      if (targetNode1 == null) {

        System.out.print("\nNo target nodes have been found!\n");

      }

      else if (targetNode2 == null) {

        if (targetNode1.data == x) {

          System.out.printf("\nSecond target Y Value (%d) not found\n", y);

        }

        else {

          System.out.printf("\nSecond target X Value (%d) not found\n", x);

        }

      }

      return head;

    }

    @Override

    public String toString() {

      Node current = this;

      String str = "\n";

      while (current.next != null) {

        str += String.format("%d -> ", current.data);

        current = current.next;

      }

      return str += String.format("%d\n\n", current.data);

    }

  }

  public static void main(String[] args) {

    LinkedList linkedList_0 = new LinkedList();

    linkedList_0.append(1);

    linkedList_0.append(2);

    linkedList_0.append(4);

    linkedList_0.append(5);

    linkedList_0.append(3);

    System.out.printf("\nBefore swap:\n %s", linkedList_0.head);

    linkedList_0.head = linkedList_0.head.swap(linkedList_0.head, 5, 2);

    System.out.printf("\nAfter swap:\n %s", linkedList_0.head);

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

    private void size() {

      System.out.printf("\nThe list has %d elements.\n", size);

    }

    @Override

    public String toString() {

      Node current = head;

      String str = String.format("\n[ %d", current.data);

      current = current.next;

      while (current.next != null) {

        str += String.format(", %d", current.data);

        current = current.next;

      }

      return str += String.format(", %d ]\n", current.data);

    }

  }

}
