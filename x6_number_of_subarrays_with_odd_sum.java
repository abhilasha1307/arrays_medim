package ARRAYS_medium;

/* 
=================================================
PROBLEM:) 1524
=================================================
Given an array of integers arr. Return the number of sub-arrays with odd sum.
As the answer may grow large, the answer must be computed modulo 10^9 + 7.

1 <= arr.length <= 10^5
1 <= arr[i] <= 100

=================================================================================
EXAMPLES:
Input: arr = [1,3,5]
Output: 4
Explanation: All sub-arrays are [[1],[1,3],[1,3,5],[3],[3,5],[5]]
All sub-arrays sum are [1,4,9,3,8,5].
Odd sums are [1,9,3,5] so the answer is 4.

Input: arr = [2,4,6]
Output: 0
Explanation: All sub-arrays are [[2],[2,4],[2,4,6],[4],[4,6],[6]]
All sub-arrays sum are [2,6,12,4,10,6].
All sub-arrays have even sum and the answer is 0
================================================================================
*/

/*
======================================================
APPROACH:)
======================================================
We make a new array to keep track of the odd sum subarrays till a said index
if the first element in the given input array is odd, we make A[0] = 1 else, 0

starting a loop at i = 1
if the element at 1 is even, it means that the total number of odd aubarrays ending at 'arr[i]' does not change
if the element is odd, we need to find the even sum subarrays for previous element. ie. Total subarrays ending at i - total odd sum subarrays at i-1. 
this is (i+1)-A[i-1];
we keep updating res by A[i], at the end of the loop

Time : O(N)
Space : O(N)
*/

/*
=======================================================
ALTERNATE SOLUTION:)
=======================================================
public static int numOfSubarrays(int[] arr)
{
  int even = 0, odd = 0, res = 0;
  for(int n:arr)
  {
    if(n%2 ==1)
    {
      int temp = odd;
      odd = even + 1;
      even = temp;
    }

    else
    {
      even++;
    }

    res = (res+odd)%1000000007;
  }
  return res;
}

Time : O(N)
Space :O(1)

if we know the number of even and odd subarrays at that end at the previous element, we can figure out how many even and odd subarrays we have for current element
if the current element is even, even subarrays increare by one and odd subarray does not change
if the current element is odd, the number of odd subarrays is the previous number of even subarrays + 1. The number of even subarrays is the previous number of odd subarrays.
*/

public class x6_number_of_subarrays_with_odd_sum {
  public static void main(String[] args) {
    int[] arr = new int[] { 1, 3, 5 };

    System.out.println(numOfSubarrays(arr));
  }

  public static int numOfSubarrays(int[] arr) {
    int result = 0;
    int[] A = new int[arr.length]; // this will track the number of odd subarrays till the ith index

    A[0] = 0;

    if (arr[0] % 2 == 1) {
      A[0] = 1;
    }

    result = A[0];

    for (int i = 1; i < arr.length; i++) {
      if (arr[i] % 2 == 0) {
        A[i] = A[i - 1];
      }

      else {
        A[i] = i - A[i - 1] + 1;
      }

      result = (result + A[i]) % 1000000007;
    }
    return result;
  }

}
