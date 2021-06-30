package begin.dp;
/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。


 */
public class Rob {
    /**
     * 动态规划的思想，核心是否决定还要继续
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length<=0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[nums.length];//创建一个数组
        int max = dp[0];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);//先确定前两间房子的状态
        for(int i=2;i<nums.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]);//然后就判断直接从前俩个房子中哪个房子的价值最大
        }
        for(int i = 0; i<dp.length; i++){
            if(dp[i]>max){
                max = dp[i];
            }
        }
        return max;
    }
}
