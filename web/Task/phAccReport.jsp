<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/13
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vo.AccReport" %>
<%@ page import="java.util.List" %>
<%@ page import="factory.DaoFactory" %>
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
        <td align="center" bgcolor="#CCFFFF">报案编号</td>
        <td align="center" bgcolor="#CCFFFF">保险单号</td>
        <td align="center" bgcolor="#CCFFFF">投保人</td>
        <td align="center" bgcolor="#CCFFFF">报案时间</td>
        <td align="center" bgcolor="#CCFFFF">事故地点</td>
        <td align="center" bgcolor="#CCFFFF">事故原因</td>
        <td align="center" bgcolor="#CCFFFF">事故处理状态</td>
    </tr>
        <%

         String ph=(String) session.getAttribute("PI");
         List<AccReport> all = DaoFactory.getIAccReporttance().findByEmp(ph);
        Iterator<AccReport> iter = all.iterator() ;
        while(iter.hasNext()) {
            AccReport accReport=iter.next();
        %>
    <tr>
        <td align="center"><%=accReport.getAccNo()%></td>
        <td align="center"><%=accReport.getiNo()%></td>
        <td align="center"><%=accReport.getPhNumber()%></td>
        <td align="center"><%=accReport.getReportTime()%></td>
        <td align="center"><%=accReport.getRiskSpot()%></td>
        <td align="center"><%=accReport.getRiskReason()%></td>
        <td align="center"><%=accReport.getAccstate()%></td>
    </tr>
        <%
        }
    %>
</body>
</html>
