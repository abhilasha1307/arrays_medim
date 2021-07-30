package ARRAYS_medium;

/*
===================================================================
PROBLEM :) 189
===================================================================
Given an array, rotate the array to the right by k steps, where k is non-negative.

Follow up:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
Could you do it in-place with O(1) extra space?

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

=============================================
EXAMPLES:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
===============================================
*/

/*
===================================================================
APPROACH:)
===================================================================
To rotate thorugh the array such that if we reach the last element, we can get back to first, element without AIOOBE
we will reverse the whole array once and then reverse the first k numbers and then the remaining part that lies after k to get the desired rotated array
for any value of 'k' we are reversing the whole array three times

Time : O(N). N elements are shited three times
Space : O(1). in place approach
*/

/*
===========================================================
ALTERNATE APPROACH:)
===========================================================
public static void rotate(int[] nums, int k)
{
 k = k%nums.length;
 int count = 0;
 for(int start = 0; count<nums.length; start++)
 {
  int current = start;
  int prev = nums[start];

  do
  {
   int next = (current+k)%nums.length;
   int temp = nums[next];
   nums[next] = prev;
   prev = temp;
   current = next;
   count++; 
  }
  while(start!=current);
 }
}

here we will keep track of the current index, the element that is at this current index will be replaced, the element which will be replacing the previous element 
the count of the number of times the replacement has happened (all elements are replaced once so in the end it should be nums.length-1)
we start at start = 0 and will go on till count is not nums.length - 1 and the point that we started at is has not been reached again

we replace the previous element with the element at the present at current + k (% nums.length to rotate through the array) since all the elements have to be shifted to current + k
it stops in mid when we put an element at current = 0 and now the element that was at current = 0 previously has already been shifted to its corrent position and its the element
at current + 1 which need to be shifted next; so we break out of the do while loop and then increment start by one so that current is now at current +1 (current = start)


Time : O(N). One pass
Space : O(1). Inplace approach
*/
public class x2_rotate_array {

 public static void main(String[] args) {
  int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };

  int k = 4;
  rotate(arr, k);

 }

 public static void rotate(int[] nums, int k) {
  k %= nums.length; // for when k >= nums.length, to rotate through

  reverse(nums, 0, nums.length - 1);
  reverse(nums, 0, k - 1);
  reverse(nums, k, nums.length - 1);

  for (int i = 0; i < nums.length; i++) {
   System.out.print(nums[i] + " ");
  }

 }

 static void reverse(int[] nums, int l, int h) {
  while (l < h) {
   int temp = nums[l];
   nums[l] = nums[h];
   nums[h] = temp;
   l++;
   h--;
  }
 }
}
