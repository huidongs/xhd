package fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @Author: xhd
 * @Date: 2021-03-25
 * @Desc:
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        //将通道指定交换机
        channel.exchangeDeclare("logs","fanout");

        channel.basicPublish("logs","",null,"fanout type message".getBytes());

        RabbitMQUtils.closeChannelAndConnection(channel,connection);
    }
}
