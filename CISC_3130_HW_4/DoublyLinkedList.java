import java.util.Scanner;

class DoublyLinkedList {

  Node head;

  Node tail;

  Node newNode;

  Node current;

  int size;

  void search() {

    Scanner input = new Scanner(System.in);

    System.out.print("\nDo you want to search for a song and its position, or the one before or after it? (Options: song, before, after): ");

    String searchType = input.nextLine().toLowerCase();

    if (!(searchType.equals("song") || searchType.equals("before") || searchType.equals("after"))) {

      System.out.print("\nInvalid Choice.\n");

      return;

    }

    System.out.print("\nEnter an index number or name of the song: ");

    String songLocation = input.nextLine();

    current = head;

    int index = 0;

    try {

      int indexOfSong = Integer.valueOf(songLocation);

      if (indexOfSong < 0 || indexOfSong >= size) {

        System.out.print("\nNo song available.\n");

        return;

      }

      while (index < indexOfSong) {

        current = current.next;

        index += 1;

      }

    }

    catch (Exception e) {

      while (!(current.val.equals(songLocation)) && index < size) {

        current = current.next;

        index += 1;

      }

    }

    if (index == 0 && searchType.equals("before") || index == size - 1 && searchType.equals("after")) {

      System.out.print("\nNo song available.\n");

      return;

    }

    if (searchType.equals("before")) {

      System.out.printf("\nThe song that comes before \"%s\" is \"%s\".\n", current.val, current.prev.val);

      return;

    }

    if (searchType.equals("after")) {

      System.out.printf("\nThe song that comes after \"%s\" is \"%s\".\n", current.val, current.next.val);

      return;

    }

    if (searchType.equals("song")) {

      System.out.printf("\nThe song \"%s\" exists at index %d.\n", current.val, index);

    }

  }

  void append(String val) {

    newNode = new Node(val);

    if (head == null) {

      head = newNode;

      size += 1;

      System.out.print("\nNew Song added to playlist!\n");

      return;

    }

    Node temp;

    current = head;

    while (current.next != null) {

      temp = current;

      current = current.next;

      current.prev = temp;

    }

    current.next = newNode;

    size += 1;

    System.out.print("\nNew Song added to playlist!\n");

  }

  void prepend(int indexOfNode, String val) {

    if (indexOfNode < 0 || indexOfNode >= size) {

      System.out.print("\nSong does not exist!\n");

      return;

    }

    newNode = new Node(val);

    if (indexOfNode == 0) {

      newNode.next = head;

      head = newNode;

      newNode.next.prev = head;

      size += 1;

      System.out.print("\nNew Song added to playlist!\n");

      return;

    }

    current = head;

    Node temp;

    int index = 0;

    while (index < indexOfNode - 1) {

      current = current.next;

      index += 1;

    }

    temp = current.next;

    current.next = newNode;

    newNode.next = temp;

    newNode.prev = current;

    newNode.next.prev = newNode;

    size += 1;

    System.out.print("\nNew Song added to playlist!\n");

  }

  void delete(int indexOfNode) {

    if (head == null && size == 0) {

      System.out.print("\nThe playlist is empty!\n");

      return;

    }

    if (indexOfNode == 0) {

      head = head.next;
 
      size -= 1;

      System.out.print("\nSong removed from playlist!\n");

      return;

    }

    int index = 0;

    current = head;

    while (index < indexOfNode - 1) {

      current = current.next;

      index += 1;

    }

    current.next = current.next.next;

    current.next.prev = current;

    size -= 1;

    System.out.print("\nSong removed from playlist!\n");

  }

  void size() {

    System.out.printf("\nThe playlist has %d songs.\n", size);

  }

  @Override

  public String toString() {

    if (size == 0) {

      return "\nThe playlist is empty!\n";

    }

    current = head;

    String str = String.format("\n[ %s", current.val);

    current = current.next;

    while (current.next != null) {

      str += String.format(", %s", current.val);

      current = current.next;

    }

    return str += String.format(", %s ]\n", current.val);

  }

}
