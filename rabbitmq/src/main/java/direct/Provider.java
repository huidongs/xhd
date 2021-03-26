package direct;

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

        channel.exchangeDeclare("logs_direct","direct");
        String routingKey = "info";
        channel.basicPublish("logs_direct",routingKey,null,("message Test"+routingKey).getBytes());

        RabbitMQUtils.closeChannelAndConnection(channel,connection);

    }
}
