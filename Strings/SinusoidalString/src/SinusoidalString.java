/**
 * Print A String Sinusoidally
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * [This is just a stupid problem, that has no relation to anything else. It's there primarily because we see it on and off. It's a string puzzle disguised as a programming problem]
 *
 *
 *
 * Also called "SnakeString". For example, the phrase "Google Worked" should be printed as follows (where ~ is the word separator):
 *
 *
 *
 *     o     ~         k
 *
 *   o  g  e  W   r   e
 *
 * G     l        o       d
 *
 *
 *
 * Input format:
 *
 *
 *
 * There is only one argument named s denoting the input string.
 *
 *
 *
 * Output format:
 *
 *
 *
 * Print the string in sinusoidally. Format is:
 *
 * → There will be 3 rows
 *
 * → Print ~ for spaces
 *
 * → First character is printed in 1st column of 3rd row
 *
 * → Second character is printed in 2nd column of 2nd row
 *
 * → Third character is printed in 3rd column of 1st row
 *
 * → Fourth character is printed in 4th column of 2nd row
 *
 * → Fifth character is printed in 5th column of 3rd row
 *
 * → Sixth character is printed in 6th column of 2nd row
 *
 * → This process goes on…
 *
 *
 *
 * Constraints:
 *
 * String consists of alphanumeric characters and spaces
 * 3 <= length_of_input_string <= 10000
 *
 *
 * Sample Test Case:
 *
 *
 *
 * Sample Input:
 *
 *
 *
 * Google Worked
 *
 *
 *
 * Sample Output:
 *
 *
 *
 *     o     ~         k
 *
 *   o  g  e  W   r   e
 *
 * G     l        o       d
 */

/**
 * Editorial by IK
 *
 * We have provided only optimal solution for this problem. There are few observations:
 *
 * → i’th character of input string is placed in i’th column of a row.
 *
 * → 0th index character of string is placed in 3rd row. Then 4th, 8th and go on.
 *
 * → 1st index character of string is placed in 2nd row. Then 3rd, 5th and go on.
 *
 * → 2nd index character of string is placed in 1st row. Then 6th, 10th and go on.
 *
 * So, we can construct 3 string representing 3 rows using the above information.
 *
 *
 * Time complexity:
 *
 * O(N)
 *
 *
 *
 * Auxiliary space:
 *
 * O(3*N) because of a 2D array
 *
 *
 *
 * Space complexity:
 *
 * Including input, O(3*N).
 */

public class SinusoidalString {

  public static void main(String[] args) {

    // TODO Auto-generated method stub

   String s = "Google Worked";
   printStringSinusoidally(s);
  }

  public static void printStringSinusoidally(String str){
    int cols = str.length();
    int rows = 3,j=0,i=rows-1;
    String s = str.replace(" ", "~");

    char[][] grid = new char[rows][cols];

    while(j < cols){
      while(i >=0 && j < cols){
        grid[i][j] = s.charAt(j);
        i--;
        j++;
      }
      i=i+2;
      while(i < 3 && j < cols){
        grid[i][j] = s.charAt(j);
        i++;
        j++;
      }
      i=i-2;
    }

    for(int k=0;k<grid.length;k++){
      for(int l=0;l<grid[0].length;l++) {
        if(grid[k][l] == 0)
          System.out.print(" ");
        else
          System.out.print(grid[k][l]);
      }
      System.out.println();
    }
  }
}
