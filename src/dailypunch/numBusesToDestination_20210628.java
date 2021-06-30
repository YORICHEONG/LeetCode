package dailypunch;

/**
 * @date 2021-06-28 09:39:13
 * @author YORICHEONG
 * @description You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
   For example, if routes[0] = [1, 5, 7], this means that the 0th bus travels in the sequence 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 -> ... forever.
   You will start at the bus stop source (You are not on any bus initially), and you want to go to the bus stop target.
   You can travel between bus stops by buses only.
   Return the least number of buses you must take to travel from source to target. Return -1 if it is not possible.
 */
import java.util.*;

public class numBusesToDestination_20210628 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }
        // 表示总共有多少车
        int n = routes.length; 
        // 用来表示两量车之间是否可以进行转换
        boolean[][] isConnect = new boolean[n][n];

        // 用来记录每个车站属于哪个公交
        Map<Integer, List<Integer>> siteMap = new HashMap<>();
        //进行二维数组的遍历
        for (int i = 0; i < n; i++) {
            for(int site : routes[i]) {
                List<Integer> siteList = siteMap.getOrDefault(site, new ArrayList<>());
                for(int j : siteList) {
                    isConnect[i][j] = isConnect[j][i] = true;
                }               
                siteList.add(i);
                siteMap.put(site, siteList);
            }
        }
        // 然后进行广度遍历
        int[] distance = new int[n];
        Arrays.fill(distance,-1);
        Queue<Integer> queue = new LinkedList<>();

        for(int site : siteMap.getOrDefault(source, new ArrayList<>())) {
            distance[site] = 1;
            queue.offer(site);
        }

        // 然后遍历所有的进过起点的车
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < n; i++) {
                if(isConnect[x][i] && distance[i] == -1 ) {
                    distance[i] = distance[x]+1;
                    queue.offer(i);
                }
            }
        }

        // 完成遍历之后，所有车站都有到的数字
        int maxCount = Integer.MAX_VALUE;
        for(int site : siteMap.getOrDefault(target, new ArrayList<>()))
            if(distance[site] != -1) {
                maxCount = Math.min(maxCount, distance[site]);
            }
        return maxCount == Integer.MAX_VALUE ? -1:maxCount;
    }
}
