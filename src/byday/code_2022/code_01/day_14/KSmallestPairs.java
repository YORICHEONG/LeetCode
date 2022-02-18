package byday.code_2022.code_01.day_14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/14 13:46
 * @Tags
 **/
public class KSmallestPairs {
    /**
     * @Description: use the matrix to find the result
     * @Author: YORICHEONG 
     * @Date: 14:55 2022/1/14
     **/
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList();
        int m = nums1.length;
        int n = nums2.length;
        if(m == 0 || n == 0 || k < 1) {
            return list;
        }
        PriorityQueue<Data> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.value));
        // 首先直接将最开始的添加到这个队列中
        heap.offer(new Data(0, 0, nums1[0] + nums2[0]));

        while(!heap.isEmpty() && k >0) {
            Data d = heap.poll();
            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[d.i]);
            pair.add(nums2[d.j]);
            list.add(pair);
            k--;

            // add next column value
            if(d.j < n - 1) {
                heap.offer(new Data(d.i, d.j + 1, nums1[d.i] + nums2[d.j + 1]));
            }
            // add store the next row value
            if(d.j == 0 && d.i < m - 1) {
                heap.offer(new Data(d.i + 1, 0, nums1[d.i + 1] + nums2[0]));
            }

        }
        return list;
    }
    class Data {
        int i;
        int j;
        int value;
        public Data(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }

    class Solution{
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] + a[0] - b[0] - b[1]);
            List<List<Integer>> result = new ArrayList<>();
            if(nums1.length == 0 || nums2.length == 0 || k == 0) {
                return result;
            }
            // 然后遍历nums1的所有元素，nums2固定为元素1，然后以这样的组合全部加入到队列中
            for (int i = 0; i < nums1.length && i < k; i++) {
                queue.offer(new int[]{nums1[i], nums2[0], 0});
            }
            while(k-- > 0 && !queue.isEmpty()) {
                int[] cur = queue.poll();
                List<Integer> temp = new ArrayList<>();
                temp.add(cur[0]);
                temp.add(cur[1]);
                result.add(temp);
                if(cur[2] == nums2.length - 1) {
                    continue;
                }
                queue.offer(new int[]{cur[0], cur[cur[2] + 1], cur[2] + 1});
            }
            return result;
        }
    }

    public static void main(String[] args) {

    }

}
/**
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2,以及一个整数 k。
 *
 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
 *
 * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
 */