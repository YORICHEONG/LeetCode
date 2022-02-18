package byday.code_2021.code_10.day_29;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/29 14:23
 * @Tags
 **/
public class Generate {

    public static void main(String[] args) {
        new Generate().generate(5);
    }

    /**
     * @Description: 动态的规划的方法来进行一状态的记录与转移
     * @Author: YORICHEONG 
     * @Date: 15:09 2021/10/29
     **/
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 1) {
            List<Integer> row1 = new ArrayList<>();
            row1.add(1);
            res.add(row1);
            return res;
        }
        int[][] resArray = new int[numRows + 1][numRows + 1];
        resArray[1][1] = 1;
        for (int i = 2; i < numRows + 1; i++) {
            for (int j = 1; j <= i; j++) {
                if(j == 1 || j == i) {
                    resArray[i][j] = 1;
                } else {
                    resArray[i][j] = resArray[i - 1][j] + resArray[i - 1][j - 1];
                }
            }
        }

        for (int i = 1; i < numRows+1 ; i++) {
            List<Integer> tempRow = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if(resArray[i][j] != 0) {
                    tempRow.add(resArray[i][j]);
                }
            }
            res.add(tempRow);
        }

        return res;
    }

    /**
     *                                            ---*---
     *                                            -- *-*--
     *                                            -  *-*-*-
     *                                               *-*-*-*
     *
     *                                               1
     *                                               11
     *                                               121
     *                                               1331
     *                                               14641
     */
}

