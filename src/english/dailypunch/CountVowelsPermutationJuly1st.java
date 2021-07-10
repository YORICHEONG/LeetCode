package english.dailypunch;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: Given an integer n, your task is to count how many strings of length n can be formed under the following rules:
 *
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
 * Each vowel 'a' may only be followed by an 'e'.
 * Each vowel 'e' may only be followed by an 'a' or an 'i'.
 * Each vowel 'i' may not be followed by another 'i'.
 * Each vowel 'o' may only be followed by an 'i' or a 'u'.
 * Each vowel 'u' may only be followed by an 'a'.
 * Since the answer may be too large, return it modulo 10^9 + 7.
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 5
 * Explanation: All possible strings are: "a", "e", "i" , "o" and "u".
 *
 * Input: n = 2
 * Output: 10
 * Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".
 *
 *
 * @author YORICHEONG
 * @date 2021/7/5 10:19
 * @version 1.0
 */
public class CountVowelsPermutationJuly1st {

    /**
     * @description: use the dp method to solution this problem
     * @param: [int] [n]
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/5 10:21
     */
    public int countVowelPermutation(int n) {
        // create dp array to store the result
        long[][] dp = new long[n+1][5];

        // this following rules array
        int[][] rules = {{0,1,0,0,0},
                {1,0,1,0,0},
                {1,1,0,1,1},
                {0,0,1,0,1},
                {1,0,0,0,0}};

        int MOD = (int)Math.pow(10,9)+7;

        // do iterator
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                if(i == 1) {
                    dp[i][j] = 1;
                    continue;
                }

                long sum = 0;
                for (int k = 0; k < 5; k++) {
                    // get the pre dp array vlaue
                    long pre = dp[i-1][k];
                    sum += pre*rules[k][j];
                }
                dp[i][j] =  sum % MOD;
            }
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            // to calculate the sum value
            ans = (ans+dp[n][i]) % MOD;
        }
        return (int)ans;
    }

    /**
     * @description: use the dps to solution the problem  and this is time limit exceeded method
     * @param: [int] [n] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/5 11:38
     */
    int MOD = (int)Math.pow(10,9)+7;
    Map<Character,Character[]> mapRules = new HashMap<>();
    {
       mapRules.put('s',new Character[]{'a', 'e', 'i', 'o', 'u'});
       mapRules.put('a',new Character[]{'e'});
       mapRules.put('e',new Character[]{'a','i'});
       mapRules.put('i',new Character[]{'a', 'e', 'o', 'u'});
       mapRules.put('o',new Character[]{'i', 'u'});
       mapRules.put('u',new Character[]{'a'});
    }
    /**
     * @description:
     * @param: [int] [n] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/5 13:50
     */
    private int countVowelPermutation2(int n) {
        return solution(n,'s');
    }
    /**
     * @description: iterator
     * @param: [int, char] [rem, key] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/5 13:48
     */
    private int solution(int rem, char key) {
        if(rem == 0) {
            return 1;
        }
        int ans = 0;
        for(Character c : mapRules.get(key)) {
            ans = (ans+solution(rem-1,c))%MOD;
        }
        return ans;
    }
}
