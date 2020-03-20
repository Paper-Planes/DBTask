<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/12
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="dbc.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 align="center">投保人信息管理</h1>
<%
    DatabaseConnection dbc = new DatabaseConnection() ;
    Connection conn=dbc.getConnection();//获取数据库连接
    Statement stmt= conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
    ResultSet rs=stmt.executeQuery("{call proPhAll}");
    int pageSize;//一页显示的记录数
    int totalItem;//记录总数
    int totalPage;//总页数
    int curPage;//待显示页码
    String strPage;
    int i;
    pageSize=4;//设置一页显示的记录数
    strPage=request.getParameter("page");//获得待显示页码
    if(strPage==null) {
        curPage=1;
    }
    else {
        curPage=java.lang.Integer.parseInt(strPage);//将字符串转换成整形
    }
    if(curPage<1) {
        curPage=1;
    }
    rs.last();//获取记录总数
    totalItem=rs.getRow();
    totalPage=(totalItem+pageSize-1)/pageSize;
    if(curPage>totalPage) curPage=totalPage;//调整待显示的页码
    if(totalPage>0)
    {//将记录指针到待显示页的第一条记录上
        rs.absolute((curPage-1)*pageSize+1);
    }
    i=0;
%>
<table width="75%" border="1" align="center" bordercolor="#996699" bgcolor="#FFFFFF" style="font-size: 15px">
    <tr bgcolor="#CCFFFF">
        <td align="center">投保人账号</td>
        <td align="center">投保人密码</td>
        <td align="center">投保人姓名</td>
        <td align="center">投保人身份证号</td>
        <td align="center">投保人电话</td>
        <td align="center">投保人地址</td>
        <%--<td align="center" colspan="2">操作</td>--%>
    </tr>
    <%//显示数据
        while(i<pageSize && !rs.isAfterLast()) {
    %>
    <tr>
        <td align="center"><%=rs.getString(1)%></td> <!---取出表中第一个字段-->
        <td align="center"><%=rs.getString(2)%></td>
        <td align="center"><%=rs.getString(3)%></td>
        <td align="center"><%=rs.getString(4)%></td>
        <td align="center"><%=rs.getString(5)%></td>
        <td align="center"><%=rs.getString(6)%></td>
        <%--<td align="center"><a href="/deletePolicyholder?delete=<%=rs.getString(1)%>">删除</a></td>--%>
        <%--<td align="center"><a href="updatePolicyholder.jsp?update=<%=rs.getString(1)%>">修改</a></td>--%>
    </tr>
    <%
            rs.next();
            i++;
        }
    %>
</table>
<p align="center">
    共<%=totalItem%>个记录,分<%=totalPage%>页显示,当前页是:第<%=curPage%>页<br />
        <%if(curPage>1){%><a href="empPhManage.jsp?page=1">首页</a><%}%>&nbsp;&nbsp;
        <%if(curPage>1){%><a href="empPhManage.jsp?page=<%=curPage-1%>">上一页</a><%}%>&nbsp;&nbsp;
        <%
   for(int j=1;j<=totalPage;j++)
   {
    out.print("&nbsp;&nbsp;<a href='empPhManage.jsp?page="+j+"'>"+j+"</a>");
   }
   %>
    &nbsp;&nbsp;
        <%if(curPage<totalPage){%><a href="empPhManage.jsp?page=<%=curPage+1%>">下一页</a><%}%>&nbsp;&nbsp;
        <%if(totalPage>1){%><a href="empPhManage.jsp?page=<%=totalPage%>">末页</a><%}%>
        <%
    rs.close();
   stmt.close();
   conn.close();
   dbc.close();
   %>
</body>
</html>
