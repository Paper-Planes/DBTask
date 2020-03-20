<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/2
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>注册界面</title>
    <link href="css/register.css" rel="stylesheet"/>
    <script type="text/javascript" src="js/register1.js" charset="UTF-8">
    </script>
</head>
<body>
<!-- 导航 -->
<div class="nav">
    <ul class="headerleft">
        <li><a href="index.jsp" class="her"> <img class="logo" src="images/logo4.png" width="399" height="46"/></a></li>
    </ul>
    <ul class="headerright">
        <li><a href="try/register.html">注册</a></li>
        <li><a href="login.jsp">登陆</a></li>
    </ul>
</div>
<div id="tab">
    <ul class="tab_menu">
        <li>顾客注册</li>
    </ul>
    <div class="tab_box">
        <!-- 注册开始 -->
        <div>
            <form method="post" name="form1" action="/phRegister">
                <div id="username">
                    <label>账&nbsp;&nbsp;&nbsp;&nbsp;号：</label>
                    <input type="text" name="phNumber" id="phNumber" placeholder="请输入您的账号"/>
                </div>
                <div id="passwor">
                    <label>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" name="phPwd" id="phPwd" placeholder="请输入您的密码"/>
                </div>
                <div id="passwo">
                    <label>确认密码：</label>
                    <input type="password" name="phPwd2" id="phPwd2" placeholder="重复您的密码" disabled=""/>
                </div>
                <div id="password">
                    <label>姓&nbsp;&nbsp;&nbsp;&nbsp;名：</label>
                    <input type="text" name="phName" id="phName" placeholder="请输入您的姓名"/>
                </div>
                <div id="passw">
                    <label>身份证号：</label>
                    <input type="password"  name="phID" id="phID" placeholder="请输入您的身份证号"/>
                </div>
                <div id="pa">
                    <label>身份证号：</label>
                    <input type="password"  name="phID2" id="phID2" placeholder="重复您的身份证号"disabled=""/>
                </div>
                <div id="pass">
                    <label>联系电话：</label>
                    <input type="text"  name="phPhone" id="phPhone" placeholder="请输入您的电话"/>
                </div>
                <div id="pas">
                    <label>家庭住址：</label>
                    <input type="text"  name="phAddr" id="phAddr" placeholder="请输入您的住址"/>
                </div>
                <!--验证码-->
                <div id="code">
                    <label>验证码：</label>
                    <input type="text" id="stu_code_hide" name="checkCode" placeholder="输验证码"/>
                    <img src="http://localhost:8080/checkCode" alt="验证码占位图"/>
                </div>
                <strong><div id="error" style="font-size: 20px"></div></strong>
                <div id="register">
                    <button type="submit" id="reg" value="注册" disabled="" >注册</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="bottom"><span>SWN车辆保险管理系统</span></div>
<div class="screenbg">
    <ul>
        <li><a><img src="images/b.jpg"></a></li>
    </ul>
</div>
</body>
</html>
