# 一、项目简介
&nbsp;&nbsp;&nbsp;&nbsp;本项目是机房报修管理系统的后端，基于SpringBoot框架搭建而成。`机房报修机房管理系统`实现前后端分离，所以此处项目仅是后端部分，
如需前端部分请点击右侧的超链接：[点我跳转](https://github.com/CheungChingYin/repair-system)。

## 项目体验
&nbsp;&nbsp;&nbsp;&nbsp;本项目已托管服务器中，各位可以通过下面的的连接访问网站进行体验，由于我提供的是超级管理员账户，所以任何人都能够自主删除管理员，希望各位体验的同学能够在做到以下几点：

- 不要胡乱删除管理员账号。
- 在产生了数据，如添加了管理员，实训室等操作，能够在登出的时候删除产生的数据，保持数据库的洁净。
- 添加维修工单可以上传图片，但希望不要涉及色情暴力的图片，亦不要上传过多的图片导致占满服务器带宽和容量。

- 体验地址：[点我跳转](http://139.199.66.197:8082)
- 账户名：`13842512341`
- 密码：`test13456`

&nbsp;&nbsp;&nbsp;&nbsp;本项目我将会以【机房报修管理系统】系列，以教程的形式发放在我的博客上：[点我跳转](https://blog.csdn.net/qq_33596978)，欢迎各位阅读我的文章。

## 文章目录：

[【机房报修管理系统】1.简介篇 机房报修管理系统简介](https://blog.csdn.net/qq_33596978/article/details/85330814)

[【机房报修管理系统】后端篇（一） 设计数据表](https://blog.csdn.net/qq_33596978/article/details/85634383)

[【机房报修管理系统】后端篇（二） SpringBoot项目搭建](https://blog.csdn.net/qq_33596978/article/details/85687727)

[【机房报修管理系统】后端篇（三） 配置阿里巴巴Druid数据源](https://blog.csdn.net/qq_33596978/article/details/85775208)

[【机房报修管理系统】后端篇（四） 配置Mybitis、通用Mapper及Pagehelper](https://blog.csdn.net/qq_33596978/article/details/85847850)

[【机房报修管理系统】后端篇（五） 使用MybatisGenerator生成实体层和DAO层](https://blog.csdn.net/qq_33596978/article/details/85924971)

[【机房报修管理系统】后端篇（六） 配置Cros解决跨域问题](https://blog.csdn.net/qq_33596978/article/details/85994125)

[【机房报修管理系统】后端篇（七） 配置自定义JSON类及解决JSON的值空时不出现Null](https://blog.csdn.net/qq_33596978/article/details/86071271)

[【机房报修管理系统】后端篇（八） 配置接口管理利器——Swagger2](https://blog.csdn.net/qq_33596978/article/details/86153304)

[【机房报修管理系统】后端篇（九） 在SpringBoot配置非关系型数据库Redis](https://blog.csdn.net/qq_33596978/article/details/86229582)

[【机房报修管理系统】后端篇（十） Service层开发——管理员管理服务](https://blog.csdn.net/qq_33596978/article/details/86303148)

[【机房报修管理系统】后端篇（十一） 配置权限管理器——Shiro](https://blog.csdn.net/qq_33596978/article/details/86299986)
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

# 四、项目部署步骤
本项目推荐使用JetBrains IDEA打开，此次部署基于JetBrains IDEA，部署方式有两种：基于Git/SVN Clone,直接下载项目直接部署。

**步骤基于已搭建MySQL和Redis的基础上**
## 1.基于Git/SVN Colne的方式（推荐）
### （一）点击上方的`Clone or download`按钮，复制红框中的链接。
![F5nA41.png](https://s2.ax1x.com/2019/01/01/F5nA41.png)

### （二）打开IDEA，点击Git。
[![F5ndbQ.png](https://s2.ax1x.com/2019/01/01/F5ndbQ.png)](https://imgchr.com/i/F5ndbQ)

### （三）将复制的链接粘贴到URL中
[![F5n4a9.png](https://s2.ax1x.com/2019/01/01/F5n4a9.png)](https://imgchr.com/i/F5n4a9)

### （四）等待右下角的进度跑完
[![F5uCxf.png](https://s2.ax1x.com/2019/01/01/F5uCxf.png)](https://imgchr.com/i/F5uCxf)

### （五）把MySQL文件导入到MySQL数据库
MySQL文件位于项目根目录的MySQL文件夹中（建议数据库名为machineroomsystem）

### （六） 打开aplication.propperties文件，修改MySQL和Redis为自己本机的用户和密码
![F5u0sO.png](https://s2.ax1x.com/2019/01/01/F5u0sO.png)
[![F5uBLD.png](https://s2.ax1x.com/2019/01/01/F5uBLD.png)](https://imgchr.com/i/F5uBLD)

### （七）启动项目

打开RepairsystemApplication,右键Run即可
[![F5ucFA.md.png](https://s2.ax1x.com/2019/01/01/F5ucFA.md.png)](https://imgchr.com/i/F5ucFA)


看见下图即为成功启动项目
[![F5ugJI.md.png](https://s2.ax1x.com/2019/01/01/F5ugJI.md.png)](https://imgchr.com/i/F5ugJI)


访问`http://localhost:8081/swagger-ui.html`能够访问成功即部署成功
[![F5uWSP.md.png](https://s2.ax1x.com/2019/01/01/F5uWSP.md.png)](https://imgchr.com/i/F5uWSP)

## 2.直接下载项目的方式
### （一）点击上方的`Clone or download`按钮，点击`Download ZIP`
![F5Kt0g.png](https://s2.ax1x.com/2019/01/01/F5Kt0g.png)
### （二）解压文件，打开IDEA，选择`Import Project`,选中之前解压的文件夹
[![F5KBpq.png](https://s2.ax1x.com/2019/01/01/F5KBpq.png)](https://imgchr.com/i/F5KBpq)
### （三）根据上面基于Git/SVN Colne的方式的（三）~（七）步骤执行即可
# 五 项目结构
```
com
    └─repairsystem
        │  RepairsystemApplication.java
        │  ServletInitializer.java
        │
        ├─config
        │  │  CorsConfig.java
        │  │  DruidConfig.java
        │  │  JacksonConfig.java
        │  │  SchedulerTask.java
        │  │  Swagger2Config.java
        │  │
        │  └─shiro
        │          MyRedisSessionDao.java
        │          MySessionIdGenerator.java
        │          MyShiroRealm.java
        │          MySignOutFilter.java
        │          ShiroConfig.java
        │          ShiroRedisCache.java
        │          ShiroRedisCacheManager.java
        │
        ├─dao
        │      AdministratorMapper.java
        │      BuildingMapper.java
        │      ClassMapper.java
        │      CompleteOrderMapper.java
        │      OrdersMapper.java
        │      RoleMapper.java
        │
        ├─entity
        │  │  Administrator.java
        │  │  Building.java
        │  │  Class.java
        │  │  CompleteOrder.java
        │  │  Orders.java
        │  │  Role.java
        │  │
        │  └─vo
        │          AdministratorVO.java
        │          ClassVO.java
        │          CompleteOrderVO.java
        │          OrderVO.java
        │
        ├─exception
        │  │  AdministratorIdIsNullException.java
        │  │  AdministratorNameIsNullException.java
        │  │  AdministratorPasswordIsNullException.java
        │  │  AdministratorPhoneIsNullException.java
        │  │  BuildingIdIsNullException.java
        │  │  BuildingNameIdIsNullException.java
        │  │  ClassIdIsNullException.java
        │  │  ClassNameIsNullException.java
        │  │  CompleteOrderIdIsNullException.java
        │  │  OrderIdIsNullException.java
        │  │  PageIsNullException.java
        │  │
        │  └─handler
        │          GlobalExceptionHandler.java
        │
        ├─service
        │  │  AdministratorService.java
        │  │  BuildingService.java
        │  │  ClassService.java
        │  │  CompleteOrderService.java
        │  │  EmailService.java
        │  │  OrdersService.java
        │  │  RoleService.java
        │  │
        │  └─Impl
        │          AdministratorServiceImpl.java
        │          BuildingServiceImpl.java
        │          ClassServiceImpl.java
        │          CompleteOrderServiceImpl.java
        │          EmailServiceImpl.java
        │          OrdersServiceImpl.java
        │          RoleServiceImpl.java
        │
        ├─utils
        │      ConstantUtils.java
        │      Entity2VO.java
        │      JsonResult.java
        │      MyMapper.java
        │      OrderUploadUtils.java
        │      PageUtils.java
        │      PasswordEncryptionUtils.java
        │      QRCodeUtils.java
        │      SerializeUtil.java
        │      ZipUtils.java
        │
        └─web
            ├─controller
            │      AdministratorController.java
            │      BuildingController.java
            │      ClassController.java
            │      CompleteOrderController.java
            │      OrderController.java
            │      QRCodeController.java
            │
            └─ui
```
