package cn.itcast.order.clients;


import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @date 2023/7/26 22:46
 * @desciption:
 */
@FeignClient("userservice")
public interface UserClients {
    @GetMapping("/user/{id}")
    SecurityProperties.User findById(@PathVariable("id") Long id);
}
