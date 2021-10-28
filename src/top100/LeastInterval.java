package top100;

import java.util.Arrays;

/**
 * @Description 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。
 * 其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，
 * 并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的 最短时间 。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/25 10:40
 * @Tags
 **/
public class LeastInterval {
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 10:40 2021/10/25
     **/
    public int leastInterval(char[] tasks, int n) {
        int[] bucket = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            bucket[tasks[i] - 'A']++;
        }
        Arrays.sort(bucket);
        int maxTimes = bucket[25];
        int maxCount = 1;
        for (int i = 25; i >= 1; i--) {
            if(bucket[i] == bucket[i - 1]) {
                maxCount++;
            } else {
                break;
            }
        }

        int res = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }
}
