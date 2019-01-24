public class TowersOfHanoi {

  public static void main(String[] args){
    towersOfHanoi(3, 'A', 'C', 'B');
  }

  private static void towersOfHanoi(int n, char from, char to, char aux) {
    if (n==1){
      System.out.println("Move disk 1 from source " + from + " to destination " + to);
      return;
    }

//    System.out.println("Recursion 1");
    towersOfHanoi(n-1,from, aux, to);
    System.out.println("Move disk " + n + " from source " + from + " to destination " + to);

//    System.out.println("Recursion 2");
    towersOfHanoi(n-1, aux, to, from);
  }

}
