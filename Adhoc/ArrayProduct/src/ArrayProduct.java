/**
 * Array Product
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given an array of numbers nums of size n, find an array of numbers products of size n, such that products[i] is the product of all numbers nums[j], where j != i.
 *
 *
 *
 * Input/Output Format For The Function:
 *
 *
 *
 * Input Format:
 *
 *
 *
 * There is only one argument: nums, denoting input array.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an array of numbers products, denoting the required product array where products[i] is the (product of all numbers nums[j]) % (10^9 + 7), where j != i.
 *
 *
 *
 * Input/Output Format For The Custom Input:
 *
 *
 *
 * Input Format:
 *
 *
 *
 * The first line of the input should contain a single integer n denoting the size of input array.
 *
 * In the next n lines, each line should contain a number Ai, denoting ith number of the input array A, (0<=i<n).
 *
 * If n = 5 and nums = [1, 2, 3, 4, 5], then input should be:
 *
 *
 *
 * 5
 *
 * 1
 *
 * 2
 *
 * 3
 *
 * 4
 *
 * 5
 *
 *
 *
 * Output Format:
 *
 *
 *
 * There will be n lines, each line containing a number Pi, denoting ith number of the resultant product array P.
 *
 *
 *
 * For input n = 5 and nums = [1, 2, 3, 4, 5], output will be:
 *
 *
 *
 * 120
 *
 * 60
 *
 * 40
 *
 * 30
 *
 * 24
 *
 *
 *
 * Constraints:
 *
 *
 *
 * You can't use division anywhere in solution.
 * 2 <= n <= 100000
 * -10^9 <= nums[i] <= 10^9, i = 0, 1, 2, … , n-1
 * products[i] >=0, i = 0, 1, 2, ... , n-1
 * You are allowed to use only constant extra space and resultant product array will not be considered as extra space.
 *
 *
 * Notes:
 *
 *
 *
 * Usage of resultant products array will not be considered as extra space used.
 * Without using division is the key constraint to remember.
 *
 *
 * Sample Test Cases:
 *
 *
 *
 * Sample Input 1:
 *
 *
 *
 * 5
 *
 * 1
 *
 * 2
 *
 * 3
 *
 * 4
 *
 * 5
 *
 *
 *
 * Sample Output 1:
 *
 *
 *
 * 120
 *
 * 60
 *
 * 40
 *
 * 30
 *
 * 24
 *
 *
 *
 * Explanation 1:
 *
 *
 *
 * Resultant Product array products = [products[0], products[1], products[2], products[3], products[4]]
 *
 * = [(nums[1]*nums[2]*nums[3]*nums[4]), (nums[0]*nums[2]*nums[3]*nums[4]), (nums[0]*nums[1]*nums[3]*nums[4]), (nums[0]*nums[1]*nums[2]*nums[4]), (nums[0]*nums[1]*nums[2]*nums[3])]
 *
 * = [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)]
 *
 * = [120, 60, 40, 30, 24]
 *
 *
 *
 * Sample Input 2:
 *
 *
 *
 * 3
 *
 * 4
 *
 * 9
 *
 * 10
 *
 *
 *
 * Sample Output 2:
 *
 *
 *
 * 90
 *
 * 40
 *
 * 36
 *
 *
 *
 * Explanation 2:
 *
 *
 *
 * Resultant Product array products = [products[0], products[1], products[2]]
 *
 * = [(nums[1]*nums[2]), (nums[0]*nums[2]), (nums[0]*nums[1])]
 *
 * = [(9*10), (4*10), (4*9)]
 *
 * = [90, 40, 36]
 *
 *
 *
 * Suggestions:
 *
 * ﻿﻿﻿﻿
 *
 * Suggested time in interview: 20 minutes.
 *
 * The “Suggested Time” is the time expected to complete this question during a real-life interview, not now in homework i.e. For the first attempt of a given homework problem, the focus should be to understand what the problem is asking, what approach you are using, coding it, as well as identifying any gaps that you can discuss during a TC session. Take your time, but limit yourself to 2 one hour sessions for most problems.
 */

