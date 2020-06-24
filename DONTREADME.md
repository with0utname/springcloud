# springcloud
# 关于一些类的测试与理解

#restTemplate的测试
#restTemplate是通过url连接其他服务器的端口
#不需要启动 a 服务器 就能 启动 b 服务器，并且实现a中所有控制器的方法
#需要主要的是，b 中的接口路径不能和 a 重复

#eureka的测试
#测试需要使用maven clean清楚本地target数据再进行新的测试
#eureka的注册只能注册在一部服务器上
#eureka的地址默认端口为8761，通过server-url中的defaultZone更改（必须是这个值，源码是public static final String DEFAULT_ZONE = "defaultZone";）
#需要注意的是
#   eureka:
#      client:
#       service-url:
#        defaultZone: http://eureka8084.com:8084,http://localhost:8083/eureka,
#这里的url中 /eureka 是必须的，因为注册路径是这里，但是通过url访问路径只能从http://localhost:8083/进入

#20200624
# 
