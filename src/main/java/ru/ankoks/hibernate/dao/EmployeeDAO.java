package ru.ankoks.hibernate.dao;

import ru.ankoks.model.Employee;
import ru.ankoks.model.FurnitureDepartment;
import ru.ankoks.model.FurnitureItem;
import ru.ankoks.model.dto.EmployeeOrderDto;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
public interface EmployeeDAO {

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployee(Integer employeeId);

    Employee updateEmployee(Employee employee);

    Employee getEmployee(int employeeid);

    Integer getRandomFreeEmployeeId();

    void updateEmployeeWorkerStatus(Integer employeeId);

    List getEmployeeIdsByDepartment(FurnitureDepartment furnitureDepartment);

    List<EmployeeOrderDto> getEmployeeOrders();

    Integer getRandomFreeEmployeeIdInDep(FurnitureItem item);
}
