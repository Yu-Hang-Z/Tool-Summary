package com.example.zyh.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;

import java.util.Collections;

/**
 * @author by zhangyuhang
 * @Classname CodeGenerator
 * @Description TODO
 * @Date 2022/5/22 22:11
 */
public class CodeGenerator {

    public static void main(String[] args) {

        String url = "jdbc:mysql://101.42.233.119:3306/Test?serverTimezone=UTC";
        String username = "root";
        String password = "Bohui@123";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("baomidou") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("./src/main/java/"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.example.zyh") // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "./src/test/java/com/example/zyh/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("t_sensitive_word_type") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