/**
 * Editorial by IK
 *
 * We have provided solutions which contain necessary comments to understand the approach used:
 *
 *
 *
 * 1) brute_force_solution.java
 *
 *
 *
 * Description:
 *
 *
 *
 * A naive approach would be, to find ith element of output array (i.e. products[i]), iterate over an entire input array nums to get the product of all elements nums[j], such that j != i.
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n*n) where n is length of input array nums.
 *
 *
 *
 * As we are iterating over complete array to find products[i] and as i can be 0<=i<=n-1. Each calculation of element of products array will take O(n) so total complexity will be O(n*n).
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(1).
 *
 *
 *
 * As we are not storing anything extra and excluding space used to store output array products.
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n) where n is length of input array nums.
 *
 *
 *
 * As storing input array nums of length n will take O(n) and auxiliary space used is O(1). So, O(n) + O(1) → O(n).
 *
 *
 *
 * 2) optimal_solution.java
 *
 *
 *
 * Description:
 *
 *
 *
 * An optimal approach would be as follows:
 *
 * Notice that for products[i], product of all input array elements other than ith element is nothing but (product of all elements nums[j], 0 <= j <= (i-1)) * (product of all elements nums[j], (i+1) <= j <= (n-1)) = (nums[0]*nums[1]*...*nums[i-1]) * (nums[i+1]*nums[i+2]*...*nums[n-1]).
 *
 * So, iterate input array nums twice to fill output array products, once for updating products[i] with (nums[0] * nums[1] *...*nums[i-1]), and next one for updating products[i] with (nums[i+1] * nums[i+2] * … * nums[n-1]).
 *
 * Please see the commented code for detailed implementation of optimal approach.
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n) where n is length of input array nums.
 *
 *
 *
 * As we are iterating over input array nums two times it will take O(n).
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(1).
 *
 *
 *
 * As we are not storing anything extra and excluding space used to store output array products.
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n) where n is length of input array nums.
 *
 *
 *
 * As storing input array nums of length n will take O(n) and auxiliary space used is O(1). So, O(n) + O(1) → O(n).
 */
public class ArrayProduct {

  public static void main(String[] args)
  {
    int arr[] = {1000000000,1000000000};
    int[] result = arrayProduct(arr);
    for(int i:result)
      System.out.println(i);
  }

  static int mod = (int)Math.pow(10, 9) + 7;
  static int[] arrayProduct(int[] nums) {

    // Size of output array is same as that of input array
    int[] products = new int[nums.length];

    // For finding value of products[i], product of all nums elements
    // other than ith element is nothing but
    // (product of all nums[j], 0<=j<=(i-1)) * (product of all nums[j], (i+1)<=j<=(nums.length-1))
    // i.e. (nums[0]*nums[1]*...*nums[i-1]) * (nums[i+1]*nums[i+2]*...*nums[nums.length-1])

    int leftProduct = 1;

    // Filling products, such that products[i] contains
    // product of all elements nums[j], 0<=j<=(i-1)
    for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
      // Here, leftProduct contains product of all elements
      // nums[j], 0<=j<=(currentIndex-1)
      products[currentIndex] = leftProduct;

      // After this updation of leftProduct, leftProduct contains product of all
      // elements nums[j], 0<=j<=currentIndex
      nums[currentIndex] = nums[currentIndex]>0?nums[currentIndex]:(mod+nums[currentIndex])%mod;
      leftProduct = (int)((leftProduct * 1l * nums[currentIndex])%mod);
    }

    int rightProduct = 1;

    // Updating products, such that products[i] contains new value
    // ((products[i]) * (product of all elements nums[j], 0<=j<=(i-1)))
    for (int currentIndex = nums.length - 1; currentIndex >= 0; currentIndex--) {
      // Here, rightProduct contains product of all elements
      // nums[j], (currentIndex+1)<=j<=(nums.length-1)
      products[currentIndex] = (int)((products[currentIndex] * 1l * rightProduct)%mod);

      // after this updation of rightProduct, rightProduct contains product of all
      // elements nums[j], currentIndex<=j<=(nums.length-1)
      rightProduct = (int)((rightProduct * 1l * nums[currentIndex])%mod);
    }
    return products;
  }

//  private static int[] arrayProduct(int[] arr) {
//    int product =1;
//    int[] result = new int[arr.length];
//    for(int element:arr)
//      product*=element;
//
//    for(int i=0;i<arr.length;i++){
//      result[i] = (product/arr [i])%(10^9 + 7);
//    }
//    return result;
//  }
}
