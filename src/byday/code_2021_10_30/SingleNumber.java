package byday.code_2021_10_30;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/30 10:34
 * @Tags
 **/
public class SingleNumber {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer value : nums) {
            if(!set.add(value)) {
                set.remove(value);
            }
        }
        int[] array = new int[set.size()];
        int i = 0;
        for(Integer value : set) {
            array[i++] = value;
        }

        return array;
    }
}
