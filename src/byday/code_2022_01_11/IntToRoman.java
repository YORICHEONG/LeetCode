package byday.code_2022_01_11;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/11 18:12
 * @Tags
 **/
public class IntToRoman {

    Map<Integer, String> romanTable = new HashMap<Integer, String>();

    public String intToRoman(int num) {
        // 进行数据的填充
        romanTable.put(1, "I");
        romanTable.put(5, "V");
        romanTable.put(10, "X");
        romanTable.put(50, "L");
        romanTable.put(100, "C");
        romanTable.put(500, "D");
        romanTable.put(1000, "M");
        romanTable.put(4, "IV");
        romanTable.put(9, "IX");
        romanTable.put(40, "XL");
        romanTable.put(90, "XC");
        romanTable.put(400, "CD");
        romanTable.put(900, "CM");

        int origin = 1000;
        int temp = num;

        while(temp / origin > 0) {
            
        }

        return null;
    }
}
