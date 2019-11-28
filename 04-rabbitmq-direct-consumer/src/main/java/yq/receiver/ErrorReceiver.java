package yq.receiver;


import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 消息接受者
 * @RabbitListener bindings ：绑定队列
 * @QueueBinding value:绑定队列的名称
 *                 exchange:配置交换器
 *
 * @Queue value：配置队列名称
 *          autoDelete:是否是一个可删除的临时队列
 *
 * @Exchange  value:为交换器起个名字
 *              type:指定具体的交换器类型
 */
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.config.queue.error}",autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),
                key="${mq.config.queue.error.routing.key}"
        )
)
@Component
public class ErrorReceiver {
    /**
     * 接受消息的方法，采用消息队列监听机制
     */
    @RabbitHandler
    public void process(String msg){
        System.out.println("error........receiver:"+msg);
    }
}
