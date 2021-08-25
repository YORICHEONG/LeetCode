package top100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description:
 * @author YORICHEONG
 * @date 2021/8/19 10:47
 * @version 1.0
 */
public class GenerateParenthesis {
    /**
     * @param: n
     * @description :
     * @return : java.util.List<java.lang.String>
     * @author : YORICHEONG
     * @date : 2021/8/19
     */
    public List<String> generateParenthesis(int n) {
        return null;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("23");
        list.add("234");
        list.add("234253");
        list.add("78");
        list.add("56");
        Map<String, Double> map = list.stream().collect(Collectors.toMap(Function.identity(), s -> (double)(int)System.currentTimeMillis()));
        List<Map<String, Double>> result = splitMap(map, 1);
        for (Map<String, Double> m: result) {
            System.out.println(m.toString());
        }
//        List<Map<String, Double>> result = splitAppIdArray(,3, (int)System.currentTimeMillis() / 1000);
//        for (Map<String, Double> map: result) {
//            System.out.println(map.size());
//            System.out.println(map.toString());
//            System.out.println("==================");
//        }
    }


    public static List<Map<String, Double>> splitMap(Map<String, Double> chunkMap, int chunkNum) {
        if (chunkMap == null || chunkMap.size() == 0 || chunkNum <= 0) {
            return null;
        }
        int i = 1;
        List<Map<String, Double>> total = new ArrayList<>();
        Map<String, Double> tem = new HashMap<>();
        for(Map.Entry<String, Double> entry : chunkMap.entrySet()) {
            tem.put(entry.getKey(), entry.getValue());
            if(i == chunkNum) {
                total.add(tem);
                tem = new HashMap<>();
                i = 0;
            }
            i++;
        }
        if (!(tem == null || tem.isEmpty())) {
            total.add(tem);
        }

        return total;
    }

}

class Task implements Runnable {

    private String requestUrl;
    private int index;

    public Task(String url, int index) {
        this.requestUrl = url;
        this.index = index;
    }

    public void init() throws IOException {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        try {
            // 创建远程url连接对象
            URL url = new URL(requestUrl);
            // 通过远程url连接对象打开一个连接，强转成httpURLConnection类
            connection = (HttpURLConnection) url.openConnection();
            // 设置连接方式：get
            connection.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15000毫秒
            connection.setConnectTimeout(15000);
            // 设置读取远程返回的数据时间：60000毫秒
            connection.setReadTimeout(60000);
            // 发送请求
            connection.connect();
            // 通过connection连接，获取输入流
            if (connection.getResponseCode() == 200) {
                System.out.println("Thread " + index + "连接成功");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.disconnect();// 关闭远程连接
        }
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {

            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}