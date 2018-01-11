package ru.ankoks.hibernate.dao;

import ru.ankoks.model.EmployeeOrder;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
public interface EmployeeOrderDAO {

    public void addEmployeeOrder(EmployeeOrder employeeOrder);

    void deleteOrderOperationByOrderId(int orderId);

    void updateOperationEmployeeId(int employeeId, Integer newEmployeeId);

    List<Integer> getOrderIdsByEmployeeIds(List<Integer> employeeIds);

    void deleteOperationByEmployeeId(int employeeId);
}
