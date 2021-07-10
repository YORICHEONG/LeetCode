package higher.treegraph;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 */
public class CanFinish {
    /**
     * 
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 创建一个入度数组来存储每个课程的入度
        int[] inDegree = new int[numCourses];

        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 初始化邻接边
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }

        // 遍历课程需求表
        for (int[] cp : prerequisites) {
            // 每个节点的入度数
            inDegree[cp[0]]++;
            // 然后创建相邻表
            adjacency.get(cp[1]).add(cp[0]);
        }

        //  
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adjacency.get(pre)) {
                if(--inDegree[cur] == 0) {
                    queue.add(cur);
                }
            }
        }
        return numCourses == 0;
    }
}
