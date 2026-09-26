/*

Part 1: Heading

Name: Nathan Chin

Programming Language: Java

*/

class Homework {

  public static void main(String[] args) {

    /*
     
      Part 2: ADT Questions

      Question 1 Answer: ADT stands for Abstract Data Type

      Question 2 Answer: An Abstract Data Type is any structure of code that acts as a blueprint of functions or attributes and can be implemented into other blueprints for objects or have further implementations to build upon its characteristics. For example, interfaces in Java act as abstract data types that can act as a contract for other interfaces and classes to implement functions. Abstract classes in Java are classes that are not meant to be instantiated as objects; Instead, they are abstract data types that contain attributes and behaviors that child classes are meant to build upon.

      Question 3 Answer: An ADT usually acts as a general outline in terms of either attributes or functions for implementations to build upon. In terms of OOP, an implementation uses the convention of inheritance to copy over the parent ADT's characteristics as an underlying data structure. Then, the implementation adds upon this foundation with its own attributes or behaviors that define its use cases.

      Question 4 Answer: Yes, two programmers can appropriate two different implementations of the ADT. This basically means that they can both add their own different attributes or behaviors to their own copies, which the ADT acts as the underlying foundation. This can allow for different efficient use cases or algorithms.

      Question 5 Answer: Yes, both are still stacks because the underlying representation of the stack implementations may be different data structures and have different attributes or associative behaviors. However, both programmers have appropriated these structures to behave as the stack data structure, so there is no difference in the objective.

      Part 8: Stack Questions

      Question 6 Answer: LIFO is an acronym for the Last In First Out principle.

      Question 7 Answer: 55 was the last element to be added to the stack, whereas 15 was the first. The pop method, as following the behavioral conventions (Last In First Out) of the stack data structure, appropriately removes the value 55 as the first element.

      Question 8 Answer: If D was the last element added, then the pop() method should remove the D element first.

      Question 9 Answer: A real-world example of a stack could be a rifle magazine, where the first round is placed at the bottom. The first shot that is fired out of the gun is the last bullet to be placed in the magazine, at the top.

      Part 14: Queue Questions

      Question 10 Answer: FIFO is an acronym for First In First Out

      Question 11 Answer: The dequeue operation, following the convention of the Queue Data Structure, removes the first element (15) that entered the queue

      Question 12 Answer: Alex should leave the Queue first since he came first.

      Question 13 Answer: A Queue would be useful for determining a waitlist of people attempting to sign up for a class. Those who signed up earlier have a higher priority of getting off the waitlist and getting enrolled into the class.

      Part 15: Stack vs. Queue

      Scenario 1 Answer: The Stack should be used for the undo feature since the program's objective is to undo the most recent action. The Stack Data Structure follows the LIFO principle, which means an operation must occur on the latest object entering the stack.

      Scenario 2 Answer: The Queue should be used to represent the printer's role since the first document should receive the operation. The Queue follows the FIFO principle, which means that the first object that entered the data structure should be operated on.

      Scenario 3 Answer: The first page that should appear when hitting the back button is GitHub since that is the page before the latest visited page, which is Amazon. This objective resembles the Stack Data Structure.

      Scenario 4 Answer: The Queue should be used to represent the customer service line since customers who enter the line earlier should receive higher priority for service.

      Scenario 5 Answer: Putting plates on top of each other resembles the objective of the Stack Data Structure. The latest plate, which is on top, will be taken first.

      Part 16: Predict the Output

      Stack:

      Question 14 Answer: The pop() function should return 18

      Question 15 Answer: The peek() function should return 22

      Queue:

      Question 16 Answer: The dequeue() function should return 7

      Question 17 Answer: The peek() function should return 12

      Part 17: Compare the ADTs

      Feature, Stack, Queue

      Rule -> LIFO (Last In First Out) | FIFO (First In First Out)

      Add operation -> Latest elements are higher priority | Latest elements are lesser priority

      Remove operation -> Last element is removed first | First element is removed firt

      View next item -> Lastest element entered into Data Structure is displayed | Earliest elements are displayed

      First item removed -> Last element entered into Data Structure is removed first | First element entered into Data Structure is removed first

      Part 18: Connect the ADT to the Implementation

      Questions 18 & 19 Answer: If a stack is implemented using the array, the array should be the ADT (Abstract Data Type) since the Stack is the implementation and the array is the underlying representation of the implemented data structure. The array itself has its own characteristics such as the ability to store multiple objects within one memory location and having numerically-indexed locations. However, the Stack implementation determines the specific behaviors applied using the array, such as the LIFO principle.

      Question 20 Answer: If the array is switched out with a linked list as the underlying representation, but the Stack operations follow the same objective, the ADT did indeed change. An array is a numerically-indexed data structure, whereas each object in a linked list holds a memory pointer, which adds spacial overhead, to its neighboring node in addition to the attribute holding the object's own data.

    */

    // Part 19

    // Part 5: Building the stack

    Stack stack = new Stack();

    stack.push(15);

    stack.push(25);

    stack.push(35);

    stack.push(45);

    stack.push(55);

    Stack_1 stack_1 = new Stack_1();

    stack_1.push(15);

    stack_1.push(25);

    stack_1.push(35);

    stack_1.push(45);

    stack_1.push(55);

    // Part 6: Testing the stack
    
    // -- Part 7: Main Output
    
    stack.display();

    stack.peek();

    stack.pop();

    stack.pop();

    stack.peek();

    stack.display();

    System.out.printf("\n%b\n", stack.isEmpty());

    // --------------

    System.out.print(stack_1);

    stack_1.peek();

    stack_1.pop();

    stack_1.pop();

    stack_1.peek();

    System.out.print(stack_1);

    System.out.printf("\n%b\n", stack_1.isEmpty());

    // --------------

    // Part 11: Building the Queue

    Queue queue = new Queue();

    queue.enqueue(15);

    queue.enqueue(25);

    queue.enqueue(35);

    queue.enqueue(45);

    queue.enqueue(55);

    // Parts 12 & 13: Testing the Queue & Output
    
    System.out.print(queue);

    queue.peek();

    queue.dequeue();

    queue.dequeue();

    queue.peek();

    System.out.print(queue);

    System.out.printf("\n%b\n", queue.isEmpty());

  }

