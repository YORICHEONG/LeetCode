package middle.dynamic;
/**
 * 时间：2021-06-23 18:51:31
 * author:YORICHEONG
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        //使用动态的规划的方法来进行动态的判断

        int length = nums.length;

        //最大可以达到的位置
        int maxGet = 0;
        
        //在遍历的过程中的动态的判断当前可以达到的最大的距离
        for(int i = 0; i<nums.length; i++){
            if(i <= maxGet) {
                maxGet = Math.max(maxGet, i+nums[i]);
                if(maxGet >= length-1){
                    return true;
                }
            }
        }

        return false;
    }
}
