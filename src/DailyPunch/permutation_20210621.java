package DailyPunch;

import java.util.LinkedList;
import java.util.List;
import java.lang.String;
import java.util.HashSet;

public class permutation_20210621 {
    List<String> result = new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return result.toArray(new String[result.size()]);
    }
    /**
     * 
     * @param x
     */
    private void dfs(int x) {
        if(x == c.length - 1) {
            result.add(String.valueOf(c));  
            return;
        }

        HashSet<Character> set = new HashSet();
        
        for (int i = x; i < c.length; i++) {
            if(set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i, x);
            dfs(x+1);
            swap(x, i);
        }
    }
    /**
     * 
     * @param s
     * @param left
     * @param right
     */
    private void swap(int left, int right) {
        char temp = c[left];
        c[left] = c[right];
        c[right] = temp;
    }
}