  // Part 20

  // Node class

  private static class Node {

    int val;

    Node next;

    public Node(int val) {

      this.val = val;

    }

  }

  // Parts 9 & 10: Queue ADT & Operations

  static class Queue {

    private Node head;

    private Node currentNode;

    private Node newNode;

    private int size;

    void enqueue(int val) {

      newNode = new Node(val);

      newNode.next = head;

      head = newNode;

      size += 1;

    }

    void dequeue() {

      System.out.print("\nOperation attempt to remove front Node\n");

      if (isEmpty()) {

        System.out.print("\nNothing to remove: Queue is empty!\n");

        return;

      }

      currentNode = head;

      while (currentNode.next.next != null) {

        currentNode = currentNode.next;

      }

      System.out.printf("\nFront Node Value to Remove: %d\n", currentNode.next.val);

      System.out.print("\nRemoval operation successful.\n");

      // Manipulating Object attributes as a secondary pointer will directly affect the main data structure

      currentNode.next = null;

    }

    void peek() {

      if (isEmpty()) {

        System.out.print("\nNothing to peek: Queue is empty!\n");

        return;

      }

      currentNode = head;

      while (currentNode.next != null) {

        currentNode = currentNode.next;

      }

      System.out.printf("\nFront Node's Value: %d\n", currentNode.val);

    }

    boolean isEmpty() {

      return head == null;

    }

    void size() {

      System.out.printf("\nThe Queue has %d elements.\n", size);

    }

    @Override

    public String toString() {

      if (isEmpty()) {

        return "\nThe Queue is empty.\n";

      }

      String str = "\n";

      currentNode = head;

      str += String.format("[ %d", currentNode.val);

      currentNode = currentNode.next;

      while (currentNode.next != null) {

        str += String.format(", %d", currentNode.val);

        currentNode = currentNode.next;

      }

      return str += String.format(", %d ]\n", currentNode.val);

    }

  }

  // Parts 3 & 4: Stack ADT & Operations (Version 1) - Latest element is the rightmost element

  static class Stack {

    private Node head;

    private Node currentNode;

    private int size;

    void push(int val) {
      
      if (isEmpty()) {

        head = new Node(val);

        currentNode = head;

        size += 1;

        System.out.print("\nNew Node pushed to Stack.\n");

        return;

      }

      // currentNode = currentNode.next -> Error: Keeps assigning null value for every node after the head

      // Fix: First assign Memory pointer for new Node object to the next attribute in order to avoid null exceptions

      currentNode.next = new Node(val);

      currentNode = currentNode.next;

      size += 1;

      System.out.print("\nNew Node pushed to Stack.\n");

    }

    void pop() {

      currentNode = head;

      while (currentNode.next.next != null) {

        currentNode = currentNode.next;

      }

      System.out.printf("\nRemoved Node Value: %d\n", currentNode.next.val);

      currentNode.next = null;

    }

    void peek() {

      System.out.printf("\nTop item's value: %d\n", currentNode.val);

    }

    boolean isEmpty() {

      return head == null;

    }

    void size() {

      System.out.printf("\nThe Stack has %d element(s).\n", size);

    }

    void display() {

      if (isEmpty()) {

        System.out.print("\nStack is empty!\n");

	return;

      }

      currentNode = head;

      System.out.printf("\n[ %d", currentNode.val);

      currentNode = currentNode.next;

      while (currentNode.next != null) {

        System.out.printf(", %d", currentNode.val);

        currentNode = currentNode.next;

      }

      System.out.printf(", %d ]\n", currentNode.val);

    }

  }

  // Stack Version 2: Latest element is the leftmost

  static class Stack_1 {

    private Node head;

    private Node newNode;

    private int size;

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

}
