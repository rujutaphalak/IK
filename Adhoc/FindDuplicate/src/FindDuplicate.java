public class FindDuplicate {

  public static void main(String[] args)
  {
    int arr[] = {-1,-2};
    int n = arr.length;
    int max_sum = findDuplicate(arr);
    System.out.println("Maximum contiguous sum is " + max_sum);
  }


  //Many ways to do this
  //1. Brute force - loop through both the arrays ti find duplicate O(n^2)
  //2. Check if the element is in the set. If not then add. IF yes  then return the duplicate. O(N) Time O(N) space.
  //3. Sort the array and then do a linear scan to see which element is the same to the right. O(NlogN). Space O(1).
  // But the input is changed here. Interviewer may ask for a way where you cannot change the input by sorting.
  //4. Using invariants. - O(NlogN) space O(1) without modifying input
  //5.
  private static int findDuplicate(int[] arr){
  return 0;
  }
}
