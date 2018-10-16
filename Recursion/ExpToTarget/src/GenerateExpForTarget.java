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

import java.util.Stack;

public class GenerateExpForTarget {

    public static void main(String[] args) {

//      String str = "222";
        String str = "123";
        long target = 6;
        String[] list = generate_all_expressions(str, target);
        for(String s:list) {
            System.out.println(s);
            System.out.println("----");
        }
    }

    public static String[] generate_all_expressions(String s, long target) {
        String exp="";
        char[] arr = s.toCharArray();
        HashSet<String> list = new HashSet<>();
        generateExp(arr,0,exp,target,list);
        return list.stream().toArray(String[]::new);
    }

    private static void generateExp(char[] arr, int index, String exp, long target, HashSet<String> list) {
        int size = arr.length;
        if(index == size){
            long eval = evaluation(exp);
            if(eval == target) {
                list.add(exp.replace("\"\"",""));
                return;
            }
        }
        else if (index == size-1) {
            generateExp(arr,index+1, exp + arr[index], target, list);
            generateExp(arr,index+1, exp + arr[index], target,list);
            generateExp(arr,index+1, exp + arr[index], target,list);
        }
        else {
            generateExp(arr,index+1, exp + arr[index] + '"'+'"', target, list);
            generateExp(arr,index+1, exp + arr[index] + '+', target, list);
            generateExp(arr,index+1, exp + arr[index] + '*', target, list);
        }
    }

    private static long evaluation(String s){
        String exp = s.replace("\"\"","");
        Stack<Character> operatorStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();
        String operators = "*+";
        String operands = "0134567892";
        char[] arr = exp.toCharArray();
        int size = arr.length;
        int j=0;
        while(j < size) {
            int i=j;
            if(operands.indexOf(arr[j]) != -1){
                while(j<size && operands.indexOf(arr[j]) != -1 ){
                    j++;
                }
                j--;
                operandStack.push(new String(arr,i,j-i+1));
            }
            else if (operators.indexOf(arr[j]) != -1){
                if (!operatorStack.isEmpty() && !operandStack.isEmpty() && operators.indexOf(arr[j])<operators.indexOf(operatorStack.peek())){
                    String op2 = operandStack.pop();
                    String op1 = operandStack.pop();
                    long result = calculate(Integer.parseInt(op1),Integer.parseInt(op2),arr[j]);
                    operandStack.push(String.valueOf(result));
                    }
                else{
                    operatorStack.push(arr[j]);
                }
            }

            j++;
        }

        while(!operatorStack.isEmpty()){
            String op2 = operandStack.pop();
            String op1 = operandStack.pop();
            char op = operatorStack.pop();
            long result = calculate(Long.parseLong(op1),Long.parseLong(op2),op);
            operandStack.push(String.valueOf(result));
        }

        if(operandStack.size() == 1) {
            return Long.parseLong(operandStack.pop());
        }
        else return -1;
    }

    private static long calculate(long op1, long op2, char c){
        long result = 0;
        switch(c){
            case '*': result = op1*op2;
                      break;

            case '+': result = op1+op2;
                      break;
        }
        return result;
    }
}
