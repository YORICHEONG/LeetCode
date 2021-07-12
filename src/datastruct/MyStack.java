package datastruct;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-12 13:50
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/12 13:50
 * @version 1.0
 */
public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
