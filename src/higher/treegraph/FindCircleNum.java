package higher.treegraph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCircleNum {
    /**
     * 
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int result = 0;
        int length = isConnected.length;
        boolean[] isVisited = new boolean[length];
        for (int i = 0; i < length; i++) {
            if(isVisited[i] == false) {
                result += 1;
                isVisited[i] = true;
                dfs(isConnected, isVisited, i);
            } 
        }
        return result;
    }

    /**
     * 
     * @param isConnected
     * @param isVisited
     * @param index
     */
    private void dfs(int[][] isConnected, boolean[] isVisited, int index) {
        int length = isConnected.length;
        for (int i = 0; i < length; i++) {
            if(isConnected[index][i] == 1 && isVisited[i] == false) {
                isVisited[i] = true;
                dfs(isConnected, isVisited, i);
            }
        }
    }
}
