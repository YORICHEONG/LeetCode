package higher.treegraph;

import java.util.List;
import java.util.Queue;

import javax.management.Query;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * 2021-07-26 09:41:41
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
   在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
   给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
   可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

 */
public class FindOrder {
    List<List<Integer>> edges;
    int[] inDegeree;
    int[] result;
    int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        inDegeree = new int[numCourses];
        result = new int[numCourses];
        index = 0;
        for (int[] infor : prerequisites) {
            edges.get(infor[1]).add(infor[0]);
            //　增加这个节点的入度
            ++inDegeree[infor[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();

        // 将所有入度为0的点放入到栈中
        for (int i = 0; i < numCourses; i++) {
            if(inDegeree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()) {
            // 从队列首部取出一个节点
            int node = queue.poll();
            // 然后将这个节点放入到答案节点中
            result[index++] = node;
            for (int v : edges.get(node)) {
                --inDegeree[v];
                // 获得这个出队列节点所有能到的边
                // 然后将这个节点入度节点的所有入度都减1
                if(inDegeree[v] == 0) {
                    // 对于新出现的节点也将这个节点加入到队列中
                    queue.offer(v);
                }
            }
        }

        if(index != numCourses) {
            return new int[0];
        }
        return result;
    }
}
