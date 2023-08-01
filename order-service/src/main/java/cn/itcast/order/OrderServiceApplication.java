package cn.itcast.order;

import cn.itcast.feign.config.DefaultConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
//@EnableFeignClients(defaultConfiguration = DefaultConfiguration.class)
@EnableFeignClients(basePackages = "cn.itcast.feign.clients")
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);

    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
         return new RestTemplate();
    }


}
