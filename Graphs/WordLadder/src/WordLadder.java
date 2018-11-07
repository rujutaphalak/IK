/*

String Transformation Using Given Dictionary Of Words

Problem Statement:

You are given a dictionary of words and two strings named start and stop.

How can you convert string start to string stop, by changing only one character at a time and making sure that 1) all the intermediate words are in the given dictionary of words and 2) minimum number of intermediate words are used?


Input Format:

There are three arguments. First is an array of strings denoting the dictionary of words, second is a string start and third is a string stop.


Output Format:

Return an array of strings.

If transformation is possible then in returned array, first string should be start, last string should be stop
and in between strings of given dictionary that you used for transformation, in the same order they are used in
your transformation. Suppose name of the returned array is ans and size is ans_size, then for 1 <= i < ans_size,
ans[i - 1] and ans[i] should differ at exactly one position.

If transformation is not possible then returned array should contain only one string "-1".

(If there are multiple valid transformations, you are free to return any one of them.)

Constraints:
Input strings contain only lower case alphabetical letters.
Length of input strings are same.
Input strings need not to be unique.
2 <= total number of characters in input strings <= 10^5
start and stop strings need not to be present in given dictionary.


Sample Test Case:

Sample Input:
words = ["cat", "hat", "bad", "had"]

start = "bat"
stop = "had"

Sample Output:
["bat", "bad", "had"]
or
["bat", "hat", "had"]

Explanation:
From "bat" change character 't' to 'd', so new string will be "bad".

From "bad" change character 'b' to 'h', so new string will be "had".
or
From "bat" change character 'b' to 'h', so new string will be "hat".

From "hat" change character 't' to 'd', so new string will be "had".

*/

import java.util.*;

public class WordLadder {

    static String[] string_transformation(String[] words, String start, String stop) {
        if(start.equals(stop) && words.length < 1)
            return new String[]{"-1"};

        //Create a set of words from the string array and add the start and stop
        Set<String> wordSet = new HashSet<>();

        wordSet.addAll(Arrays.asList(words));
        wordSet.add(start);
        wordSet.add(stop);

        //BFS - to find the shortest path using wordGraph, start and stop
        List<String> path = getShortestPath(wordSet,start, stop);
        return path.toArray(new String[0]);
    }

    static LinkedList<String> getNeighbors(Set<String> wordSet, String word, boolean charOperation){
        LinkedList<String> neighbors = new LinkedList<>();

        if(charOperation){
            for(int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    String str=null;
                    if(word.charAt(i) != c) {
                        str = word.substring(0, i) + String.valueOf(c) + word.substring(i + 1);
                        if (wordSet.contains(str))
                            neighbors.add(str);
                    }
                }
            }
        }
        else{
            for(String potentialWord:wordSet)
                if(!word.equals(potentialWord))
                    if(isCharDifferenceOne(word,potentialWord))
                        neighbors.add(potentialWord);
        }
        return neighbors;
    }

    static boolean isCharDifferenceOne(String word, String potentialWord){
        int len1= word.length();
        if(len1 != potentialWord.length())
            return false;
        if (word.equals(potentialWord))
            return false;
        int count = 0;
        for(int i=0;i<len1;i++){
            if(word.charAt(i) != potentialWord.charAt(i)){
                count+=1;
                if(count>1)
                    return false;
            }
        }
        return true;
    }

    static List<String> getShortestPath(Set<String> wordSet, String start, String stop){
        Queue<String> queue = new LinkedList<>();
        Map<String,String> backRefs = new HashMap();
        queue.add(start);
        backRefs.put(start,null);
        boolean found = false;

        int size = wordSet.size();
        int wordLength = start.length();
        int wordSetComparisons = size*(size-1)*wordLength;
        int wordCharOperations = wordLength*26;
        boolean charOperation = (wordCharOperations < wordSetComparisons)?true:false;

        while(!queue.isEmpty()){
            String word = queue.remove();

            for(String neighbor: getNeighbors(wordSet,word,charOperation)){

                if (!backRefs.containsKey(neighbor)) {
                    backRefs.put(neighbor, word);
                }
//                if(neighbor.equals(stop) && backRefs.get(neighbor) == null)
//                    backRefs.replace(neighbor,null,word);

                if (neighbor.equals(stop)){
                    found = true;
                    break;
                }
                queue.add(neighbor);
                }
            if(found)
                break;
        }

        List<String> path = new ArrayList<>();
        if(!backRefs.containsKey(stop))
            path.add("-1");

        String str = stop;
        while(str != null){
            path.add(str);
            str = backRefs.get(str);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args){
        String[] words = new String[]{"cccw", "accc", "accw"};
        String start = "cccc";
        String stop = "cccc";
        String[] path = string_transformation(words,start,stop);
//        System.out.println(path.length);
        for(String p:path)
            System.out.println(p);
    }
}
