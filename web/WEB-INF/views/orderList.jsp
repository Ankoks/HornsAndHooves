<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: AntonK
  Date: 09.01.2018
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
  <h1>Order List</h1>
  <h3>
    <a href="/newOrder">New Order</a>
  </h3>
  <table border="1">

    <th>ID</th>
    <th>Name</th>
    <th>Type</th>
    <th>Order date</th>
    <th>Status</th>
    <th>Day(s) to end</th>

    <c:forEach var="order" items="${listOrder}">
      <tr>
        <td>${order.id}</td>
        <td>${order.name}</td>
        <td>${order.item.title}</td>
        <td><fmt:formatDate pattern = "dd.MM.yyyy" value = "${order.orderDate}"/></td>
        <td>${order.status.title}</td>
        <td>${order.completeDays}</td>
        <td><a href="editOrder?id=${order.id}">Edit</a>
          <a href="deleteOrder?id=${order.id}">Delete</a></td>
      </tr>
    </c:forEach>
  </table>
  <a href="/">back</a>
</div>
</body>
</html>
