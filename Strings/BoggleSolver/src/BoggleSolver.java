
/**
 * This is an age-old question, which leads to some excellent discussions in an interview. Here, you're essentially comparing one set of strings to another set of strings. As you try to solve it, you'll go thru various approaches e.g. hashing the strings, sorting and binary search, tries, recursion (DFS), and even BFS:
 *
 *
 *
 * Given a dictionary, a method to do lookup in dictionary and a M x N board where every cell has one character. Find all possible words that can be formed by a sequence of adjacent characters. Note that we can move to any of 8 adjacent characters, but a word should not have multiple instances of same cell. Get all possible such words and return them.
 *
 * Example:
 *
 * Input: dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
 *        boggle[][]   = {{'G','I','Z'},
 *                        {'U','E','K'},
 *                        {'Q','S','E'}};
 *       isWord(str): returns true if str is present in dictionary
 *                    else false.
 *
 * Output:  Following words of dictionary are present
 *          GEEKS
 *          QUIZ
 *
 *
 * Test cases: If your test cases fail, then check why they failed. If it's simply because of the ordering of printed words, then it's okay.
 *
 *
 *
 *
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
 * https://leetcode.com/problems/word-search-ii/
 *
 * This is easy to understand, but is inefficient compared to using a Trie: http://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
 *
 * These uses a Trie: 1) https://www.geeksforgeeks.org/boggle-set-2-using-trie/ (interview appropriate solution) 2) http://stackoverflow.com/a/746102/327310 (code in the stack overflow link is not correct, but you should understand the logic. Mostly it is same as GeeksForGeeks solution. This is also an interview appropriate solution, which can avoid recursion at some extent.)
 *
 * This explanation come up often in Google searches, but is NOT optimal: http://exceptional-code.blogspot.com/2012/02/solving-boggle-game-recursion-prefix.html [The author claims to be doing DP, but it's essentially just BFS, and that too is not implemented completely. Plus, it is not faster than a Trie-based solution when it comes to even slightly larger board sizes. Stick to Tries and DFS for an optimal solution, but clearly understand why other solutions won't be optimal]
 */

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class BoggleSolver {

  static int[] rowDirections = {0,0,-1,1,-1,1,-1,1};
  static int[] colDirections = {-1,1,0,0,-1,-1,1,1};
  static int rows =0;
  static int cols = 0;

  static class TrieNode{
    char data;
    HashMap<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(){
      this.children = new HashMap<>();
      this.isWord = false;
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

    public boolean isWord() {
      return isWord;
    }

    public void setWord(boolean word) {
      isWord = word;
    }
  }

  public static String[] findWords(String[] dictionaryList,char[][] board) {
    rows = board.length;
    cols = board[0].length;
    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();
    boolean[][] visited = new boolean[rows][cols];
    StringBuilder sb = new StringBuilder();
    List<String> dictionary = new ArrayList<>();
    for (String s : dictionaryList) {
      dictionary.add(s);

      for (int i = 0; i < dictionaryList.length; i++) {
        insertInTrie(root, dictionaryList[i]);
      }

      TrieNode child = root;
      for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
          if (!visited[i][j] && child.getChildren().containsKey(board[i][j])) {
            searchWord(board, child.getChildren().get(board[i][j]), visited, i, j, sb, dictionary, result);
            sb.setLength(0);
          }
        }
      }
    }
    return result.toArray(new String[0]);
  }

  private static void searchWord(char[][] board, TrieNode root, boolean[][] visited, int i, int j, StringBuilder sb, List<String> dictionary, List<String> result) {
    sb.append(board[i][j]);
    visited[i][j] = true;

    String s = sb.toString();
    if(dictionary.contains(s))
      result.add(s);

    for (char c : root.getChildren().keySet()) {
      for (int k = 0; k < rowDirections.length; i++) {
        int ni = i + rowDirections[k];
        int nj = j + colDirections[k];
        if (isValid(ni, nj) && c == board[ni][nj]) {
          if (!visited[ni][nj]) {
            searchWord(board, root.getChildren().get(c), visited, ni,nj,sb, dictionary, result);
          }
        }
      }
    }
  }


  private static void insertInTrie(TrieNode root, String s) {
    for(char ch: s.toCharArray()){
      if(root.children.containsKey(ch)){
        root = root.getChildren().get(ch);
      }
      else {
        TrieNode child = new TrieNode();
        child.setData(ch);
        root.getChildren().put(ch, child);
        root = child;
      }
    }
    root.setWord(true);
  }

  private static boolean isValid(int ni, int nj) {
    if(ni<0 && ni >=rows && nj<0 && nj>=cols)
      return false;
    return true;
  }
}
