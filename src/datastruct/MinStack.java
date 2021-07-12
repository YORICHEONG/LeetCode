package datastruct;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-12 15:32
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/12 15:32
 * @version 1.0
 */
public class MinStack {
    Deque<Integer> data = new ArrayDeque<>();
    Deque<Integer> help = new ArrayDeque<>();

    public void push(int val) {
        data.addLast(val);
        if (help.isEmpty() || help.peekLast() >= val) {
            help.addLast(val);
        } else {
            help.addLast(help.peekLast());
        }
    }

    public void pop() {
        data.pollLast();
        help.pollLast();
    }

    public int top() {
        return data.peekLast();
    }

    public int getMin() {
        return help.peekLast();
    }
}
