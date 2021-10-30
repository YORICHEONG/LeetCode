package byday.code_2021_10_30;

/**
 * @Description 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 *
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2021/10/30 11:31
 * @Tags
 **/
public class LemonadeChange {
    /**
     * @Description: 这个更多的是一个逻辑题
     * @Author: YORICHEONG 
     * @Date: 11:49 2021/10/30
     **/
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int value : bills) {
            if(value == 5) {
                five++;
            } else if(value == 10) {
                five --;
                ten ++;
            } else if(ten > 0) {
                ten --;
                five --;
            } else {
                five -= 3;
            }
            if(five < 0) {
                return false;
            }
        }
        return true;
    }
}
