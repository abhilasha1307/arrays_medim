package ARRAYS_medium;

/*
=================================================================================================
PROBLEM:) 11
=================================================================================================
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

Notice that you may not slant the container.

CONSTRAINTS:
n == height.length
2 <= n <= 3 * 104
0 <= height[i] <= 3 * 104

==================================================================================================================================
EXAMPLES:)
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.


Input: height = [1,2,1]
Output: 2

Input: height = [4,3,2,1,4]
Output: 16
=========================================================================================================================
*/

/*
===========================================================================================
APPROACH:)
===========================================================================================
For the maximum water to be stores, we have to find a pair of ai's such that the minimum between them and the width between them gives the maximum product
we store this product in maxarea. 
for decreasing width, if the storing goes up, its becoz of the height of the ai, so we search for the pair which has better height, in turn decreasing the width of the container to be

Since we move the smaller value pointer to the inner array; instead of moving the pointer to the next value, we can save some time by moving the pointer to the next larger value because smaller height must result in a smaller area which is not a good candidate for the maximum area (greater height with less width is)s

Time : O(N)
Space : O(1)
*/

public class x16_container_with_most_water {

 public static void main(String[] args) {
  int[] height = new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
  System.out.println(maxArea(height));

 }

 public static int maxArea(int[] height) {
  int maxarea = 0, l = 0, r = height.length - 1;
  while (l < r) {
   maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
   if (height[l] < height[r]) {
    int left = height[l];
    while (height[l] <= left && l < r) {
     l++;
    }
   } else {
    int right = height[r];
    while (height[r] <= right && l < r) {
     r--;
    }
   }
  }
  return maxarea;
 }
}
