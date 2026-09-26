/**

Part 1: Heading

Name: Nathan Chin

Programming Language: Java

Editor: Vim

*/

import java.util.Arrays;

class Homework {

  public static void main(String[] args) {
    
    // Part 2: Array Declaration and Initialization
    
    int[] arr = {99, 33, 111, 23, 13, 43, 56, 76, 67, 78, 89, 100, 121};

    System.out.printf("\nOriginal Array: %s\n", Arrays.toString(arr));
    
    /**

    Part 4: Bubble Sort Big O

    Question 1 Answer: The worst case time complexity of Bubble Sort is O(n^2).

    Question 2 Answer: Bubble Sort performs with an outer loop that runs as many times as the number of elements in the array. There is a nested for loop in which each pass involves comparing each element to its next, starting from index 0. For each increment of the outer loop, the entirety of the array's elements have been compared with its next. Therefore, by the time the algorithm is done, there would have been as many as O(n^2) operations being performed.

    Question 3 Answer: With Bubble Sort's time complexity of O(n^2), 10 elements would need 10^2 comparions, while 1,000 elements would need 1,000,000 comparisons.

    Part 6: Compare Bubble Sort and Merge Sort

    Question 4 Answer: The Big O time complexity of Merge Sort is O(n * log(n)) operations, where "n" is the number of elements in the object.

    Question 5 Answer: Merge Sort generally performs better as the dataset becomes larger since its time complexity is O(n * log(n)), which is more efficient than Bubble Sort's time complexity of O(n ^ 2).

    Question 6 Answer: Bubble Sort = O(n ^ 2), Merge Sort = O(n * log(n))

    Part 11: Searching Questions

    Question 7 Answer: The Big O time complexity of linear search is O(n).

    Question 8 Answer: The Big O time complexity of binary search is O(log(n)).

    Question 9 Answer: Binary search requires sorted data since the algorithm relies on eliminating search spaces for each pass of the algorithm, which depends on comparing the target to less or greater than values whether the direction of the object is ascending or descending. The target won't be searched for properly if the data is not sorted.

    Question 10 Answer: I would use linear search if the data is not sorted since binary search would be rendered useless, since that algorithm relies on sorted data to obtain valid results.

    Question 11 Answer: Binary search would generally be preferable for a large and sorted data set, since its time complexity of O(log(n)) is more efficient compared to O(n) that linear search offers.

    */
    
    int[] sorted_arr = bubbleSort(arr);

    mergeSort(arr);

    // Part 8: Linear Search Test Cases

    System.out.print("\nLinear Search Test Cases\n");

    System.out.print("\nTarget: 111\n");

    linear_search(arr, 111);

    System.out.print("\nTarget: 100\n");

    linear_search(arr, 100);

    System.out.print("\nTarget: 200\n");

    linear_search(arr, 200);

    // Part 10: Binary Search Test Cases

    // 2nd and 3rd arguments are for low and high indiexes

    System.out.print("\nBinary Search Test Cases\n");

    System.out.print("\nTarget: 33\n");

    binary_search(sorted_arr, 0, arr.length - 1, 33);

    System.out.print("\nTarget: 121\n");

    binary_search(sorted_arr, 0, arr.length - 1, 121);

    System.out.print("\nTarget: 400\n");

    binary_search(sorted_arr, 0, arr.length - 1, 400);

  }

  // Part 3: Bubble Sort

  static int[] bubbleSort(int[] arr) {

    int[] new_arr = new int[arr.length];
    
    for (int i = 0; i < new_arr.length; i += 1) {

      new_arr[i] = arr[i];

    }

    for (int i = 0; i < new_arr.length; i += 1) {

      for (int j = 0; j < new_arr.length - 1; j += 1) {

        if (new_arr[j + 1] < new_arr[j]) {

          int temp = new_arr[j + 1];
          
          new_arr[j + 1] = new_arr[j];

          new_arr[j] = temp;

        }

      }

    }

    System.out.printf("\nArray after Bubble Sort: %s\n", Arrays.toString(new_arr));

    return new_arr;

  }

