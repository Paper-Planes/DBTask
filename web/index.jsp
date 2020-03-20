<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/11
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SWN车辆保险管理系统</title>
    <link rel="stylesheet" href="css/style.css">
    <script>
        window.onload=function(){
            var imgs =["images/b1.png", "images/b2.jpg", "images/b3.png"];    //（设定想要显示的图片）
            var i = 0;
            var head=document.getElementById("content");//获取DIV对象
            head.style.background="url(images/b1.png)";   //设置图片的初始图片为该路径的图片
            head.style.backgroundRepeat= "no-repeat";
            head.style.backgroundSize="cover";
            function time(){
                i++;
                i=i%3;         // 超过2则取余数，保证循环在0、1、2之间
                head.style.background="url("+imgs[i]+")";
                head.style.backgroundRepeat= "no-repeat";
                head.style.backgroundSize="cover";
            }
            setInterval(time,3000);//循环调用time1()函数，时间间隔为2000ms
            //setInterval()函数，按照指定的周期（按毫秒计）来调用函数或表达式
        }
    </script>
  </head>
  <body>
  <!-- 导航 -->
  <div class="nav">
    <ul class="headerleft">
      <li><img class="logo" src="images/logo4.png" width="399" height="46"/></li>
    </ul>

    <ul class="headerright">
      <li><a href="register.jsp" target="locate">注册</a></li>
      <li><a href="login.jsp" target="locate">登陆</a></li>
    </ul>
  </div>
  <!--主体内容-->
  <div id="content">
  </div>
  <!--div class="footer">
    <ul>
      <li>SWN车辆保险管理系统</li>
    </ul>
  </div-->
  </body>
</html>
