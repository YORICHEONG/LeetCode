package top100;

/**
 * @Description
 * @Author YORICHEONG
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021-08-15
 */
public class LongestPalindrome {
    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenterLength(s, i, i);
            int len2 = expandAroundCenterLength(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 中心扩展方法
     * @param s
     * @param left
     * @param right
     * @return
     */
    private int expandAroundCenterLength(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
