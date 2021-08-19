package top100;

import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * @author YORICHEONG
 * @date 2021/8/18 10:16
 * @version 1.0
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backTrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    /**
     * @param: combinations
     * @param: phoneMap
     * @param: digits
     * @param: index
     * @param: combination
     * @description :
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/8/18
     */
    private void backTrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if(index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; i++) {
                combination.append(letters.charAt(i));
                backTrack(combinations, phoneMap, digits, index+1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
