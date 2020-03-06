package com.example.seed.support.constant;

/**
 * 项目常量
 * @author 吴小鹏
 */
public final class ProjectConstant {
    public static final String BASE_PACKAGE = "com.example.seed";
    //生成的Model所在包
    public static final String MODEL_PACKAGE = BASE_PACKAGE + ".model.entity";
    //生成的Mapper所在包
    public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".mapper";
    //生成的Service所在包
    public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";
    //生成的ServiceImpl所在包
    public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";
    //生成的Controller所在包
    public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".controller";


    //JDBC配置，请修改为你项目的实际配置
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?nullCatalogMeansCurrent=true";
    public static final String JDBC_USERNAME = "root";
    public static final String JDBC_PASSWORD = "123456";
    public static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    //项目在硬盘上的基础路径,这是idea默认的不需要修改
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    //生成的模板位置
    public static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/test/resources/generator/template";

    //java文件路径
    public static final String JAVA_PATH = "/src/main/java";
    //资源文件路径
    public static final String RESOURCES_PATH = "/src/main/resources";
    //xml资源文件路径
    public static final String XML_PATH = "/mapper";

    //作者
    public static final String AUTHOR = "wuxiaopeng";
}
