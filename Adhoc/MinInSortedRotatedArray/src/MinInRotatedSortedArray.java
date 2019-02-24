/**
 * Minimum Element In A Sorted And Rotated Array
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * You are given a sorted array arr which is rotated by unknown pivot k. You need to find minimum element from given array using fastest possible way which uses only constant space.
 *
 *
 *
 * Input Format:
 *
 *
 *
 * Only argument for function, integer array named arr.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return integer which is minimum element in given array.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= n <= 10^5 where n is number elements in given array.
 *
 * Every element of array will be unique.
 *
 * For every element arr[i],
 *
 * -10^9 <= arr[i] <= 10^9 where 0 <= i <= (n-1)
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
 * arr = [ 4, 5, 6, 7, 8, 1, 2, 3]
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * 1
 *
 *
 *
 * Explanation:
 *
 *
 *
 * For given arr = [ 4, 5, 6, 7, 8, 1, 2, 3] which is sorted in ascending order and right rotated by pivot 5 has minimum value as 1 at index 5.
 */

/**
 * Ediotorial by IK
 * We have provided solutions which contain necessary comments to understand the approach used:
 *
 *
 *
 * 1) brute_force_solution.java
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n) where n is number of elements in array.
 *
 *
 *
 * This approach is very simple, We just need to iterate over the given array and maintain the minimum value found and return that minimum value which will be our answer.
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(1).
 *
 * As we are not storing anything.
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n).
 *
 * Input is O(n) because we are storing n elements of array and auxiliary space used is O(1). So, O(n) + O(1) -> O(n).
 *
 *
 *
 * 2) suboptimal_solution.java
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * Time complexity for the function find_minimum: O(log n) where n is number of elements in array.
 *
 * Time complexity for the complete program: O(n) where n is number of elements in array, because size of input is n.
 *
 *
 *
 * In this approach we used recursive binary search.
 *
 * If we take some examples and look closely, we would observe some patterns:
 *
 * If array was previously sorted in ascending order:
 *
 * The minimum element is the only element whose previous element is greater than it.
 * If we found any subarray ( from low to high ) which is ascending sorted then minimum element will be element at low.
 * Else minimum element lies in either left half or right half.
 * If middle element is greater than element at low, then the minimum element lies in right half.
 * Else minimum element lies in left half.
 *
 *
 * If array was previously sorted in descending order:
 *
 * We use these patterns to make solution:
 *
 * The minimum element is the only element whose next element is greater than it.
 * If we found any subarray ( from low to high ) which is descending sorted then minimum element will be element at high.
 * Else minimum element lies in either left half or right half.
 * If middle element is less than element at low, then the minimum element lies in right half.
 * Else minimum element lies in left half.
 *
 *
 * As the time complexity of binary search will be
 *
 * T(n) = T(n/2) + c ( Each iteration reducing array in half ).
 *
 *
 *
 * The above function can be solved either using recurrence Tree method or Master method. It falls in case II of Master Method and solution of the function is O(log n) hence, complexity of our solution (find_minimum function) is O(log n).
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(log n) where n is number of elements in array.
 *
 * Similarly by above logic for time complexity, number of recursive calls will be O(log n) and hence size of function stack used will be O(log n).
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n) where n is number of elements in array.
 *
 * Input is O(n) because we are storing n elements of array and auxiliary space used is O(1). So, O(n) + O(1) -> O(n).
 *
 *
 *
 * 3) optimal_solution.java
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * Time complexity for the function find_minimum: O(log n) where n is number of elements in array.
 *
 * Time complexity for the complete program: O(n) where n is number of elements in array, because size of input is n.
 *
 *
 *
 * Here we are using iterative approach of binary search. Explanation will same as mentioned above for suboptimal_solution.
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
 * As we are using only constant extra space.
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n) where n is number of elements in array.
 *
 * Input is O(n) because we are storing n elements of array and auxiliary space used is O(1). So, O(n) + O(1) -> O(n).
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinInRotatedSortedArray {

  public static void main(String[] args) {
//    int[] arr = new int[]{3,2,6,5,4};
    int[] arr = new int[]{4,5,6,2,3};
    int min = find_minimum(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    System.out.println(min);
  }

  public static int find_minimum(List<Integer> arr) {
    int size = arr.size();
    if (size == 1)
      return arr.get(0);
    if (size == 2)
      return Math.min(arr.get(0), arr.get(1));
    if (size == 3)
      return Math.min(arr.get(0), Math.min(arr.get(1), arr.get(2)));

    //If array is sorted in ascending order but with rotation 0. e.g 1,2,3,4,5
    if (arr.get(0) < arr.get(size - 1) && arr.get(0) < arr.get(1) && arr.get(size - 2) < arr
        .get(size - 1))
      return arr.get(0);


    //If array is sorted in descending order but with rotation 0. e.g 5,4,3,2,1. This a is needed here.
    // If not added this array will all under findMinimumAscending(arr) on line 28 instead off findMinimumDescending(arr)
    if (arr.get(0) > arr.get(size - 1) && arr.get(0) > arr.get(1) && arr.get(size - 2) > arr
        .get(size - 1))
      return arr.get(size - 1);

    if (arr.get(0) > arr.get(size - 1))
      return findMinimumAscending(arr);
    else
      return findMinimumDescending(arr);
  }

  //Try this with {4,5,6,2,3};
 private static int findMinimumAscending(List<Integer> arr) {
    int start = 0, end = arr.size() - 1;
    while (start <= end) {
      if (arr.get(start) <= arr.get(end)) {
        return arr.get(start);
      }
      int mid = start + (end - start) / 2;
      //Why is this >=
      if (arr.get(mid) >= arr.get(start))
        //Why is start=mid+1? why not start=mid
        start = mid + 1;
      else
        end = mid;
    }
    return -1;
  }

  //Try this {3,2,6,5,4}.
  private static int findMinimumDescending(List<Integer> arr) {
    int start = 0, end = arr.size() - 1;
    while (start <= end) {
      if (arr.get(start) == arr.get(end)) {
        return arr.get(end);
      }
      int mid = start + (end - start) / 2;
      //Why is this > and >= like above
      if (arr.get(start) > arr.get(mid))
        start = mid;
      else
        end = mid;
    }
    return -1;
  }
  //Because in above code stopping condition is start==end. we can also write the code as below
//  private static int findMinimumDescending(List<Integer> arr) {
//    int start = 0, end = arr.size() - 1;
//    while (start < end) {
//      int mid = start + (end - start) / 2;
//      //Why is this > and >= like above
//      if (arr.get(start) > arr.get(mid))
//        start = mid;
//      else
//        end = mid;
//    }
//    return arr.get(start);
//  }
}
