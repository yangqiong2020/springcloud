package yq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface ISendeService {
	String OUTPUT="outputProduct";
	
	@Output(OUTPUT)
	SubscribableChannel send();
}
