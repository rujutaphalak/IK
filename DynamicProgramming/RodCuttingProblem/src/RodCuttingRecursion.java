public class RodCuttingRecursion {

  public static int[] DP = new int[7];

  public static void main(String[] args) {
    int[] p = {0,1,3,8,6,10,9};
    int len = 6;
    int maxProfit = maxPriceMainRec(len,p);
    System.out.println("MaxProfit----------- " + maxProfit);
  }

  public static int maxPriceMainRec(int len, int[] p) {
    return maxPriceRec(len, p);
  }

  private static int maxPriceRec(int len, int[] p) {

    if (len==0) return 0;

    int maxPrice = p[len];
    for(int subLen=1; subLen<=len;subLen++){
      maxPrice = Math.max(maxPrice, p[subLen] + maxPriceRec(len-subLen,p));
    }

    return maxPrice;
  }
}