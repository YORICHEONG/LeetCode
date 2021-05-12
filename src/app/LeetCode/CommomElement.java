package app.LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.omg.CORBA.FREE_MEM;

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
        int[] result = new int[list.size()];
        for(int k = 0; k<list.size(); k++){
            result[k] = list.get(k);
        }
        return result;
    }
}
