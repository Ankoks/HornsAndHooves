package ru.ankoks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ankoks.hibernate.service.EmployeeOrderService;
import ru.ankoks.hibernate.service.EmployeeService;
import ru.ankoks.hibernate.service.OrderService;
import ru.ankoks.model.*;
import ru.ankoks.model.dto.EmployeeOrderDto;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeOrderService employeeOrderService;

    @RequestMapping(value = "/orderList")
    public ModelAndView listOrder(ModelAndView model) throws IOException {
        List<Order> listOrder = orderService.getAllOrders();
        model.addObject("itemList", FurnitureItem.ALL);
        model.addObject("listOrder", listOrder);
        model.setViewName("orderList");
        return model;
    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Order order = new Order();
        model.addObject("order", order);
        model.setViewName("orderForm");
        return model;
    }

    @RequestMapping(value = "/saveOrder", method = RequestMethod.POST)
    public ModelAndView saveOrder(@ModelAttribute Order order) {

        Integer randomFreeEmployeeId = employeeService.getRandomFreeEmployeeId();

        if (randomFreeEmployeeId != null) {
            order.setStatus(OrderStatus.STARTED);
        } else {
            order.setStatus(OrderStatus.NEW);
        }

        if (order.getId() == 0) {
            orderService.addOrder(order);

            if (randomFreeEmployeeId != null) {
                employeeService.updateEmployeeWorkerStatus(randomFreeEmployeeId);

                EmployeeOrder employeeOrder = new EmployeeOrder();
                employeeOrder.setEmployeeId(randomFreeEmployeeId);
                employeeOrder.setOrderId(orderService.getLastOrder());

                employeeOrderService.addEmployeeOrder(employeeOrder);
            }
        } else {
            orderService.updateOrder(order);
        }

        return new ModelAndView("redirect:/orderList");
    }

    @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
    public ModelAndView deleteOrder(HttpServletRequest request) {
        int orderId = Integer.parseInt(request.getParameter("id"));
        orderService.deleteOrder(orderId);

        employeeOrderService.deleteOrderOperationByOrderId(orderId);

        return new ModelAndView("redirect:/orderList");
    }

    @RequestMapping(value = "/editOrder", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int orderId = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.getOrder(orderId);
        ModelAndView model = new ModelAndView("orderForm");
        model.addObject("order", order);

        return model;
    }

    @RequestMapping(value = "/orderListByDepartment")
    public ModelAndView orderListByDepartment(ModelAndView model) {
        List<Integer> employeeIdsSoftDepartment = employeeService.getEmployeeIdsByDepartment(FurnitureDepartment.SOFT);
        List<Integer> employeeIdsStorageDepartment = employeeService.getEmployeeIdsByDepartment(FurnitureDepartment.STORAGE);
        List<Integer> employeeIdsOfficeDepartment = employeeService.getEmployeeIdsByDepartment(FurnitureDepartment.OFFICE);

        List<Integer> orderIdsByEmployeeIdsSoft = employeeIdsSoftDepartment.isEmpty() ? Collections.EMPTY_LIST : employeeOrderService.getOrderIdsByEmployeeIds(employeeIdsSoftDepartment);
        List<Integer> orderIdsByEmployeeIdsStorage = employeeIdsStorageDepartment.isEmpty() ? Collections.EMPTY_LIST : employeeOrderService.getOrderIdsByEmployeeIds(employeeIdsStorageDepartment);
        List<Integer> orderIdsByEmployeeIdsOffice = employeeIdsOfficeDepartment.isEmpty() ? Collections.EMPTY_LIST : employeeOrderService.getOrderIdsByEmployeeIds(employeeIdsOfficeDepartment);

        List<Order> listOrderSoft = orderIdsByEmployeeIdsSoft.isEmpty() ? Collections.EMPTY_LIST : orderService.getOrdersByIds(orderIdsByEmployeeIdsSoft);
        List<Order> listOrderStorage = orderIdsByEmployeeIdsStorage.isEmpty() ? Collections.EMPTY_LIST : orderService.getOrdersByIds(orderIdsByEmployeeIdsStorage);
        List<Order> listOrderOffice = orderIdsByEmployeeIdsOffice.isEmpty() ? Collections.EMPTY_LIST : orderService.getOrdersByIds(orderIdsByEmployeeIdsOffice);

        model.addObject("listOrderSoft", listOrderSoft);
        model.addObject("listOrderStorage", listOrderStorage);
        model.addObject("listOrderOffice", listOrderOffice);

        model.setViewName("orderListByDepartment");
        return model;
    }

    @RequestMapping(value = "/orderListByEmployee")
    public ModelAndView orderListByEmployee(ModelAndView model) {

        List<EmployeeOrderDto> orderList = employeeService.getEmployeeOrders();

        model.addObject("orderList", orderList);

        model.setViewName("orderListByEmployee");
        return model;
    }

    @RequestMapping(value = "/listNonCompleteOrders")
    public ModelAndView listNonCompleteOrders(ModelAndView model) {

        List<Order> nonCompleteOrders = orderService.getNonCompleteOrders();

        model.addObject("nonCompleteOrders", nonCompleteOrders);

        model.setViewName("listNonCompleteOrders");
        return model;
    }
}
