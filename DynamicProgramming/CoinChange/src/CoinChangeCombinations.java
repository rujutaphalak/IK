import sun.awt.image.IntegerComponentRaster;

public class CoinChangeCombinations {
  public static void main(String[] args){
    int[] d = {2,3,5};
    int c = 8;
    int numCoins = combinations(c,d);
    System.out.println(numCoins);
  }

  public static int combinations(int c, int[] d){
    return combos(c,d);
  }
//
//  private static int combos(int c, int[] d,int currentCoin){
//    //base cases
//
//    if(c == 0) return 1;
//    if(c < 0) return 0;
//
//    int count=0;
//    for(int coin = currentCoin; coin< d.length; coin++){
//      count+=combos(c-d[coin],d,coin);
//    }
//
//    return count;
//  }


  private static int combos(int c, int[] d){
    //base cases

    if(c == 0) return 1;
    if(c < 0) return 0;

    int count=0;
    for(int coin = 0; coin< d.length; coin++){
      count+=combos(c-d[coin],d);
    }

    return count;
  }

}
