package ARRAYS_medium;

/*
==========================================================================
PROBLEM:) 
==========================================================================
Given an array(0-based indexing), you have to find the max sum of i*A[i] where A[i] is the element at index i in the array. The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.

Constraints:
1<=N<=104
1<=A[]<1000

================================================================
EXAMPLE:)
Input:
N = 4
A[] = {8,3,1,2}
Output: 29
Explanation: Above the configuration
possible by rotating elements are
3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11
Here the max sum is 29
=================================================================
*/

/*
===============================================================
APPROACH:)
===============================================================
We are rotating clockwise, one element from front goes to the last index in every iteration 
to calculate the value of rotated array, we add arr[i-1]*(n-1) as index here will go from 0 to n-1
all the other elements have their multipliers (indices) decremented by one (net). that is from the sum of all the elements we have to take out the element at index(i-1) 
this difference when taken away from the curr_value, will give us the sum for elements whose multipliers have decremented by one
curr_value - (Sum - arr[i-1]) + arr[i-1]*(n-1)

for every iteration, we change the value of curr_value and res(if its more than the prev value)

Time: O(N)
Space: O(1)
*/
public class p2_Max_sum_in_the_configuration {

  public static void main(String[] args) {
    int[] arr = new int[] { 82, 517, 517, 3, 232, 140, 797, 405, 339, 581, 219, 22, 971, 863, 813, 380, 978, 686, 537,
        905, 177, 484, 208, 760, 858, 745 };
    int n = arr.length;

    System.out.println(max_sum(arr, n));
  }

  public static int max_sum(int A[], int n) {
    int S = 0;
    int curr_val = 0;
    for (int i = 0; i < n; i++) {
      S += A[i];
      curr_val += A[i] * i;
    }

    int res = curr_val;
    for (int i = 1; i < n; i++) {
      int next_val = curr_val - (S - A[i - 1]) + A[i - 1] * (n - 1); // IMP

      curr_val = next_val;
      res = Math.max(res, next_val);
    }
    return res;
  }

}
