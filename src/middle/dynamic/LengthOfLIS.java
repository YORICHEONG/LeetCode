package middle.dynamic;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 2021-06-24 10:28:20
 * author：YORICHEONG
 */
public class LengthOfLIS {
    /**
     * 使用动态规划的方法
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        // 然后创建一个数组来记录当前位置的最长递增序列个数
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        // 进行遍历，查找最大的值
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    // 然后来进行更新
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            // 实时更新最长的子序列个数
            res = Math.max(res, dp[i]);
        }
        // 最后的就是当前位置的最长的递增子序列
        return res;

    }

    public static void main(String[] args) throws ParseException {
        Map<String, String> params = new HashMap<>();
        params.put("sdkuid", "1234545");
        params.put("status", "0");
        params.put("timestamp", String.valueOf(System.currentTimeMillis()/1000));
        System.out.println(params.get("timestamp"));
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getValue());
        }
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec("v2d3e6h32i2r62xlw82vf334ua18x6m8".getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            String hash = byteArrayToHexString(sha256_HMAC.doFinal(sb.toString().getBytes()));
            System.out.println(hash);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
        }
    }

    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();

        for(int i = 0; i < b.length; ++i) {
            resultSb.append(byteToHexString(b[i], true));
        }

        return resultSb.toString();
    }
    private static final String[] hexDigits = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    private static String byteToHexString(byte b, boolean bigEnding) {
        int n = b;
        if (b < 0) {
            n = 256 + b;
        }

        int d1 = n / 16;
        int d2 = n % 16;
        return bigEnding ? hexDigits[d1] + hexDigits[d2] : hexDigits[d2] + hexDigits[d1];
    }
}



