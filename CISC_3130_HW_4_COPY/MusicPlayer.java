import java.util.Map;

import java.util.Deque;

import java.util.ArrayDeque;

import java.util.HashMap;

class MusicPlayer {

  // Songs can be of type record, containing attributes but no methods

  // Song ids are primitive int data types

  // Song titles are Strings and artists are also Strings

  record song(int id, String title, String artist) {}

  // Universal incrementer to assign unique int id for each song

  private static int song_id = 0;

  // The Five Data Structures
  // --------------

  private static DoublyLinkedList playlist = new DoublyLinkedList();

  private static Map<String, Node> library = new HashMap<>();

  private static Deque<song> up_next = new ArrayDeque<>();

  private static Stack history = new Stack();

  private static Map<Integer, Integer> play_counts = new HashMap<>();

  // --------------

  // Data Structure to keep track of removed songs so that history and up_next may skip

  private static Map<String, Node> removed_songs = new HashMap<>();
  
  // Head Node variable to keep pointer to head node (first song) for necessary reassignment
  
  private static Node head;
  
  // Current variable to track current song in playlist

  private static Node current;

  // Currently Playing variable to track current playing song

  private static Node current_playing_song;

  // Loop Node Tracking variable as a buffer practice for convenient searching in general
  
  private static Node loop_node_tracker;

