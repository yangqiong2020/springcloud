package com.bjsxt;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	public static String doGet(String url, Map<String, String> param) {

		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建uri
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);

			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状�?是否�?00
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	public static String doGet(String url) {
		return doGet(url, null);
	}

	public static String doPost(String url, Map<String, String> param) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建参数列表
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				// 模拟表单
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,"utf-8");
				httpPost.setEntity(entity);
			}
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}

	public static String doPost(String url) {
		return doPost(url, null);
	}
	
	public static String doPostJson(String url, String json) {
		// 创建Httpclient对象
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			// 创建Http Post请求
			HttpPost httpPost = new HttpPost(url);
			// 创建请求内容
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			// 执行http请求
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultString;
	}
	
	public static void main(String[] args) {
		//刷新配置
//		String url ="http://127.0.0.1:9051/refresh";
//		String info = HttpClientUtil.doPost(url);
//		System.out.println(info);
		//-----------------------对称加密
		//加密字符
//		String eurl = "http://127.0.0.1:9050/encrypt";
//		String einfo = HttpClientUtil.doPostJson(eurl,"root");
//		System.out.println(einfo+"   --------------");
		//解密字符
//		String durl = "http://127.0.0.1:9050/decrypt";
//		//83084e7d3b76442ee2339854da5b76d66e5192b0954546d1176018fa910c92b5
//		String dinfo = HttpClientUtil.doPostJson(durl,"83084e7d3b76442ee2339854da5b76d66e5192b0954546d1176018fa910c92b5");
//		System.out.println(dinfo+"   ==============");
		//======================非对称加密
//		String url1 =  "http://127.0.0.1:9050/encrypt";
//		String info1 =  HttpClientUtil.doPostJson(url1,"root");
//		System.out.println(info1);

		String url =  "http://127.0.0.1:9050/decrypt";
		String info =  HttpClientUtil.doPostJson(url,"AQBJ4seGMcywWCIhGZ7FtkpZTfCDu2uAlLmFprs69k4qLcgOTZoU7WbTmy22b8yhdnPRz4fM3ublj8NFT+s/W4JcGKm5VWHWj+jNNoeqmiUT+bwpkPb/6xFvuBf/bc4iVo/wxEWjvQfNF9nFIwBglm6buihuwEfrQGtNmQ7u1ZRuBvgmK6FQbYy0JCCrK7PnDqbqSr94uDv/iOBvMM4WXTdrSZJ0oy0z2QkSQfnMaENOG2HK1e8gHsDJFU0HCKFbxrlZpdY8YKY3C5ZdB/+vZlPSM+5jcjosX/p2iB7+ahF57VJ2qUWqpFzHeuUiCpzm9eAf+Ke6d9q/GhTFyyTIJ3LLmT+lG10BudIl42fuyVZPKKrXoZrdIkRsy2BwzA3GWmc=\n");
		System.out.println(info);

	}
}
