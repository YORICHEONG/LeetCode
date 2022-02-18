package byday.code_2021.code_10.day_31;

import java.util.*;

/**
 * @Description 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * 键盘如下图所示。
 * @Author YORICHEONG
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021-10-31
 */
public class FindWords {
    /**
     * 判断每一行的值
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();

        String context1 = "qwertyuiop";
        String context2 = "asdfghjkl";
        String context3 = "zxcvbnm";

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();

        for (int i = 0; i < context1.length(); i++) {
            set1.add(context1.charAt(i));
        }
        for (int i = 0; i < context2.length(); i++) {
            set1.add(context2.charAt(i));
        }
        for (int i = 0; i < context3.length(); i++) {
            set1.add(context3.charAt(i));
        }

        int line = 0;
        int nextLine = 0;

        for(String s : words) {
            String value = s.toLowerCase();
            char[] c = value.toCharArray();
            char context = c[0];
            if(set1.contains(context)) {
                line = 1;
                nextLine = line;
            } else if(set2.contains(context)) {
                line = 2;
                nextLine = line;
            } else if(set3.contains(context)){
                line = 3;
                nextLine = line;
            }

            for (int i = 1; i < c.length && line == nextLine; i++) {
                char currentChar = c[i];
                if(set1.contains(currentChar)) {
                    nextLine = 1;
                } else if(set2.contains(currentChar)) {
                    nextLine = 2;
                } else if(set3.contains(currentChar)){
                    nextLine = 3;
                }
            }
            if(line == nextLine) {
                res.add(s);
            }
        }

        return res.toArray(new String[res.size()]);
    }
}
