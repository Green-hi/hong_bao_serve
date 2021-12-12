package com.greenhi;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//@EnableScheduling //开启定时任务
//@EnableTransactionManagement//开启事务管理
@MapperScan("com.greenhi.hongBao.mapper")//与dao层的@Mapper二选一写上即可(主要作用是扫包)
public class HongBaoApplication {

    private static final Logger log = LoggerFactory.getLogger(HongBaoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HongBaoApplication.class, args);
        log.info("---------------------- 项目启动成功 --------------------");
    }
}
