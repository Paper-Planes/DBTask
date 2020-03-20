<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/13
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vo.Insurance" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="factory.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">个人保险信息</h1>
<table width="70%" border="1" align="center" bordercolor="#996699" bgcolor="#FFFFFF"style="font-size: 15px">
    <tr>
        <td align="center" bgcolor="#CCFFFF">保险编号</td>
        <td align="center" bgcolor="#CCFFFF">车辆牌照</td>
        <td align="center" bgcolor="#CCFFFF">保险开始时间</td>
        <td align="center" bgcolor="#CCFFFF">保险截至时间</td>
        <td align="center" bgcolor="#CCFFFF">保险类型</td>
        <td align="center" bgcolor="#CCFFFF">处理员工</td>
    </tr>
        <%

         String ph=(String) session.getAttribute("PI");
         List<Insurance> all = DaoFactory.getInsuranceInstance().findByEmp(ph);
        Iterator<Insurance> iter = all.iterator() ;
        while(iter.hasNext()) {
           Insurance i=iter.next();
        %>
    <tr>
        <td align="center"><%=i.getiNo()%></td>
        <td align="center"><%=i.getPlateNumber()%></td>
        <td align="center"><%=i.getStartDate()%></td>
        <td align="center"><%=i.getEndDate()%></td>
        <td align="center"><%=i.getInsNo()%></td>
        <td align="center"><%=i.getEmpNo()%></td>
    </tr>
        <%
        }
    %>
</body>
</html>
