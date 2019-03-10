/**
 * Detect Prime Numbers
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given an integer array a of size N. For each integer in a we have to check if it is a prime number or not.
 *
 *
 *
 * Input/Output Format For The Function:
 *
 *
 *
 * Input Format:
 *
 *
 *
 * There is only one argument denoting integer array a.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return a string res of size N, where ith character of string contains '1' if a[i] is a prime number else it should contain '0'. (1 is neither a prime nor a composite number, hence according to the previous statement, it should go in else part, i.e. ith character should contain '0', when a[i] = 1.)
 *
 *
 *
 * Input/Output Format For The Custom Input:
 *
 *
 *
 * Input Format:
 *
 *
 *
 * The first line should contain a number N, denoting the number of elements in the array a. In next N lines, ith line should contain a number a[i], denoting ith element in a.
 *
 *
 *
 * If N = 4 and a = [6, 2, 5, 8], then input should be:
 *
 *
 *
 * 4
 *
 * 6
 *
 * 2
 *
 * 5
 *
 * 8
 *
 *
 *
 * Output Format:
 *
 *
 *
 * There will be one line, containing a resultant string res.
 *
 *
 *
 * For input N = 4 and a = [6, 2, 5, 8], output will be:
 *
 *
 *
 * 0110
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= a[i] <= 4 * 10^6
 * 1 <= N <= 3 * 10^5
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
 * [6, 2, 5, 8]
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * 0110
 *
 *
 *
 * Explanation:
 *
 *
 *
 * 6 is not a prime number. (6 = 2 * 3)
 *
 * 2 is a prime number.
 *
 * 5 is a prime number.
 *
 * 8 is not a prime number. (8 = 2 * 4)
 *
 *
 *
 * Notes:
 *
 * Maximum time allowed in interview: 20 Minutes.
 */

import java.util.Arrays;

/**
 * Editorial by IK
 *
 * For any number a[i], we iterate over 2 to a[i] - 1 and check if any of them divides a[i] or not. If we find atleast one number that divides a[i] then a[i] is not a prime number. So, this is a brute force solution with time complexity O(N * MAX_A). Have a look at the "brute_force_solution.cpp" provided by us.
 *
 *
 *
 * Any positive number x, which is non-prime (and not 1), can be written as x = a * b where a > 1 and b > 1. Here both a and b can not be > root(x), because if a > root(x) and b > root(x) then, a * b > root(x) * root(x), hence a * b > x, which contradicts a * b = x. When number is a square like 16 then it can be written as root(16) * root(16). So, non-prime number x can be writen as a * b having at least one of them <= root(x). Now in previous solution for each a[i], loop from root(a[i]) + 1 to a[i] - 1 is not necessary. So, now our solution will become O(N * root(MAX_A)). Have a look at the "sub_optimal_solution.cpp" provided by us.
 *
 *
 *
 * Still we can improve. We can write any composite number as multiplication of prime numbers. Like 60 = 2 * 2 * 3 * 5. So, when we find any prime number, we can visit all the multiple of it and mark them as visited (non-prime). We start from 2 as base case, consider 2 as prime number and mark all its multiples 4, 6, 8, 10, ... as visited (non-prime) because they are multiples of 2. After considering 2, we will consider 3. Now, 3 is not marked as visited, which means, there are no factors of 3 and it is a prime number. Hence for 3 also, we do the same thing, mark all its multiples 6, 9, 12, 15 ... as visited (non-prime), because they are multiple of 3. Now 4 comes, but 4 is marked as visited by 2, so we know that 4 is not a prime number. Here also we can do the same thing mark all its multiples 8, 12, 16 ... as visited, but all those positions are already marked as visited by 2, because all multiples of 4 are also multiples of 2. So, no need to do rework! Now, we keep on following the same steps for next numbers. Try to find prime numbers till 30 and you will get more clear idea.
 *
 *
 *
 * Still there can be some optimizations. When we find any prime number like 11, we mark 22, 33. 44, 55, 66 ... them as non-prime, but 22, 33, 44, 55 are already visited by smaller prime numbers. Like 22 is visited by 2, 33 is visited by 3, 44 is visited by 4 ... 110 is visited by 10. So, instead of start marking multiples as non-prime from x + x, we can start from x * x.
 *
 *
 *
 * This solution will be O(N * log(log MAX_A)). Have a look at the "optimal_solution.cpp" provided by us. This algoritham is called as "Sieve of Eratosthenes".
 *
 *
 *
 * Can we say that solution with time complexity O(N * log(log MAX_A)) is better than solution with time complexity O(N * root(MAX_A))? NO! It depends on situation. In terms of time complexity of course it is better, but we should also consider space! Solution with time complexity O(N * root(A)) requires O(1) extra space, but other needs O(MAX_A) extra space. So, when space is more imp than time, we should opt the slower one!
 *
 *
 *
 * When we are given a single integer and we need to find if it is a prime or not, we should use Sieve of Eratosthenes? No!! If there is only one number to check then, we can do it in O(root(A)) by iterating over 2 to root(A). We should use Sieve of Eratosthenes only when, numbers are given in some range where pre-processing can work. Think!
 *
 *
 *
 * In this problem we are given the range of a[i]'s. But when given a stream of random numbers and nothing is specified about range of a[i] then we can use caching (though caching will be useful only when some numbers are going to repeat, but in real life it is likely to happen). We maintain two hash-tables. One containing prime numbers encountered till now and other containing non-prime numbers encountered till now. For next number, we check the presence in our hash tables and if it is present in one of them then nothing much to do, but if it is not present then we use O(root(number)) method to check if it is prime or non-prime and add into appropriate hash table for future reference.
 *
 *
 *
 * Here also we can improve, there is no need to store even numbers as non-prime. We can handle the case of even number separately. Doing this will help to save some space.
 */

