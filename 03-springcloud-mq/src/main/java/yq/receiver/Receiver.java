package yq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 */
@Component
public class Receiver {

    /**
     * 接受消息的方法，采用消息队列监听机制
     */
    @RabbitListener(queues = "hello-queue")
    public  void process(String msg){
        System.out.println("receiver"+msg);
    }
}
