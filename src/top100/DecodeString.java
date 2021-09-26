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

    private final static char OPEN = '[';

    private final static char CLOSE = ']';

    private StringBuilder builder;
   /**
    * @Description:
    * @Author: YORICHEONG
    * @Date: 10:13 2021/9/23
    **/
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> chartStack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                numberStack.push(c - '0');
            } else if(Character.isLetter(c)) {
                chartStack.push(String.valueOf(c));
            } else if(c == OPEN) {
                chartStack.push(String.valueOf(OPEN));
            } else if(c == CLOSE) {
                builder = new StringBuilder();
                Integer count  = numberStack.pop();
                StringBuilder tempBuilder = new StringBuilder();
                while(!chartStack.peek().equals( String.valueOf(OPEN))) {
                    tempBuilder.append(chartStack.pop());
                }
                chartStack.pop();
                for (int i = 0; i < count; i++) {
                    builder.append(tempBuilder.toString());
                }
                chartStack.push(builder.toString());
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
    }
}
