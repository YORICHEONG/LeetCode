package top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/9/23 10:11
 * @Tags
 **/
public class DecodeString {

    private final static String OPEN = "[";

    private final static char CLOSE = ']';

    private static StringBuilder builder = new StringBuilder();
   /**
    * @Description:
    * @Author: YORICHEONG
    * @Date: 10:13 2021/9/23
    **/
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> chartStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                numberStack.push(c - '0');
            } else if(c == CLOSE) {
                // do the builder
                int stringNumber = numberStack.pop();
                while(true) {
                    String currentString = chartStack.pop();
                    if(currentString.equals(OPEN)) {
                        break;
                    }
                    builder.append(currentString);
                }
                String stringContext = builder.toString();
                builder.delete(0, builder.length());
                for (int i = 0; i < stringNumber; i++) {
                    builder.append(stringContext);
                }
                String resultContext = builder.toString();
                builder.delete(0, builder.length());
                chartStack.push(resultContext);
            } else {
                chartStack.push(String.valueOf(c));
            }
        }
        while(!chartStack.isEmpty()) {
            builder.append(chartStack.pop());
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        // "accaccacc"
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
    }
}
