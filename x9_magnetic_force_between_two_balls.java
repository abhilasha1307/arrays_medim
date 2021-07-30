package ARRAYS_medium;

import java.util.Arrays;

/*
============================================
PROBLEM:) 1552
============================================

In universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. 
Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.

Rick stated that magnetic force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.

n == position.length
2 <= n <= 10^5
1 <= position[i] <= 10^9
All integers in position are distinct.
2 <= m <= position.length 
*/

/*
===============================================
APPROACH:)
===============================================
/*
  * We can use binary search to find the answer.
  * 
  * Define function count(d) that counts the number of balls can be placed in to
  * baskets, under the condition that the minimum distance between any two balls
  * is d.
  * 
  * We want to find the maximum d such that count(d) == m.
  * 
  * If the count(d) > m , we have too many balls placed, so d is too small. If
  * the count(d) < m , we don't have enough balls placed, so d is too large.
  * Since count(d) is monotonically decreasing with respect to d, we can use
  * binary search to find the optimal d.
  * 
  * Time complexity: O(Nlog(10^9)) or O(NlogM), where M = max(position) -
  * min(position) Space complexity: O(1)
  
*/
public class x9_magnetic_force_between_two_balls {

  public static int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    int lo = 0;
    int hi = position[position.length - 1];
    int optimal = 0;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (canPut(position, m, mid)) {
        optimal = mid;
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return optimal;
  }

  /*
   * returns whether we can put m balls such that minimum distance between two
   * consecutive ball is always greater than or equal to the max.
   */
  private static boolean canPut(int[] positions, int m, int max) {
    int count = 1;
    int last = positions[0];
    for (int i = 0; i < positions.length; i++) {
      if (positions[i] - last >= max) {
        last = positions[i];
        count++;
      }
    }
    return count >= m;
  }

  public static void main(String[] args) {
    int[] position = new int[] { 1, 2, 3, 4, 7 };
    int m = 3;

    System.out.print(maxDistance(position, m));
  }

}
