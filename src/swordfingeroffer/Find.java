package swordfingeroffer;

/**
 * @Description 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/7/4 11:37
 * @Tags
 **/
public class Find {
    public static void main(String[] args) {

    }

    public boolean find(int target, int[][] arr) {
        int rowLength = arr.length;
        int colLength = arr[0].length;

        for(int row = rowLength - 1, col = 0; col >= 0 && row < rowLength;) {
            int temp = arr[row][col];
            if(temp == target) {
                return true;
            }else if(target > temp) {
                row--;
                continue;
            } else {
                col++;
                continue;
            }
        }

        return false;
    }
}