  public static void main(String[] args) {

    // Test Section 1

    System.out.print("\n--- 1. Build the playlist ---\n");

    // Test Playlist entries

    boolean add_attempt_1 = addSong(song_id, "Night Drive", "A");

    boolean add_attempt_2 = addSong(song_id, "Slow Tide", "B");

    boolean add_attempt_3 = addSong(song_id, "Copper Sky", "C");

    boolean add_attempt_4 = addSong(song_id, "Static Bloom", "D");

    boolean add_attempt_5 = addSong(song_id, "Low Orbit", "E");

    boolean add_attempt_6 = addSong(song_id, "Glass Rivers", "F");

    // Print validity of adding song attempts

    System.out.printf("%b\n", add_attempt_1);

    System.out.printf("%b\n", add_attempt_2);

    System.out.printf("%b\n", add_attempt_3);

    System.out.printf("%b\n", add_attempt_4);

    System.out.printf("%b\n", add_attempt_5);

    System.out.printf("%b\n", add_attempt_6);

    // Set head and current nodes to playlist head after list initialization

    head = playlist.head;

    // Current variable is reset to head once all songs are added to the playlist

    current = head;

    // Loop node tracker variable utilized for traversing lists and stacks for printing purposes before linkedlist and stack toString() method updates

    loop_node_tracker = head;

    // Check if duplicate of song 3 (count instances of song name)

    int name_instances = 0;

    boolean duplicate_s3 = false;

    Node temp = loop_node_tracker;

    for (int i = 1; i <= 6; i += 1) {

      if (current.val.title.equals("Copper Sky")) {

        name_instances += 1;

      }

      loop_node_tracker = loop_node_tracker.next;

    }

    loop_node_tracker = temp;

    if (name_instances > 1) {

      duplicate_s3 = true;

    }

    System.out.printf("duplicate s3: %b", duplicate_s3);

    //printSong(findSong("F"));

    //printSong(findSong("G"));
    
    System.out.print("\nplaylist: ");

    showPlaylist();

    // Test Section 2

    System.out.print("\n--- 2. Look up songs ---");

    // Fourth song has the id number: 3

    Node find_fourth_song = findSong(3);

    // Ninth song would have the id number: 8

    Node find_ninth_song = findSong(8);

    // Handle Null Exceptions in case respective song doesn't exist, otherwise print title

    try {

      System.out.printf("\nfind s4: %s", find_fourth_song.val.title);

    }

    catch (Exception e) {

      System.out.print("\nfind s4: null");

    }

    try {

      System.out.printf("\nfind s9: %s", find_ninth_song.val.title);

    }

    catch (Exception e) {

      System.out.print("\nfind s9: null");

    }

    // LinkedList Print method

    // System.out.print(playlist);

    System.out.print("\n--- 3. Play and move forward ---");

    // First song starts at index 0

    Node play_first_song = play(0, false);

    // Debugging to prevent history from pushing duplicate entries, and handling null runtime

    //System.out.printf("\nCurrently playing: %s", current_playing_song.val.title);

    Node play_ninth_song = play(8, false);

   // System.out.printf("\nCurrently playing: %s", current_playing_song.val.title);

    Node play_next_1 = next();

   // System.out.printf("\nCurrently playing: %s", current_playing_song.val.title);

    Node play_next_2 = next();

   // System.out.printf("\nCurrently playing: %s", current_playing_song.val.title);

    try {

      System.out.printf("\nplay s1: %s", play_first_song.val.title);

    }

    catch (Exception e) {

      System.out.print("\nplay s1: null");

    }

    try {

      System.out.printf("\nplay s9: %s", play_ninth_song.val.title);

    }

    catch (Exception e) {

      System.out.print("\nplay s9: null");

    }

    System.out.printf("\nnext: %s", play_next_1.val.title);

    System.out.printf("\nnext: %s", play_next_2.val.title);

    //System.out.print("\nhistory: [");

    temp = loop_node_tracker;

    // Latest addition to history stack is at the head node

    //loop_node_tracker = history.head;
    
    // Utilize new toString() method for stacks

    System.out.printf("\nhistory: %s", history);

    /*while (loop_node_tracker.next != null) {

      System.out.printf(" %s,", loop_node_tracker.val.title);

      loop_node_tracker = loop_node_tracker.next;

    }

    System.out.printf(" %s ]", loop_node_tracker.val.title);*/

    System.out.print("\n--- 4. Up next ---");

    boolean deque_mod_1 = queueLater(4);

    boolean deque_mod_2 = queueLater(5);

    boolean deque_mod_3 = queueNext(0);

    boolean deque_mod_4 = queueLater(8);

    DoublyLinkedList up_next_list = showUpNext();

    //System.out.printf("\nup next: %s", up_next_list);

    Node play_next_3 = next();

    Node now_playing_1 = nowPlaying();

    System.out.printf("\n%b", deque_mod_1);

    System.out.printf("\n%b", deque_mod_2);

    System.out.printf("\n%b", deque_mod_3);

    System.out.printf("\nqueue s9: %b", deque_mod_4);

    System.out.printf("\nup next: %s", up_next_list);

    /*System.out.print("\nup next: [");

    loop_node_tracker = up_next_list.head;

    while (loop_node_tracker.next != null) {

      System.out.printf(" %s,", loop_node_tracker.val.title);

      loop_node_tracker = loop_node_tracker.next;

    }

    System.out.printf(" %s ]", loop_node_tracker.val.title); */

    System.out.printf("\nnext: %s", play_next_3.val.title);

    System.out.printf("\nnow playing: %s", now_playing_1.val.title);

    System.out.printf("\nhistory: %s", history);

    /*System.out.print("\nhistory: [");

    temp = loop_node_tracker;

    loop_node_tracker = history.head;

    while (loop_node_tracker.next != null) {

      System.out.printf(" %s,", loop_node_tracker.val.title);

      loop_node_tracker = loop_node_tracker.next;

    }

    System.out.printf(" %s ]", loop_node_tracker.val.title);

    loop_node_tracker = temp;*/

    System.out.print("\n--- 5. Back button ---");

    Node play_back_1 = back();

    System.out.printf("\nback: %s", play_back_1.val.title);

    System.out.printf("\nup next: %s", showUpNext());

    System.out.printf("\nhistory: %s", showHistory());

    System.out.print("\n--- 6. Remove songs ---");

    boolean remove_fifth_song = removeSong(4);

    boolean remove_third_song = removeSong(2);

    boolean remove_ninth_song = removeSong(8);

    System.out.printf("\nremove s5: %b", remove_fifth_song);

    System.out.printf("\nremove current (s3): %b", remove_third_song);

    System.out.printf("\nremove s9: %b", remove_ninth_song);

    System.out.print("\nplaylist: ");

    showPlaylist();

    System.out.printf("\nup next: %s", showUpNext());

    System.out.print("\n--- 7. Removed songs are skipped ---");

    Node play_next_4 = next();

    Node play_next_5 = next();

    Node play_next_6 = next();

    Node now_playing_2 = nowPlaying();

    Node play_back_2 = back();

    System.out.printf("\nnext: %s", play_next_4.val.title);

    System.out.printf("\nnext: %s", play_next_5.val.title);

    try {

      System.out.printf("\nnext at end: %s", play_next_6.val.title);

    }

    catch (Exception e) {

      System.out.print("\nnext at end: null");

    }

    System.out.printf("\nnow playing: %s", now_playing_2.val.title);

    System.out.printf("\nback: %s", play_back_2.val.title);

    System.out.printf("\nup next: %s", showUpNext());

    System.out.printf("\n--- 8. Play counts ---");

    int play_count_song_1 = playCount(0);

    int play_count_song_3 = playCount(2);

    int play_count_song_6 = playCount(5);

    int play_count_song_5 = playCount(4);

    System.out.printf("\ns1: %d", play_count_song_1);

    System.out.printf("\ns3: %d", play_count_song_3);

    System.out.printf("\ns6: %d", play_count_song_6);

    System.out.printf("\ns5 (removed): %d", play_count_song_5);

    System.out.print("\n--- 9. Empty player ---");

    current_playing_song = null;

    int iterator = 0;

    playlist = new DoublyLinkedList();

    while (iterator <= song_id) {

      Node remove_song = findSong(iterator);

      current_playing_song = remove_song;

      if (current_playing_song == null) {

        iterator += 1;

        continue;

      }

      removeSong(current_playing_song.val.id);

      iterator += 1;

    }

    while (history.head != null) {

      history.head = history.head.next;

    }

    while (up_next.size() > 0) {

      up_next.pollFirst();

    }

    // Playlist size: 0

    //System.out.printf("\nplaylist size: %d", playlist.size());

    Node empty_next_1 = next();

    Node empty_back_1 = back();

    Node empty_now_playing = nowPlaying();

    try {

      System.out.printf("\nnext: %s", empty_next_1.val.title);

    }

    catch (Exception e) {

      System.out.print("\nnext: null");

    }

    try {

      System.out.printf("\nback: %s", empty_back_1.val.title);

    }

    catch (Exception e) {

      System.out.print("\nback: null");

    }

    try {

      System.out.printf("\nnow playing: %s", empty_now_playing.val.title);

    }

    catch (Exception e) {

      System.out.printf("\nnow playing: %s", empty_now_playing);

    }

    System.out.print("\nplaylist: ");

    showPlaylist();

  }

