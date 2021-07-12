public class ByteTest {
    public static void main(String[] args) {
        int cnt;
        for (int i = 0; i < 30; i++) {
            int cur = 0;
            if(i < 10) {
                cur = (big >> i) & 1;
                System.out.print(cur);
            } else if(i < 20) {
                cur = (medium >> (i-10)) & 1;
                System.out.print(cur);
            } else if(i < 30) {
                cur = (small << (i-20)) & 1;
                System.out.print(cur);
            }
            cnt += cur == 1 ? 1 << i : 0;
            
            System.out.println(cnt);
        }
    }
}
