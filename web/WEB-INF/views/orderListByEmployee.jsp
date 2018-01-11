<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: AntonK
  Date: 10.01.2018
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
  <h1>Order List by Employee</h1>
  <table border="1">
    <th>Employee Name</th>
    <th>Employee Department</th>
    <th>Order name</th>
    <th>Order date</th>
    <th>Day(s) to end</th>
    <th>Order Status</th>

    <c:forEach var="item" items="${orderList}">
      <tr>
        <td>${item.employeeName}</td>
        <td>${item.employeeDepartment}</td>
        <td>${item.orderName}</td>
        <td><fmt:formatDate pattern = "dd.MM.yyyy" value = "${item.orderDate}"/></td>
        <td>${item.completeDays}</td>
        <td>${item.orderStatus}</td>
      </tr>
    </c:forEach>
  </table>
  <a href="/">back</a>
</div>
</body>
</html>
