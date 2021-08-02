package test;

import java.io.OutputStream;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/7/30 11:43
 * @version 1.0
 */
public enum OutCome {

}



interface Item {
    OutCome compare (Item item);
    OutCome eval (Paper p);
    OutCome eval(Scissors s);
    OutCome eval(Rock r);
}

class Paper implements Item {

    @Override
    public OutCome compare(Item item) {
        return null;
    }

    @Override
    public OutCome eval(Paper p) {
        return null;
    }

    @Override
    public OutCome eval(Scissors s) {
        return null;
    }

    @Override
    public OutCome eval(Rock r) {
        return null;
    }
}

class Scissors implements Item {

    @Override
    public OutCome compare(Item item) {
        return null;
    }

    @Override
    public OutCome eval(Paper p) {
        return null;
    }

    @Override
    public OutCome eval(Scissors s) {
        return null;
    }

    @Override
    public OutCome eval(Rock r) {
        return null;
    }
}

class Rock implements Item {

    @Override
    public OutCome compare(Item item) {
        return null;
    }

    @Override
    public OutCome eval(Paper p) {
        return null;
    }

    @Override
    public OutCome eval(Scissors s) {
        return null;
    }

    @Override
    public OutCome eval(Rock r) {
        return null;
    }
}