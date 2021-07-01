package higher.stringarray;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-01 10:33
 */

import java.util.*;

/**
 * @description: 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分
 * 输入：s = "3+2*2"
 * 输出：7
 * @author YORICHEONG
 * @date 2021/7/1 10:33
 * @version 1.0
 */
public class Calculate {
    
    /**
     * @description: 使用单个栈来实现
     * @param: [java.lang.String] [s] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/1 11:02
     */
    public int calculate(String s) {
        Deque<Integer> stack = new LinkedList();
        // 初始第一个操作符
        char preSign = '+';
        int num = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(Character.isDigit(s.charAt(i))) {
                num = num*10 + s.charAt(i) - '0';
            }
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' '|| i == n - 1) {
                switch (preSign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    default:
                        stack.push(stack.pop() / num);
                }
                preSign = s.charAt(i);
                num = 0;
            }
        }
        int ans = 0;
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}
