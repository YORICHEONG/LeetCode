package byday.code_2022.code_01.day_10;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/10 13:58
 * @Tags
 **/
public class isAdditiveNumber {
    
    /**
     * @Description:
     * @Author: YORICHEONG 
     * @Date: 14:14 2022/1/10
     **/
    public boolean isAdditiveNumber(String num) {
        if(num.length() < 3) {
            return false;
        }
        for (int i = 2; i < num.length(); i++) {
            int currentValue = num.charAt(i) - '0';
            int preValue = num.charAt(i - 1) - '0';
            int prePreValue = num.charAt(i - 2) - '0';
            if(currentValue != (preValue + prePreValue)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String testValue = "112358";
        System.out.println(new isAdditiveNumber().isAdditiveNumber(testValue));
    }
}

/**
 * An additive number is a string whose digits can form an additive sequence.
 *
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers,
 *
 * each subsequent number in the sequence must be the sum of the preceding two.
 *
 * Given a string containing only digits, return true if it is an additive number or false otherwise.
 *
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 */
class solution {
    // 199100199
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        // 采用一个双循环
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((i > 0 && num.charAt(0) == '0') || (j > i + 1 && num.charAt(i + 1) == '0')) continue;
                long i0 = Long.parseLong(num.substring(0, i + 1));
                long i1 = Long.parseLong(num.substring(i + 1, j + 1));
                if (j + 1 >= n) break;
                if (dfs(i0, i1, num, 0, j + 1)) return true;
            }
        }
        return false;
    }

    public boolean dfs(long i, long j, String num, long cur, int index) {
        cur = cur * 10 + num.charAt(index) - '0';
        if (cur == i + j) {
            if (index == num.length() - 1) return true;
            else return dfs(j, cur, num, 0, index + 1);
        } else if (cur != 0 && cur < i + j && index < num.length() - 1) {
            return dfs(i, j, num, cur, index + 1);
        } else return false;
    }
}