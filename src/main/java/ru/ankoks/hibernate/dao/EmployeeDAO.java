package ru.ankoks.hibernate.dao;

import ru.ankoks.model.Employee;
import ru.ankoks.model.FurnitureDepartment;
import ru.ankoks.model.dto.EmployeeOrderDto;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
public interface EmployeeDAO {

    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(Integer employeeId);

    public Employee updateEmployee(Employee employee);

    public Employee getEmployee(int employeeid);

    Integer getRandomFreeEmployeeId();

    void updateEmployeeWorkerStatus(Integer employeeId);

    List getEmployeeIdsByDepartment(FurnitureDepartment furnitureDepartment);

    List<EmployeeOrderDto> getEmployeeOrders();
}
