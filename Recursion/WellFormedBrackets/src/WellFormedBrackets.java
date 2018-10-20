/*
Find All Well Formed Brackets





Problem Statement:



Given positive integer n, find all well formed round brackets of length 2n.



Input Format:



There is only one argument denoting integer n.



Output Format:



Return array of strings containing all possible well formed round brackets of length 2n (Length of each string will be 2n).



You need not to worry about the order of strings in your array. Like for n = 2, ["(())", "()()"] or ["()()", "(())"], both will be accepted.



Constraints:



1 <= n <= 13
Only use round brackets. '(' and ')'.
Need to find ALL well formed brackets possible.


Sample Test Case:



Sample Input:



3



Sample Output:



[

  "((()))",

  "(()())",

  "(())()",

  "()(())",

  "()()()"

]



(This is one of the possible outputs. Array containing these five string in any order, will be accepted.)
 */

import java.util.ArrayList;

public class WellFormedBrackets {

    public static void main(String []args){
        int n = 3;
        String[] list = find_all_well_formed_brackets(n);
        for(String s:list){
            System.out.println(s);
        }
    }

    static String[] find_all_well_formed_brackets(int n){
        ArrayList<String> result = new ArrayList<>();
        String string = "";
        well_formed_brackets_rec(n, result,string,0,0);
        return result.stream().toArray(String[]::new);
    }

    private static ArrayList<String> well_formed_brackets_rec(int n, ArrayList<String> result, String formation, int countOpen, int countClose) {

        if(countClose == n) {
            result.add(formation);
            return result;
        }

        if(countOpen<n)
            well_formed_brackets_rec(n,result,formation+"(",countOpen+1,countClose);
        if(countClose<countOpen)
            well_formed_brackets_rec(n,result,formation+")",countOpen,countClose+1);

        return result;
    }
}