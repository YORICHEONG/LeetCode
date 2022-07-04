package test;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-30 11:06
 */

import java.io.File;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/30 11:06
 * @version 1.0
 */
public class EmunTest {
    private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'+'SSSS");

    private static final DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ParseException {
        String all = "3161875,2681124,2323514,3129215,3129299,3177519,3184733,3227688,3316002,3072599,3355289,3352535,3335774,3327079,3272652,3186797,3332284,3370721,3185912,3190157,3128366,3239668,3403739,3324318,3328518,3368997,3405091,3378277,3369524,3363092,3368997,3359365,3350486,3270973,3238739,3213404,3198411,3163955,2897832,2524875,3076498";
        String part = "3190157,3239668,3332284,3129299,3185912,3076498,2897832,3403739,3363092,3316002,3161875,3129215,3327079,2323514,3184733,3128366,3368997,3405091,3369524,2681124,3186797,3227688,3072599,3324318,3378277,2524875,3335774,3350486,3272652,3328518,3370721,3352535,3355289,3213404";

        String[] allList = all.split(",");
        List<Integer> allLists = new java.util.ArrayList<>();
        for(String s : allList) {
            allLists.add(Integer.parseInt(s));
        }

        String[] partlist = part.split(",");
        List<Integer> partLists = new java.util.ArrayList<>();
        for(String s : partlist) {
            partLists.add(Integer.parseInt(s));
        }

        HashSet<Integer> allset = new HashSet<>(allLists);
        HashSet<Integer> partSet = new HashSet<>(partLists);

        allset.removeAll(partSet);

        for(Integer a : allset) {
            System.out.println(a);
        }
    }

    public static void receive(double max) {
        System.out.println(max);
    }
}

class LongTest{
    Long Value;
}

enum Color {
    BLACK("one"), BLUE("two"), RED("three"), YELLOW("four");

    private String colorName;

    Color (String colorName) {
         this.colorName = colorName;
    }
}

enum Status {
    A {
        @Override
        void process(Product product) {
            System.out.println("Join the B");
            product.status = B;
            System.out.println("Transfer to A");
        }
    },
    B {
        @Override
        void process(Product product) {
            System.out.println("Join the A");
            product.status = A;
            System.out.println("Transfer to B");
        }
    };
    abstract void process (Product product);
}
class Product {
    public Status status = Status.A;

    public void make() {
        status.process(this);
    }
}