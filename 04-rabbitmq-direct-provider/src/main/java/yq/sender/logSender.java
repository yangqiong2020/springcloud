package yq.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 */
@Component
public class logSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    //交换器的名称
    @Value("${mq.config.exchange}")
    private String exchange ;
    //routingkey 路由键
    @Value("${mq.config.queue.info.routing.key}")
    private String routingKey;

    /**
     * 发送消息的方法
     */

    public void send(String msg){
        //向消息队列发送消息
        //参数一：交换器名称
        //参数二：路由键
        //参数三：消息
        this.amqpTemplate.convertAndSend(this.exchange,this.routingKey,msg);
    }

}
