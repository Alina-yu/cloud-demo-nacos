package cn.itcast.order.pojo;

import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;


@Data
public class Order {
    private Long id;
    private Long price;
    private String name;
    private Integer num;
    private Long userId;
    private SecurityProperties.User user;

}