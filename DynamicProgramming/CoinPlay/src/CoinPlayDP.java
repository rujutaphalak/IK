public class CoinPlayDP {

  //to be continued not working dp solution yet
  public static void main(String[] args){
    int[] v = {8,15,3,7};
    int maxProfit = maxWin(v);
    System.out.println(maxProfit);
  }

  public static int maxWin(int[] v){
    int len = v.length;
    int[][] memo = new int[len][len];
    for(int i=0;i<memo.length;i++){
      for(int j=0;j<memo.length;j++) {
        if (i==j)
          memo[i][j] = v[i];
      }
    }
    return maxWin(v,0,len-1, memo);
  }

  private static int maxWin(int[] v, int first, int last, int[][] memo) {

    if(memo[first][last] != 0)
      return memo[first][last];

    if(first == last)
      return memo[first][last] = v[first];

    if(last == first + 1)
      return memo[first][last] = Math.max(v[first], v[last]);

    int opt1 = v[first] + Math.min(maxWin(v,first+2, last, memo),maxWin(v,first+1, last-1, memo));
    int opt2 = v[last] + Math.min(maxWin(v,first+1, last-1, memo),maxWin(v,first, last-2, memo));

    return memo[first][last]= Math.max(opt1,opt2);
  }
}
