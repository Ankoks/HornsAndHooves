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
  <h1>Non-complete orders list</h1>
  <table border="1">
    <th>Order name</th>
    <th>Order date</th>
    <th>Day(s) to end</th>
    <th>Order Status</th>

    <c:forEach var="item" items="${nonCompleteOrders}">
      <tr>
        <td>${item.name}</td>
        <td><fmt:formatDate pattern = "dd.MM.yyyy" value = "${item.orderDate}"/></td>
        <td>${item.completeDays}</td>
        <td>${item.status.title}</td>
      </tr>
    </c:forEach>
  </table>
  <a href="/">back</a>
</div>
</body>
</html>
