public class RobberyDP {

  public static void main(String[] args){
    int[] values = {6,1,3,7};
    int stolen = maxStolenValue(values);
    System.out.println(stolen);
  }
  static int maxStolenValue(int[] values) {

    if(values.length == 0)
      return 0;
    if(values.length == 1)
      return values[0];
    if(values.length == 2)
      return Math.max(values[0], values[1]);

    int[] dpTable = new int[values.length];
    dpTable[0] = values[0];
    dpTable[1] = Math.max(values[0],values[1]);

    for(int i=2;i<values.length;i++){

      //Skip the current house
      int opt1 = dpTable[i-1];
      //Starting backwards we steal from ith house and the (i-2)nd house
      int opt2 = values[i] + dpTable[i-2];

      dpTable[i] = Math.max(opt1,opt2);
    }

    return dpTable[dpTable.length-1];
  }
}
