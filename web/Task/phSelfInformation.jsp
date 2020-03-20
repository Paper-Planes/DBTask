<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/12
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vo.policyholder" %>
<%@ page import="factory.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String ph=(String) session.getAttribute("PI");
    policyholder p= DaoFactory.getIpolicyholderDaoInstance().findById(ph);

%>
<h1 align="center">个人信息:</h1>
<table width="50%" border="0" align="center" bordercolor="#996699" bgcolor="#FFFFFF"style="font-size: 15px">
    <tr>
        <td align="center" bgcolor="#CCFFFF">个人账号:</td>
        <td><%=p.getPhNumber()%></td>
    </tr>
    <tr >
        <td align="center" bgcolor="#CCFFFF">个人密码:</td>
        <td><%=p.getPhPwd()%></td>
    </tr>
    <tr >
        <td align="center" bgcolor="#CCFFFF">个人姓名:</td>
        <td><%=p.getPhName() %></td>
    </tr>
    <tr >
        <td align="center" bgcolor="#CCFFFF">身份证号:</td>
        <td><%=p.getPhID()%></td>
    </tr>
    <tr >
        <td align="center" bgcolor="#CCFFFF">个人电话:</td>
        <td><%=p.getPhPhone()%></td>
    </tr>
    <tr >
        <td align="center" bgcolor="#CCFFFF">个人地址:</td>
        <td><%=p.getPhAddr()%></td>
    </tr>
</table>
</body>
</html>