  private static void printSong(Node obj) {

    if (obj == null) {

      System.out.print("\nNo such song exists.\n");

      return;

    }

    System.out.printf("\n{ id: %d, title: %s, artist: %s }\n", obj.val.id, obj.val.title, obj.val.artist);

  }

  private static boolean addSong(int song_id, String title, String artist) {

    // If requested song id is less than universal id count and a song in the library or playlist already exists with that id, invalidate operation

    if (MusicPlayer.song_id > song_id && findSong(title) != null) {

      return false;

    }

    song new_song = new song(song_id, title, artist);

    // If replacing missing song id, use prepend method

    if (MusicPlayer.song_id > song_id) {

      playlist.prepend(song_id, new_song);

    }

    else {

      playlist.append(new_song);

      MusicPlayer.song_id += 1;

    }

    // If song dded to playlist is first song, current node will be first song. Otherwise, move to next node to add to the library.

    if (new_song.id == 0) {

      head = playlist.head;

      current = head;

    }

    else {

      current = current.next;

    }

    library.put(new_song.title, current);

    return true;

  }

  private static Node findSong(String song_title) {

    // OLD: If requested song id is greater than or equal to universal song id counter, the song doesn't exist

    /*if (MusicPlayer.song_id <= song_id) {

      return null;

    }*/

   return library.get(song_title);

  }

  // Overloaded help method: findSong using parameter: int song_id

