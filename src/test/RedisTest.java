package test;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/13 15:08
 * @Tags
 **/
public class RedisTest {
    public static void main(String[] args) {
        System.out.println( new RedisTest().redisToString());
    }

    public String redisToString() {
        try {
            return returnString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Test";
    }

    public String returnString() {
        return "yoricheong";
    }
}
