package helloworld;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
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

    @Test
    public void Send() throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        //获取连接通道
        Channel channel = connection.createChannel();
        //通道绑定对应消息队列
        channel.queueDeclare("hello",false,false,false,null);
        //发布消息
        channel.basicPublish("","hello",null,"hello rabbitmq".getBytes());

       RabbitMQUtils.closeChannelAndConnection(channel,connection);
    }
}
