package byday.code_2021.code_11.day_01;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。你需要把这些糖果平均分给一个弟弟和一个妹妹。
 * 返回妹妹可以获得的最大糖果的种类数。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/11/1 10:06
 * @Tags
 * @Example candies = [1,1,2,2,3,3]
 *          输出: 3
 *
 *          candies = [1,1,2,3]
 *          输出: 2
 **/
public class DistributeCandies {
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 10:06 2021/11/1
     **/
    public int distributeCandies(int[] candyType) {
        // 这个数组是偶数，然后进行平分之后
        // 所以妹妹最大能获取的种类是数量是数组长度的一般
        // 定义一个Set来存储这个数据中有几种糖果
        Set<Integer> set = new HashSet<>();
        for(int type : candyType) {
            set.add(type);
        }
        return set.size() >= candyType.length / 2 ? candyType.length / 2 : set.size();
    }
}