  private static Node findSong(int song_id) {

    if (song_id == head.val.id) {

      // Give head node reference for playCounts method

      // Buffer node pointer practice for protection from modification

      Node buffer = head;

      return head;

    }

    // Keep Node reference to revert changes back to original current Node position in case target is non-existent, whether it was the head Node or elsewhere

    Node temp = loop_node_tracker;

    loop_node_tracker = head;

    // Searching works only for list of sorted ids

    // First general while loop attempt

   /* while (current != null) {

      if (song_id == current.val.id) {

        Node foundNode = current;

        current = temp;

        return foundNode;

      }

      if (current.val.id < song_id) {

        current = current.next;

      }

      if (current.val.id > song_id) {

        current = current.prev;

      }

    }*/

    // Second general while loop attempt

    while (loop_node_tracker != null) {

      if (loop_node_tracker.val.id == song_id) {

        Node foundNode = loop_node_tracker;

        loop_node_tracker = temp;

        return foundNode;

      }

      //System.out.println("Hello");

      loop_node_tracker = loop_node_tracker.next;

    }

  //  if (current == null)

    loop_node_tracker = temp;

  //  System.out.print("\nSong doesn't exist\n");

    return null;

  }

  private static void showPlaylist() {

    Node temp = loop_node_tracker;

    loop_node_tracker = playlist.head;

    System.out.print("[ ");

    if (loop_node_tracker == null) {

      loop_node_tracker = temp;

      System.out.print("]");

      return;

    }

    while (loop_node_tracker.next != null) {

      System.out.printf(" %s,", loop_node_tracker.val.title);

      loop_node_tracker = loop_node_tracker.next;

    }

    System.out.printf(" %s ]\n", loop_node_tracker.val.title);

    // Revert back to current variable's original Node position

    loop_node_tracker = temp;

  }

  private static Node play(int song_id, boolean playing_back) {

    // If current playing song value is same as the history, invalidate push operation since the previous play operation involved a non-existent song

    if (current_playing_song != null) {

      if (history.head != null && current_playing_song.val.title.equals(history.head.val.title)) {

        // Do nothing

      }

      else if (!playing_back) {

        history.push(current_playing_song.val);

      }

    }

    if (song_id == head.val.id) {

      // Buffer node pointer practice for protection from modification

      start(findSong(song_id));

      Node foundNode = head;

      return foundNode;

    }

    // Preserve initial position of current node and reassign if target doesn't exist

    Node temp = loop_node_tracker;

    loop_node_tracker = head;

    // First general while loop attempt

    /*while (current != null) {

      if (song_id == current.val.id) {

        start(current);

        return;

      }

      if (song_id > current.val.id) {

        current = current.next;

      }

      if (song_id < current.val.id) {

        current = current.prev;

      }

    }*/

    // Second general while loop attempt

    while (loop_node_tracker != null) {

      if (loop_node_tracker.val.id == song_id) {

        Node foundNode = loop_node_tracker;

        loop_node_tracker = temp;

        start(foundNode);

	return foundNode;

      }

      //System.out.println("Hello");

      loop_node_tracker = loop_node_tracker.next;

    }

    loop_node_tracker = temp;

    //if (current == null)

    //System.out.print("\nSong doesn't exist\n");

    // OLD APPROACH: Any attempt to play a song that doesn't exist will assign null to the current playing song variable. A previous playing song is sent to the latest history

   // current_playing_song = null;

    return null;

  }

  // Helper method -> parameter: song of type Node for retrieval from playlist

  private static void start(Node song) {

    if (findSong(song.val.title) == null) {

      System.out.print("\nSong doesn't exist.\n");

      return;

    }

    current_playing_song = song;

    //System.out.printf("\nPlaying: %s\n", current.val.title);
    
    if (play_counts.get(song.val.id) != null) {

      play_counts.put(song.val.id, play_counts.get(song.val.id) + 1);

    }

    else {

      play_counts.put(song.val.id, 1);

    }

  }

  // nowPlaying method

  private static Node nowPlaying() {

    if (current_playing_song == null) {

      //System.out.print("\nNo song is currently playing.\n");

    }

    else {

     // System.out.printf("\nSong (%s) is currently playing\n", current_playing_song.val.title);

    }

    return current_playing_song;

  }

  // playCount method

