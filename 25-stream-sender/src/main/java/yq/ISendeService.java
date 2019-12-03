package yq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface ISendeService {

	@Output("yangqiong-exchange")
	SubscribableChannel send();
}
