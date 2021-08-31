package frame.dubbo.spi;/**
 * @Description
 * @author YORICHEONG
 * @create 2021-08-25 17:02
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @description: TODO
 * @author YORICHEONG
 * @date 2021/8/25 17:02
 * @version 1.0
 */
public class SPITest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);

        Iterator<SPIService> iterator = load.iterator();
        while(iterator.hasNext()) {
            SPIService service = iterator.next();
            service.execute();
        }
        String url = "test";
        String user = "user";
        String password = "password";
        Class.forName("com.mysql.jdbcDriver");
        Connection connection = DriverManager.getConnection(url, user, password);

    }
}
