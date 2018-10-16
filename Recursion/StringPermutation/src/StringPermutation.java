import java.util.Arrays;

//Working
//Find permutations of the string
class StringPermutation {
    public static void main(String[] args) {

        System.out.println("Hello Codiva");
        char[] arr = {'a','b','c','d'};
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
            swap(arr,anchor,startIndex);
            permute(arr,startIndex+1);
            swap(arr,anchor,startIndex);
        }
    }

    private static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }
}


