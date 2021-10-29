package byday.code_2021_10_29;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/29 16:29
 * @Tags
 **/
public class GetRow {
    public static void main(String[] args) {
        System.out.println(new GetRow().getRow(3));
    }
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 16:34 2021/10/29
     **/
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row1 = new ArrayList<>();
        if(rowIndex == 0) {
            row1.add(1);
            return row1;
        }
        rowIndex = rowIndex + 1;
        int[][] resArray = new int[rowIndex + 1][rowIndex + 1];
        resArray[1][1] = 1;
        for (int i = 2; i < rowIndex + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if(j == 1 || j == i) {
                    resArray[i][j] = 1;
                } else {
                    resArray[i][j] = resArray[i - 1][j] + resArray[i - 1][j - 1];
                }
            }
        }
        for (int i = 1; i <= rowIndex; i++) {
            if(resArray[rowIndex][i] > 0) {
                row1.add(resArray[rowIndex][i]);
            }
        }
        return row1;
    }
}
