/*
Generate All Subsets Of A Set





Problem Statement:



Given a set (string s containing only distinct lowercase letters ('a' - 'z')), you have to generate ALL possible subsets of it .



Note that empty set is always a subset of any set.



Input Format:



There is only one argument denoting string s.



Output Format:



Return array of strings containing ALL possible subsets of given string.



You need not to worry about order of strings in your output array. Like for s = "a", arrays ["", "a"] and ["a", ""] both will be accepted.



Order of characters in any subset must be same as in the input string. For s = "xy", array ["", "x", "y", "xy"] will be accepted, but ["", "x", "y", "yx"] will not be accepted.



Constraints:



0 <= |s| <= 20
s only contains distinct lowercase alphabetical letters ('a' - 'z').
You have to return ALL possible subsets.


Sample Test Cases:



Sample Input:



"xy"



Sample Output:



["", "x", "y", "xy"]

 */

import java.util.ArrayList;

class Subset {
    public static void main(String[] args) {

        String str = "ABC";
        String[] list = subset(str);
        for(String s:list)
            System.out.println(s);
    }

    public static String[] subset(String str){
        String subset = "";
        ArrayList<String> list = new ArrayList<>();
        list = generate_subsets(str, subset, list);
        return list.stream().toArray(String[]::new);
    }

    private static ArrayList<String> generate_subsets(String set, String subset, ArrayList<String> list){

        if (set.length()==0) {
            list.add(subset);
            return list;
        }

        generate_subsets(set.substring(1,set.length()),subset+set.substring(0,1),list);
        generate_subsets(set.substring(1,set.length()),subset,list);

        return list;

    }


}
