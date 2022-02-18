package byday.code_2021.code_11.day_03;

/**
 * @Description 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * @Author YORICHEONG
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021-11-03
 */
public class CanCompleteCircuit {
    /**
     * 如何来进行测试来判断
     * 首先获取的要大雨消耗的，然后就是如果一个点的收益为0，那么这个点就不能成为起点
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalTank = 0;
        int curTank = 0;
        int startStation = 0;

        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            // 如果当前的获得小于当前的消耗，那么这个就是一个无效的起点
            // 如果连续的几个点都是这样的话，那么这个起点还是不可以成为一个有效的起点
            if(curTank < 0) {
                curTank = 0;
                startStation = i + 1;
            }
        }
        return totalTank >= 0 ? startStation : -1;
    }
}
