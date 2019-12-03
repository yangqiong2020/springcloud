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
		for(int i=0;i<10;i++){
		product.setId(i);
		product.setName("Spring Cloud"+i);
			//将消息封装成Message
			Message message = MessageBuilder.withPayload(product).build();
			this.iSendService.send().send(message);
		}
		
	}
}
