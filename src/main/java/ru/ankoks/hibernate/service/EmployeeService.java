package ru.ankoks.hibernate.service;

import ru.ankoks.model.Employee;
import ru.ankoks.model.FurnitureDepartment;
import ru.ankoks.model.dto.EmployeeOrderDto;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
public interface EmployeeService {
    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(Integer employeeId);

    public Employee getEmployee(int employeeid);

    public Employee updateEmployee(Employee employee);

    public Integer getRandomFreeEmployeeId();

    public void updateEmployeeWorkerStatus(Integer employeeId);

    List<Integer> getEmployeeIdsByDepartment(FurnitureDepartment furnitureDepartment);

    List<EmployeeOrderDto> getEmployeeOrders();
}
