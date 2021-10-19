package top100;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/9/28 14:31
 * @Tags
 **/
public class IsValid {
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 14:32 2021/9/28
     **/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>(3);
        map.put(']', '[');
        map.put('}', '{');
        map.put(')', '(');
        for (Character c : s.toCharArray()) {
            if(c.equals('}')) {
                if(!stack.isEmpty() && map.get(c).equals(stack.pop())) {
                    continue;
                } else {
                    return false;
                }
            } else if(c.equals(']')) {
                if(!stack.isEmpty() && map.get(c).equals(stack.pop())) {
                    continue;
                } else {
                    return false;
                }
            } else if(c.equals(')')) {
                if(!stack.isEmpty() && map.get(c).equals(stack.pop())) {
                    continue;
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? true : false;
    }


    public boolean isValid2(String s) {
        int mid = s.length() / 2;
        for (int i = 0; i < mid; i++) {

        }
        return false;
    }

    public static void main(String[] args) {
        String filePath = "http://app.res.meizu.com/cabs/35/3431483dcc6046e5888a659e84928758.cab";
        int index = filePath.lastIndexOf(".");
        String subPath = "";
        String fileType = "";
        if(index != -1) {
            subPath = filePath.substring(0, index);
            fileType = filePath.substring(index, filePath.length());
        }
        StringBuilder builder = new StringBuilder(subPath);
        builder.append("_delete");
        builder.append(fileType);
        System.out.println(builder.toString());
    }
}
