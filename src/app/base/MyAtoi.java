package app.base;
/*
author：YORICHOENG
*/
public class MyAtoi {
    public int solution(String s){
        String context = s.trim();//首先进行一个字符串的清空的炒
        if(context.length()==0){
            return 0;
        }
        int index = 0;
        int result = 0;
        int sign = 1;
        int length = context.length();
        
        if(context.charAt(index)=='-'||context.charAt(index)=='+'){
            sign = context.charAt(index++)=='+'?1:-1;
        }
        for(;index<length; ++index){
            int digit = context.charAt(index)-'0';

            if(digit<0||digit>9){
                break;
            }
            /**
            进行一个边界的处理判断
            **/
            if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&digit>Integer.MAX_VALUE%10)){
                return  sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }else{
                result =  result*10+digit;
            }
        }
        return sign*result;
    }
}
