package ru.ankoks.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ankoks.hibernate.dao.EmployeeDAO;
import ru.ankoks.hibernate.service.EmployeeService;
import ru.ankoks.model.Employee;
import ru.ankoks.model.FurnitureDepartment;
import ru.ankoks.model.dto.EmployeeOrderDto;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Transactional
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    public Employee getEmployee(int empid) {
        return employeeDAO.getEmployee(empid);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    public Integer getRandomFreeEmployeeId() {
        return employeeDAO.getRandomFreeEmployeeId();
    }

    public void updateEmployeeWorkerStatus(Integer employeeId) {
        employeeDAO.updateEmployeeWorkerStatus(employeeId);
    }

    public List<Integer> getEmployeeIdsByDepartment(FurnitureDepartment furnitureDepartment) {
        return employeeDAO.getEmployeeIdsByDepartment(furnitureDepartment);
    }

    public List<EmployeeOrderDto> getEmployeeOrders() {
        return employeeDAO.getEmployeeOrders();
    }

}
