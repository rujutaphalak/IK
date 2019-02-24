import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.List;
import java.util.HashSet;


//Brute force is the obvious O(n^2) solution with space O(1)
//Solution1 is O(N) using auxillary space O(N)
//Solution2 is O(NlogN) with space O - sort and scan with two pointers starting and moving inwards.
public class TwoSum {

  public static void main(String[] args)
  {
    int arr[] = {1,2,3,5};
    int k=4;
    int[] list = twoSum(arr,k);
    for (int i=0;i<list.length;i++){
      System.out.println(list[i]);
    }
  }

  //Solution 1 - This returns the two numbers from the array that add up to target k.
  private static int[] twoSum(int[] arr, int k) {
    List<Integer> list = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    for (int i = 0; i < arr.length; i++) {
      if (set.contains(k - arr[i])) {
        list.add(arr[i]);
        list.add(k - arr[i]);
      }
      set.add(arr[i]);
    }
    int[] array = new int[list.size()];
    for (int i = 0; i < array.length; i++) {
      array[i] = list.get(i);
    }
    return array;
  }

  //This returns the indexes of the two complements.
//  public static int[] twoSum(int[] nums, int target) {
//    List<Integer> list = new ArrayList<>();
//    Map<Integer,Integer> map = new HashMap<>();
//
//    for(int i=0;i<nums.length;i++){
//      if(map.containsKey(target-nums[i])){
//        list.add(i);
//        list.add(map.get(target-nums[i]));
//      }
//      map.put(nums[i], i);
//    }
//    return list.stream().mapToInt(i -> i).toArray();
//  }
}

