package ARRAYS_medium;

/*
=======================================
PROBLEM:) 1482
=======================================
Given an integer array bloomDay, an integer m and an integer k.

We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
Return the minimum number of days you need to wait to be able to make m bouquets from the garden. 
If it is impossible to make m bouquets return -1.

bloomDay.length == n
1 <= n <= 10^5
1 <= bloomDay[i] <= 10^9
1 <= m <= 10^6
1 <= k <= n
*/

/*
===============================================
APPROACH:)
===============================================
https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/discuss/686529/Java-Binary-Search-with-detailed-explanation.-Runtime%3A-O(nLog(maxdays))-100

This approach is to do a Hit or miss, starting from min days to max days.
Time Complexity: O(nLog(maxdays))
Space Complexity: O(1)
*/
public class x12_Minimum_Number_of_Days_to_Make_m_Bouquets {
 public static int minDays(int[] bloomDay, int m, int k) {
  if (bloomDay.length < m * k)
   return -1;
  int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
  for (int i : bloomDay) {
   max = Math.max(max, i);
   min = Math.min(min, i);
  }
  // Take the boundary starting from 1 to the max day in the bloomDay.
  while (min < max) {
   int mid = min + (max - min) / 2;
   int possibleBouquets = getPossibleBouquets(bloomDay, mid, k);
   // The
   if (possibleBouquets < m) {
    min = mid + 1;
   } else {
    max = mid;
   }
  }
  return min;
 }

 private static int getPossibleBouquets(int[] bloomDay, int day, int k) {
  // This method is to find the number of bouquets that can be formed on a given
  // day.
  int bouquets = 0, flowersCollected = 0;
  for (int value : bloomDay) {
   if (value <= day) {
    // If the current flower can be taken with in days then increase the flower
    // flowersCollected.
    flowersCollected++;
   } else {
    // If there is a flower in between that takes more number of days then the given
    // day, then resent the counter.
    flowersCollected = 0;
   }
   // If the flowersCollected is same as the required flower per bookie, then
   // increase the bouquets count;
   if (flowersCollected == k) {
    bouquets++;
    flowersCollected = 0;
   }
  }
  return bouquets;
 }

 public static void main(String[] args) {
  int[] bloomDay = new int[] { 1, 10, 3, 10, 2 };
  int m = 3;
  int k = 1;

  System.out.println(minDays(bloomDay, m, k));
 }

}
