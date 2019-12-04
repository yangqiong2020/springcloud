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
      
10-springcloud-hystrix-ribbon-provider      
10-springcloud-hystrix-ribbon-cache-consumer
    1.利用redis把查询数据缓存起来，下次如果key相同直接返回数据，减少服务器压力
    2.删除数据时候，也要把对应的缓存清空
    3.此案例get和del方法不需要用到provider端
    
10-springcloud-hystrix-ribbon-provider    
11-springcloud-hystrix-ribbon-batch-consumer
    1.使用请求合并方式来减少服务器压力，把配置时间段内的请求 一次性发送给provider进行处理
    2.此案例不需要用到provider端服务
    
09-springcloud-feign-provider
12-springcloud-hystrix-ribbon-breaker-consumer
    1.需要这两个服务来演示熔断机制
    多少秒内大于多少个请求
    多少秒内错误率大于多少
    熔断之后多少秒内进行重试
    2.这里访问provider是方式service的url
    3.重试机制没有试验成功，在一定时间超过请求数量也没试验成功
    
09-springcloud-feign-provider
13-springcloud-hystrix-ribbon-threadpool-consumer
    1.使用线程池隔离之后，调用provider的方法和fallback方法不是一个线程
    2.在没有使用线程池隔离时，调用provider的方法和fallback方法是同一个线程
    
09-springcloud-feign-provider    
14-springcloud-hystrix-ribbon-semaphore-consumer
    1.调用provider的线程和请求是同一个线程，信号量隔离
    2.调用provider的线程和请求不是同一个线程，线程池隔离 
        说明：controller中的方法请求线程，service的方法调用provider线程
  
09-springcloud-feign-service      
09-springcloud-feign-provider  
15-springcloud-hystrix-feign-fallback-consumer
    1.使用feign请求的方式，进行降级处理，返回兜底数据
 
09-springcloud-feign-service      
09-springcloud-feign-provider 
15-springcloud-hystrix-feign-fallback-consumer-factory
    1.使用feign请求的方式，进行降级处理，返回兜底数据，并捕获异常信息
    
16-springcloud-dashboard-hystrix-ribbon-consumer
16-springcloud-dashboard-view-hystrix-ribbon-consumer
    1.使用dashboard-view来监控hystrix请求
    监控的数据：提供服务的服务监控日志：http://localhost:1001/hystrix.stream
    监控的页面：http://localhost:1002/hystrix
    把要监控的数据，添加到http://localhost:1002/hystrix这个页面的指定输入框中，
    多少时间刷新一次，监控的标题
    
17-springcloud-turbine-consumer
17-springcloud-turbine-consumer-s1
17-springcloud-turbine-consumer=s2
16-springcloud-dashboard-view-hystrix-ribbon-consumer
    1.利用turbine做集群监控日志，然后把页面流传给dashboard
    集群服务地址：http://localhost:9010/hystrix.stream
                   http://localhost:9011/hystrix.stream
    turbine服务地址：http://localhost:1002/turbine.stream
    dashboard服务地址：http://localhost:1002/hystrix
    turbine监控集群服务聚合日志，然后把日志地址传入dashboard
    2.必须要有服务，不然没有数据
    
18-springcloud-dashboard-mq-consumer
18-springcloud-turbine-mq-consumer
16-springcloud-dashboard-view-hystrix-ribbon-consumer
    1.中间加了一个rabbitmq被监控的日志，直接传递给rabbitmq；
    然后turbine在去rabbitmq中去
    2.不需要向上个案例，turbine要配置所有被监控的服务名字，
    而且日志量好，使用消息队列可以消峰
    3.试验没成功，日志没有传递到rabbitmq中去

19-generator-sqlmap-custom
    1.先在数据库中把库和表都建好，然后通过逆向工程来生成mapper.xml和pojo文件
    2.测试之后没有生成文件，下次解决

