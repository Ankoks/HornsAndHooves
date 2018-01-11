<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <h1>Employee List</h1>
  <h3>
    <a href="newEmployee">New Employee</a>
  </h3>
  <table border="1">

    <th>ID</th>
    <th>Name</th>
    <th>Department</th>
    <th>Ready for work</th>

    <c:forEach var="order" items="${listEmployee}">
      <tr>
        <td>${order.id}</td>
        <td>${order.name}</td>
        <td>${order.department.title}</td>
        <td>${order.free}</td>
        <td><a href="editEmployee?id=${order.id}">Edit</a>
          <a href="deleteEmployee?id=${order.id}">Delete</a></td>
      </tr>
    </c:forEach>

  </table>
  <a href="/">back</a>
</div>
</body>
</html>
