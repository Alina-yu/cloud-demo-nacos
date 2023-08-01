package cn.itcast.feign.config;


import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @date 2023/7/31 07:26
 * @desciption: 远程调用对外提供的接口
 */
@FeignClient(value = "userservice")
public interface DefaultConfiguration {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);

}
