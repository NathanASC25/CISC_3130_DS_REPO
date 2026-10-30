import java.util.HashMap;

import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    HashMap<String, Integer> playCounts = new HashMap<>();

    DoublyLinkedList playlist = new DoublyLinkedList();

    playlist.append("A");

    playlist.append("B");

    playlist.append("C");

    playlist.append("D");

    System.out.print(playlist);

    playlist.prepend(-1, "1");

    playlist.search(input);

    playlist.delete(2);

    System.out.print(playlist);

    playlist.search(input);

    input.close();

  }

}
