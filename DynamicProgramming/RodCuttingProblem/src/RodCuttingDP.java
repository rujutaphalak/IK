public class RodCuttingDP {

  public static void main(String[] args) {
    int[] p = {0,1,3,8,6,10,9};
    int len = 6;
    int maxProfit = maxPriceDP(len,p);
    System.out.println("MaxProfit----------- " + maxProfit);
  }

  private static int maxPriceDP(int len, int[] p) {
    int[] dpTable = new int[len+1];
    dpTable[0]=0;

    dpTable[len]= p[len];
    for(int subLen=1; subLen<=len;subLen++){
      dpTable[subLen] += Math.max(dpTable[subLen], p[subLen] + dpTable[len-subLen]);
    }

    return dpTable[len];
  }
}
