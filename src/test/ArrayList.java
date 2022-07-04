package test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author YORICHEONG yoricheong@gmail.com precent99@qq.com
 * @Date 2022/5/6 11:28
 * @Tags
 **/
public class ArrayList {
    public static void main(String[] args) throws IOException {


    }

    private static void testSwitch(int list) {
        switch (list) {
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("pre 4");
                break;
                default:
                break;
        }
    }

}
