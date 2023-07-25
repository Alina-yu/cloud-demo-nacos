package cn.itcast.user.web;


import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import sun.util.resources.LocaleData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope //nacos 的热更新
public class UserController {

    @Autowired
    private UserService userService;
    //读取nacos配置
//     @Value("${pattern.dateformat}")
//     private String dateformat;
    //注入类文件
    @Autowired
    private PatternProperties properties;



    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id
                          ) {

        return userService.queryById(id);
    }

    @GetMapping("now")
    public String now(){
        return   LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));

    }

}
