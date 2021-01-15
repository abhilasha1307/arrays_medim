package ARRAYS.ARRAYS_medium;

//https://www.geeksforgeeks.org/number-of-subarrays-with-odd-sum/

/* 
PROBLEM:) 1524

Given an array of integers arr. Return the number of sub-arrays with odd sum.
As the answer may grow large, the answer must be computed modulo 10^9 + 7.
*/

/*


*/
public class x6_number_of_subarrays_with_odd_sum {

 public static int numOfSubarrays(int[] arr) {
  // 222 ms
  /*
   * int result = 0; int sum = 0;
   * 
   * for (int i = 0; i < arr.length; i++) { if (arr[i] % 2 == 1) { result++; } }
   * 
   * for (int i = 0; i < arr.length; i++) { sum = 0; sum += arr[i]; for (int j = i
   * + 1; j < arr.length; j++) { sum += arr[j];
   * 
   * if (sum % 2 == 1) { result++; } } } result = result % 1000000007; return
   * result;
   */

  /*
   * explain in your words later
   */

  /*
   * Case 1: For any even number in array, it's addition to existing odd sum
   * subarrays will affect the odd sum subarrays. odd + even = odd Hence dp[i] =
   * dp[i-1]
   * 
   * Case 2: For any *odd element *in array, it will make sum of even sum
   * subarrays ending at previous position, odd. We need to find the even sum
   * subarrays for previous element. ie. Total subarrays ending at i - total odd
   * sum subarrays at i-1. We include even + odd = odd, and exclude odd+odd =even
   * Hence dp[i] = i+1- dp[i-1];
   */

  // 11ms
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

  // alternate sol 1: 10ms
  /*
   * If we know the number of even and odd subarrays that end at the previous
   * element, we can figure out how many even and odd subarrays we have for
   * element n:
   * 
   * If n is even, we increase the number of even subarrays; the number of odd
   * subarrays does not change. If n is odd, the number of odd subarrays is the
   * previous number of even subarrays + 1. The number of even subarrays is the
   * previous number of odd subarrays.
   * 
   */

  /*
   * int odd = 0, even = 0, res = 0; for(int n:arr) { if(n%2 == 1) { int temp =
   * odd; odd = even + 1; even = temp; }
   * 
   * else { even++; }
   * 
   * res = (res+odd)%1000000007; } return res;
   */

  // alternate sol 2 : 10ms
  // Since odd + even equals the number of elements so far, we
  // can simplify our solution by only tracking odd.
  // here we just track the number of odd subarrays and the total subarrays ending
  // i (Number of subarrays ending i, would be i+1)
  // E.g. subarrays ending index 1, will be [1,3], [3]. Ie.2
  /*
   * int Odd = 0, Res = 0; for(int i = 0; i<arr.length; i++) { if(arr[i]%2 == 1) {
   * Odd = i-Odd+1; }
   * 
   * Res = (Res+Odd)%1000000007; }
   * 
   * return Res;
   */
 }

 public static void main(String[] args) {
  int[] arr = new int[] { 1, 3, 5 };

  System.out.println(numOfSubarrays(arr));
 }

}
