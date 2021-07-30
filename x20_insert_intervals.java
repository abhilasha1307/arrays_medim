package ARRAYS_medium;

import java.util.*;

public class x20_insert_intervals {
 public static void main(String[] args) {
  int[][] intervals = new int[][] { { 2, 5 }, { 6, 7 }, { 8, 9 } };
  int[] newInt = new int[] { 0, 1 };

  int[][] res = insert(intervals, newInt);
  for (int i = 0; i < res.length; i++) {
   for (int j = 0; j < res[i].length; j++) {
    System.out.print(res[i][j] + " ");
   }
   System.out.println();
  }
 }

 public static int[][] insert(int[][] intervals, int[] newInterval) {
  ArrayList<int[]> list = new ArrayList<>();
  boolean added = false;
  for (int i = 0; i < intervals.length; i++) {
   if (intervals[i][1] < newInterval[0]) {
    list.add(intervals[i]);
   }

   else if (intervals[i][0] > newInterval[1]) {
    if (!added) {
     list.add(newInterval);
    }
    added = true;
    list.add(intervals[i]);
   }

   else {
    newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
    newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
   }
  }

  if (!added) {
   list.add(newInterval);
  }
  return list.toArray(new int[list.size()][2]);
 }
}

// if (intervals.length == 0) {
// int[][] ans = new int[1][2];
// ans[0][0] = newInterval[0];
// ans[0][1] = newInterval[1];

// return ans;
// }
// int res[][] = new int[intervals.length + 1][intervals[0].length];

// for (int i = 0; i < intervals.length; i++) {
// res[i][0] = intervals[i][0];
// res[i][1] = intervals[i][1];
// }
// res[intervals.length][0] = newInterval[0];
// res[intervals.length][1] = newInterval[1];

// Arrays.sort(res, (a, b) -> Integer.compare(a[0], b[0]));
// LinkedList<int[]> list = new LinkedList<>();

// for (int[] interval : res) {
// if (list.isEmpty() || list.getLast()[1] < interval[0]) {
// list.add(interval);
// } else {
// list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
// }
// }

// return list.toArray(new int[list.size()][]);}