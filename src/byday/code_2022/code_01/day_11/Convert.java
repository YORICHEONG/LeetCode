package byday.code_2022.code_01.day_11;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/11 14:36
 * @Tags
 **/
public class Convert {
    public String convert(String s, int numRows) {
        // 对于一个String字符串，然后寻找一个规律，然后可以对这个字符串进行一次的遍历，然后就可以判断每个字符串的对应于行
        if(numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean isDown = false;
        for(char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if(curRow == 0 || curRow == numRows - 1) {
                isDown = !isDown;
            }
            curRow += isDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder stringBuilder : rows) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }
}
/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 然后对于这个Z字行，然后按行来进行遍历
 */