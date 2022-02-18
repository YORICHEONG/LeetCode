package byday.code_2022.code_01.day_11;

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

        String[] symbols = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < symbols.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while(num >= value) {
                num -= value;
                sb.append(symbol);
            }
            if(num == 0) {
                break;
            }
        }

        return sb.toString();
    }
}
