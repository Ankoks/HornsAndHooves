<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
  <h1>New/Edit Employee</h1>
  <form:form action="saveEmployee" method="post" modelAttribute="employee">
    <table>
      <form:hidden path="id"/>
      <tr>
        <td>Name:</td>
        <td><form:input path="name" /></td>
      </tr>
      <tr>
        <td>Department:</td>
        <td>
          <form:select path="department">
            <form:option value="-" label="--Please Select"/>
            <form:options items="${departmentList}" itemValue="name" itemLabel="title"/>
          </form:select>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" value="Save"></td>
      </tr>
    </table>
  </form:form>
</div>
</body>
</html>
