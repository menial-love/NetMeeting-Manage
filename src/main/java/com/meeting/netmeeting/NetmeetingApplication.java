package com.meeting.netmeeting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.meeting.netmeeting")  // 启动类所在路径
@MapperScan(value = "com.meeting.netmeeting.mapper")   // 扫包
public class NetmeetingApplication {
    public static void main(String[] args) {
        SpringApplication.run(NetmeetingApplication.class, args);
    }
}
