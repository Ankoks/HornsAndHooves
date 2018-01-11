<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: AntonK
  Date: 09.01.2018
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div align="center">
  <h1>New/Edit Order</h1>
  <form:form action="saveOrder" method="post" modelAttribute="order">
    <table>
      <form:hidden path="id"/>
      <tr>
        <td>Name:</td>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td>Type:</td>
        <td>
          <form:select path="item">
            <form:option value="-" label="--Please Select"/>
            <form:options items="${itemList}" itemValue="name" itemLabel="title"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td>Order date:</td>
        <td><form:input type="text" path="orderDate"/> (date in 'dd.MM.yyyy' format)</td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"></td>
      </tr>
    </table>
  </form:form>
  <a href="/orderList">back</a>
</div>
</body>
</html>
