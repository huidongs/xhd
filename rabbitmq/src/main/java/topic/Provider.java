package topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @Author: xhd
 * @Date: 2021-03-26
 * @Desc:
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics","topic");

        String routeKey = "user.save";

        channel.basicPublish("topics",routeKey,null,("这是tipic路由模型，routekey:"+routeKey).getBytes());
        RabbitMQUtils.closeChannelAndConnection(channel,connection);
    }
}
