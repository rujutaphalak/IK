import java.util.Arrays;

public class MergeArr1ToArr2 {
    public static void main(String[] args){
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2,4, 6, 0, 0, 0};
        merger_first_into_second(arr1,arr2);
        System.out.println(Arrays.toString(arr2));
    }

    static int[] merger_first_into_second(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 =arr2.length;

        int k=length2-1;
        int j = length2-1;
        while(arr2[j] == 0){
            j--;
        }

        for(int x=length1-1;x>=0;x--) {
            for(int y=j-1;y>=0;y--) {
                if(arr1[x] > arr2[y]){
                    arr2[k--] = arr1[x];
                }
                else{
                    arr2[k--] = arr2[y];
                }
            }

        }
        return arr2;
    }
}
