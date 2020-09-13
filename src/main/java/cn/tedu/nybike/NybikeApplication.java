package cn.tedu.nybike;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan//扫描sevlet的原生组件
@MapperScan("cn.tedu.nybike.mapper")//把mapper这个包拖给spring框架管理
public class NybikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NybikeApplication.class, args);
    }

}
