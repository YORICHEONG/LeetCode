package byday.code_2022.code_01.day_05;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/5 19:14
 * @Tags
 **/
public class ModifyString {
    
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 9:59 2022/1/6
     **/
    public String modifyString(String s) {
        // 增加一个边界条件
        char[] sArray = ("a"+s+"a").toCharArray();
        // 然后使用三个字符串来进行代替
        char[] value = {'a','b','c'};
        for(int i = 1; i < sArray.length; i++) {
            if(sArray[i] == '?') {
                for(char c : value) {
                    if(c != sArray[i- 1] && c != sArray[i + 1]) {
                        sArray[i] = c;
                        break;
                    }
                }
            }
        }
        return String.valueOf(sArray, 1, s.length());
    }
}
/**
 * Given a string s containing only lowercase English letters and the '?' character,
 * convert all the '?' characters into lowercase letters such that the final string does not contain any consecutive repeating characters.
 * You cannot modify the non '?' characters.
 * It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.
 * Return the final string after all the conversions (possibly zero) have been made.
 * If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints
 *
 */