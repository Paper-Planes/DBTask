<%@ page import="vo.policyholder" %><%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/12
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" src="/js/phSelfUpdate.js">
    </script>
</head>
<body>
<%
    policyholder ph=new policyholder();
    ph=(policyholder) session.getAttribute("ph");
%>
<div id="out">
    <div id="repair">
        <form action="/updatePolicyholder" method="post">
            <table bgcolor="white">
                <th colspan="3" id="heade">修改个人信息</th>
                <tr>
                    <td class="des">原姓名：</td>
                    <td><%=ph.getPhName()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">姓名：</td>
                    <td><input type="text" name="phName" id="phName"/></td>
                    <td class="mes"><span id="phNameMsg">请输入4到20个字符，1个汉字为两个字符</span></td>
                </tr>
                <tr>
                    <td class="des">密码：</td>
                    <td><input type="password" name="phPwd" id="phPwd1"/></td>
                    <td class="mes"><span id="phPwd1Msg">请输入4-20位数字与字母组合</span></td>
                </tr>
                <tr>
                    <td class="des">确认密码：</td>
                    <td><input type="password" name="phPwd2" id="phPwd2" disabled=""/></td>
                    <td class="mes"><span id="phPwd2Msg">与密码保持一致</span></td>
                </tr>
                <tr>
                    <td class="des">身份证号：</td>
                    <td><%=ph.getPhID()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">身份证号：</td>
                    <td>
                        <input type="password" name="phID" id="phID"/>
                    </td>
                    <td class="mes"><span id="phIDMsg">请输入正确的身份证号</span></td>
                </tr>
                <tr>
                    <td class="des">确认身份证号：</td>
                    <td>
                        <input type="password" name="phID2" id="phID2" disabled=""/>
                    </td>
                    <td class="mes"><span id="phID2Msg">请再次输入身份证号</span></td>
                </tr>
                <tr>
                    <td class="des">原手机号：</td>
                    <td><%=ph.getPhPhone()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">手机号：</td>
                    <td><input type="text" name="phPhone" id="phPhone"/></td>
                    <td class="mes"><span id="phPhoneMsg">请输入新手机号</span></td>
                </tr>
                <tr>
                    <td class="des">原地址：</td>
                    <td><%=ph.getPhAddr()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">地址：</td>
                    <td><input type="text" name="phAddr" id="phAddr"></td>
                    <td class="mes"><span id="phAddrMsg">请输入新住址</span></td>
                </tr>
                <tr>
                    <td></td>
                    <td >
                        <input type="submit" value="修改信息" class="button" id="update" disabled=""/>
                    </td>
                    <td ></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
