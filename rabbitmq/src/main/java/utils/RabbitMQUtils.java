package utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author: xhd
 * @Date: 2021-03-09
 * @Desc:
 */
public class RabbitMQUtils {
    private static ConnectionFactory connectionFactory;
    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("139.196.196.1");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("huidong");
        connectionFactory.setPassword("huidong");
    }
    /**
     * @Description:获取connection
     * @Param: []
     * @return: com.rabbitmq.client.Connection
     * @Author: xhd
     * @Date: 2021-03-09
     */
    public static Connection getConnection() {
        try {
            return connectionFactory.newConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description:关闭Channel,Connection连接
     * @Param: [channel, conn]
     * @return: void
     * @Author: xhd
     * @Date: 2021-03-09
     */
    public static void closeChannelAndConnection(Channel channel, Connection conn) {
        try {
            if (channel != null) {
                channel.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
