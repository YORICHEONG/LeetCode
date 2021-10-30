package byday.code_2021_10_30;

/**
 * @Description 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/30 11:04
 * @Tags
 **/
public class ValidPalindrome {
    /**
     * @Description: 贪心算法
     * @Author: YORICHEONG 
     * @Date: 11:04 2021/10/30
     **/
    public boolean validPalindrome(String s) {
        // 对于贪心算法来讲，使用双指针的方法，从两边往中间来进行遍历
        int low = 0, high = s.length() - 1;
        while(low < high) {
            char c1 = s.charAt(low);
            char c2 = s.charAt(high);

            if(c1 == c2) {
                low++;
                high--;
            } else {
                // 当不是会回文字符串的情况下就可以进行一两边的判断，删除任何一个回文字符串满足的话都可以成立
                return validPalindrome(s, low, high - 1) || validPalindrome(s, low + 1, high);
            }

        }

        return true;
    }

    private boolean validPalindrome(String s, int low, int high) {
        for (int i = low, j = high; i < j; i++, j--) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            if(c1 != c2) {
                return false;
            }
        }

        return true;
    }
}
