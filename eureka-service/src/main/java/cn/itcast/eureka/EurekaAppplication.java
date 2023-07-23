package cn.itcast.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @date 2023/7/22 23:14
 * @desciption:
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaAppplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaAppplication.class,args);
    }
}
