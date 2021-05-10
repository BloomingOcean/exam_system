#### 软件架构
软件架构说明


#### 安装教程

 编译打包：

	添加maven的package任务， 一般是clean package
	同时添加虚拟机参数，忽略测试任务：-Dmaven.test.skip=true

#### 使用说明

	java -jar xxx.jar --spring.profiles.active=local --server.port=8080
 	