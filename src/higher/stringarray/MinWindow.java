package higher.stringarray;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-01 15:23
 */

/**
 * @description: 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * @author YORICHEONG
 * @date 2021/7/1 15:23
 * @version 1.0
 */
public class MinWindow {
    /**
     *
     * @description:
     * @param: [java.lang.String, java.lang.String] [s, t] 
     * @return: java.lang.String
     * @author YORICHEONG
     * @date: 2021/7/1 15:295
     */
    public String minWindow(String s, String t) {
        // 首先进行一个判断
        if(s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        // 创建一个数组用来存储需要的数组
        int[] need = new int[128];
        for(char c : t.toCharArray()) {
            need[c]++;
        }
        //
        int left = 0;
        int right = 0;
        int size = Integer.MAX_VALUE;
        int count = t.length();
        int start = 0;
        // 然后进行遍历
        while(right<s.length()) {
            char c = s.charAt(right);
            // 如果是需要的字符
            if(need[c] > 0) {
                count--;
            }
            // 同时更新已有的字符数量记录表
            need[c]--;
            // 当包含所有的字符串的时候
            if(count == 0) {
                // 对于已有字符串进行删除无效字符处理
                while (left < right && need[s.charAt(left)] < 0) {
                    need[s.charAt(left)]++;
                    left++;
                }
                if(right - left + 1 < size) {
                    size = right - left + 1;
                    start = left;
                }
                need[s.charAt(left)]++;
                left++;
                count++;
            }
            right++;
        }
        // 如何确定最小的长度的子串
        return size == Integer.MAX_VALUE ? "":s.substring(start,start+size);
    }
}
