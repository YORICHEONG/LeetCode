package top100;

/**
 * @Description 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/26 11:14
 * @Tags
 * @Exapmle
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 **/
public class DailyTemperatures {
    /**
     * @Description: 根据从后往前的方法来进行查找
     * @Author: YORICHEONG 
     * @Date: 11:14 2021/10/26
     **/
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        if(length == 1) {
            return new int[]{0};
        }
        int[] result = new int[length];
        result[length - 1] = 0;
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j += result[j]) {
                if(temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                } else if(result[j] == 0) {
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }
}
