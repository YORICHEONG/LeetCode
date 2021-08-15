package top100;

/**
 * @Description
 * @Author YORICHEONG
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021-08-15
 */
public class MaxArea {
    /**
     * 盛最多水的容器
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if(height[left] <= height[right]) {
                ++left;
            } else {
                --right;
            }
        }
        return ans;
    }
}
