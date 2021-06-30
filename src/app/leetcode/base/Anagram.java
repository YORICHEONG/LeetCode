package app.leetcode.base;
/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 * 
 * 输入: s = "anagram", t = "nagaram"
   输出: true

   输入: s = "rat", t = "car"
   输出: false
 */
/**
 * author:YORICHEONG
 * date:08点52分/May19/2021
 */
public class Anagram {
    /**
     * 使用一个数组来记录字符串中的每个字符的数量，一个String字符串是用来增加数量，一个字符串是用来减少数量
     * 最后再比较是否这个数组每个字符串的数量中都为0，如果是就返回true，否则返回false
     * @param s
     * @param t
     * @return
     */
    public boolean solution_01(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        int[] count = new int[26];
        /**
         * 先遍历第一个字符串，然后用数组来记录字符串中每个字符的个数
         */
        for(int i =0; i<s.length(); i++){
            count[s.charAt(i)-'a']++;
        }
        /**
         * 然后遍历第二个字符串，然后根据这个字符串来减少数组中每个字符串个数
         */
        for(int i =0; i<t.length(); i++){
            if(count[t.charAt(i)-'a']==0){
                return false;//这里直接判断
            }
            count[t.charAt(i)-'a']--;
        }
        /**
         * 最后对这个数组进行一个遍历判断，是否全部都为0
         */
        // for(int value:count){
        //     if(value!=0){
        //         return false;
        //     }
        // }
        return true;
    }
    /**
     * 一次遍历方法
     * @param s
     * @param t
     * @return
     */
    public boolean solution_2(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        int result = 0;
        int[] count = new int[26];
        for(int i = 0;i<s.length(); i++){
            if(++count[cs[i]-'a']==1){
                result++;
            }
            if(--count[ts[i]-'a']==0){
                result--;
            }
        }
        return result==0;
    }
}
