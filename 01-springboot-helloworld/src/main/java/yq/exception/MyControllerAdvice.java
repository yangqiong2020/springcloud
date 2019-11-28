package yq.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice {

	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public Map<String, Object> myException(Exception ex) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", 500);
		map.put("msg", "出错了。");
		return map;
	}
	
	@ResponseBody
	@ExceptionHandler(value=NullPointerException.class)
	public Map<String, Object> myException2(Exception ex) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", -500);
		map.put("msg", "空指针异常");
		return map;
	}
	
	@ResponseBody
	@ExceptionHandler(value=yq.exception.ApplicationException.class)
	public Map<String, Object> myException3(Exception ex) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", -800);
		map.put("msg", ex.getMessage());
		return map;
	}
	
	
}
