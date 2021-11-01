package byday.code_2021_11_01;

/**
 * @Description 给你一个整数数组 arr，只有可以将其划分为三个和相等的 非空 部分时才返回 true，否则返回 false。
 *
 * 形式上，如果可以找出索引 i + 1 < j 
 * 且满足 (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1]) 就可以将数组三等分。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/11/1 11:07
 * @Tags
 **/
public class CanThreePartsEqualSum {

    public static void main(String[] args) {
        System.out.println(new CanThreePartsEqualSum().canThreePartsEqualSum(new int[] {0,2,1,-6,6,-7,9,1,2,0,1}));
    }

    /**
     * @Description: 分成三个等分，且下标是相连的，这里关于数组的下标是相连，如果进行排序就会破坏原来的下标
     * @Author: YORICHEONG 
     * @Date: 11:08 2021/11/1
     **/
    public boolean canThreePartsEqualSum(int[] arr) {
        int sumValue = sumArray(arr);
        if(sumValue % 3 != 0) {
            return false;
        }
        int targetValue = sumValue / 3;
        int iteratorValue = 0;
        int count = 0;
        // 然后进行分解
        for (int i = 0; i < arr.length; i++) {
            iteratorValue += arr[i];
            if(iteratorValue == targetValue) {
                count++;
                if(count == 3) {
                    return true;
                }
                iteratorValue = 0;
            }
        }

        return count == 3 || (count > 3 && targetValue == 0);
    }

    private int sumArray(int[] array) {
        int sum = 0;
        for(int value : array) {
            sum += value;
        }

        return sum;
    }

    class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            int sum = 0;
            for (int num: A) {
                sum += num;
            }
            // 数组A的和如果不能被3整除直接返回false
            if (sum % 3 != 0) {
                return false;
            }
            // 遍历数组累加，每累加到目标值cnt加1，表示又找到1段
            sum /= 3;
            int curSum = 0, cnt = 0;
            for (int i = 0; i < A.length; i++) {
                curSum += A[i];
                if (curSum == sum) {
                    cnt++;
                    curSum = 0;
                }
            }
            // 最后判断是否找到了3段（注意如果目标值是0的话可以大于3段）
            return cnt == 3 || (cnt > 3 && sum == 0);
        }
    }
}
