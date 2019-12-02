package yq.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 用户登录权限验证序演示
 * @author Administrator
 *
 */
@Component
public class AccessFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);
	/**
	 * 过滤内容：在run方法编写过滤逻辑
	 */
	@Override
	public Object run() {
		//获取请求上下文
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		logger.info("------------------------pre1-----------------------------");
		//获取表单中的token
		String token = request.getParameter("token");
		//对token做判断
		if(token == null){
			logger.warn("token is null............");
			rc.setSendZuulResponse(false);//代表请求结束。不在继续向下请求
			rc.setResponseStatusCode(401);//添加一个响应的状态码
			rc.setResponseBody("{\"result\":\"token is null\"}");//响应内容
			rc.getResponse().setContentType("text/html;charset=utf-8");//响应类型
		}else{
			//访问redis服务 进行验证
			logger.info("token is OK");
			rc.setResponseBody("{\"result\":\"token is ok\"}");//响应内容
			rc.getResponse().setContentType("text/html;charset=utf-8");//响应类型
		}
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
