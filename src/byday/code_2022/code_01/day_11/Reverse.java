package byday.code_2022.code_01.day_11;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/11 15:00
 * @Tags
 **/
public class Reverse {
    public int reverse(int x) {
        String math = Integer.toString(x);
        long number = 0;
        boolean isNative = false;
        boolean isLastZero = true;
        for (int i = math.length() - 1; i >= 0; i--) {
            if(math.charAt(i) == '0' && isLastZero) {
                continue;
            } else if(math.charAt(i) == '-') {
                isNative = true;
            } else {
                number = number * 10 + math.charAt(i) - '0';
                isLastZero = false;
            }
        }
        if(isNative) {
            number = -number;
        }
        if(number > Integer.MAX_VALUE || number < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)number;
    }

    public static void main(String[] args) {
        int math = -120;
        System.out.println(Integer.toString(math));
    }
}
