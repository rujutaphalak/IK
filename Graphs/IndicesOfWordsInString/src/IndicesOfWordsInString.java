/**
 * Indices Of Words In Text String
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * You are given a text string and q words. For all q words, You need to find out all words from text string which are matching with given word.
 *
 *
 *
 * Input Format:
 *
 *
 *
 * Two arguments. First is text string and second is list of words.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return List of q lists, where ith list contains indices of first character of all the matching words in text string, for words[i], in sorted order.
 *
 * If no word found in text string for given word then have -1 as only element of answer list for that word.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * Text string and words of query can contain characters from a-z, A-Z, 0-9 and symbols from set {'$', '#', '@', '?' ,';'}. Additionally text string can contain spaces also.
 * Assume words in text string are single space separated. text string starts and ends with a word, not space(s). There will be no consecutive spaces in text string.
 * 1 <= len(text) <= 1000000.
 * 1<= q <= 100000.
 * Length of any word of query and text string l, 1<= l <= 10.
 * Every query word will be unique.
 * Consider indexing of character in text string from 0.
 * Returned list of indices must be sorted in increasing order.
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
 * text = “you are very very smart”
 *
 * words = [“you”, “are”, “very”, “handsome”]
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * [
 *
 * [0],
 *
 * [4],
 *
 * [8, 13],
 *
 * [-1]
 *
 * ]
 *
 *
 *
 * Explanation:
 *
 *
 *
 * For given text string = “you are very very smart”. “you” is matching with first word “you” which is starting from index 0 of text string so answer for “you” will be 0.
 *
 * Similarly for “are” answer is 4.
 *
 * “very” is matching with word at index 8 and 13 so answer for “very” will be 8 and 13.
 *
 * “handsome” is not matching with any word so it’s answer is -1;
 */


