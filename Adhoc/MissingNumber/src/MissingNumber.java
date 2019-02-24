public class MissingNumber {
  
  //Method 1 is to find the total using n(n+1)/2. This gives total from 1...n.
  // Then in O(n) time I can loop through all the elements in the array to find its sum. 
  // The n*n(n+1)/2 - (sum of the array = the missing number.

  //Method 2: Using XOR. XOR two same number is 0. 0^0 =0, 1^1=0, 1^0=1, 0^1=1.

  public static void main(String[] args)
  {
    int arr[] = {1,3,4,5};
    int n = arr.length;
    int max_sum = missingNumber(arr);
    System.out.println("Maximum contiguous sum is " + max_sum);
  }

  private static int missingNumber(int[] arr) {
    
  }


}
