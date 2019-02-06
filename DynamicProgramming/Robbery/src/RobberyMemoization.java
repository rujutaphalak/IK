public class RobberyMemoization {
  public static void main(String[] args){
    int[] values = {6,1,4,7};
    int[] memo = new int[values.length];
    for(int i=0;i<memo.length;i++)
      memo[i]=-1;
    int stolen = maxStolenValue(values,0,memo);
    System.out.println(stolen);
  }

  static int maxStolenValue(int[] values, int i,int[] memo) {
    if(i>=values.length)
      return 0;
    if(memo[i] != -1)
      return  memo[i];

    int opt1 = maxStolenValue(values,i+1,memo);
    int opt2 = values[i] + maxStolenValue(values,i+2,memo);

    memo[i]=Math.max(opt1, opt2);
    return memo[i];
  }
}
