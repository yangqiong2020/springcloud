package yq;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface IReceiveService {

	@Input("yangqiong-exchange")
	SubscribableChannel receive();
}
