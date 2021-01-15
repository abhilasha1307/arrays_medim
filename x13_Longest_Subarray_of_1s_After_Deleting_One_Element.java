package ARRAYS.ARRAYS_medium;

/*
=======================================
PROBLEM:) 1493
=======================================
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array.
Return 0 if there is no such subarray.

1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
*/

/*
=======================================
APPROACH:)
=======================================
we make three variables; Pc to record the largest previous subarray of 1s before a zero is encountered
count to count the number of 1s
and result which will have the required result we will be returning

we start a one pass loop from i = 0 to nums.length-1 and increment count by one when nums[i] is 1
if nums[i] != 1 we just store the greater of res and Pc+count in res (we want the longest subarray of 1s)
since we can remove only one element, it has to be the zero between the Pc and count and therefore we do Pc+count

if all the elements are 1, as we have to remove a element, we will return res-1 (here result will be equal to nums.length as all the elements are equal to 1)

Time : O(n)
Space : O(1)
*/

/*
ALTERNATIVE : SLIDING WINDOW APPROACH
Intuition is to keep at most one 0 in the window

learn

*/

public class x13_Longest_Subarray_of_1s_After_Deleting_One_Element {
 public static int longestSubarray(int[] nums) {

  int Pc = 0, count = 0, res = 0;

  for (int i = 0; i < nums.length; i++) {
   if (nums[i] == 1) {
    count++;
   }

   else {
    res = Math.max(res, Pc + count);
    Pc = count;
    count = 0;
   }
  }
  res = Math.max(res, count + Pc);

  return res == nums.length ? res - 1 : res;

 }

 public static void main(String[] args) {
  int[] arr = new int[] { 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1 };

  System.out.println(longestSubarray(arr));
 }

}
