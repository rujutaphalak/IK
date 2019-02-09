public class CountWaysToReachNthStairMemoization {

  //Not working
  public static void main(String[] args) {
    int n=11;
    int[] steps = {1,2,5};
    int[] memo = new int[n+1];
    memo[0] = 1;
    int numSteps = countWaysToReachNthStairMemoization(steps, n, memo);
    System.out.println(numSteps);
  }

  private static int countWaysToReachNthStairMemoization(int[] steps, int n, int[] memo) {

    if(n==0)
      return memo[0];

    for(int i=0; i<steps.length; i++){
      if(n>=steps[i]) {
        //In recursive steps this actually updates the array. When unwinding, the values at hte position are added using memo[n]+=
        memo[n]+= countWaysToReachNthStairMemoization(steps, n - steps[i], memo);
      }
    }
    return memo[n];
  }
}