  private static int playCount(int song_id) {

    // Exception handling in case song doesn't exist

    try {

      // Uses findSong method utilizing integer id as parameter

      //System.out.printf("\nSong (%s) has been played %d times.\n", findSong(song_id));

      return play_counts.get(song_id);

    }

    catch (Exception e) {

      // Possibly removed song can still retrieve play count

      if (play_counts.get(song_id) != null) {

        return play_counts.get(song_id);

      }

      //System.out.print("\nSong doesn't exist\n");

      return 0;

    }

  }

  private static boolean queueLater(int song_id) {

    if (findSong(song_id) == null) {

      return false;

    }
    
    up_next.addLast(findSong(song_id).val);

    return true;

  }

  private static boolean queueNext(int song_id) {

    if (findSong(song_id) == null) {

      return false;

    }

    up_next.addFirst(findSong(song_id).val);

    return true;

  }

  private static DoublyLinkedList showUpNext() {

    if (up_next.size() == 0) {

      return null;

    }

    DoublyLinkedList up_next_list = new DoublyLinkedList();

    Deque<song> copy = new ArrayDeque<>(up_next);

    //Node temp = current;

    //current = up_next.getFirst();

    while (copy.size() > 0) {

      song copy_song = copy.pollFirst();

      // Entering both a string or song value for the argument in the get method will not be differentiated

      if (removed_songs.get(copy_song.title) == null) {

        // Append the copy value

        up_next_list.append(copy_song);

      }

    }

    //current = temp;
    
    return up_next_list;

  }

  private static Node next() {

    /*if (up_next.size() == 0) {

      // If there is no current song playing and the curated up next deque is empty, return null

      if (current_playing_song == null || findSong(current_playing_song.val.id + 1) == null) {

        return null;

      }

      return play(current_playing_song.val.id + 1, false);

    }

    song next_song = up_next.pollFirst();

    return play(next_song.id, false);*/

    if (up_next.size() == 0) {

      // If there is no current song playing and the curated up next deque is empty, return null

      if (current_playing_song == null || findSong(current_playing_song.val.id + 1) == null) {

        return null;

      }

      // Get the next song in the playlist that is also not removed

      return play(current_playing_song.val.id + 1, false);

    }

    song next_song = up_next.pollFirst();

    if (removed_songs.get(next_song.title) != null) {

      while (up_next.size() > 0) {

        // Removed song from playlist also eventually gets removed from up_next list
	
        if (removed_songs.get(next_song.title) == null) {

          break;

	}

        next_song = up_next.pollFirst();

      }

    }

    // If next_song still is a removed song after iterating through the entire up_next list, return null

    if (removed_songs.get(next_song.title) != null) {

      return null;

    }

    return play(next_song.id, false);

  }

  private static Node back() {

    if (history.head == null) {

      return null;

    }

    Node previous_song = history.pop();

    if (removed_songs.get(previous_song.val.title) != null) {

      while (history.head != null) {

        if (removed_songs.get(history.head.val.title) == null) {

          break;

	}

        previous_song = history.pop();

      }

    }

    if (removed_songs.get(previous_song.val.title) != null) {

      return null;

    }

    Node move_song_next = current_playing_song;

    queueNext(move_song_next.val.id);

    return play(previous_song.val.id, true);

  }

  private static DoublyLinkedList showHistory() {

    if (history.head == null) {

      return null;

    }

    DoublyLinkedList history_list = new DoublyLinkedList();

    Node temp = loop_node_tracker;

    loop_node_tracker = history.head;

    while (loop_node_tracker != null) {

      if (removed_songs.get(loop_node_tracker.val.title) != null) {

        loop_node_tracker = loop_node_tracker.next;

        continue;

      }

      Node copy = new Node(loop_node_tracker.val);

      history_list.append(copy.val);

      loop_node_tracker = loop_node_tracker.next;

    }

    loop_node_tracker = temp;

    return history_list;

  }

  private static boolean removeSong(int song_id) {

    if (findSong(song_id) == null || current_playing_song.val.id == song_id) {

      return false;

    }

    Node copy_song = findSong(song_id);

    playlist.delete(song_id);

    library.remove(copy_song.val.title);

    removed_songs.put(copy_song.val.title, copy_song);

    return true;

  }

}
