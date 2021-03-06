/**
 * Alternating Positives and Negatives
 *
 *
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given an array named array of size n, that contains both positive and negative numbers. Rearrange the array elements so that positive and negative numbers appear alternatively in the output. The order in which the positive elements appear should be maintained. Similarly, the order in which the negative elements appear should also be maintained.
 *
 *
 *
 * Number of positive and negative integers may not be equal and extra positives or negatives have to appear in the end of the array.
 *
 *
 *
 * Input Format:
 *
 *
 *
 * There is only one argument in input, denoting integer array named array.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an integer array with alternate positive and negative numbers with order maintained.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= n <= 500000
 * -2 * 10^9 <= array[i] <= 2 * 10^9
 * Consider 0 as a positive integer for this particular question.
 * Start the array with the positive integer unless all the integers in the input array are negative.
 *
 *
 *
 *
 * Sample Test Case:
 *
 *
 *
 * Sample Input:
 *
 *
 *
 * array = [2 3 -4 -9 -1 -7 1 -5 -6]
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * [2 -4 3 -9 1 -1 -7 -5 -6]
 *
 *
 *
 * Explanation:
 *
 *
 *
 * Order of positive integers in the input array is [2 3 1] which is similar to order of positive integers in the output array.
 *
 *
 *
 * Order of negative integers in the input array is [-4 -9 -1 -7 -5 -6] which is similar to order of negative integers in the output array.
 *
 *
 * The output array starts with a positive integer and keeps alternating with negative integers until all positive integers are exhausted. Rest of the output array is filled with leftover negative integers.
 */

import java.util.Arrays;

/**
 * Editorial by IK
 * We have used two approaches to solve this problem.
 *
 *
 *
 * 1) optimal_solution.cpp
 *
 *
 *
 * Description:
 *
 *
 *
 * We keep two pointers, one pointing to all positive numbers in the original array and another pointing to all negative numbers in the original array.
 *
 *
 *
 * Let us call them positive_pointer and negative_pointer respectively.
 *
 *
 *
 * Then similar to merge sort, we will merge them the numbers pointed by these two pointers in a new array keeping positive and negative numbers alternatively placed to each other in the final array.
 *
 *
 *
 * Example:
 *
 *
 *
 * Let the input array be:
 *
 * 5 0 1 -3 4 -6 -8 3 2 -9
 *
 *
 *
 * We initialise both positive_pointer and negative_pointer to 0 (index at the start of the array).
 *
 *
 *
 * We will run a loop to fill each index of the output array.
 *
 *
 *
 * We move the pointers forward unless we find the next positive element for the positive_pointer and next negative element for the negative_pointer.
 *
 *
 *
 * For our example, the first positive integer is 5 which is at index 0 and the first negative number is -3 which is at index 4.
 *
 *
 *
 * Now, at first iteration, since the index of iteration in the loop is 0, and we are starting with the positive element first, we will place the next positive element there which is 5 and move the positive_pointer ahead by 1 place and go to next iteration.
 *
 *
 *
 * Now we repeat same by finding the next positive and negative elements and continue the process ahead.
 *
 *
 *
 * Once the value of positive_pointer or negative_pointer becomes 10 (size of array), it means that no more positive or negative elements respectively are left. We will keep adding other elements available.
 *
 *
 *
 *
 *
 * Time Complexity:
 *
 * O(n)
 *
 * positive_pointer and negative_pointer iterate over each element in the array once. O(n) + O(n) -> O(n)
 *
 *
 *
 *
 *
 * Auxiliary Space Used:
 *
 * O(n)
 *
 * As we are using an array to store all the resultant elements.
 *
 *
 *
 *
 *
 * Space Complexity:
 *
 * O(n)
 *
 * As input is O(n) and auxiliary space used is O(n). O(n) + O(n) -> O(n)
 *
 *
 *
 *
 *
 * 2) other_solution.cpp
 *
 *
 *
 * Description:
 *
 *
 *
 * In this solution, wrong_index points to the element that shouldn’t be there, either a positive element is at an odd index or a negative element is at an even index. If a wrong_index is set, it is replaced with eligible current index whenever possible.
 *
 *
 *
 * Example:
 *
 *
 *
 * Let the input array be:
 *
 * 5 0 1 -3 4 -6 -8 3 2 -9
 *
 *
 *
 *
 *
 * Initially the value of wrong_index is -1. Then we run a loop for each element in the array.
 *
 *
 *
 * For each index, we check if the wrong_index is set and if it is set, we replace it with the next eligible element and push rest of the elements forward upto the index of current element and if wrong_index is not set, we just check if the current element is at wrong index.
 *
 *
 *
 * For index 0, wrong_index is not set (as wrong_index equals -1), we check if the element at index 0 is at a wrong position. Since, array[0] which is 5 is positive and expected at even index, we do nothing and simply move forward to analyse the rest of the array.
 *
 *
 *
 * For index 1, at an odd index we have 0, which is considered positive for this problem, we mark wrong_index as 1.
 *
 *
 *
 * Moving forward to index 2, since wrong_index is set (not equal to -1),  we check if the current element (at index 2) should be at wrong_index. The current element is positive and we are looking for a negative element for wrong_index (which is currently 1 and odd).
 *
 *
 *
 * Now at index 3, wrong_index is still set and array[3] is -3 which is a negative number. It is the one supposed to be at wrong index. So we right rotate the subarray from wrong_index (which is at 1) to the current index in the loop which is at 3.
 *
 *
 *
 * The rotated array becomes:
 *
 * 5 -3 0 1 4 -6 -8 3 2 -9
 *
 *
 *
 * After rotation, the element next to wrong_index would be at correct position given the fact that it should be of opposite sign already. So, the next candidate for wrong_index is 2 steps from its current value. That value is at wrong_index if the current index in the loop is more than 2 steps away as they all were of same sign and couldn’t replace the element at wrong_index. If the gap is not more than 2, we just move ahead, unset wrong_index and then check if the element at current_index is at wrong index and keep repeating this entire procedure for all the indexes in the array.
 *
 *
 *
 *
 *
 * Time Complexity:
 *
 * O(n^2)
 *
 * wrong_index continuously keep moving forward linearly. For each pair of wrong_index and right_index, the rotation takes the time proportional to the elements between the pair of indices. n such pairs and n time to rotate each pair in worst case.
 *
 *
 *
 *
 *
 * Auxiliary Space Used:
 *
 * O(1)
 *
 * As we are using constant space to rotate the array and store the variables and no extra space is used throughout. To solve this problem with constant auxiliary space, a minimum time complexity of O(n^2) is required.
 *
 *
 *
 *
 *
 * Space Complexity:
 *
 * O(n)
 *
 * As input is O(n) and auxiliary space used is O(1). O(n) + O(1) -> O(n)
 *
 * ﻿﻿﻿﻿﻿﻿
 *
 *
 *
 * Note:
 *
 * If we are asked to write solution with O(1) auxiliary space, then we need to write solution with time complexity O(n^2). We can not do better than O(n^2) time complexity, if only constant auxiliary space is allowed.
 */

