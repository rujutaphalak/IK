/**
 * Implement a power function to raise a double to an int power, including negative powers.
 *
 *
 *
 * e.g. pow(double d, int p) should give 'd' raised to power 'p'.
 *
 *
 *
 * Of course, please don't use in-built methods like pow(). Idea is to implement that using recursion.
 *
 *
 *
 * Note:
 *
 *
 *
 * This problem is under development according to IK standards. If you'd like to contribute, then please feel free to email soham@interviewkickstart.com
 *
 *
 *
 * Till we finish developing this problem, you can look at:
 *
 * https://leetcode.com/problems/powx-n/
 *
 * http://stackoverflow.com/questions/101439/the-most-efficient-way-to-implement-an-integer-based-power-function-powint-int
 */
//Some issue with negative power that has the power value of -2147483647.
public class DoublePower {

  public static void main(String[] args) {

    float dblbase = (float) 1.1;
    int ipower = 3;
    float ans = pow(dblbase, ipower);
    System.out.println("ans is " + ans);
  }
  private static float pow(float dblbase, int ipower) {
    if(ipower<0)
      return 1/powRecursion(dblbase,(-ipower));
    else
      return powRecursion(dblbase, ipower);
  }

  private static float powRecursion(float dblbase, int ipower) {
    if(ipower==0)
      return 1;
    if(ipower==1)
      return dblbase;
    return ipower%2==0?powRecursion(dblbase*dblbase,ipower/2):dblbase*powRecursion(dblbase,ipower-1);
  }
}
