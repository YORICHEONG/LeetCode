package app.LeetCode;

import java.util.*;

public class PlushOneArray{
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if(digits[length-1]!=9){//如果最后一位不为9，就直接将最后一位加一然后返回这个数组
            digits[length-1] = digits[length-1]+1;
            return digits;
        }else{
            //然后判断其他的数组中的是否全部为9
            boolean flag = true;
            for(int i = 0; i<digits.length; i++){
                if(digits[i]!=9){
                    flag = false;
                }
            }
            if(flag){
                int[] result = new int[length+1];
                result[0] = 1;
                return result;
            }else{
                //如果最后一位是9
                if(digits[length-1]==9){
                    for(int i = length-1; i>0; i--){
                        if(digits[i]==9){//如果当前位为9 9+1 = 10
                            digits[i] = 0;//将当前位设为0
                            if(digits[i-1]+1==10){//然后在判断当前位的前一位加上进位是否为10
                                digits[i-1] = 9; //设置当前位前一位为9
                            }else{
                                digits[i-1] = digits[i-1]+1;//如果前一位不是为10，则直接将当前位的前一位加1然后跳出遍历
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                }
            }
        }
        return digits;
    }
}