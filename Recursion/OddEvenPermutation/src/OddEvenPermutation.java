import java.util.Arrays;

//Working
//Out oust should be {1,2,3,4}, {3,2,1,4}, {1,4,3,2},{3,4,1,2}
class OddEvenPermutation {
    public static void main(String[] args) {

        System.out.println("Hello Codiva");
        char[] arr = {'4','2','3','1'};
        permutation(arr);

    }
    public static void permutation(char[] arr){

        permute(arr,0);
    }

    private static void permute(char[] arr, int startIndex){

        if(startIndex == arr.length-1) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int anchor=startIndex; anchor<arr.length;anchor++){
            if(ValueOkAtPosition(arr,arr[anchor],startIndex)){
                swap(arr,anchor,startIndex);
                permute(arr,startIndex+1);
                swap(arr,anchor,startIndex);
            }

        }
    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }

    //if value at anchor is even, then startIndex should be odd because anchor and startIndex are always right next to each other.
    //As anchor is the variable each time we have to check for anchor value with start Index
    private static boolean ValueOkAtPosition(char[] arr, int anchorValue, int startIndex){
        if ( (startIndex % 2 == 0 && anchorValue % 2 == 1) || (startIndex % 2 == 1 && anchorValue % 2 == 0) )
            return true;
        return false;
    }
}
