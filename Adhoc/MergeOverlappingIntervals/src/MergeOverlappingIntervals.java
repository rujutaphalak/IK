/**
 * Merge Overlapping Intervals
 *
 *
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given an array of time intervals(in any order) inputArray, of size n, merge all overlapping intervals into one and return the resulting array outputArray, such that no two intervals in outputArray are overlapping. In other words, result array should contain only mutually exclusive intervals. Hence, in outputArray, no pair of intervals i and j exists, such that
 *
 * outputArray[i][0] <= outputArray[j][0] <= outputArray[i][1].
 *
 *
 *
 * (In this problem, you should consider all the intervals as closed intervals. i.e. endpoints of intervals are inclusive.)
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
 * There is only one argument: inputArray, denoting input array of time intervals, where inputArray is 2D array of n*2 size, denoting inputArray[i][0] as start point of ith interval, and inputArray[i][1] as end point of ith interval.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an array of time intervals outputArray, denoting the required array of merged time intervals, where outputArray is 2D array of len*2 size, denoting outputArray[i][0] as start point of ith interval, and outputArray[i][1] as end point of ith interval.
 *
 * (Order of intervals in outputArray doesn't matter.)
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
 * First line should contain a number n, denoting number of intervals in inputArray. Next line should contain 2, unconditionally, as inputArray is 2D array of n*2. In next n lines, ith line should contain two space separated numbers starti and endi, denoting start point and end point of ith interval respectively.
 *
 *
 *
 * If n = 4, inputArray = [[1, 3], [5, 7], [2, 4], [6, 8]], then input should be:
 *
 *
 *
 * 4
 *
 * 2
 *
 * 1 3
 *
 * 5 7
 *
 * 2 4
 *
 * 6 8
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Let say len*2 is the size of resultant 2D array outputArray. Then, there will be len lines, where ith line contains two space separated integers starti and endi, denoting start point and end point of ith interval in outputArray respectively.
 *
 *
 *
 * For input n = 4, inputArray = [[1, 3], [5, 7], [2, 4], [6, 8]], output will be:
 *
 *
 *
 * 1 4
 *
 * 5 8
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= n <= 10^5
 * -10^9 <= inputArray[i][0] <= inputArray[i][1] <= 10^9,   i=0, 1, ..., (n-1)
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
 * 4
 *
 * 2
 *
 * 1 3
 *
 * 5 7
 *
 * 2 4
 *
 * 6 8
 *
 *
 *
 * Sample Output 1:
 *
 *
 *
 * 1 4
 *
 * 5 8
 *
 *
 *
 * Explanation 1:
 *
 *
 *
 * The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1,4}.
 *
 * Similarly {5,7} and {6,8} should be merged and become {5,8}.
 *
 *
 *
 * Sample Input 2:
 *
 *
 *
 * 7
 *
 * 2
 *
 * 100 154
 *
 * 13 47
 *
 * 1 5
 *
 * 2 9
 *
 * 7 11
 *
 * 51 51
 *
 * 47 50
 *
 *
 *
 * Sample Output 2:
 *
 *
 *
 * 1 11
 *
 * 13 50
 *
 * 51 51
 *
 * 100 154
 *
 *
 *
 * Explanation 2:
 *
 *
 *
 * The intervals {1,5} and {2,9} overlap with each other, so they should be merged and become {1,9}.
 *
 * Also, {1,9} and {7,11} overlap with each other, so they should be merged and become {1,11}
 *
 * Similarly, The intervals {13,47} and {47,50} should be merged and become {13,50}.
 *
 * Intervals {51,51} and {100,154} are kept as it is as they are not overlapping with any other intervals.
 *
 *
 *
 * Suggestions:
 *
 *
 *
 * Suggested time in interview: 20 minutes.
 *
 * The “Suggested Time” is the time expected to complete this question during a real-life interview, not now in homework i.e. For the first attempt of a given homework problem, the focus should be to understand what the problem is asking, what approach you are using, coding it, as well as identifying any gaps that you can discuss during a TA session. Take your time, but limit yourself to 2 one hour sessions for most problems.
 */

import java.util.Arrays;
import java.util.Comparator;

