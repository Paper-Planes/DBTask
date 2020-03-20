<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/2
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SWN车辆保险管理系统</title>
    <link href="css/login.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <link href="css/style.css" rel="stylesheet" rev="stylesheet" type="text/css" media="all" />
    <script type="text/javascript">
        function check() {
            var list=document.getElementsByName("radio");
            for(i=0;i<list.length;i++){
                if(list[i].checked==true){
                    if(list[i].value=="顾客")
                    {
                        document.form1.action="/phLogin";
                        document.form1.submit();
                        break;
                    }
                    //如果选择职员
                    if(list[i].value=="职员")
                    {
                        document.form1.action="/empLogin";
                        document.form1.submit();
                        break;
                    }
                }
            }
        }
    </script>
</head>
<body>
<!-- 导航 -->
<div class="nav">
    <ul class="headerleft">
        <li><a href="index.jsp" class="her">
            <img class="logo" src="images/logo4.png" width="399" height="46"/>
        </a></li>
    </ul>
    <ul class="headerright">
        <li><a href="register.jsp">注册</a></li>
        <li><a href="login.jsp">登陆</a></li>
    </ul>
</div>

<div id="tab">
    <ul class="tab_menu">
        <li>登录界面</li>
    </ul>
    <div class="tab_box">
        <!-- 登录开始 -->
        <div>
            <form  method="post" name="form1">
                <div id="username">
                    <label>账&nbsp;&nbsp;&nbsp;号：</label>
                    <input type="text"  name="phNumber" placeholder="请输入您的账号" value="${name}"/>
                </div>
                <div id="password">
                    <label>密&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password"  name="phPwd"placeholder="请输入您的密码" value="${pass}"/>
                </div>
                <!--验证码-->
                <div id="code">
                    <label>验证码：</label>
                    <input type="text" id="stu_code_hide" name="checkCode" placeholder="输入验证码"/>
                    <img src="http://localhost:8080/checkCode" alt="验证码占位图"/>
                </div>
                <!--单选按钮-->
                <div id="remember">
                    <input type="radio" name="radio"  value="顾客">顾客
                    &nbsp; &nbsp; &nbsp; &nbsp;
                    <input type="radio" name="radio" value="职员">职员
                </div>
                <div id="login">
                    <button type="submit" onclick="check()" value="登录">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="bottom"><span>SWN车辆保险管理系统</span></div>
<div class="screenbg">
    <ul>
        <li><a href="javascript:;"><img src="images/b.jpg"></a></li>
    </ul>
</div>
</body>
</html>
