package yq.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class LogFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);
	/**
	 * 过滤内容：在run方法编写过滤逻辑
	 */
	@Override
	public Object run() {
		//获取请求上下文
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		logger.info("LogFilter.....method={},url={}",request.getMethod(),request.getRequestURL().toString());
		return null;
	}

	/**
	 * 是否开启过滤器：默认为false不开启
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 过滤器的执行顺序：通过整数表示顺序，数值越小，优先级越高
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 过滤器类型：通过过滤器类型决定了过滤器执行的时间
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
