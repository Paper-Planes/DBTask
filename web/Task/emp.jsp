<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/12
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/Menutop.css">
</head>
<body class="b">
<!-- 导航 -->
<div class="nav">
    <ul class="headerleft">
        <li><img class="logo" src="/images/logo4.png" width="399" height="46"/></li>
    </ul>
    <UL id=fm>
        <LI><A href="Task/empInsuranceType.jsp" target="luck">车辆险种管理</A>
            <UL>
                <LI><A href="Task/i1.jsp" target="luck">商业第三者责任险</A></LI>
                <LI><A href="Task/i2.jsp" target="luck">全车盗抢险</A></LI>
                <LI><A href="Task/i3.jsp" target="luck">司机座位责任险</A></LI>
                <LI><A href="Task/i4.jsp" target="luck">乘客座位责任险</A></LI>
                <LI><A href="Task/i5.jsp" target="luck">不计免赔特约险</A></LI>
                <LI><A href="Task/i6.jsp" target="luck">玻璃单独破碎险</A></LI>
                <LI><A href="Task/i7.jsp" target="luck">自燃损失险</A></LI>
                <LI><A href="Task/i8.jsp" target="luck">车身刮痕损失险</A></LI>
            </UL>
        </LI>
        <LI><a href="Task/empPhManage.jsp" target="luck">投保人管理</a>
        </LI>
        <LI><a href="Task/empEmpManage.jsp" target="luck">职工管理</a>
            <UL>
                <LI><a href="Task/empEmpAdd.jsp"target="luck">添加职工信息</a></LI>
            </UL>
        </LI>
        <LI><a href="Task/empCar.jsp" target="luck">车辆管理</a>
        </LI>
        <LI><A href="Task/empInsurance.jsp" target="luck">保单管理</A>
        </LI>
        <LI><A href="Task/empAccReport.jsp" target="luck">事故报案</A>
        </LI>
        <LI><A href="Task/empSurvey.jsp" target="luck">事故理赔</A>
            <UL>
                <LI><a href="Task/empSurveyAdd.jsp"target="luck">添加理赔信息</a></LI>
            </UL>
        </LI>
        <LI><A href="Task/chart.jsp" target="luck">各险种销售信息</A>
        </LI>
    </UL>
</div>
<!--主体内容-->
<div id="content">
    <iframe width="100%"  height="500px"  name="luck"></iframe>
</div>
<!--div class="footer">
    <ul>
        <li>SWN车辆保险管理系统</li>
    </ul>
</div-->
</body>
</html>
