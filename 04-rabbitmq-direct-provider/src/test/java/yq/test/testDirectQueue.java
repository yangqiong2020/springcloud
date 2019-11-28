package yq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yq.App;
import yq.sender.logSender;


@RunWith(SpringRunner.class)
@SpringBootTest(classes= App.class)
public class testDirectQueue {
    @Autowired
    private logSender sender;

    /*
     * 测试消息队列
     */
    @Test
    public void test1()throws Exception{
        int i=0;
        while(true){
            Thread.sleep(1000);
            this.sender.send("Hello RabbitMQ"+(i++));
        }
    }
}
