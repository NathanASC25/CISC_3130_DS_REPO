import java.util.HashMap;

class Main {

  public static void main(String[] args) {

    HashMap<String, Integer> playCounts = new HashMap<>();

    DoublyLinkedList playlist = new DoublyLinkedList();

    playlist.append("A");

    playlist.append("B");

    playlist.append("C");

    playlist.append("D");

    System.out.print(playlist);

    playlist.prepend(-1, "1");

    playlist.search();

    playlist.delete(2);

    System.out.print(playlist);

    playlist.search();

  }

}
