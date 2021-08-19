package top100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
        TimeUnit unit;
        BlockingQueue workQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(20, 50, 60, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 1000000; i++) {
            
        }
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