  // Part 5: Merge Sort (Incomplete)

  static void mergeSort(int[] arr) {

    // int left_loop_start = -1;

    int[] sorted_arr;

    // int[] left_arr = null;

    // if (arr.length % 2 == 0) {

      // left_arr = new int[arr.length / 2];

      // left_loop_start = arr.length / 2;

    // }

    // else {

      // left_arr = new int[arr.length / 2 + 1];

      // left_loop_start = arr.length / 2 + 1; 

    // }
  
    // int[] right_arr = new int[arr.length / 2];

    // for (int i = 0; i < left_loop_start; i += 1) {

      // left_arr[i] = arr[i];

    // }

    // for (int i = left_loop_start; i < arr.length; i += 1) {

      // right_arr[i - left_loop_start] = arr[i];

    // }

    // left_arr = divide(left_arr);

    // right_arr = divide(right_arr);

    // System.out.printf("\nLeft Array: %s\n", Arrays.toString(left_arr));

    // System.out.printf("\nRight Array: %s\n", Arrays.toString(right_arr));

    sorted_arr = divide(arr, 1);

    System.out.printf("\nUpdated Array: %s\n\n", Arrays.toString(sorted_arr));

  }

  static int[] divide(int[] arr, int it) {

    if (arr.length <= 1) {

      return arr;

    }

    int left_loop_start = -1;

    int[] left_arr = null;

    if (arr.length % 2 == 0) {

      left_arr = new int[arr.length / 2];

      left_loop_start = arr.length / 2;

    }

    else {

      left_arr = new int[arr.length / 2 + 1];

      left_loop_start = arr.length / 2 + 1;

    }

    int[] right_arr = new int[arr.length / 2];

    for (int i = 0; i < left_loop_start; i += 1) {

      left_arr[i] = arr[i];

    }

    for (int i = left_loop_start; i < arr.length; i += 1) {

      right_arr[i - left_loop_start] = arr[i];

    }

    System.out.printf("\nLeft Array: %s (Depth %d)\n", Arrays.toString(left_arr), it);

    System.out.printf("\nRight Array: %s (Depth %d)\n", Arrays.toString(right_arr), it);
    
    divide(left_arr, it + 1);

    divide(right_arr, it + 1);

    int[] sorted_arr = new int[left_arr.length + right_arr.length];

    for (int i = 0; i < sorted_arr.length; i += 1) {

      if (i >= left_arr.length && i >= right_arr.length) continue;

      if (i >= left_arr.length) {

        sorted_arr[i] = right_arr[i];

        continue;

      }

      if (i >= right_arr.length) {

        sorted_arr[i] = left_arr[i];

        continue;

      }

      if (left_arr[i] > right_arr[i]) sorted_arr[i] = right_arr[i];

      else sorted_arr[i] = left_arr[i];

    }

    return sorted_arr;

  }

  // Part 7: Linear Search

  static void linear_search(int[] arr, int target) {

    for (int i = 0; i < arr.length; i += 1) {

      if (arr[i] == target) {

        System.out.printf("\nTarget found at index: %d\n", i);

        return;

      }

    }

    System.out.print("\nTarget not found.\n\n");

  }

  // Part 9: Binary Search

  static void binary_search(int[] arr, int low, int high, int target) {

    if (low > high) {

      System.out.print("\nTarget not found.\n\n");

      return;

    }

    int mid = low + (high - low) / 2;

    if (arr[mid] > target) {

      binary_search(arr, low, mid - 1, target);

    }

    else if (arr[mid] < target) {

      binary_search(arr, mid + 1, high, target);

    }

    else {

      System.out.printf("\nTarget found at index: %d\n", mid);

      return;

    }

  }

}
