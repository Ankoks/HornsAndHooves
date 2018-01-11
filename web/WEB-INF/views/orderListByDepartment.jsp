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
  <h1>Order List of "Мягкая мебель" department</h1>
  <table border="1">
    <th>Name</th>
    <th>Type</th>
    <th>Order date</th>
    <th>Day(s) to end</th>
    <th>Status</th>

    <c:forEach var="order" items="${listOrderSoft}">
      <tr>
        <td>${order.name}</td>
        <td>${order.item.title}</td>
        <td><fmt:formatDate pattern = "dd.MM.yyyy" value = "${order.orderDate}"/></td>
        <td>${order.completeDays}</td>
        <td>${order.status.title}</td>
      </tr>
    </c:forEach>
  </table>
  <h1>Order List of "Системы хранения" department</h1>
  <table border="1">
    <th>Name</th>
    <th>Type</th>
    <th>Order date</th>
    <th>Day(s) to end</th>
    <th>Status</th>

    <c:forEach var="order" items="${listOrderStorage}">
      <tr>
        <td>${order.name}</td>
        <td>${order.item.title}</td>
        <td><fmt:formatDate pattern = "dd.MM.yyyy" value = "${order.orderDate}"/></td>
        <td>${order.completeDays}</td>
        <td>${order.status}</td>
      </tr>
    </c:forEach>
  </table>
  <h1>Order List of "Офисная мебель" department</h1>
  <table border="1">
    <th>Name</th>
    <th>Type</th>
    <th>Order date</th>
    <th>Day(s) to end</th>
    <th>Status</th>

    <c:forEach var="order" items="${listOrderOffice}">
      <tr>
        <td>${order.name}</td>
        <td>${order.item.title}</td>
        <td><fmt:formatDate pattern = "dd.MM.yyyy" value = "${order.orderDate}"/></td>
        <td>${order.completeDays}</td>
        <td>${order.status}</td>
      </tr>
    </c:forEach>
  </table>
  <a href="/">back</a>
</div>
</body>
</html>
