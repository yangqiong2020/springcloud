01-springboot-helloworld
  1.动态改变配置文件
    a.在resources中增加不同的配置文件格式如: application-{dev,prod,test}
    b.使用命令动态改动配置文件java -jar 01-springboot-helloworld-1.0-SNAPSHOT.jar --spring.profiles.active=prod
  2.增加logback日志记录器
  3.使用yml格式来记录配置文件
     a.空白处不能使用tab要使用空格
     b.属性和值之间用冒号和空格分开
     c.前缀相同可以使用yml节约文件配置数
  4.全局异常处理

02-springboot-admin-client
02-springboot-admin-server
  1.增加健康检查
    a.客户端配置
      #关闭安全检查，不然服务端获取不了更多信息
      management.security.enabled=false
      #http://localhost:9090 表示是 Spring Boot Admin 服务单的 IP 地 址以及端口号
      spring.boot.admin.url: http://localhost:9090 
    b.服务端配置
     

03-springcloud-mq
   1.安装rabitmq 注意rabmitmq与relang版本问题
   2.测试spring和rabmitmq的连通性 


04-rabbitmq-direct-consumer
04-rabbitmq-direct-provider
    1.使用direct方式转发日志
    
05-rabbitmq-topic-consumer
05-rabbitmq-topic-provider
    1.rabbitmq使用topic 路由方式发送消息 
    
06-rabbitmq-fanout-provider
06-rabbitmq-fanout-consumer
    1.rabbitmq使用fanout 路由方式发送消息，广播方式

06-rabbitmq-fanout-soh-consumer
06-rabbitmq-fanout-soh-provider
    1.rabbitmq使用fanout 路由方式发送消息，广播方式
    2.增加了红包打印功能
 
 
07-rabbitmq-durable-direct-provider
07-rabbitmq-durable-direct-consumer
    1.主要是关闭了自动删除，消费完了才会删除
   
08-springcloud-eureka-server
    1.单机版本的eureka服务，测试连通性
    
08-springcloud-eureka-consumer
08-springcloud-eureka-provider
08-springcloud-eureka-server-ha
    1.集群版本的eureka服务
    2.增加了优雅关闭客户端（解决和3同样的问题）
    3.增加了关闭服务端的自我保护功能
    4.增加了访问服务端需要密码验证功能
    5.在consumer端修改rabbin的负载均衡策略
    6.把provider部署两套服务做负载，才能看到rabbin的负债均衡效果
    
08-spring-eureka-consumer-direct
    1.消费者不向注册中心注册，通过直连provider服务获得服务，一般用做测试
    
09-springcloud-feign-consumer
09-springcloud-feign-provider
09-springcloud-feign-service
    1.使用feign的方式获取服务，用户感觉像是调用本地服务
    2.consumer继承service的接口，并注解上provider的服务名字
    3.provider实现service的接口
    4.service中使用HttpURLConnection客户端post和get方式接受参数的不同，post可以接受对象
    
09-springcloud-feign-consumer-gzip
    1.增加了feign端的启动gzip功能
    2.增加了浏览器端响应的数据启动gzip功能
    
09-springcloud-feign-consumer-httpclient
    1.如果使用 HttpClient 作为 Feign 的客户端工具。
    那么在定义接口上的注解是需要 注意，如果传递的是一个自定义的对象（对象会使用 json 格式来专递）。需要制定类型
    2.httpClient客户端使用post和get都可以传递对象，不给过在provider接受的时候需要在参数前面都加上注解@RequestBody
    
09-springcloud-feign-consumer-log
    1.通过配置，可以在日志中查看到feign请求服务和相应服务需要的时间信息
    2.浏览器可以查看用户请求consumer到consumer响应的总共耗时 
    3.配置feign的请求超时时间就是配置ribbon的超时时间，配合测试需要把provide的findALl方法等待6秒
    如果在等待时间内返回响应则不会报错，如果在等待时间外返回响应则报错
 
10-springcloud-hystrix-ribbon-consumer
10-springcloud-hystrix-ribbon-provider
    1.使用降级方式来实验雪崩的托底数据
      a.可以通过访问service服务中接口上的注解标注的url来访问实现类provider
      b.可以直接访问provider注解上的url来调用实现类的方法
      两中方式都是使用ribbon来调用，一个经过service一个不经过，
      不过使用了service就可以通过consumer来继承service来通过本地的方式调用provider
      而不需要通过provider来多次一举，直接再provider上加注解用原始的ribbon来访问即可
      
      
10-springcloud-hystrix-ribbon-cache-consumer
    1.利用redis把查询数据缓存起来，下次如果key相同直接返回数据，减少服务器压力
    2.删除数据时候，也要把对应的缓存清空
    3.此案例get和del方法不需要用到provider端
    
11-springcloud-hystrix-ribbon-batch-consumer
    1.使用请求合并方式来减少服务器压力，把配置时间段内的请求 一次性发送给provider进行处理
    2.此案例不需要用到provider端服务