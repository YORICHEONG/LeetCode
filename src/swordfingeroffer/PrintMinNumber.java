package swordfingeroffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/7/4 13:55
 * @Tags
 **/
public class PrintMinNumber {

    public static void main(String[] args) {
        System.out.println(PrintMinNumber.PrintMinNumber(new int[] {1,2,3,4,5,6,9,8}));
    }

    public static String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String var1 = o1 + "" + o2;
                String var2 = o2 + "" + o1;
                return var1.compareTo(var2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Integer value : list) {
            sb.append(value);
        }

        return sb.toString();
    }
}
