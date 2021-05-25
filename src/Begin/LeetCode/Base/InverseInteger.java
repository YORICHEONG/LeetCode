package Begin.LeetCode.Base;
/**
 *  给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
    如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 */
public class InverseInteger {
    public int solution(int x){
        long res = 0;//定义变量用来存储反转值，为了考虑超过Int类型大小的情况，使用Long类型
        while(x!=0){//进行一个循环，然后数字反转
            res = res*10+x%10;
            x/=10;
        }    
        /**
         * 判断结果是否超过Int类型的边界
         */
        if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE){//这个判断也可以放在循环中
            return 0;
        }
        return (int)res;
    }
}
