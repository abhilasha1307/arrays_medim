package ARRAYS_medium;

/*
PROBLEM:) 1574
Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.

A subarray is a contiguous subsequence of the array.

Return the length of the shortest subarray to remove
*/

/*
APPROACH:)
intution and how we code it

see the sliding window approach as well
https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/discuss/830480/C%2B%2B-O(N)-Sliding-window-Explanation-with-Illustrations
*/

public class x8_Shortest_Subarray_to_be_Removed_to_Make_Array_Sorted {
 public static int findLengthOfShortestSubarray(int[] arr) {

  int start = 0;
  int end = arr.length - 1;

  while (start + 1 < arr.length && arr[start] <= arr[start + 1]) {
   start++;
  }

  if (start == arr.length - 1) {
   return 0;
  }

  while (end - 1 >= 0 && arr[end] >= arr[end - 1]) {
   end--;
  }

  int length = Math.min(arr.length - start - 1, end);

  int i = 0;
  int j = end;

  while (i <= start && j < arr.length) {
   if (arr[j] >= arr[i]) {
    length = Math.min(length, j - i - 1);
    i++;
   } else {
    j++;
   }
  }

  return length;
 }

 public static void main(String[] args) {
  int[] arr = new int[] { 1, 2, 3, 10, 4, 2, 3, 5 };

  System.out.println(findLengthOfShortestSubarray(arr));
 }

}
