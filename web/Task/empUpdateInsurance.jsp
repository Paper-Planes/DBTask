<%@ page import="factory.DaoFactory" %>
<%@ page import="vo.Insurance" %><%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/13
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" src="/js/updateInsurance1.js">
    </script>
</head>
<body>
<%
    int iNo=Integer.parseInt(request.getParameter("update"));
    session.setAttribute("I", DaoFactory.getInsuranceInstance().findById(iNo));
    Insurance insurance=new Insurance();
    insurance=(Insurance) session.getAttribute("I");
%>
<div id="out">
    <div id="repair">
        <form action="/updateInsurance" method="post">
            <table bgcolor="white">
                <th colspan="3" id="heade">审核保单信息</th>
                <tr>
                    <td class="des">保单编号：</td>
                    <td><%=insurance.getiNo()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">车辆牌照：</td>
                    <td><%=insurance.getPlateNumber()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">原保险开始时间：</td>
                    <td><%=insurance.getStartDate()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">保险开始时间：</td>
                    <td><input type="date" name="startDate" id="startDate"/></td>
                    <td class="mes"><span id="startDateMsg">请输入保险开始时间</span></td>
                </tr>
                <tr>
                    <td class="des">原保险截至时间：</td>
                    <td><%=insurance.getEndDate()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">保险截至时间：</td>
                    <td>
                        <input type="date" name="endDate" id="endDate"/>
                    </td>
                    <td class="mes"><span id="endDateMsg">请输入保险截至时间</span></td>
                </tr>
                <tr>
                    <td class="des">原保单类型：</td>
                    <td><%=insurance.getInsNo()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">保单类型：</td>
                    <td>
                        <input type="text" name="iType" id="iType"/>
                    </td>
                    <td class="mes"><span id="iTypeMsg">请输入选择保单类型</span></td>
                </tr>
                <tr>
                    <td class="des">原负责职员：</td>
                    <td><%=insurance.getEmpNo()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">负责职员：</td>
                    <td><input type="text" name="empNo" id="empNo"></td>
                    <td class="mes"><span id="empNoMsg">请输入负责职员编号</span></td>
                </tr>
                <tr>
                    <td></td>
                    <td >
                        <input type="submit" value="修改保单信息" class="button" id="update"/>
                    </td>
                    <td ></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
