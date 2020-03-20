<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/13
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/register.css" rel="stylesheet"/>
</head>
<body>
<div id="tab">
    <ul class="tab_menu">
        <li>理赔信息</li>
    </ul>
    <div class="tab_box">
        <div>
            <form method="post" name="form1" action="/addSurvey">
                <div>
                    <label>事故编号：</label>
                    <input type="text" name="AccNo" id="AccNo" placeholder="请输入事故编号"/>
                </div>
                <div>
                    <label>损失金额：</label>
                    <input type="text" name="LostMoney" id="LostMoney" placeholder="请输入客户损失金额"/>
                </div>
                <div>
                    <label>赔付金额：</label>
                    <input type="text" name="PayMoney" id="PayMoney" placeholder="重复公司赔付金额" />
                </div>
                <div>
                    <label>负责职工：</label>
                    <input type="text" name="empNo" id="empNo" placeholder="请输入负责职工编号"/>
                </div>
                <br>
                <div id="register">
                    <button type="submit" id="reg" value="添加" >提交理赔信息</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
