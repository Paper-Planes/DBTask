<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/13
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="out">
    <div id="repair">
        <form action="/phAccReportAdd" method="post">
            <table bgcolor="white">
                <th colspan="3" id="heade">填写报案信息</th>
                <tr>
                    <td class="des">保单号：</td>
                    <td><input type="text" name="iNo" id="iNo" placeholder="请输入一个正确的保单号"/></td>
                    <td class="mes"><span id="iNoMsg">请输入一个正确的保单号</span></td>
                </tr>
                <tr>
                    <td class="des">事故地点：</td>
                    <td><input type="text" name="riskSpot" id="riskSpot"/></td>
                    <td class="mes"><span id="riskSpotMsg">请输入事故发生地点</span></td>
                </tr>
                <tr>
                    <td class="des">事故原因：</td>
                    <td><input type="text" name="riskReason" id="riskReason"/></td>
                    <td class="mes"><span id="riskReasonMsg">请简述事故原因</span></td>
                </tr>
                <tr>
                    <td></td>
                    <td >
                        <input type="submit" value="确认报案信息" class="button" id="update"/>
                    </td>
                    <td ></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
