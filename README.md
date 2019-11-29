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
    4.service中使用HttpURLConnection客户端post和get方式接受参数不同post可以接受对象