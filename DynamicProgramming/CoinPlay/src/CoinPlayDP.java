public class CoinPlayDP {

  //to be continued not working dp solution yet
  public static void main(String[] args){
    int[] v = {8,15,3,7};
    int maxProfit = maxWin(v);
    System.out.println(maxProfit);
  }

  public static int maxWin(int[] v){
    int len = v.length;
    int[][] dpTable = new int[len][len];
    for(int i=0;i<dpTable.length-1;i++){
          dpTable[i][i] = v[i];
          dpTable[i][i+1] = Math.max(v[i],v[i+1]);
    }
//    for(int i=0;i<len-1;i++){
//      dpTable[i][len-1] = 0;
//    }
//    for(int i=0;i<len-1;i++){
//      dpTable[len-1][i] = 0;
//    }
    return maxWin(v,dpTable);
  }

  private static int maxWin(int[] v, int[][] dpTable) {

    for(int row=dpTable.length-1; row>=0;row++){
      for(int col=dpTable.length-1;col>=0;col++){
        int opt1 = v[row] + Math.min(dpTable[row+2][col],dpTable[row+1][col-1]);
        int opt2 = v[col] + Math.min(dpTable[row+1][col-1],dpTable[row][col-2]);
        dpTable[row][col] = Math.max(opt1,opt2);
      }
    }
    return dpTable[0][0];
  }
}
