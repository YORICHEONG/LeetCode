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
        if(nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            return null;
        }
        boolean flag = nums1.length<nums2.length?true:false;
        int length = nums1.length<nums2.length?nums1.length:nums2.length;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int[] firstArray;
        int[] lastArray;
        List<Integer> result = new ArrayList<Integer>();
        if(true){
            firstArray = nums1;
            lastArray = nums2;
        }else{
            firstArray = nums2;
            lastArray = nums1;
        }
        for(int i = 0; i<length; i++){
            set1.add(firstArray[i]);
        }
        for(int i =0; i<lastArray.length; i++){
            set2.add(lastArray[i]);
        }
        for(Integer number:set2){
            if(!set1.add(number)){
                result.add(number);
            }
        }
        int[] result1 = new int[result.size()];
        System.out.println(result.size());
        for(int i = 0; i<result.size(); i++){
            result1[i] = result.get(i);
        }
        return result1;
    }
}
