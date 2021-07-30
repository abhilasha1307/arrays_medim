package ARRAYS_medium;

import java.util.*;

public class p4_minimize_height_II {
  static class Pair {
    int value;
    int index;

    Pair(int value, int index) {
      this.value = value;
      this.index = index;
    }

    public int getValue() {
      return this.value;
    }

    public int getIndex() {
      return this.index;
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 1, 5, 10, 15 };
    int k = 3;
    System.out.println(getMinDiff(arr, arr.length, k));
  }

  private static int getMinDiff(int[] arr, int n, int k) {
    ArrayList<Pair> heights = new ArrayList<>();
    int visited[] = new int[n];

    for (int i = 0; i < n; i++) {
      if (arr[i] - k >= 0) {
        heights.add(new Pair(arr[i] - k, i));
      }
      heights.add(new Pair(arr[i] + k, i));
      visited[i] = 0;
    }
    Collections.sort(heights, new Comparator<Pair>() {
      public int compare(Pair p1, Pair p2) {
        return p1.getValue() - p2.getValue();
      }
    });

    int ele = 0;
    int l = 0;
    int r = 0;
    int size = heights.size();

    while (ele < n && r < size) {
      if (visited[heights.get(r).getIndex()] == 0) {
        ele += 1;
      }
      visited[heights.get(r).getIndex()]++;
      r++;
    }

    int ans = heights.get(r - 1).getValue() - heights.get(l).getValue();

    while (r < size) {
      if (visited[heights.get(l).getIndex()] == 1) {
        ele--;
      }

      visited[heights.get(l).getIndex()]--;
      l++;

      while (ele < n && r < size) {
        if (visited[heights.get(r).getIndex()] == 0) {
          ele += 1;
        }
        visited[heights.get(r).getIndex()]++;
        r++;
      }

      if (ele == n) {
        ans = Math.min(ans, heights.get(r - 1).getValue() - heights.get(l).getValue());
      }

      else
        break;
    }
    return ans;
  }
}
