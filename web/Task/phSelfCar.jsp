<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/12
  Time: 19:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vo.Car" %>
<%@ page import="factory.DaoFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">个人车辆信息</h1>
<table width="70%" border="1" align="center" bordercolor="#996699" bgcolor="#FFFFFF"style="font-size: 15px">
    <tr>
        <td align="center" bgcolor="#CCFFFF">车牌照号</td>
        <td align="center" bgcolor="#CCFFFF">行驶证号</td>
        <td align="center" bgcolor="#CCFFFF">发动机号</td>
        <td align="center" bgcolor="#CCFFFF">车架号码</td>
        <td align="center" bgcolor="#CCFFFF">车辆类型</td>
        <td align="center" bgcolor="#CCFFFF">核定座位</td>
        <td align="center" bgcolor="#CCFFFF">初次登记时间</td>
        <td align="center" bgcolor="#CCFFFF">车辆价格</td>
    </tr>
        <%

         String ph=(String) session.getAttribute("PI");
         List<Car> all = DaoFactory.getCarInstance().findByEmp(ph);
        Iterator<Car> iter = all.iterator() ;
        while(iter.hasNext()) {
            Car car=iter.next();
        %>
    <tr>
        <td align="center"><%=car.getPlateNumber()%></td>
        <td align="center"><%=car.getDriLic()%></td>
        <td align="center"><%=car.getEngine()%></td>
        <td align="center"><%=car.getVin()%></td>
        <td align="center"><%=car.getVehicleType()%></td>
        <td align="center"><%=car.getSeat()%></td>
        <td align="center"><%=car.getInitialTime()%></td>
        <td align="center"><%=car.getPrice()%></td>
    </tr>
        <%
        }
    %>
</body>
</html>
