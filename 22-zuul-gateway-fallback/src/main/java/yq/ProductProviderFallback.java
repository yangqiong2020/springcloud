package yq;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
/**
 * 对Provider-Product服务降级处理
 * @author Administrator
 *
 */
@Component
public class ProductProviderFallback implements ZuulFallbackProvider {

	/**
	 * 当服务无法执行时，该方法返回托底信息
	 */
	@Override
	public ClientHttpResponse fallbackResponse() {
		
		return new ClientHttpResponse() {
			
			/**
			 * 设置响应的头信息
			 */
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders header = new HttpHeaders();
				MediaType mt = new MediaType("application","json",Charset.forName("utf-8"));
				header.setContentType(mt);
				return header;
			}
			
			/**
			 * 设置响应体
			 */
			@Override
			public InputStream getBody() throws IOException {
				String content = "订单服务不可用，请与管理员联系";
				return new ByteArrayInputStream(content.getBytes());
			}
			
			/**
			 * ClientHttpResponse的fallback的状态码 返回String
			 */
			@Override
			public String getStatusText() throws IOException {
				return this.getStatusCode().getReasonPhrase();
			}
			
			/**
			 * ClientHttpResponse的fallback的状态码 返回HttpStatus
			 */
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return HttpStatus.OK;
			}
			
			/**
			 * ClientHttpResponse的fallback的状态码 返回int
			 */
			@Override
			public int getRawStatusCode() throws IOException {
				return this.getStatusCode().value();
			}
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}

	/**
	 * 给定对哪个服务做降级处理
	 */
	@Override
	public String getRoute() {
		return "e-book-order-provider";
	}

}
