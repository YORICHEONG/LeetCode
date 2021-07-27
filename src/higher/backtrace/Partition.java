package higher.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/27 9:37
 * @version 1.0
 */
public class Partition {
    boolean[][] flag;
    List<List<String>> result = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    int n;
    /**
     * @param: s
     * @description : TODD
     * @return : List<List<String>>
     * @author : YORICHEONG
     * @date : 2021/7/27
     */
    public List<List<String>> partition(String s) {
        int length = s.length();
        n = s.length();
        flag = new boolean[length][length];
        for (int i = 0; i < n; i++) {
            Arrays.fill(flag[i], true);
        }

        for (int i = length-1; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                // 判断是否是回文字符串
                flag[i][j] = (s.charAt(i) == s.charAt(j)) && flag[i+1][j-1];
            }
        }

        dfs(s, 0);
        return result;
    }
    
    /**
     * @param: context
     * @param: index
     * @description : TODD
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/7/27
     */
    private void dfs(String context, int index) {
        if(index == n) {
            result.add(new ArrayList<>(ans));
            return;
        }
        for (int i = index; i < n; i++) {
            if(flag[index][i]) {
                ans.add(context.substring(index, i+1));
                dfs(context, i+1);
                ans.remove(ans.size()-1);
            }
        }
    }
}
