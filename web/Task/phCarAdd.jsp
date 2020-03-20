<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/12
  Time: 19:46
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
        <form action="/addCarPh" method="post">
            <table bgcolor="white">
                <th colspan="3" id="heade">添加车辆信息</th>
                <tr>
                    <td class="des">车牌照号：</td>
                    <td><input type="text" name="plateNumber" id="plateNumber"/></td>
                    <td class="mes"><span id="plateNumberMsg">请输入正确的车牌号</span></td>
                </tr>
                <tr>
                    <td class="des">行驶证号：</td>
                    <td><input type="text" name="driLic" id="driLic"/></td>
                    <td class="mes"><span id="driLicMsg">请输入正确的行驶证号</span></td>
                </tr>
                <tr>
                    <td class="des">发动机号：</td>
                    <td><input type="text" name="engine" id="engine"/></td>
                    <td class="mes"><span id="engineMsg">请输入正确的发动机号</span></td>
                </tr>
                <tr>
                    <td class="des">车架号码：</td>
                    <td><input type="text" name="vinNo" id="vinNo"></td>
                    <td class="mes"><span id="vinMsg">请输入正确的车架号码</span></td>
                </tr>
                <tr>
                    <td class="des">车辆类型：</td>
                    <td>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="vehicleType" value="小汽车" checked> 小汽车
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="radio" name="vehicleType" value="客车">客车
                    </td>
                    <td class="mes"><span id="vehicleTypeMsg">请选择车辆类型</span></td>
                </tr>
                <tr>
                    <td class="des">座位数：</td>
                    <td>
                        <input type="text" name="seat" id="seat"/>
                    </td>
                    <td class="mes"><span id="seatMsg">请输入车辆核定座位</span></td>
                </tr>
                <tr>
                    <td class="des">初次登记时间：</td>
                    <td><input type="date" name="initialTime" id="initialTime"></td>
                    <td class="mes"><span id="initialTimeMsg">请输入初次登记时间</span></td>
                </tr>
                <tr>
                    <td class="des">车辆价格：</td>
                    <td><input type="text" name="price" id="price"></td>
                    <td class="mes"><span id="priceMsg">请输入车辆价格</span></td>
                </tr>
                <tr>
                    <td></td>
                    <td >
                        <input type="submit" value="添加车辆信息" class="button" id="update"/>
                    </td>
                    <td ></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
