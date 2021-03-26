package priv.huidong;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RabbitMQApplication.class)
@RunWith(SpringRunner.class)
public class RabbitMQTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void Test(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }
}
