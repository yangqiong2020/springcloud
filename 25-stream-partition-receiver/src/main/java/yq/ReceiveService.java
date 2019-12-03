package yq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * 处理消息的类
 * @author Administrator
 *
 */
@Service
@EnableBinding({IReceiveService.class})
public class ReceiveService {

	@StreamListener(IReceiveService.INPUT)
	public void onReceive(Product product){
		//处理消息
		System.out.println("Receiver 0: "+product.toString());
	}
}
