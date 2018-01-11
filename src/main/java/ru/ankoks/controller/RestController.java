package ru.ankoks.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ankoks.hibernate.service.OrderService;
import ru.ankoks.model.Order;

import java.util.List;

/**
 * Пример использования REST запроса
 * Created by AntonK on 11.01.2018.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/restOrderList", method = RequestMethod.GET)
    public String getOrderList() {
        List<Order> listOrder = orderService.getAllOrders();

        Gson gson = new Gson();

        return gson.toJson(listOrder);
    }
}
