/*
Generate All Possible Expressions That Evaluate To The Given Target Value





Problem Statement:



You are given a string s, containing only numerical characters ('0' - '9'). You are also given a non-negative number target.



You have to put between each pair of numerical characters, one of ("", "*", "+") operators such that the expression you get will evaluate to the target value.



Putting "" (an empty string) operator between two numerical characters means, that the they are joined (e.g. 1""2 = 12). Also the join can be extended further (e.g. 1""2""3 = 123).



Precedence of the operators matters. In higher to lower precedence:

Join ("") > Multiplication ("*") > Addition ("+")



Input Format:



There are two arguments.

1) String s.

2) Long integer target.



Output Format:



Return array of strings containing ALL possible strings that evaluate to the target value.



You need not to worry about the order of strings in your output array. Like for s = "22" and target = 4, arrays ["2+2", "2*2"] and ["2*2", "2+2"] both will be accepted.



Any string in the returned array should not contain any spaces. In the above example string "2+2" is expected, other strings containing any space like " 2+2", "2 + 2", "2 +2" etc. will give wrong answer.



Constraints:



1 <= |s| <= 13
s only contains numerical characters ('0' - '9').
0 <= target < 10^13
You have to return ALL possible strings that evaluate to target value.


Sample Test Cases:



Sample Input:



s = "222"

target = 24



Sample Output:



["22+2", "2+22"]



Explanation:



1) 22 + 2 = 24 (Here, we put "" operator between the first two characters and then put "+" operator between the last two characters.)

2) 2 + 22 = 24 (Here, we put "+" operator between the first two characters and then put "" operator between the last two characters.)


 */
import java.util.HashSet;
public class GenerateExpForTarget {

    public static void main(String[] args) {

      String str = "222";
        long target = 24;
        String[] list = generate_all_expressions(str, target);
        for(String s:list) {
            System.out.println(s);
            System.out.println("----");
        }
    }

    public static String[] generate_all_expressions(String s, long target) {
        String exp = "";
        char[] arr = s.toCharArray();
        HashSet<String> list = new HashSet<>();
        generateExp(arr, 0, exp, target, list);
        return list.stream().toArray(String[]::new);
    }

    private static void generateExp(char[] arr, int index, String exp, long target, HashSet<String> list) {
        int size = arr.length;
        if (index == size) {
            long eval = evaluation(exp);
            if (eval == target) {
                list.add(exp.replace("\"\"", ""));
                return;
            }
        } else if (index == size - 1) {
            generateExp(arr, index + 1, exp + arr[index], target, list);
        } else {
            generateExp(arr, index + 1, exp + arr[index] + '"' + '"', target, list);
            generateExp(arr, index + 1, exp + arr[index] + '+', target, list);
            generateExp(arr, index + 1, exp + arr[index] + '*', target, list);
        }
    }

    private static long evaluation(String s) {
        String exp = s.replace("\"\"", "");
        String[] parts = exp.split("\\+");
        long sum = 0;
        for (String part : parts) {
            String[] prodParts = part.split("\\*");
            long product = 1;
            for (String prod : prodParts) {
                product=product*Long.parseLong(prod);
            }
            sum+=product;
        }
        return sum;
    }
}

//I tried this evaluation using two stack(overkill) and the below code(again another overkill)

//    private static long evaluation(String s){
//        String exp = s.replace("\"\"","");
//        if(!exp.contains("+") && !exp.contains("*"))
//            return Long.parseLong(exp);
//
//        else if(exp.contains("*") && (!exp.contains("+"))){
//            long product = 1;
//            String[] multiplyParts = exp.split("\\*");
//            for (String mul : multiplyParts) {
//                product = product * Long.parseLong(mul);
//            }
//            return product;
//        }
//        else if (!exp.contains("*") && (exp.contains("+"))){
//            long addition = 0;
//            String[] addParts = exp.split("\\+");
//            for(String addPart:addParts) {
//                addition = addition + Long.parseLong(addPart);
//            }
//            return addition;
//        }
//
//        else {
//            String[] addParts = exp.split("\\+");
//            long product = 0;
//            boolean productChanged = false;
//            long totalResult = 0;
//                for(String addPart:addParts) {
//                    if (addPart.contains("*")) {
//                        totalResult = totalResult*1;
//                        String[] multiplyParts = addPart.split("\\*");
//                        for (String mul : multiplyParts) {
//                            totalResult= totalResult * Long.parseLong(mul);
//                        }
//                    }
//                    else {
//                        totalResult = totalResult + Long.parseLong(addPart);
//                    }
//                }
//            return totalResult;
//       }
//    }
//}
