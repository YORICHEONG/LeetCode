package test;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-07-30 11:06
 */

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/30 11:06
 * @version 1.0
 */
public class EmunTest {
    public static void main(String[] args) {
        System.out.println(Color.valueOf("BLACK"));
    }
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