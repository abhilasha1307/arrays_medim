package ARRAYS_medium;

/*
==================================================================
PROBLEM:)
==================================================================
Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

Constraints:
1 ≤ N ≤ 10^6
-10^7 ≤ A[i] <= 10^7

======================================================================
EXAMPLES:
Input:
N = 5
arr[] = {1,2,3,-2,5}
Output: 9

N = 4
arr[] = {-1,-2,-3,-4}
Output: -1
=========================================================================
*/

/*
======================================================================
APPROACH:)
========================================================================
we make two variables max_current = 0 and Max = Integer.MIN_VALUE (for array will all negative elements). 
we add the current element to the max_current and then compare it with Max, to see which is maximum and assign the maximum of two to Max
then we check if max_current is <0, if yes, we set it to zero and then continue the loop for the next element
return Max when the array is traversed

Time : O(N)
Space: O(1)
*/
public class p1_Kadane_algorithm {

 public static void main(String[] args) {
  int[] arr = new int[] { 1, -3, 2, 1, -1 };
  int n = arr.length;
  System.out.println(maxSubarraySum(arr, n));
 }

 public static int maxSubarraySum(int arr[], int n) {

  int max_current = 0;
  int Max = Integer.MIN_VALUE;

  for (int i = 0; i < n; i++) {
   max_current += arr[i];
   if (Max < max_current) {
    Max = max_current;
   }

   if (max_current < 0) {
    max_current = 0;
   }

  }

  return Max;
 }

}
