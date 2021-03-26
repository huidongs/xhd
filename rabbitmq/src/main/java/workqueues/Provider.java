package workqueues;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.Test;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @AUTHOR: xhd
 * @DATE: 2021-03-09
 * @Desc:
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("workqueues", false, false, false, null);
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("", "workqueues", null, (i+": Work Queues!").getBytes());
        }
        RabbitMQUtils.closeChannelAndConnection(channel, connection);
    }
}
