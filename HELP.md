# 环境 

Springboot3.4 spring-security6 Java17 Maven3 

## ERROR:JAVA: 错误: 不支持发行版本 5 解决方法
https://blog.csdn.net/xiao_yi_xiao/article/details/119142118

修改项目和模块的编译器和language level都选到Java版本17，并且一致。idea2019不能选到17，需要升级到idea2024。

##  Maven 编译报错
[ERROR] 	Could not transfer artifact org.springframework:spring-beans:jar:6.2.2 from/to central (https://repo.maven.apache.org/maven2): Connect to repo.maven.apache.org:443 [repo.maven.apache.org/151.101.108.215] failed: Read timed out

设置中修改Maven版本，改为内置的Maven3。

## 执行maven install报错，java: 程序包org.springframework.stereotype不存在
  参考：https://blog.csdn.net/qq_28807077/article/details/113105274
  （1）Settings-Build,Exception,Deployment -Maven -Runner - 勾选 "Delegate IDE build/run actins to maven" 。注：当 IDEA 的 build/run 动作被委托给 maven 后，就会由 maven 执行 pom.xml 中的打包配置。
  （2）JRE版本选择java17
  （3）pom.xml - 右键菜单 -Maven - Sync Project
   然后重新执行 maven install

# Spring Security

## Spring Security默认做了什么

保护应用程序URL，要求对应用程序的任何交互进行身份验证
。程序启动时生成一个默认用户“user”
。生成一个默认的随机密码，并将此密码记录在控制台上
。生成默认的登录表单和注销页面
。提供基于表单的登录和注销流程，
。对于Web请求，重定向到登录页面:
。对于服务请求，返回401未经授权。处理跨站请求伪造(CSRF)攻击。
处理会话劫持攻击、
。写入Strict-Transport-Security以确保HTTPS。
。写入X-Content-Type-0ptions以处理探攻击。写入Cache Control头来保护经过身份验证的资源。写入X-Frame-0ptions以处理点击劫持攻击。

 通过Servlet的过滤器实现。Springboot通过Controller的方式实现了Servlet。

 Filter通过Bean对象的方式注册。
 DelegateingFilterProxy将FilterChainProxy注册到Sevlet生命周期中。
 FilterChainProxy将SecurityFilterChain注册到Sevlet生命周期中。
 SecurityFilterChain0：  SecurityFilter0 - SecurityFiltern
 SecurityFilterChainn：  SecurityFilter0 - SecurityFiltern
 
![security-framework.jpg](note%2Fsecurity-framework.jpg)

## DefaultSecurityFilterChain
DefaultSecurityFilterChain：16个过滤器。
UserPasswordAuthenticationFilter、Login、Logout等

## SecurityProperties

 默认的用户名为user 密码未随机生成的uuid

 在application.properties中自定义用户名 密码
    spring.security.user.name=admin
    spring.security.user.password=123

## 配置文件