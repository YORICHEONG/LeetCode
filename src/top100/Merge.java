package top100;

import jdk.nashorn.internal.ir.Symbol;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 * @date 2021/9/2 13:52
 * @version 1.0
 */
public class Merge {
    private static Pattern pattern = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");

    private static  String regExp = "^[1]([3-9])[0-9]{9}$";

    public static void main(String[] args) {
        String number = "17187673954";
        if(number.matches(regExp)) {
            System.out.println("Mathcer");
        } else {
            System.out.println("no mathcher");
        }
    }

    /**
     * @param: intervals
     * @description : 首先将传入的二维数组中的每个数组以每个开头的值来进行排序
     * @return : int[][]
     * @author : YORICHEONG
     * @date : 2021/9/2
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    //====================Method 2==================================================//
    
    /**
     * @param: intervals
     * @description :
     * @return : int[][]
     * @author : YORICHEONG
     * @date : 2021/9/2
     */
    public int[][] merge2(int[][] intervals) {
        BitSet bitSet = new BitSet();
        int max = 0;
        for (int[] interval : intervals) {
            int temp = interval[1] * 2 + 1;
            bitSet.set(interval[0] * 2, temp, true);
            max = temp >= max ? temp : max;
        }

        int index = 0, count = 0;
        while (index < max) {
            int start = bitSet.nextSetBit(index);
            int end = bitSet.nextClearBit(start);

            int[] item = {start / 2, (end - 1) / 2};
            intervals[count++] = item;

            index = end;
        }
        int[][] ret = new int[count][2];
        for (int i = 0; i < count; i++) {
            ret[i] = intervals[i];
        }

        return ret;
    }
}
