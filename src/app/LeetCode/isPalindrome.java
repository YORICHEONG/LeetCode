package app.LeetCode;

import java.util.*;

/**
 * author:YORICHEONG
 * date:May 19,2021
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写
 */
public class isPalindrome {
    /**
     * 使用一个双指针来进行遍历判断
     */
    public boolean solution_01(String s){
        if(s==null||s.length()==0){
            return true;
        }
        int left = 0; 
        int right = s.length()-1;
        s = s.toLowerCase();
        while(left<right){
            while(left<right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    /**
     * 使用正则表达式来进行一个过滤
     */
    public boolean solution_02(String s){
        String context = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();//先进行一个正则过滤还有大小写转换
        String result = new StringBuffer(context).reverse().toString();
        return context.equals(result);
    }

    
}
