package byday.code_2022_01_11;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/11 18:08
 * @Tags
 **/
public class isPalindrome {
    public boolean isPalindrome(int x) {
        String origin = String.valueOf(x);
        StringBuilder sb = new StringBuilder(origin);
        sb = sb.reverse();
        String originNext = sb.toString();

        return origin.equals(originNext);
    }
}
