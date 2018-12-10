public class RodCuttingProblem {

  public static int[] DP = new int[7];

  public static void main(String[] args){
    int[] p = {0,2,3,4};
    int len = 3;
//    int maxProfit = maxPriceMainRec(len,p);
    int maxProfit = maxPriceMainMemoization(len,p);
    System.out.println("MaxProfit----------- " + maxProfit);
  }

  public static int maxPriceMainRec(int len, int[] p) {
    return maxPriceRec(len, p,0);
  }

  private static int maxPriceRec(int len, int[] p, int count) {
    count++;

    if(len==0)
      return 0;

    int maxResult = Integer.MIN_VALUE;

    System.out.println("Recursion stack level " + count + ". Initialized MaxResult for rod length " + len + " is $" + maxResult);
    for(int l = 1; l <= len; l++){
      System.out.println("Rod len " + len);
      System.out.println(" l = " + l);
      maxResult = Math.max(maxResult, p[l]+maxPriceRec(len-l,p,count));
      System.out.println("MaxResult so far at level " + count + " is $" + maxResult);
      System.out.println("unfolding recursion level " + count);
    }
    count--;
    System.out.println("Returning maxResult $" + maxResult);
    return maxResult;
  }


  public static int maxPriceMainMemoization(int len, int[] p) {
    initializeDP();
    return maxPriceMemoization(len, p);
  }

  private static void initializeDP() {
    for(int i=0;i<DP.length;i++)
      DP[i]=-1;
  }

  private static int maxPriceMemoization(int len, int[] p){
    int maxResult;
    int result;

    if(len==0)
      return 0;
    for(int l = 1; l <= len; l++){
      if(DP[len-l] != -1)
        result = DP[len];
      maxResult = Math.max( )
  }
}
