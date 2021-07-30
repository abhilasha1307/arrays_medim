package ARRAYS_medium;

import java.util.Arrays;

/*
==========================================
PROBLEM:) 1508
==========================================
Given the array nums consisting of n positive integers. You computed the sum of all non-empty continous subarrays from the array and then sort them in non-decreasing order, creating a new array of n * (n + 1) / 2 numbers.

Return the sum of the numbers from index left to index right (indexed from 1), inclusive, in the new array. Since the answer can be a huge number return it modulo 10^9 + 7.

1 <= nums.length <= 10^3
nums.length == n
1 <= nums[i] <= 100
1 <= left <= right <= n * (n + 1) / 2

==========
Example:
==========

*/

/*
============================================
APPROACH:)
============================================
we make an array 'result' to store the sum of the previous elements till we hit the end of the array
as its given that left and right point to the indices of a 1 indexed array, we make the 0th element of result as 0 and first element same as nums[0]


Time : O(n^2 log n^2)
Space : O(n^2). Array of size n*(n+1)/2 is made
*/

/*
public static int rangeSum(int[] nums, int n, int left, int right) {
  long res = 0, mod = 1_000_000_007, sum = 0;
  List<Long> sums = new ArrayList<>(), pSum = new ArrayList<>(); // sums - all sums of subarrays, pSum - prefix sums;
  pSum.add(0L);
  for (int i = 0; i < n; i++) {
   sum += nums[i];
   pSum.add(sum);
   for (int j = 0; j < pSum.size() - 1; j++)
    sums.add(sum - pSum.get(j));
  }
  Collections.sort(sums);
  while (left <= right)
   res = (res + sums.get(left++ - 1)) % mod;
  return (int) res;
 }
*/

//look for solutions with priority queue, heap
public class x11_Range_Sum_of_Sorted_Subarray_Sums {

  public static int rangeSum(int[] nums, int n, int left, int right) {

    int[] result = new int[(n * (n + 1) / 2) + 1];
    result[0] = 0;
    result[1] = nums[0];
    int k = 0;

    for (int j = 2, i = 1; j < result.length;) {
      if (i == nums.length) {
        k++; // NOTE : reaseonm ??
        i = k;
        result[j++] = nums[i++];
      } else {
        result[j] = nums[i] + result[j - 1];
        j++;
        i++;
      }
    }

    Arrays.sort(result);
    int sum = 0;

    while (left <= right) {
      sum = (sum + result[left++]) % 1000000007;
    }
    return sum;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 2, 3, 4 };
    int n = 4;
    int left = 1;
    int right = 5;

    System.out.println(rangeSum(nums, n, left, right));

    System.out.println(Practise.rangeSum(nums, n, left, right));

  }

}

class Practise {

  public static int rangeSum(int[] nums, int n, int left, int right) {

    return 0;
  }

}