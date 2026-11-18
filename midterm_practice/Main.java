
class Node {


   int data;


   Node next;


   public Node(int data) {


       this.data = data;


       this.next = null;


   }


   @Override


   public String toString() {


       return "Node(" + this.data + ")";


   }


}


 
 
public class Main {


   public static void main(String[] args) {


       Node head = new Node(1);


       Node cur = head;


       for (int i = 2; i <= 6; i++) {


           cur.next = new Node(i);


           cur = cur.next;


       }


       print(head);


       System.out.println("After swap");


       head = swapNodes(head, 2,4);


       print(head);


   }


 
   // print helper


   public static void print(Node head) {


       for (Node n = head; n != null; n = n.next) {


           System.out.print(n.data + (n.next != null ? " -> " : "\n"));


       }


   }


 
   public static Node swapNodes(Node head, int x, int y) {


       if (x == y) {


           System.out.println("Nodes don't have duplicates");


           return head;


       }


 
       Node cur = head;


 
       Node X = null;


       Node Y = null;


 
       Node prevX = null;


       Node nextX = null;


 
       Node prevY = null;


       Node nextY = null;


 
       while (cur != null && (X == null || Y == null)) {


           if (cur.data == x) {


               X = cur;


               nextX = cur.next;


           } if (cur.data == y) {


               Y = cur;


               nextY = cur.next;


           }


           if (X == null) {


               prevX = cur;


           } if (Y == null) {


               prevY = cur;


           }


           cur = cur.next;


       }


 
       if (X == null) {


           System.out.println("Couldn't find X");


           return head;


       }


       if (Y == null) {


           System.out.println("Couldn't find Y");


           return head;


       }


 
       // Check if X or Y == head


       if (prevX == null && nextX != Y) {


           Y.next = nextX;


           prevY.next = X;


           X.next = nextY;


           return Y;


       }


       if (prevY == null && nextY != X) {


           X.next = nextY;


           prevX.next = Y;


           Y.next = nextX;


           return X;


       }


 
       // Check for adjacency


       if (nextX == Y) {


           if (prevX == null) {


               head = Y;


               head.next = X;


               X.next = nextY;


               return head;


           }


           prevX.next = Y;


           Y.next = X;


           X.next = nextY;


           return head;


       }


       if (nextY == X) {


           if (prevY == null) {


               head = X;


               head.next = Y;


               Y.next = nextX;


               return head;


           }


           prevY.next = X;


           X.next = Y;


           Y.next = nextX;


           return head;


       }


 
       // General case


       prevX.next = Y;


       Y.next = nextX;


 
       prevY.next = X;


       X.next = nextY;


 
       return head;


   }


}
