public class MinCoinChangeDP {

  private static int[] coins = {1,2,3};

  public static void main(String[] args) {
    int amount=5;
    int numCoins = coinChangeDP(amount);

    System.out.println(numCoins);
  }

  private static int coinChangeDP(int amount) {
    int numCoins = coinChange(amount);
    if(numCoins == Integer.MAX_VALUE)
      return -1;
    else return numCoins;
  }

  private static int coinChange(int amount) {
    int[] dpTable = new int[amount + 1];
    dpTable[0] = 0;

    for (int i = 1; i <= amount; i++) {
      int minCoins = Integer.MAX_VALUE;
      for (int d=0; d<coins.length; d++) {
        if (coins[d] <= i) {
          int numCoins = dpTable[i-coins[d]];
          if (numCoins != Integer.MAX_VALUE && numCoins+1<minCoins)
            minCoins=numCoins+1;
        }
        dpTable[i] = minCoins;
      }
    }
    return dpTable[amount];
  }
}
