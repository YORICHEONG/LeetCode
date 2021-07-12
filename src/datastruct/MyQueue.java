package datastruct;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-12 11:09
 */

import java.util.Stack;

/**
 * @description: 采用双栈的方式类找
 * @author YORICHEONG
 * @date 2021/7/12 11:09
 * @version 1.0
 */
public class MyQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!out.isEmpty()) {
            in.push(out.pop());
        }
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!in.isEmpty()) {
            out.push(in.pop());
        }
        return out.peek();
    }

    /** Get the front element. */
    public int peek() {
        while(out.isEmpty()) {
            while(!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
