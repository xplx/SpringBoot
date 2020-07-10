package generator;

import static generator.MapperGeneratorUtil.genMoreTable;

/**
 * @author wuxiaopeng
 * @description: 生成TK模板代码
 * @date 2020/3/4 15:46
 */
public class GeneratorCodeMain {
    public static void main(String[] args) {
        //生成表、可以使用数组同时生成多张表
        genMoreTable("location");
        //自定义生成的类名
        //genCodeByCustomModelName("user_info", "Info");
        //genMoreTable("user_info");
    }
}
