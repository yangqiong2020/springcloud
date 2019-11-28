package yq.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import yq.App;
import yq.sender.UserSender;

/**
 * 消息队列测试类
 * @author Administrator
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= App.class)
public class QueueTest {

	@Autowired
	private UserSender sender;
	
	/*
	 * 测试消息队列
	 */
	@Test
	public void test1()throws Exception{
		while(true){
			Thread.sleep(1000);
			this.sender.send("Hello RabbitMQ");
		}
	}
}
