import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

  public static void main(String[] args)
  { int arr[] = {0,1,2,3,4,5};
    int k=8;
    List<List<Integer>> result = threeSum(arr,k);
    for(int i =0;i<result.size();i++){
      System.out.println(result.get(i).toString());
    }
  }
//
//  private static void threeSum(int[] arr, int target) {
//    Arrays.sort(arr);
//
//    for (int i = 0; i < arr.length-2; i++) {
//      int j = i+1, k =arr.length-1;
//      int sum = arr[i] + arr[j] + arr[k];
//      if(sum == target)
//        System.out.println(arr[i]+","+arr[j]+","+arr[k]);
//      if(sum < target){
//        j++;
//      }
//      else {
//        k--;
//      }
//    }
//  }

  //Time complexity O(N^2)- nlogn for sorting but for each i, we have to do a two sum linearly, hence O(n^2)
  //This does not filter duplicate though, that is still an issue.
    private static List<List<Integer>> threeSum(int[] arr, int target) {
      List<List<Integer>> result = new ArrayList<>();
      if (arr.length < 3)
        return new ArrayList<>();

      Arrays.sort(arr);

      for (int i = 0; i < arr.length - 2; i++) {
        int j = i + 1, k = arr.length - 1;
        while (j < k) {
          int sum = arr[i] + arr[j] + arr[k];
          if (sum == target) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[j]);
            list.add(arr[k]);
            result.add(list);
            k--;
          } else if (sum < target) {
            j++;
          } else {
            k--;
          }
        }
      }
      return result;
    }
}
