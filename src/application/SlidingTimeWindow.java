package application;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/8 12:51
 * @Tags
 **/
public class SlidingTimeWindow {
    // 实现服务的访问次数
    private Long count = 0L;

    // 使用Linkedlist 来记录滑动窗口的十个格子
    LinkedList<Long> slots = new LinkedList();


    // 进行判断是否超过流量的方法
    private void doCheck() throws Exception {
        while(true) {
            slots.addLast(count);
            if(slots.size() > 10) {
                slots.removeLast();
            }
            if((slots.peekLast() - slots.peekFirst()) > 100) {
                // 这个时候就要进行一个限流
            } else {
                // 这个时候就不需要进行限流
            }
        }
    }


}
