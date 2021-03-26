package direct;

import com.rabbitmq.client.*;
import utils.RabbitMQUtils;

import java.io.IOException;

/**
 * @Author: xhd
 * @Date: 2021-03-26
 * @Desc:
 */
public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();

        Channel channel = connection.createChannel();

        channel.exchangeDeclare("logs_direct","direct");

        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,"logs_direct","error");
        channel.queueBind(queueName,"logs_direct","info");

        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumer 2:"+new String(body));
            }
        });
    }
}
