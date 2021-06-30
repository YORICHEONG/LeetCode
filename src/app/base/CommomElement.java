package app.base;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 */
public class CommomElement {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,2,1};
        int[] b = new int[]{2,2};
        int[] result = new CommomElement().intersect_01(a, b);
        System.out.println(Arrays.toString(result));
    }
    /**
     * 
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect_01(int[] nums1, int[] nums2) {
        //首先对两个数组进行排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<Integer>();
        //分别用两个指标来对两个数组进行遍历比较，将相同的值添加到集合中
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        //将集合转成数组
        int[] result = new int[list.size()];
        for(int k = 0; k<list.size(); k++){
            result[k] = list.get(k);
        }
        return result;
    }
}
