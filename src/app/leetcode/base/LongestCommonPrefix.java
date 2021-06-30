package app.leetcode.base;
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {
  public String solution(String[] strs){
    //首先是一个字符串为公共的前缀
    //首先进行一个边界条件的判断
    if(strs==null||strs.length==0){
      return "";
    }
    String pre = strs[0];
    int i = 1;
    while(i<strs.length){
      while(strs[i].indexOf(pre)!=0){
        pre = pre.substring(0, pre.length()-1);
      }
      i++;
    }
    return pre;
  }
}
