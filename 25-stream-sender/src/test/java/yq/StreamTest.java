package yq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import yq.ISendeService;
import yq.StreamSenderApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= StreamSenderApplication.class)
public class StreamTest {
	
	@Autowired
	private ISendeService iSendService;
	
	@Test
	public void testSend(){
		String msg = "yangqiong............";
		//将消息封装成Message
		Message message = MessageBuilder.withPayload(msg.getBytes()).build();
		int i=1;
		while(true){
			i++;
			this.iSendService.send().send(message);
			if(i==1000){
				break;
			}
		}
	}
}
