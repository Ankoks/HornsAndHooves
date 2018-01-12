package ru.ankoks.hibernate.service;

import ru.ankoks.model.Employee;
import ru.ankoks.model.FurnitureDepartment;
import ru.ankoks.model.FurnitureItem;
import ru.ankoks.model.dto.EmployeeOrderDto;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
public interface EmployeeService {
    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer employeeId);

    Employee getEmployee(int employeeid);

    Employee updateEmployee(Employee employee);

    Integer getRandomFreeEmployeeId();

    void updateEmployeeWorkerStatus(Integer employeeId);

    List<Integer> getEmployeeIdsByDepartment(FurnitureDepartment furnitureDepartment);

    List<EmployeeOrderDto> getEmployeeOrders();

    Integer getRandomFreeEmployeeIdInDep(FurnitureItem item);
}
