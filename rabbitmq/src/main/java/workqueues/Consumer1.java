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
public class Consumer1 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        //创建通道
        final Channel channel = connection.createChannel();
        channel.basicQos(1);
        //通道绑定队列
        channel.queueDeclare("workqueues",false,false,false,null);
        //消费消息
        channel.basicConsume("workqueues",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者-1: "+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });

    }
}
