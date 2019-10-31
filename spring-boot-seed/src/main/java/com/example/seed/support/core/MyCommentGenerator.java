package com.example.seed.support.core;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import tk.mybatis.mapper.generator.MapperCommentGenerator;

/**
 * 重写MapperCommentGenerator类的方法
 * @author wuxiaopeng
 */
public class MyCommentGenerator extends MapperCommentGenerator {
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        StringBuilder sb = new StringBuilder();

        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString());

        //      addJavadocTag(field, false);

        field.addJavaDocLine(" */");
        String defaultValue = introspectedColumn.getDefaultValue();
        if(defaultValue==null || defaultValue.length()==0){
            field.addJavaDocLine("@ApiModelProperty(value = \""+introspectedColumn.getRemarks()+"\")");
        }else{
            field.addJavaDocLine("@ApiModelProperty(value = \""+introspectedColumn.getRemarks()+"\", example=\""+defaultValue+"\")");
        }

        if(!introspectedColumn.isNullable()){
            field.addJavaDocLine("@NotNull(message=\""+introspectedColumn.getRemarks()+"不能为空\")");

        }
    }
}