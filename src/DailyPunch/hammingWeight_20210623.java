package DailyPunch;

public class hammingWeight_20210623 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 对于进制问题需要的位运算
        int result = 0;
        while(n != 0) {
            result += n&1;
            n >>>= 1;
        }
        return result;
    }
}
