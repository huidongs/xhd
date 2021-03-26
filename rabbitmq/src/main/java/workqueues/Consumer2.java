package workqueues;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author: xhd
 * @Date: 2021-03-09
 * @Desc:
 */
public class Consumer2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQUtils.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //通道绑定队列
        channel.queueDeclare("workqueues",false,false,false,null);
        //消费消息
        channel.basicConsume("workqueues",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者-2: "+new String(body));            }
        });

    }
}
