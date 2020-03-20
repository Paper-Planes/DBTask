<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/4
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="vo.InsuranceType" %>
<%@ page import="factory.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" src="/js/addInsurancePh1.js">
    </script>
</head>
<body>
<%
    String ins=request.getParameter("update");
    session.setAttribute("buy", DaoFactory.getITypeInstance().findById(ins));
    InsuranceType buy=new InsuranceType();
    buy=(InsuranceType) session.getAttribute("buy");
%>
<div id="out">
    <div id="repair">
        <form action="/buyInsurance" method="post">
            <table bgcolor="white">
                <th colspan="3" id="heade">购买保险</th>
                <tr>
                    <td class="des">车辆牌照：</td>
                    <td><input type="text" name="plateNumber" id="plateNumber"/></td>
                    <td class="mes"><span id="plateNumberMsg">请输入正确的车牌号</span></td>
                </tr>
                <tr>
                    <td class="des">保险类型：</td>
                    <td><%=buy.getInsName()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">保险开始时间：</td>
                    <td><input type="date" name="startDate" id="startDate"/></td>
                    <td class="mes"><span id="startDateMsg">请输入保险开始时间</span></td>
                </tr>
                <tr>
                    <td class="des">保险截至时间：</td>
                    <td>
                        <input type="date" name="endDate" id="endDate"/>
                    </td>
                    <td class="mes"><span id="endDateMsg">请输入保险截至时间</span></td>
                </tr>
                <tr>
                    <td></td>
                    <td >
                        <input type="submit" value="确认添加保单" class="button" id="update"/>
                    </td>
                    <td ></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
