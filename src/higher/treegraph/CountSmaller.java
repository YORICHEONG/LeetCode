package higher.treegraph;

import java.util.*;

/**
 * @description: 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * @author YORICHEONG
 * @date 2021/7/26 11:10
 * @version 1.0
 */
public class CountSmaller {

    private int[] c;

    private int[] a;

    /**
     * @param: nums
     * @description : 使用离散化树状数组来进行动态维护前缀和数据结构
     * @return : List<Integer>
     * @author : YORICHEONG
     * @date : 2021/7/26
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length-1; i >= 0; --i) {
            int id = getId(nums[i]);
            resultList.add(query(id-1));
            update(id);
        }
        Collections.reverse(resultList);
        return resultList;
    }

    /**
     * @param: length
     * @description : 初始化一个数组，并且所有的初始值为0
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/7/26
     */
    private void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    /**
     * @param: x
     * @description :
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/7/26
     */
    private int lowBit(int x) {
        return x & (-x);
    }

    /**
     * @param: pos
     * @description :
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/7/26
     */
    private void update(int pos) {
        while(pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    /**
     * @param: pos
     * @description :
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/7/26
     */
    private int query(int pos) {
        int ret = 0;
        while(pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }
        return ret;
    }

    /**
     * @param: nums
     * @description :
     * @return : void
     * @author : YORICHEONG
     * @date : 2021/7/26
     */
    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    /**
     * @param: x
     * @description :
     * @return : int
     * @author : YORICHEONG
     * @date : 2021/7/26
     */
    private int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }
}
