package ru.ankoks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.ankoks.hibernate.service.EmployeeOrderService;
import ru.ankoks.hibernate.service.EmployeeService;
import ru.ankoks.model.Employee;
import ru.ankoks.model.FurnitureDepartment;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeOrderService employeeOrderService;

    @RequestMapping(value = "/employeeList")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<Employee> listEmployee = employeeService.getAllEmployees();
        model.addObject("listEmployee", listEmployee);
        model.setViewName("employeeList");
        return model;
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Employee employee = new Employee();
        model.addObject("employee", employee);
        model.addObject("departmentList", FurnitureDepartment.ALL);
        model.setViewName("employeeForm");
        return model;
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        employee.setFree(true);
        if (employee.getId() == 0) {
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:/employeeList");
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);

        Integer randomFreeEmployeeId = employeeService.getRandomFreeEmployeeId();

        if (randomFreeEmployeeId != null) {
            employeeOrderService.updateOperationEmployeeId(employeeId, randomFreeEmployeeId);
        } else {
            employeeOrderService.deleteOperationByEmployeeId(employeeId);
        }

        return new ModelAndView("redirect:/employeeList");
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("employeeForm");
        model.addObject("departmentList", FurnitureDepartment.ALL);
        model.addObject("employee", employee);

        return model;
    }
}
