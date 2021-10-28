package top100;

/**
 * @Description 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/26 10:50
 * @Tags
 **/
public class CountSubstrings {
    
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 11:00 2021/10/26
     **/
    public int countSubstrings(String s) {
        int length = s.length();
        int number = 0;
        char[] sArray = s.toCharArray();
        for (int i = 0,begin1 = 0, begin2 = 0, end1 = 0, end2 = 1; i < length; begin1 = ++i, begin2 = end1 = i, end1 = i, end2 = i + 1 ) {
            while(begin1 >= 0 && end1 < length && sArray[begin1] == sArray[end1]) {
                number++;
                begin1--;
                end1++;
            }
            while(begin2 >= 0 && end2 < length && sArray[begin2] == sArray[end2]) {
                number++;
                begin2--;
                end2++;
            }
        }
        return number;
    }
}
