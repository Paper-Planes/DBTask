<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/12
  Time: 9:56
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
        <LI><A href="Task/phInsuranceType.jsp" target="luck">最新险种信息</A>
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
        <LI><a href="Task/phSelfInformation.jsp" target="luck">个人信息</a>
            <UL>
                <LI><a href="Task/phSelfInformationUpdate.jsp"target="luck">修改个人信息</a></LI>
            </UL>
        </LI>
        <LI><a href="Task/phSelfCar.jsp" target="luck">个人车辆信息</a>
            <UL>
                <LI><a href="Task/phCarAdd.jsp"target="luck">添加个人车辆</a></LI>
            </UL>
        </LI>
        <LI><A href="Task/phSelfInsurance.jsp" target="luck">保单信息</A>
        </LI>
        <LI><A href="Task/phAccReport.jsp" target="luck">报案信息</A>
            <UL>
                <LI><a href="Task/phAccReportAdd.jsp"target="luck">事故报案信息</a></LI>
            </UL>
        </LI>
        <LI><A href="Task/phSurvey.jsp" target="luck">保险理赔信息</A>
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
