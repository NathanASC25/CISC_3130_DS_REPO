class Recursion {

  public static void main(String[] args) {

    printStars(5);

  }

  static void printStars(int num) {

    if (num > 1) {

      printStars(num - 1);

    }

    for (int i = 0; i < num; i += 1) {

      System.out.print("*");

    }

    System.out.println();

  }

}
