<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/12
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/register.css" rel="stylesheet"/>
    <script type="text/javascript" src="/js/addEmp1.js">
    </script>
</head>
<body>
<div id="tab">
    <ul class="tab_menu">
        <li>添加职工信息</li>
    </ul>
    <div class="tab_box">
        <div>
            <form method="post" name="form1" action="/addEmp">
                <div>
                    <label>职工账号：</label>
                    <input type="text" name="empNo" id="empNo" placeholder="请输入职工账号"/>
                </div>
                <div>
                    <label>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                    <input type="password" name="empPwd" id="empPwd1" placeholder="请输入职工密码"/>
                </div>
                <div>
                    <label>确认密码：</label>
                    <input type="password" name="empPwd2" id="empPwd2" placeholder="重复职工密码" disabled=""/>
                </div>
                <div>
                    <label>职工姓名：</label>
                    <input type="text" name="empName" id="empName" placeholder="请输入职工姓名"/>
                </div>
                <br>
                <div>
                    <label>
                        &nbsp;&nbsp;&nbsp;&nbsp;职工性别：
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                    <input type="radio" name="empSex" value="女" checked> 女
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="empSex" value="男"> 男
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </div>
                <div >
                    <label>职工职位：</label>
                    <input type="text"  name="emp" id="emp" placeholder="请输入职工职位"/>
                </div>
                <strong><div id="error" style="font-size: 20px"></div></strong>
                <div id="register">
                    <button type="submit" id="reg" value="添加" >添加</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