public class AlternatePosNegNumbers {

  public static void main(String[] args) {
    int arr[] = {-1, -2};
    int[] result = alternating_positives_and_negatives(arr);
    System.out.println("Maximum contiguous sum is " + Arrays.toString(result));
  }

  //Not complete
//  private static int[] alternating_positives_and_negatives(int[] arr) {
//    int wrongIndex=-1;
//    for(int index=0;index<arr.length;index++){
//      if(wrongIndex != -1)
//      {
//
//      }
//      if(arr[index] >=0 && index%2 != 0 || arr[index] < 0 && index%2==0)
//        wrongIndex = 1;
//    }
//  }

  //This one is the easiest soln with O(n) ITme complexity and o(n) space complexity.
  //There is another soln with o(n^2) time complexity and O(1) space complexity
  private static int[] alternating_positives_and_negatives(int[] array) {
    int len = array.length;
    int[] result = new int[len];
    int positivePtr = 0;
    int negativePtr = 0;

    for (int i = 0; i < len; i++) {
      while (positivePtr < len && array[positivePtr] < 0)
        positivePtr++;
      while (negativePtr < len && array[negativePtr] >= 0)
        negativePtr++;
      if(positivePtr == len){
        result[i] = array[negativePtr];
        negativePtr++;
      }
      else if (negativePtr == len){
        result[i] = array[positivePtr];
        positivePtr++;
      }
      else {
        if (i % 2 == 0) {
          result[i] = array[positivePtr];
          positivePtr++;
        } else {
          result[i] = array[negativePtr];
          negativePtr++;
        }
      }
    }
    return result;
  }


}
