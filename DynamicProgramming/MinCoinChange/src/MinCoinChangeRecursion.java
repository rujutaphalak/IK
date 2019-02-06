public class MinCoinChangeRecursion {

  private static int[] coins = {1,2,3};

  public static void main(String[] args) {
    int amount=5;
    int numCoins = coinChangeMain(amount);

    System.out.println(numCoins);
  }
//----------------------GEEKS for GEEKs------------------------//
  private static int coinChangeMain(int amount) {
    int numCoins = coinChange(amount);
    if(numCoins == Integer.MAX_VALUE)
      return -1;
    else return numCoins;
  }

  private static int coinChange(int amount) {
    if (amount == 0)
      return 0;

    int minCoins = Integer.MAX_VALUE;

    for (int i = 0; i < coins.length; i++) {
      if(coins[i] <=amount) {
        int numCoins = coinChange(amount - coins[i]);
        if (numCoins != Integer.MAX_VALUE && numCoins+1<minCoins)
          minCoins=numCoins+1;
      }
    }
    return minCoins;
  }
//  //----------------------GEEKS for GEEKs------------------------//


  //-----------------------Using INT_MAX--------------------//
//  private static int coinChangeMain(int amount) {
//    int numCoins = coinChange(amount);
//    if(numCoins == Integer.MAX_VALUE)
//      return -1;
//    else return numCoins;
//  }
//
//  private static int coinChange(int amount) {
//    if (amount == 0)
//      return 0;
//    if (amount < 0)
//      return Integer.MAX_VALUE;
//
//    int minCoins = Integer.MAX_VALUE;
//
//    for (int i = 0; i < coins.length; i++) {
//      int numCoins = coinChange(amount - coins[i]);
//      if(numCoins != Integer.MAX_VALUE)
//        numCoins+=1;
//      minCoins = Math.min(minCoins, numCoins);
//    }
//    return minCoins;
//  }

//  private static int coinChange(int amount) {
//    if (amount == 0)
//      return 0;
//    if (amount < 0)
//      return Integer.MAX_VALUE;
//
//    int minCoins = Integer.MAX_VALUE;
//
//    for (int i = 0; i < coins.length; i++) {
//      int numCoins = coinChange(amount - coins[i]);
//      minCoins = Math.min(minCoins, numCoins);
//    }
//    return minCoins==Integer.MAX_VALUE?Integer.MAX_VALUE:minCoins+1;
//  }
  //-----------------------Using INT_MAX--------------------//

  //-----------------------Using -1 instead of INT_MAX--------------------//
  //this kind of works on leet code with time limit exceeded.
//  private static int coinChange(int amount) {
//    if (amount == 0) return 0;
//    if(amount < 0) return -1;
//
//    int minCoins = -1;
//
//    for (int i = 0; i < coins.length; i++) {
//        int numCoins = coinChange(amount - coins[i]);
//
//        if (numCoins >= 0)
//          minCoins = minCoins<0?numCoins:Math.min(minCoins,numCoins);
//      }
//    return minCoins<0?-1:minCoins+1;
//  }
  //-----------------------Using -1 instead of INT_MAX--------------------//

  //Found the below solution online.
//  private static int coinChange(int[] coins, int amount) {
//      if (amount == 0) return 0;
//      if (amount <  0) return -1;
//
//      int min = -1;
//      for (int coin : coins) {
//        int currentMin = coinChange(coins, amount - coin);
//
//    // if amount is less than coin value
//      if (currentMin >= 0) {
//       min = min < 0 ? currentMin : Math.min(currentMin, min);
//    }
//  }
//    return min < 0 ? -1 : min + 1;
//  }
}