20-e-book-consumer
20-e-book-order-provider
20-e-book-order-service
20-e-book-product-provider
20-e-book-product-service
20-e-book-trade-provider
20-e-book-trade-service
20-e-book-user-provider
20-e-book-user-service
    1.使用了代理链条设计模式
    2.浏览器访问create方法
    3.验证登录
    4.先创建order订单，然后在穿件trade交易流水，然后在创建交易流水的service服务中，调用更新新order订单的服务，把交易id传入之前的order订单中，并更新
    5.疑问，同样是个插入order和trade 为什么在order中create_date可以自动创建，而在trade中create_date不能自动创建
    6.自动更新日期在试验使用的mysql版本中需要加入触发器，触发器要创建增加，修改，删除三种，不能使用 on update的方式
    
21-zuul-gateway
20-e-book-order-provider
20-e-book-order-service
  1.访问方式：http://网关服务地址:网关服务端口/访问的服务的名称/访问的服务中的接口的地址
  例如：http://localhost:9020/e-book-order-provider/order/findAll 
  
21-zuul-gateway-route
20-e-book-user-provider
20-e-book-user-service
    1.配置：zuul.routes.e-book-user-provider.path=/suibian/**
    访问：http://localhost:9030/suibian/user/login?userName=admin&password=admin
    
21-zuul-gateway-route
20-e-book-user-provider
20-e-book-order-provider
20-e-book-product-provider
    1.增加前缀来访问服务
    2.排除所有服务，然后添加需要的服务
    3.排除指定访问路径的服务
    4.排除多个服务
    5.路由指定，url和服务指定 
    6.路由指定，两条配置合并成一条
    
21-zuul-gateway-filter
    1.自定义网关过滤器

21-zuul-gateway-example
20-e-book-user-provider
    1.自定义网关过滤器
    2.验证pre error post routing 和权重影响下的执行顺序
     
22-springcloud-eureka-consumer-dashboard-view
22-zuul-gateway
20-e-book-order-provider
    1.dashboard监控zuul
    2.访问地址：http://localhost:9020/e-book-order-provider/order/findAll
    3.日志流:http://localhost:9020/hystrix.stream
    4.显示页面:http://localhost:1001/hystrix
    
22-zuul-gateway-fallback
20-e-book-order-provider
    1.zuul给服务降级处理

22-zuul-gateway-ratelimt
20-e-book-order-provider
20-e-book-product-provider
    1.测试全局限流和局部限流
    2.在多少秒内只能访问几次

22-zuul-gateway-timeout
20-e-book-order-provider
    1.hystrix和ribbon超时演示
    
23-config-client
23-config-server
    1.注意在github上要新建项目config
    2.项目必须是public的不然需要密码验证
    3.通过服务端访问配置：http://localhost:9050/config-client/dev
        通过客户端访问对应的服务，会连接上配置
    4.客户端的配置文件命名必须是bootstrap.properties ，因为这个配置优先于application.properties实例化，
    只有bootstrap实例化了（从config-server取到配置了），application中的配置才会取的到
    
23-config-client-refresh
23-config-server
23-commons
    1.这个服务的名字会把下面服务的名字覆盖掉：spring.application.name=ooxx-config-client
      spring.cloud.config.name=config-client，如果配置中心客户端不叫config-client就会初始化实例失败并且启动失败
      如果application名字不想叫config-client，那就必须重写spring.cloud.config.name这个配置成config-client，application名就可以随便取
    2.通过httpClient定时使用doPost方式刷新配置http://127.0.0.1:9051/refresh
      
23-config-server-encryption-sym
23-commons
23-config-client
    1.Dalston.SR1 这个版本支持加密
    2.如果访问http://127.0.0.1:9050/encrypt/status不是这个状态：{"status":"OK"}
    3.需要下载加密的jar包，覆盖到对应的目录（看文档）     
    4.使用httpClient发送doPost请求加密和解密
         加密（post 请求）：http://127.0.0.1:9050/encrypt 
         解密（post 请求）：http://127.0.0.1:9050/decrypt 
    5.加密好的配置上传到github配置如：datasource.password = {cipher} 83084e7d3b76442ee2339854da5b76d66e5192b0954546d1176018fa910c92b5


23-config-server-rsa
23-commons    
23-config-client-refresh
    1.使用keytool -genkeypair -alias "config-info" -keyalg "RSA" -keystore "encrypt-info.keystore"  生成私钥
    2.encrypt-info.keystore放入配置中心服务的resources中
    3.使用httpClient加密字符
    4.加密好的配置上传到github中去
    
23-config-server-encryption-sym-security
    1.开启密码验证，访问配置需要输入用户名和密码，服务要访问配置，要配置允许访问的用户名和密码

    
25-stream-receiver
25-stream-sender
    1.开启消息队列
    2.使用sender中的测试方法来发送消息
    3.使用receiver来接受消息

25-stream-group-receiver
25-stream-group-sender
    1.启动两个消息receiver
    2.使用sender测试方法发送消息


25-stream-partition-receiver
25-stream-partition-receiver1
25-stream-partition-sender
    1.使用sender发送消息
    2.消息会进入到不同的分区中
    3.相同消息发送到相同的服务中
    根据指定的分区规则看数据存入哪个分区中
    spring.cloud.stream.bindings.outputProduct.producer.partitionKeyExpression=payload
    
26-sleuth-product-provider (已改名)
26-sleuth-product-service
26-sleuth-consumer     (已改名)
    1.trace:从客户端发起请求（request）抵达被追踪的边界开始，到北追踪系统向客户端返回响应（response）为止的整个过程
    2.span:每个trace中会调用若干个服务，为了记录调用了哪些服务，以及每次调用服务的消耗时间等信息，在每次调用服务时，埋入一个调用记录
    3.x-b3-parentSpanid：标识当前工作单元所属的上一个工作单元
    4.x-b3-sampled:是否采样，1表示需要被输出,0表示不需要被输出
    5.x-b3-traceid:一条请求链路trace的唯一标识，必须值
    6.x-span-name:工作单元的名称，例如：http://user/login
    7.x-b3-spanid：一个工作单元span的唯一标识，必须值
    注意：要在logback中把日志级别调成debug；网络波动导致连接数据库超时，可以调节ribbon的连接时间和处理时间
    
26-sleuth-elk-product-provider
26-sleuth-product-service
26-sleuth-elk-consumer
    环境:java1.8以上；虚拟机参数设置(文档中掉了两条配置)
    1.安装nodejs
    2.安装npm（如果nodejs是免安装版自带npm）
    3.在head目录下安装grunt-cli和grunt
    4.启动logstash:./bin/logstash -f config/log_to_es.conf
        logstash配置中监听的地址必须是ip地址，不能写域名，不然其他服务telnet 9250不通 
    5.启动es:./elasticsearch -d 
    6.启动head：grunt server 
    7.启动kibana：./bin/kibana
  
27-sleuth-zipkin-product-provider  
27-sleuth-zipkin-product-service
27-sleuth-zipkin-server
    1.如果properties中的配置高亮说明不识别key，需要排查
    2.pom文件中的jar如果正确引入，CTRL+点击类会跳转，引入不正确会点击类名没反应
    3.zipkin的客户端和cloud版本有关联，当前实验环境是Dalston.SR4
    4.先启动zipkin服务再启动其他服务

28-sleuth-zipkin-mq-consumer
28-sleuth-zipkin-mq-product-provider
28-sleuth-zipkin-server-mq
    1.服务不直接连zipkin，通过rabbitmq消息队列相连
    
28-sleuth-zipkin-mq-consumer
28-sleuth-zipkin-mq-product-provider    
29-sleuth-zipkin-server-mq-mysql
    1.把服务追踪日志持久化到mysql数据库中