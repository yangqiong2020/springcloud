package yq.filter;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 对异常响应内如处理
 * @author Administrator
 *
 */
@RestController
public class ExceptionHandler implements ErrorController {

	@Override
	public String getErrorPath() {
		System.out.println("getErrorPath------------------");
		return "/error";
	}
	
	@RequestMapping(value="/error")
	public String error(){
		return "{\"result\":\"500 error!!!!\"}";
	}

}