/**
 * Editorial by IK
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
 * A naive approach would be that iterating over inputArray,
 *
 * For 0<=i<=n-1, Check if inputArray[i] is a removed interval.
 *
 * If it’s a removed interval continue.
 * If it's not a removed interval, compare inputArray[i] with all other intervals for overlapping. Let say it overlaps with interval inputArray[k], then remove inputArray[k] from array and merge it into the inputArray[i].
 *
 *
 * For removing an interval from array, one way is to make the interval invalid (i.e. start>end), so that later we can
 *
 * check if it is removed or not. See implementation for better understanding.
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n*n) where n is length of inputArray.
 *
 *
 *
 * As we have to iterate entire input interval array for each interval, time complexity will be O(n*n).
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
 * Here, all updation can be done in inputArray only. So, no extra space is used.
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n) where n is length of inputArray.
 *
 *
 *
 * For inputArray, it takes O(n) and auxiliary space used is O(1). So, O(n) + O(1) → O(n).
 *
 *
 *
 * 2) other_solution.java
 *
 *
 *
 * Description:
 *
 *
 *
 * An efficient approach would be as follows:
 *
 * Sort the interval array in increasing order of start point. Once we have sorted intervals, we can combine all intervals in a linear traversal.
 *
 * Following is the detailed step by step algorithm.
 *
 * Sort the intervals based on increasing order of starting time.
 * Push the first interval on to a stack.
 * For each interval do the following
 * If the current interval does not overlap with the stack top, push it.
 * If the current interval overlaps with stack top and ending time of current interval is more than that of stack top, update stack top with the ending  time of current interval.
 * At the end stack contains the merged intervals.
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n*log(n)) where n is length of inputArray.
 *
 *
 *
 * As we have to sort the interval array, followed by linear traversal, time complexity will be
 *
 * O(n*log(n)) + O(n) → O(n*log(n)).
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(n) where n is length of inputArray.
 *
 *
 *
 * Here we have used Stack. So, extra space is used other than that of inputArray. So, auxiliary space used is O(n). (Here we are ignoring auxiliary space used by inbuilt sort function for sorting n elements of inputArray because it is language specific like in java, it will take O(1) but in python it will take O(n)).
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n) where n is length of inputArray.
 *
 *
 *
 * For inputArray, it takes O(n) and auxiliary space used is O(n). So, O(n) + O(n) → O(n).
 *
 *
 *
 * 3) optimal_solution.java
 *
 *
 *
 * Description:
 *
 *
 *
 * Auxiliary space used in above approach is O(n). It can be reduced.
 *
 * The idea remains same as discussed in previous approach. Sort the interval array in increasing order of starting point.
 *
 * Once you have sorted intervals, you can combine all intervals in a linear traversal.
 *
 * Following is the detailed step by step algorithm:
 *
 * Let last be the last interval of non overlapping intervals. last=0.
 *
 * Iterating over inputArray, starting from second interval (1<=i<=n-1)
 *
 * Check if inputArray[i] is overlapping with inputArray[last]
 * If overlapping, merge inputArray[i] and inputArray[last], For merging them, it is sufficient to update only endpoint of inputArray[last] as it is guaranteed that starting point of inputArray[last] <= starting point of inputArray[i][0] as array is sorted by starting point.
 * If non overlapping, we increment last and moving on, inputArray[i] is the new interval under test of overlapping with following intervals.
 * repeat step 1 for i=i+1.
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n*log(n)) where n is length of inputArray.
 *
 *
 *
 * As we have to sort the interval array, followed by linear traversal, time complexity will be
 *
 * O(n*log(n)) + O(n) → O(n*log(n)).
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
 * Here, all updation can be done in inputArray only. So, no extra space is used. (Here we are ignoring auxiliary space used by inbuilt sort function for sorting n elements of inputArray because it is language specific like in java, it will take O(1) but in python it will take O(n)).
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n) where n is length of inputArray.
 *
 *
 *
 * For inputArray, it takes O(n) and auxiliary space used is O(1). So, O(n) + O(1) → O(n).
 */
public class MergeOverlappingIntervals {

  public static void main(String[] args)
  {
    int arr[][] = {{1, 3}, {5,7}, {2, 4}, {6, 8}};
    int result[][] = mergeIntervals(arr);
    for(int[] e: result)
      System.out.println(Arrays.toString(e));
  }

  private static int[][] mergeIntervals(int[][] arr) {
    Arrays.sort(arr, (int[] o1, int[] o2)-> {
        if(o1[0] != o2[0])
          return o1[0]-o2[0];
        return o1[1]-o2[1];
      });

    int prev =0;
    for(int i=1;i<arr.length;i++){
      if(arr[prev][1] >= arr[i][0])
      {
        arr[prev][1] = Math.max(arr[prev][1], arr[i][1]);
      }
      else{
        prev++;
        arr[prev] = arr[i];
      }
    }
    return Arrays.copyOfRange(arr, 0, prev+1);
  }

}
