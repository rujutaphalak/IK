public class NonEmptySubsetSum {

    public static void main(String []args){
        long[] arr = {1,-50};
        int k = 5;
        if(check_if_sum_possible(arr,k))
            System.out.println("Found a subset with target");
        else
            System.out.println("Did not find a subset with target");
    }

    public static boolean check_if_sum_possible(long[] arr, long k) {
        return check_sum_rec(arr,0,k,false);
    }

    /* We can keep a count at each subset, but that solution has a problem
      when negative numbers come into picture because the sum can change
      with negative numbers.
    */
    private static boolean check_sum_rec(long[] arr, int i, long difference, boolean notEmpty){

        if(difference == 0 && notEmpty == true)
            return true;

        if(i == arr.length)
            return false;

        return check_sum_rec(arr, i+1, difference, notEmpty) || check_sum_rec(arr, i+1, difference-arr[i],true);
    }
}
