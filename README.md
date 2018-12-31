# 一、项目简介
&nbsp;&nbsp;&nbsp;&nbsp;本项目是机房报修管理系统的后端，基于SpringBoot框架搭建而成。`机房报修机房管理系统`实现前后端分离，所以此处项目仅是后端部分，
如需前端部分请点击右侧的超链接：[点我跳转](https://github.com/CheungChingYin/repair-system)。

&nbsp;&nbsp;&nbsp;&nbsp;本项目我将会以`【机房报修管理系统】`系列，以教程的形式发放在我的博客上：[点我跳转](https://blog.csdn.net/qq_33596978)，欢迎各位阅读我的文章。

## 文章目录：

[【机房报修管理系统】1.简介篇 机房报修管理系统简介](https://blog.csdn.net/qq_33596978/article/details/85330814)
# 二、涉及到的技术
## 1.后端
### （1）框架
- SpringBoot（含`Spring`、`SpringMVC`）
### （2）数据库相关
- MySQL连接驱动：`mysql-connector-java`
- Redis操作工具：`spring-boot-starter-data-redis`
- Mybatis：`mybatis-spring-boot-starter`
- Mybatis通用Mapper：`tk.mybatis`
- 分页插件：`com.github.pagehelper`
- 阿里开源数据源: `druid`
### （3）服务器
- SpringBoot自带Tomcat：`spring-boot-starter-tomcat`
### （4）其他工具类
- SpringBoot测试：`spring-boot-starter-test`
- 密码加密工具：`commons-codec`
- 字符串判断工具：`commons-lang3`
- IO流工具：`commons-io`
- JavaBean工具：`commons-beanutils`
- 接口记录及调试工具：`Swagger2`
- 访问权限管理工具：`Shiro`
- 二维码生成器插件：`qrcode-plugin`
- 压缩文件工具：`zip4j`
## 2.项目构建工具
- Maven
## 3.数据库
- MySQL 5.7.10
- Redis 4.0.2
## 4.项目管理工具
- Git
## 5.本人电脑环境
- 操作系统：Windows10
- Java版本：1.8.0_172
- IDE：JetBrains IDEA 2018.2.6

# 三、项目预览截图
## 1.登录页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181230234259738.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMzNTk2OTc4,size_16,color_FFFFFF,t_70)
## 2.主页面
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181230234335108.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMzNTk2OTc4,size_16,color_FFFFFF,t_70)

## 3.维修工单管理页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181230234510529.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMzNTk2OTc4,size_16,color_FFFFFF,t_70)
## 4.实训室管理页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181230234634295.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMzNTk2OTc4,size_16,color_FFFFFF,t_70)

## 5.二维码生成下载页
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181230234824928.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzMzNTk2OTc4,size_16,color_FFFFFF,t_70)
