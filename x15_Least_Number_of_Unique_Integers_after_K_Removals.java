package ARRAYS.ARRAYS_medium;

//min heap
import java.util.*;

/*
============================
PROBLEM:) 1481
============================
Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.

Input: arr = [5,5,4], k = 1
Output: 1
Explanation: Remove the single 4, only 5 is left.

1 <= arr.length <= 10^5
1 <= arr[i] <= 10^9
0 <= k <= arr.length
*/

/*
===========================================
APPROACH:)
===========================================
The intution is to count the frequencies of all the elements in the array and then remove the elements of least frequency 
the more the elements with bigger frequencies, the lesser will be the number of unique integers there is

so we make a map to record the frequencies of the elements <key, value> => <element, frequency>
we make a list where we store just the frequencies of the elements and then we sort the list so that removing the lower frenqencies is easy
make a variable 'count' which counts the number of elements with said frenqency taken away from k (we have to remove k elements and then see how many unique integers are left)
as k can be 0 too, we do this till k<0 and then break out of the loop

count is the number of elements removed and map.keyset.size essentially gives the total number of elememts in the array
since we removed the elements of least freqency, the remaining elements will be unique only when counted once 
therefore we return  map.keySet().size() - count

Time : O(n) + O(n*logn) + O(n) => O(n*logn) [worst of three]
Space : space for map and space for arraylist (calculate?)
*/

/*
ALTERNATE SOLUTION : using Comparable (explain?)

public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : arr) map.put(n, map.getOrDefault(n, 0) + 1);
        List<Integer> l = new ArrayList<>(map.keySet());
        Collections.sort(l, (a, b) -> map.get(a) - map.get(b));
        int n = map.size(), remove = 0, idx = 0;
        while (k > 0 && idx < n) {
            k -= map.get(l.get(idx++));
            if (k >= 0) remove++;
        }
        return n - remove;
    }*/

public class x15_Least_Number_of_Unique_Integers_after_K_Removals {
    public static int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            if (map.containsKey(n)) {
                int a = map.get(n);
                a++;
                map.put(n, a);
            } else {
                map.put(n, 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list); // O(n*logn) [modified merge sort]

        int count = 0;
        for (int n : list) {
            k -= n;

            if (k < 0)
                break;
            else
                count++;
        }

        return map.keySet().size() - count;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 4, 3, 1, 1, 3, 3, 2 };

        int k = 3;
        System.out.println(findLeastNumOfUniqueInts(arr, k));
    }

}
