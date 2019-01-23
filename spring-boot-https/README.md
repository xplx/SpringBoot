传输层安全性协议（英语：Transport Layer Security，缩写作 TLS），及其前身安全套接层（Secure Sockets Layer，缩写作 SSL）是一种安全协议，目的是为互联网通信，提供安全及数据完整性保障。网景公司（Netscape）在1994年推出首版网页浏览器，网景导航者时，推出HTTPS协议，以SSL进行加密，这是SSL的起源。IETF将SSL进行标准化，1999年公布第一版TLS标准文件。随后又公布RFC 5246 （2008年8月）与 RFC 6176 （2011年3月）。在浏览器、电子邮件、即时通信、VoIP、网络传真等应用程序中，广泛支持这个协议。主要的网站，如Google、Facebook等也以这个协议来创建安全连接，发送数据。目前已成为互联网上保密通信的工业标准。

SSL包含记录层（Record Layer）和传输层，记录层协议确定传输层数据的封装格式。传输层安全协议使用X.509认证，之后利用非对称加密演算来对通信方做身份认证，之后交换对称密钥作为会谈密钥（Session key）。这个会谈密钥是用来将通信两方交换的数据做加密，保证两个应用间通信的保密性和可靠性，使客户与服务器应用之间的通信不被攻击者窃听。

 

在配置TLS/SSL之前我们需要拿到相应签名的证书，测试实例可以使用Java 下面的 Keytool 来生成证书：

 

打开控制台输入：

keytool -genkey -alias tomcat  -storetype PKCS12 -keyalg RSA -keysize 2048  -keystore keystore.p12 -validity 3650

 

这里的别名是 keystore.p12，密码什么的直接设置就好，然后回车

 

然后根据路径找到生成好的证书，把证书复制到项目里，我是放到了这里

放好证书后，建立一个index.html放到resources/templates文件夹下，一会用于测试。

再配置properties

 

    server.port=8888
    server.tomcat.uri-encoding=utf-8
    server.servlet.context-path=/demo
     
    server.ssl.key-store=keystore.p12
    server.ssl.key-store-password=123456
    server.ssl.key-store-type=PKCS12
    server.ssl.key-alias=tomcat
     
    spring.thymeleaf.prefix=classpath:/templates/

 

配置好properties再加入下面的代码

 

 

 

    @Configuration
    public class HttpsConfig {
     
        /**
         * spring boot 1.0
         */
       /* @Bean
        public EmbeddedServletContainerFactory servletContainer() {
            TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
                @Override
                protected void postProcessContext(Context  context) {
                    SecurityConstraint constraint = new SecurityConstraint();
                    constraint.setUserConstraint("CONFIDENTIAL");
                    SecurityCollection collection = new SecurityCollection();
                    collection.addPattern("/*");
                    constraint.addCollection(collection);
                    context.addConstraint(constraint);
                }
            };
            tomcat.addAdditionalTomcatConnectors(httpConnector());
            return tomcat;
        }*/
     
        /**
         * spring boot 2.0
         * @return
         */
        @Bean
        public TomcatServletWebServerFactory servletContainer() {
            TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
                @Override
                protected void postProcessContext(Context context) {
                    SecurityConstraint constraint = new SecurityConstraint();
                    constraint.setUserConstraint("CONFIDENTIAL");
                    SecurityCollection collection = new SecurityCollection();
                    collection.addPattern("/*");
                    constraint.addCollection(collection);
                    context.addConstraint(constraint);
                }
            };
            tomcat.addAdditionalTomcatConnectors(httpConnector());
            return tomcat;
        }
     
        @Bean
        public Connector httpConnector() {
            Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
            connector.setScheme("http");
            //Connector监听的http的端口号
            connector.setPort(8080);
            connector.setSecure(false);
            //监听到http的端口号后转向到的https的端口号
            connector.setRedirectPort(8888);
            return connector;
        }
     
    }

 

 

    @Controller
    @RequestMapping
    public class ViewControlller {
     
        @GetMapping("index")
        public String index(){
            return "index";
        }
    }

 

 

 

值得注意的是加入的springboot jar的版本不同代码有一定的改变，我这里用的是2.0的版本，还有就是要想跳转到html页面的时候一定注意的就是千万不要在Controller中用@RestController而是要用Controller，如果用RestController的话就会直接把你的index解析显示在页面当中，就不会跳转了，还有就是想要跳转的话一定要加入下面的两个jar包
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-web</artifactId>
       <version>2.0.1.RELEASE</version>
    </dependency>
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

准备完毕后启动项目，打印台显示

 

再输入：

127.0.0.1:8080/demo/index就会自动跳转