public class DetectPrimeNumbers {

  public static void main(String[] args)
  {
    int[] arr = {6, 2, 5, 8};
    String result = detect_prime(arr);
    System.out.println(result);
  }

  //--------------------Sub optimal solution-----------------//
  //this solution is definitely better if we have a continuous stream coming and we have calculate oif
  //number is prime or not. The result of this calculation can be stored in cache.
  private static String detect_prime(int[] arr) {
    char[] result = new char[arr.length];
    for(int element=0; element<arr.length; element++){
      if(isPrime(arr[element]))
        result[element] = '1';
      else
        result[element] = '0';
    }
    return new String(result);
  }

  private static boolean isPrime(int num) {
    if (num == 1)
      return false;
    for (int i = 2; i * i <= num; i++) {
      if (num % i == 0)
        return false;
    }
    return true;
  }
  //----------------------Sub optimal solution-----------------//

  //--------------------Optimal solution-----------------//
  /*this solution more optimal as we are pre processing and storing the results in an array.
  If we have an array of numbers and we know the range of numbers,
  this method is better. If we do not know the range then this method is not as optimal as above.
  */
  //there is problem with this program, it is changing the array due to sorting and the result is different.
  // The result isPrime value be the same as the input array. the values of MAX are also not correct.
//  static final int MAX = Integer.MAX_VALUE;
//  static boolean[] isPrime = new boolean[4000000];
//
//  private static String detect_prime(int[] arr) {
//    char[] result = new char[arr.length];
//    Arrays.sort(arr);
//    int maxArray = arr[arr.length-1];
//    for(int i=0;i<isPrime.length;i++){
//      isPrime[i]= true;
//    }
//    setPrimes(maxArray);
//    for(int element=0; element<arr.length; element++){
//      if(isPrime[element])
//        result[element] = '1';
//      else
//        result[element] = '0';
//    }
//    return new String(result);
//  }
//
//  private static void setPrimes(int max) {
//    isPrime[1] = false;
//    for (int i = 2; i * i <= max; i++) {
//      int start = i*i;
//      for(int j = start; j<=max; j+=i){
//        isPrime[j] = false;
//      }
//    }
//  }
  //----------------------Optimal solution-----------------//
}