/**
 * Solution by IK
 * We have provided solutions which contain necessary comments to understand the approach used:
 *
 *
 *
 * 1) brute_force_solution.java
 *
 *
 *
 * Description:
 *
 *
 *
 * This approach is very simple and a brute force solution. For every query word find all first index of character of word from text string which is matching.
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n*q*l) where n is number of words in text string and q is number of queries of words and l is maximum length of word.
 *
 *
 *
 * As we are finding solution for each query in O(n*l) and there can be q queries so it will take O(n*q*l) time.
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(q+n) where n is number of words in text string and q is number of queries of words.
 *
 * As we storing indices of query words which we found and as it is possible that result list can contain all indices of words of text string which can be equal to n. (Given that the query words will be unique, hence any word in text string can match <= 1 query word. Hence summation of matching indices in returned list of lists can not be more than n .)
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O((n+q)*l) where n is number of words in text string, q is number of queries of words, l is maximum length of word.
 *
 * For input we are storing q words of maximum length l in O(q*l) and for storing text string it will be O(n*l) and auxiliary space used is O(q+n).
 *
 * So, O(q*l) + O(n*l) + O(q+n) -> O((n+q)*l).
 *
 *
 *
 * 2) optimal_solution1.java
 *
 *
 *
 * Description:
 *
 *
 *
 * In this solution, we are using HashMap to maintain indices list for words. We are populating hashmap while iterating over given words of text string. Then for each query we are getting query indices of matching word from maintained hashmap.
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O((n+q)*l) where n is number of words in text string and q is number of queries of words and l is maximum length of word.
 *
 *
 *
 * To populate hashmap, time complexity will be O(n*l) and for getting result of q queries time complexity will be O(q*l).
 *
 * O(n*l) + O(q*l) → O((n+q)*l)
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O((n*l)+q) where n is number of words in text string and q is number of queries of words and l is maximum length of word.
 *
 *
 *
 * As we are maintaining hashmap for indices list of words in O(n*l) and storing indices of query words which we found in O(q + n) as it is possible that result list can contain all indices of words of text string which can be equal to n. (Given that the query words will be unique, hence any word in text string can match <= 1 query word. Hence summation of matching indices in returned list of lists can not be more than n .)
 *
 * So, O(n*l) + O(q+n) → O((n*l)+q)
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O((n+q)*l) where n is number of words in text string, q is number of queries of words, l is maximum length of word.
 *
 *
 *
 * For input we are storing q words of maximum length l in O(q*l) and for storing text string it will be O(n*l) and auxiliary space used is O((n*l)+q).
 *
 * So, O(q*l) + O(n*l) + O((n*l)+q) -> O((n+q)*l).
 *
 *
 *
 * 3) optimal_solution2.java
 *
 *
 *
 * Description:
 *
 *
 *
 * In this solution, we are using Trie tree. First we will iterate over all the words in text string and inserting them to Trie tree. Now whenever we need to find matching words from text string we search it in Trie and return result indices.
 *
 *
 *
 * optimal_solution2 (using trie tree) will be better than optimal_solution1 (using hashmap) in cases where prefix of strings are overlapping. Because space will be less to store n number of strings where some strings prefixes are overlapping.
 *
 *
 *
 * In actual interview, Interviewer will except a Trie solution from you instead of hashmap one.
 *
 *
 *
 * For more information on when to use hashmap and when to use trie tree. Look at this stackoverflow answer.
 *
 * https://stackoverflow.com/questions/245878/how-do-i-choose-between-a-hash-table-and-a-trie-prefix-tree
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O((n+q)*l) where n is number of words in text string and q is number of queries of words and l is maximum length of word.
 *
 *
 *
 * As Insert and search in Trie tree will be O(l).
 *
 * To populate trie tree, it will iterate over all words in text string hence will take O(n*l).
 *
 * And, to search for q queries, it will iterate over all q queries hence will take O(q*l)
 *
 * So, O(n*l) + O(q*l) → O((n+q)*l)
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(n*l + q) where n is number of words in text string, l is maximum length of word and q is number of queries of words.
 *
 *
 *
 * As we are storing n words of maximum length l in trie tree and storing indices of query words which we found in O(q + n) as it is possible that result list can contain all indices of words of text string which can be equal to n. (Given that the query words will be unique, hence any word in text string can match <= 1 query word. Hence summation of matching indices in returned list of lists can not be more than n .)
 *
 * O(n*l) + O(q+n) → O(n*l + q)
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O((n+q)*l) where n is number of words in text string, q is number of queries of words, l is maximum length of word.
 *
 *
 *
 * For input we are storing q words of maximum length l in O(q*l) and for storing text string it will be O(n*l) and auxiliary space used is O(n*l + q).
 *
 * So, O(q*l) + O(n*l) + O(n*l + q) -> O((n+q)*l).
 */
/**
 * Working solution
 */

