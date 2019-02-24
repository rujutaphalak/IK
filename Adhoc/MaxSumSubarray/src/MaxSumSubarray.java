//https://www.geeksforgeeks.org/maximum-subarray-sum-using-divide-and-conquer-algorithm/
public class MaxSumSubarray {

  public static void main(String[] args)
  {
//    int arr[] = {2, 3, 4, 5, 7};
      int arr[] = {-1,-2};
      int n = arr.length;
      int max_sum = maxSubArraySum(arr);
      System.out.println("Maximum contiguous sum is " + max_sum);
  }

//Time complexity NlogN

//  private static int maxSubArraySum(int[] arr, int start, int end) {
//    if(start == end)
//      return arr[start];
//
//    int mid = (start + end)/2;
//
//    int sum1 = maxSubArraySum(arr, start, mid); //logn
//    int sum2 = maxSubArraySum(arr, mid+1, end); //logn
//    int sum3 = maxCrossingSum(arr, start, mid, end); //O(n)
//
//    return Math.max(Math.max(sum1,sum2),sum3);
//
//  }
//
//  private static int maxCrossingSum(int[] arr, int start, int mid, int end) {
//    int leftSum =Integer.MIN_VALUE, rightSum=Integer.MIN_VALUE;
//    int sum=0;
//    for(int i =mid; i>=start; i--){
//      sum+=arr[i];
//      if(sum>leftSum){
//        leftSum= sum;
//      }
//    }
//
//    //Do not forget to reset sum to 0. Otherwise the rightSum will be wrong.
//    sum=0;
//    for(int i =mid+1; i<=end; i++){
//      sum+=arr[i];
//      if(sum>rightSum){
//        rightSum= sum;
//      }
//    }
//    return leftSum+rightSum;
//  }


  //Kadane's algorithm
  /* Idea is to move a pointer from left to right, drop/reset cumulative value to 0 if it falls below 0.
   * This is true for only non negative array numbers.
   */

  private static int maxSubArraySum(int[] arr) {
    int max_sum=Integer.MIN_VALUE, cum_sum=0;
    for(int i=0;i<arr.length; i++){
      cum_sum+=arr[i];
      //This needs to be the second step
      if(cum_sum<0) {
        cum_sum = 0;
      }

      if(cum_sum>max_sum) {
        max_sum = cum_sum;
      }
    }
    return max_sum;
  }

  /*
   * This takes care of arrays with negative numbers
   */
//  private static int maxSubArraySum(int[] arr) {
//    int max_sum=Integer.MIN_VALUE, cum_sum=0;
//    for(int i=0;i<arr.length; i++){
//      cum_sum+=arr[i];
//      if(cum_sum>max_sum) {
//        max_sum = cum_sum;
//      }
//      if(cum_sum<0) {
//        cum_sum = 0;
//      }
//    }
//    return max_sum;
//  }

}
