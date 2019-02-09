public class CountWaysToReachNthStairDP {

  public static void main(String[] args) {
    int n=11;
    int[] steps = {1,2,5};
    long numSteps = countWaysToReachNthStairDP(steps, n);
    System.out.println(numSteps);
  }

  private static long countWaysToReachNthStairDP(int[] steps, int n) {
    long[] dpTable = new long[n+1];
    dpTable[0] = 1;

    for(int i=1; i<=n; i++){
      for(int step:steps){
          int previousStep = i-step;
          if(previousStep>=0)
            dpTable[i]+= dpTable[i-step];
      }
    }
    return dpTable[n];
  }
}