import java.util.*;
public class IndicesOfWordsInString {
//
//  static class TrieNode{
//    private char data;
//    private HashMap<Character, TrieNode> children;
//    private ArrayList<Integer> indexes;
//
//    public TrieNode() {
//      this.children = new HashMap<>();
//      this.indexes = new ArrayList<>();
//    }
//
//    public char getData() {
//      return data;
//    }
//
//    public void setData(char data) {
//      this.data = data;
//    }
//
//    public HashMap<Character, TrieNode> getChildren() {
//      return children;
//    }
//
//    public void setChildren(HashMap<Character, TrieNode> children) {
//      this.children = children;
//    }
//
//    public ArrayList<Integer> getIndexes() {
//      return indexes;
//    }
//
//    public void setIndexes(ArrayList<Integer> indexes) {
//      this.indexes = indexes;
//    }
//  }
//
//  public static ArrayList<ArrayList<Integer>> find_words(String text, List<String> words) {
//    TrieNode root = new TrieNode();
//    String[] splitText = text.split(" ");
//    int nextIndex = 0;
//    for(int i=0; i<splitText.length; i++){
//      insertInTrie(splitText[i], nextIndex, root);
//      nextIndex+= splitText[i].length()+1;
//    }
//
//    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//    for(int i=0; i<words.size(); i++) {
//      ArrayList<Integer> indexes = searchTrie(words.get(i), root);
//      if (indexes.size() == 0)
//        indexes.add(-1);
//      result.add(indexes);
//    }
//    return result;
//  }
//
//  private static void insertInTrie(String text, int index, TrieNode root){
//    for(char ch: text.toCharArray()){
//      if(root.children.containsKey(ch)){
//        root = root.getChildren().get(ch);
//      }
//      else {
//        TrieNode child = new TrieNode();
//        child.setData(ch);
//        root.getChildren().put(ch, child);
//        root = child;
//      }
//    }
//    root.getIndexes().add(index);
//  }
//
//  private static ArrayList<Integer> searchTrie(String word, TrieNode root) {
//
//    for(char c: word.toCharArray()){
//      if(root.getChildren().containsKey(c)){
//        root = root.getChildren().get(c);
//      }
//      else{
//        return new ArrayList<>();
//      }
//    }
//    return root.getIndexes();
//  }

  static class TrieNode {

    private char data;
    private HashMap<Character, TrieNode> children;
    private ArrayList<Integer> indexes;

    public TrieNode() {
      this.children = new HashMap<>();
      this.indexes = new ArrayList<>();
    }

    public char getData() {
      return data;
    }

    public void setData(char data) {
      this.data = data;
    }

    public HashMap<Character, TrieNode> getChildren() {
      return children;
    }

    public void setChildren(HashMap<Character, TrieNode> children) {
      this.children = children;
    }

    public ArrayList<Integer> getIndexes() {
      return indexes;
    }

    public void setIndexes(ArrayList<Integer> indexes) {
      this.indexes = indexes;
    }
  }

  public static ArrayList<ArrayList<Integer>> find_words(String text, List<String> words){
    TrieNode root = new TrieNode();
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    int index = 0;

    //build trie from entire string text.
    // In one attempt I tried to create the buildtrie by passing in all text and root at once But in that case, the root was losing track of its reference
    //For every new word the word look up should start from the root.  Thsat was not happening. Lesson learnt for trie inserts and search, the root should always be
    // initialized before to insert and search function. They should also accept a string which is a whole word not a string of words.
    String[] sArr = text.split(" ");
    for (String str : sArr) {
      buildTrie(str, root, index);
      index+=str.length()+1;
    }

    //search for words in trie
    for(String word :words) {
      ArrayList<Integer> list = searchInTrie(word, root);
      if (list.size() == 0)
        list.add(-1);
      result.add(list);
    }

    return  result;
  }

  private static ArrayList<Integer> searchInTrie(String word, TrieNode root) {
    ArrayList<Integer> list;
    char[] cArr = word.toCharArray();
    for(char c: cArr){
      if(root.getChildren().containsKey(c)){
        root = root.getChildren().get(c);
      }
      else{
        return new ArrayList<>();
      }
    }
    return root.getIndexes();
  }

  private static void buildTrie(String str, TrieNode root, int index) {
    char[] cArr = str.toCharArray();
        for(char ch : cArr){
          if(root.children.containsKey(ch))
            root = root.children.get(ch);
          else {
            TrieNode child = new TrieNode();
            child.setData(ch);
            root.getChildren().put(ch, child);
            root = child;
          }
        }
        ArrayList<Integer> indexes = root.getIndexes();
        indexes.add(index);
        root.setIndexes(indexes);
  }

  public static void main(String[] args){

    String text = "you are very very smart";
    String[] words = {"you", "are", "very", "handsome"};
    ArrayList<ArrayList<Integer>> result = find_words(text, Arrays.asList(words));
    for(List list : result){
      System.out.println(list.toString());
    }
  }

}
