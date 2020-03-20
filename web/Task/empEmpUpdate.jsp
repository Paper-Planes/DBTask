<%@ page import="factory.DaoFactory" %>
<%@ page import="vo.Emp" %><%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/12
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/style.css">
    <script type="text/javascript" src="/js/updateEmp1.js">
    </script>
</head>
<body>
<%
    String empNo=request.getParameter("update");
    session.setAttribute("em", DaoFactory.getEmpInstance().findById(empNo));
    Emp em=new Emp();
    em=(Emp) session.getAttribute("em");
%>
<div id="out">
    <div id="repair">
        <form action="/updateEmp" method="post">
            <table bgcolor="white">
                <th colspan="3" id="heade">修改职工信息</th>
                <tr>
                    <td class="des">原密码：</td>
                    <td><%=em.getEmpPwd()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">密码：</td>
                    <td><input type="password" name="empPwd1" id="empPwd1"/></td>
                    <td class="mes"><span id="empPwd1Msg">请输入新密码</span></td>
                </tr>
                <tr>
                    <td class="des">确认密码：</td>
                    <td><input type="password" name="empPwd2" id="empPwd2"></td>
                    <td class="mes"><span id="empPwd2Msg">再次确定密码</span></td>
                </tr>
                <tr>
                    <td class="des">原姓名：</td>
                    <td><%=em.getEmpName()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">姓名：</td>
                    <td><input type="text" name="empName" id="empName"/></td>
                    <td class="mes"><span id="empNameMsg">请输入4到20个字符，1个汉字为两个字符</span></td>
                </tr>
                <tr>
                    <td class="des">原性别：</td>
                    <td><%=em.getEmpSex()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">性别：</td>
                    <td><div id="checkSex">&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="empSex" value="女" checked> 女
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="empSex" value="男"> 男 </div>
                    </td>
                    <td class="mes"><span id="sexMsg">请选择你的性别!</span></td>
                </tr>
                <tr>
                    <td class="des">原职位：</td>
                    <td><%=em.getEmp()%></td>
                    <td class="mes"></td>
                </tr>
                <tr>
                    <td class="des">职位：</td>
                    <td>
                        <input type="text" name="position" id="position"/>
                    </td>
                    <td class="mes"><span id="positionMsg">请输入职工职位</span></td>
                </tr>
                <tr>
                    <td></td>
                    <td >
                        <input type="submit" value="修改信息" class="button" id="update"/>
                    </td>
                    <td ></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
