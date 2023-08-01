package cn.itcast.order.service;



import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    //    @Autowired
//    private RestTemplate restTemplate;
//
//
//    public Order queryOrderById(Long orderId) {
//        Order order = orderMapper.findById(orderId);
//        String url = "http://userservice/user/"+order.getUserId();
//        SecurityProperties.User user = restTemplate.getForObject(url, SecurityProperties.User.class);
//        order.setUser(user);
//
//
//        return order;
//    }
    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        Order order = orderMapper.findById(orderId);

        User user = userClient.findById(order.getUserId());
        order.setUser(user);
        return order;
    }


}
