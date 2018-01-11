package ru.ankoks.hibernate.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ankoks.hibernate.dao.EmployeeOrderDAO;
import ru.ankoks.hibernate.service.EmployeeOrderService;
import ru.ankoks.model.EmployeeOrder;

import java.util.List;

/**
 * Created by AntonK on 09.01.2018.
 */
@Service
@Transactional
public class EmployeeOrderServiceImpl implements EmployeeOrderService {

    @Autowired
    private EmployeeOrderDAO employeeOrderDAO;

    @Transactional
    public void addEmployeeOrder(EmployeeOrder employeeOrder) {
        employeeOrderDAO.addEmployeeOrder(employeeOrder);
    }

    public void deleteOrderOperationByOrderId(int orderId) {
        employeeOrderDAO.deleteOrderOperationByOrderId(orderId);
    }

    public void updateOperationEmployeeId(int employeeId, Integer newEmployeeId) {
        employeeOrderDAO.updateOperationEmployeeId(employeeId, newEmployeeId);
    }

    public List<Integer> getOrderIdsByEmployeeIds(List<Integer> employeeIds) {
        return employeeOrderDAO.getOrderIdsByEmployeeIds(employeeIds);
    }

    public void deleteOperationByEmployeeId(int employeeId) {
        employeeOrderDAO.deleteOperationByEmployeeId(employeeId);
    }
}
