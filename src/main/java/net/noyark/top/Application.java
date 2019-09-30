package net.noyark.top;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//目前还差
//1. 上传图片 删除图片 添加top的控制器和页面
//2. 底层的mapper没有完成
@SpringBootApplication
@MapperScan(basePackages = "net.noyark.top.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
