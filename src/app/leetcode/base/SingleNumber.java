package app.leetcode.base;
/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumber{
    public static void main(String[] args) {
        
    }
    /**
     * 使用异或运算来找出含有重复数字的数组
     * 异或运算的规则：a^a=0, a^0=a, a^b^b=b^b^a  相同为零不同为1
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i =0; i<nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }

}