package top100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/8/2 9:40
 * @version 1.0
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s != null && s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        int[] indexChar = new int[26];
        Arrays.fill(indexChar, 0);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int currentIndex = s.charAt(j)-'a';
                int currentLength = j-i+1;
                if (indexChar[currentIndex] ==  1) {
                    if( maxLength < currentLength) {
                        maxLength = currentLength;
                    }
                    Arrays.fill(indexChar, 0);
                    continue;
                } else {
                    indexChar[currentIndex] = 1;
                }
            }
        }
        return maxLength;
    }
}
