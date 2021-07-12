package test;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-12 10:25
 */

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/12 10:25
 * @version 1.0
 */
public class ByteTest {
    int cnt;
    public ByteTest(int big, int medium, int small) {
        for (int i = 0; i < 30; i++) {
            int cur = 0;
            if(i < 10) {
                System.out.println("join the i < 10");
                cur = (big >> i) & 1;
                System.out.println(cur);
            } else if(i < 20) {
                System.out.println("join the i < 20");
                cur = (medium >> (i-10)) & 1;
                System.out.println(cur);
            } else if(i < 30) {
                System.out.println("join the i < 30");
                cur = (small << (i-20)) & 1;
                System.out.println(cur);
            }
            cnt += cur == 1 ? 1 << i : 0;
            System.out.println(cnt);
        }
    }
    public static void main(String[] args) {
        int big= 5;
        int medium = 1;
        int small = 0;

        System.out.println("big>>0 " + ((big >> 0) & (1)));
        new ByteTest(big,medium,small);
    }
}
