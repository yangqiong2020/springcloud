package yq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import yq.App;
import yq.sender.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class testQueue {
    @Autowired
    private Sender sender;
    /**
     * 测试消息队列
     */
    @Test
    public void test1(){
//        while(true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.sender.send("hello-rabbitmq");
//        }
    }
}
