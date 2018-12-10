public class MinCoinChange {

  public static void main(String[] args){
    int[] d = {1,2};
    int c = 4;
    int numCoins = minCoinsMain(c,d);
    System.out.println(numCoins);
  }

  public static int minCoinsMain(int c,int[] d){
    return minCoins(c,d,0);
  }

  private static int minCoins(int c, int[] d, int currentCoin){
    if (c == 0) return 0;
    if(c < 0) return 1000;

//    for(int coin=0; coin<d.length; coin++){
//      1+Math.min(minCoins(c-d[coin],d,coin));
//    }
    return 0;
  }
}
