package english.top100;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @description: Given a string s, find the length of the longest substring without repeating characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * @author YORICHEONG
 * @date 2021/7/2 17:48
 * @version 1.0
 */
public class LengthOfLongestSubstring {
    /**
     * @description:
     * @param: [java.lang.String] [s] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/2 17:48
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }

        Integer[] chars = new Integer[128];

        int left = 0;
        int right = 0;

        int res = 0;

        while(right < s.length()) {
            char r = s.charAt(right);
            Integer index = chars[r];
            System.out.println(index);
            if(index != null && index >= left && index < right) {
                left = index+1;
            }

            res = Math.max(res, right-left+1);
            chars[r] = right;
            right++;
        }

        return res;
    }

    /**
     * @description: use the map to store the character-index
     * @param: [java.lang.String] [s]
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/2 18:13
     */
    public int lengthOfLongestSubstring02(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();

        // iterator the string
        for (int j = 0, i = 0; j < n; j++) {
            // if find the current index char has been in the map
            if (map.containsKey(s.charAt(j))) {
                // make the current begin i direct move to j index
                i = Math.max(map.get(s.charAt(j)), i);
            }
            // calculate the longest index i to j
            ans = Math.max(ans, j - i + 1);
            // put the first meeting char to map and record it index
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /**
     * @description: use the hastset to store the character when you iterator the string
     * @param: [java.lang.String] [s]
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/2 18:21
     */
    private int lengthOfLongestSubstring03(String s) {
        if(s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        int i = 0;
        int j = 0;
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(set.size(),res);
            } else {
                // if set contains the repeat the character we remove the character begin in the i unit the set didn't has repeat the character
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        new LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
    }
}
