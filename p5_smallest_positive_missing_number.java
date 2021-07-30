package ARRAYS_medium;

/*
You are given an array arr[] of N integers including 0. The task is to find the smallest positive number missing from the array.
*/
/*
APPROACH:)

*/
public class p5_smallest_positive_missing_number {
 public static void main(String[] args) {
  int[] arr = new int[] { 0, -10, 1, 3, -20 };
  int size = arr.length;

  System.out.println(missingNumber(arr, size));
 }

 public static int missingNumber(int arr[], int size) {
  int p = 0;
  for (int i = 0; i < size; i++) {
   if (arr[i] == 1) {
    p = 1;
    break;
   }
  }

  if (p == 0) {
   return 1;
  }

  for (int i = 0; i < size; i++) {
   if (arr[i] <= 0 || arr[i] > size) {
    arr[i] = 1;
   }
  }

  for (int i = 0; i < size; i++) {
   arr[(arr[i] - 1) % size] += size;
  }

  for (int i = 0; i < size; i++) {
   if (arr[i] <= size) {
    return (i + 1);
   }
  }
  return (size + 1);
 }
}

/*
 * ALTERANATIVE:
 * 
 * APPROACH:) segregate new array; copy elements use elements as indices and
 * mark as neagtive the element which is left positive
 * 
 * CODE:
 */