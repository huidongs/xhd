package priv.huidong.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: xhd
 * @Date: 2021-03-26
 * @Desc:
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class Consumer {

    @RabbitHandler
    public void receiver(String message){
        System.out.println(message);
    }

}
