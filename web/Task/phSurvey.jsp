<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/13
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vo.Survey" %>
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
        <td align="center" bgcolor="#CCFFFF">理赔编号</td>
        <td align="center" bgcolor="#CCFFFF">报案编号</td>
        <td align="center" bgcolor="#CCFFFF">损失金额</td>
        <td align="center" bgcolor="#CCFFFF">赔付金额</td>
        <td align="center" bgcolor="#CCFFFF">负责员工</td>
    </tr>
        <%

         String ph=(String) session.getAttribute("PI");
         List<Survey> all = DaoFactory.getISurveytance().findByEmp(ph);
        Iterator<Survey> iter = all.iterator() ;
        while(iter.hasNext()) {
            Survey survey=iter.next();
        %>
    <tr>
        <td align="center"><%=survey.getSurveyNumber()%></td>
        <td align="center"><%=survey.getAccNo()%></td>
        <td align="center"><%=survey.getLostMoney()%></td>
        <td align="center"><%=survey.getPayMoney()%></td>
        <td align="center"><%=survey.getEmpNo()%></td>
    </tr>
        <%
        }
    %>
</body>
</html>
