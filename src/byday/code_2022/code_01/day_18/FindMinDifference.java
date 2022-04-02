package byday.code_2022.code_01.day_18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/1/18 10:18
 * @Tags
 **/
public class FindMinDifference {
    public int findMinDifference(List<String> timePoints) {
        for(int i = 0; i < timePoints.size(); i++) {
            String[] from = timePoints.get(i).split(":");
            for (int j = 1; j < timePoints.size(); j++) {
                String[] to = timePoints.get(i).split(":");

            }
        }


        return -1;
    }
    
    /**
     * @Description: 写两个时间是如何来进行比较的
     * @Author: YORICHEONG 
     * @Date: 10:23 2022/1/18
     **/
    private void compareTime(String[] from, String[] to) {
        Integer hour1 = Integer.parseInt(from[0]);
        Integer hour2 = Integer.parseInt(to[0]);

        
    }

    class Solution {
        
        /**
         * @Description:
         * @Author: YORICHEONG 
         * @Date: 14:20 2022/1/18
         **/
        public int findMinDifference(List<String> timePoints) {
            // 创建14 * 60个boolean数组，然后来进行判断
            boolean[] mark = new boolean[24 * 60];
            for (String time : timePoints) {
                String[] t = time.split(":");
                int h = Integer.parseInt(t[0]);
                int m = Integer.parseInt(t[1]);
                if (mark[h * 60 + m]) return 0;
                mark[h * 60 + m] = true;
            }

            int prev = 0, min = Integer.MAX_VALUE;
            int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
            for (int i = 0; i < 24 * 60; i++) {
                if (mark[i]) {
                    if (first != Integer.MAX_VALUE) {
                        min = Math.min(min, i - prev);
                    }
                    first = Math.min(first, i);
                    last = Math.max(last, i);
                    prev = i;
                }
            }

            min = Math.min(min, (24 * 60 - last + first));

            return min;
        }
    }

    public static void main(String[] args) {
//        List<String> list = new ArrayList<String>();
//        for (int i = 0; i < 9; i++) {
//            list.add("i" + i);
//        }
//        list.add(null);
//        List<String> list2 = null;
//        for(String s : list2) {
//            if(s == null) {
//                System.out.println("find a null");
//            }
//        }
        Long provinceValue = 650000000000L;
        Long cityValue = 659000000000L;
        Long areaValue = 659011000000L;
        Long zero = 5L;

        Integer provinceType = getType(provinceValue);
        Integer cityType = getType(cityValue);
        Integer areaType = getType(areaValue);

        System.out.println(provinceType);
        System.out.println(cityType);
        System.out.println(areaType);

        System.out.println(zero == 5);
        /*
        List<String> removeList;
        int j = list.size() / 3;
        for (int i = 0; i <= j; i++) {
            int maxLimit = i * 3 + 3;
            if(maxLimit > list.size()) {
                maxLimit = list.size();
            }
            removeList = list.subList(i * 3, maxLimit);
            if(removeList.size() == 0) {
                break;
            }
            System.out.println(removeList.size());
        }*/
    }
    private static final Long AREA_FACTOR = 1000000L;
    private static final Long CITY_FACTOR = 100000000L;
    private static final Long PROVINCE_FACOTOR = 10000000000L;

    private static Integer getType(Long value) {
        if(value / AREA_FACTOR > 100000) {
            return 3;
        }else if(value / CITY_FACTOR > 1000) {
            return 2;
        }else if(value / PROVINCE_FACOTOR > 10){
            return 1;
        } else {
            return 0;
        }
    }
}
