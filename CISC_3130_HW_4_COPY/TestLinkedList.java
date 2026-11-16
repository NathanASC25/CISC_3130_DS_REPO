class TestLinkedList {

  public static void main(String[] args) {

    DoublyLinkedList list = new DoublyLinkedList();

    list.append(new MusicPlayer.song(0, "A", "Artist A"));

    list.append(new MusicPlayer.song(1, "B", "Artist B"));

    list.append(new MusicPlayer.song(2, "C", "Artist C"));

    list.append(new MusicPlayer.song(3, "D", "Artist D"));

    list.delete(3);

    list.append(new MusicPlayer.song(3, "D", "Artist D"));

    list.delete(1);

    list.prepend(1, new MusicPlayer.song(1, "B", "Artist B"));

    System.out.print(list);

  }

}
