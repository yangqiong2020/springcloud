package yq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=StreamSenderApplication.class)
public class StreamTest {
	
	@Autowired
	private ISendeService iSendService;
	
	@Test
	public void testSend(){
		Product product = new Product();
		product.setId(100);
		product.setName("Spring Cloud");
		//将消息封装成Message
		Message message = MessageBuilder.withPayload(product).build();
		for(int i=0;i<100;i++){
		this.iSendService.send().send(message);
		}
	}
}
