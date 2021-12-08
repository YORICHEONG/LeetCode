package byday.code_2021_10_30;

/**
 * @Description 给定一个非负整数 N，
 * 找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * @Author YORICHEONG
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021-10-30
 */
public class MonotoneIncreasingDigits {

    /**
     * 这个问题的关键是如果遇到不满足的状态下要如何来处理
     * 如何找到这个满足递增且最大的
     * 从后往前来进行
     * @param n
     * @return
     */
    public int monotoneIncreasingDigits(int n) {
        if(n < 10) {
            return n;
        }
        if(n == 10) {
            return 9;
        }

        char[] numberChar = String.valueOf(n).toCharArray();
        boolean isSmaller = false;
        int changeIndex = numberChar.length;
        for (int i = numberChar.length - 1; i > 0; i--) {
            if(numberChar[i] < numberChar[i - 1]) {
                numberChar[i - 1] = (char) (numberChar[i - 1] - 1);
                numberChar[i] = '9';
                changeIndex = i;
            }

        }
        for (int i = changeIndex + 1; i < numberChar.length; i++) {
            numberChar[i] = '9';
        }
        
        Integer result = Integer.valueOf(String.valueOf(numberChar));

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(332));

    }
}
