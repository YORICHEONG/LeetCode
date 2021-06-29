package higher.StringArray;

import java.math.RoundingMode;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/**
 * @author YORICHEONG
 * @date 2021-06-29 18:05:53
 * @description 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 *  在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int start = 0;
        int end = height.length-1;
        if(height.length == 2){
            return getArea(height, 0, 1);
        }
        while(start < end) {
           int currentArea = getArea(height, start, end);
           maxArea = Math.max(currentArea, maxArea);
           if(height[start] <= height[end]) {
               start++;
           } else {
               end--;
           }
        }
        return maxArea;
    }

    private int getArea(int[] height, int start, int end) {
        return Math.min(height[start],height[end]) * (end-start);
    }
}
