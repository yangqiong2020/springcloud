package yq.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @HystrixCommand(fallbackMethod = "fallback")
    public Map<String,String> getUser(){

        throw  new RuntimeException();
    }

    //返回托底数据的方法
    public Map<String,String> fallback(){
        System.out.println(Thread.currentThread().getName());
       Map<String,String> map = new HashMap<>();
       map.put("fallback","......");
       return map;
    }
}
