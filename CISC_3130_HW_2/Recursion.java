class Recursion {

  public static void main(String[] args) {

    // printStars(5);
    
    int[] arr = {1, 2, 3, 4, 5, 6};

    printElements(arr);

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

  static void printElements(int[] arr) {

    if (arr.length > 1) {

      int new_length = arr.length / 2;

      int[] new_arr = new int[new_length];

      for (int i = 0; i < new_length; i += 1) {

        new_arr[i] = arr[i];

      }

      //System.out.println(new_arr.length);

      printElements(new_arr);

    }

    for (int num : arr) {

      System.out.print(num);

    }

    System.out.println();

  }

}
