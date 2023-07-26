package cn.itcast.order.service;


import cn.itcast.order.clients.UserClients;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
    private UserClients userClients;

    public Order queryOrderById(Long orderId) {
        Order order = orderMapper.findById(orderId);
        SecurityProperties.User user = userClients.findById(order.getUserId());
        order.setUser(user);
        return order;
    }


}
