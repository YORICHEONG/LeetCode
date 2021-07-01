package dailypunch;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-01 9:16
 */

import java.util.*;

/**
 * @description: 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。
 * 返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * 输出：3
 * @author YORICHEONG
 * @date 2021/7/1 9:16
 * @version 1.0
 */
public class numWays_20210701 {
    private int n;
    private int k;
    private int way;
    private List<List<Integer>> edges;
    /**
     * @description: 使用深度优先搜索
     * @param: [int, int[][], int] [n, relation, k] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/1 10:05
     */
    public int numWays(int n, int[][] relation, int k) {
        this.way = 0;
        this.n = n;
        this.k = k;

        // 创建一个图形数据结构
        edges = new ArrayList<>();

        // 初始化
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        // 添加图数据
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }

        // 调用深度遍历方法
        dfs(0,0);
        return way;
    }

    /**
     * @description: 深度遍历方法
     * @param: [int, int] [index, steps] 
     * @return: void
     * @author YORICHEONG
     * @date: 2021/7/1 10:30
     */
    private void dfs(int index, int steps) {
        // 满足的条件的就方案数加1
        if(steps == k) {
            if(index == n-1) {
                way++;
            }
            return;
        }
        // 首先获取第一条边的数据
        List<Integer> list = edges.get(index);
        for (int nextIndex : list) {
            dfs(nextIndex, steps+1);
        }
    }

    
    /**
     * @description: 使用广度优先搜索
     * @param: [int, int[][], int] [n, relation, k] 
     * @return: int
     * @author YORICHEONG
     * @date: 2021/7/1 10:18
     */
    public int numWays02(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for (int[] edge: relation) {
            int src = edge[0];
            int dst = edge[1];
            edges.get(src).add(dst);
        }

        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        // 是通过遍历将所有k步能到达的点记录下来
        while(!queue.isEmpty() && steps < k) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                List<Integer> list = edges.get(index);
                for (int nextIndex :
                     list) {
                    queue.offer(nextIndex);
                }
            }
        }

        int ways = 0;
        // 然后进行比较记录k步的记录
        if( steps == k) {
            while(!queue.isEmpty()) {
                if( queue.poll() == n-1) {
                    ways++;
                }
            }
        }

        return ways;
    }

}

