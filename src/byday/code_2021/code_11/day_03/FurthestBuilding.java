package byday.code_2021.code_11.day_03;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Description 给你一个整数数组 heights ，表示建筑物的高度。另有一些砖块 bricks 和梯子 ladders 。
 * 你从建筑物 0 开始旅程，不断向后面的建筑物移动，期间可能会用到砖块或梯子。
 * 当从建筑物 i 移动到建筑物 i+1（下标 从 0 开始 ）时：
 * 如果当前建筑物的高度 大于或等于 下一建筑物的高度，则不需要梯子或砖块
 * 如果当前建筑的高度 小于 下一个建筑的高度，您可以使用 一架梯子 或 (h[i+1] - h[i]) 个砖块
 * 如果以最佳方式使用给定的梯子和砖块，返回你可以到达的最远建筑物的下标（下标 从 0 开始 ）。
 *
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/11/3 15:04
 * @Tags
 **/
public class FurthestBuilding {
    /**
     * @Description: 每次用的都是最合理的，如何判断每次是否应该是使用梯子还是砖头
     * @Author: YORICHEONG 
     * @Date: 15:05 2021/11/3
     **/
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // 使用贪心+大小堆的算法来进行
        // 首先使用砖，当砖没有的时候然后将用的最多的砖替换成为梯子
        // 首先使用梯子，然后将差值最小的使用砖

        int n = heights.length;
        int sumCount = 0;
        // 创建一个优先队列来进行存储差距
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i < n; i++) {
            int dif = heights[i] - heights[i-1];
            if(dif > 0) {
                queue.add(dif);
                // 如果梯子使用完了之后
                if(queue.size() > ladders) {
                    sumCount += queue.poll();
                }
                // 当砖也不够的时候
                if(sumCount > bricks) {
                    return i - 1;
                }
            }
        }
        // 如果最后能够成功的通过所有的建筑
        return n - 1;
    }
}
