package datastruct;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-12 13:53
 */

import middle.dynamic.CanJump;

/**
 * @description: 三合一。描述如何只用一个数组来实现三个栈。
 *
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 *
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 *
 * @author YORICHEONG
 * @date 2021/7/12 13:53
 * @version 1.0
 */
public class TripleInOne {
    int[] store;

    int length;

    final int INDEX = 3;

    public TripleInOne(int stackSize) {
        store = new int[stackSize*3];
        length = store.length;
    }

    /**
     * @description: 
     * @param: [int, int] [stackNum, value] 
     * @return: void
     * @author YORICHEONG
     * @date: 2021/7/12 15:00
     */
    public void push(int stackNum, int value) {
        for(int i = stackNum; i < store.length; ) {
            if (store[i] == 0) {
                store[i] = value;
                return;
            }
            i += INDEX;
        }
    }
    
    /**
     * @description:
     * @param: [int] [stackNum] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/12 15:00
     */
    public int pop(int stackNum) {
        if(store[stackNum] == 0) {
            return -1;
        }
        for (int i = length-INDEX+stackNum; i >= stackNum; ) {
            if(store[i] != 0) {
                int result = store[i];
                store[i] = 0;
                return result;
            } else {
                i -= INDEX;
            }
        }
        return -1;
    }
    
    /**
     * @description: 
     * @param: [int] [stackNum] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/12 15:11
     */
    public int peek(int stackNum) {
        if(store[stackNum] == 0) {
            return -1;
        }
        for (int i = length - INDEX + stackNum; i >= stackNum; ) {
            if(store[i] != 0) {
                int result = store[i];
                return result;
            } else {
                i -= INDEX;
            }
        }
        return -1;
    }
    
    /**
     * @description:
     * @param: [int] [stackNum] 
     * @return: boolean
     * @author YORICHEONG
     * @date: 2021/7/12 15:11
     */
    public boolean isEmpty(int stackNum) {
        return store[stackNum] == 0;
    }
}
