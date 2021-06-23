package middle.SortSearch;
import java.util.*;
/**
 * Input:[[1,3],[2,6],[8,10],[15,18]]
 * Output:[[1,6],[8,10],[15,18]]
 * 2021年6月23日11:41:32
 * author:YORICHEONG
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[0] - n[0];
            }
        });
        
        List<int[]> merged = new ArrayList<int[]>();

        for(int i = 0; i<intervals.length; i++) {

            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果是新的就直接进行添加
            if(merged.size() == 0 || merged.get(merged.size()-1)[1] < left) {
                merged.add(new int[]{left,right});
            }else {
                //如果还是在范围中就进行更新
                merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1],right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    private void print(int[][] a) {
        for(int i = 0; i<a.length; i++){
            System.out.println(a[i][0]+","+a[i][1]);
        }
    }
    public static void main(String[] args) {
        int[][] test =new int[][]{{1,4},{0,2},{3,5}};
        new Merge().merge(test);
    }
}
