<%--
  Created by IntelliJ IDEA.
  User: shan
  Date: 2019/1/10
  Time: 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.jfree.data.general.DefaultPieDataset" %>
<%@ page import="org.jfree.chart.JFreeChart" %>
<%@ page import="org.jfree.chart.ChartFactory" %>
<%@ page import="java.awt.*" %>
<%@ page import="org.jfree.chart.plot.PiePlot3D" %>
<%@ page import="org.jfree.chart.labels.StandardPieSectionLabelGenerator" %>
<%@ page import="java.io.File" %>
<%@ page import="org.jfree.chart.ChartUtilities" %>
<%@ page import="java.io.IOException" %>
<%@ page import="org.jfree.chart.ChartFrame" %>
<%@ page import="dbc.DatabaseConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int a1=0;
    int a2=0;
    int a3=0;
    int a4=0;
    int a5=0;
    int a6=0;
    int a7=0;
    int a8=0;
    int a9=0;
    DatabaseConnection dbc = new DatabaseConnection() ;
    Connection conn=dbc.getConnection();//获取数据库连接
    Statement stmt= conn.createStatement();
    String sql1="select count(*)交强险 From Insurance where insNo='001'";
    ResultSet rs1=stmt.executeQuery(sql1);
    while (rs1.next()){
        a1=Integer.parseInt(rs1.getString("交强险"));
    }
    String sql2="select count(*)商业第三者责任险 From Insurance where insNo='002'";
    ResultSet rs2=stmt.executeQuery(sql2);
    while (rs2.next()){
        a2=Integer.parseInt(rs2.getString("商业第三者责任险"));
    }
    String sql3="select count(*)全车盗抢险 From Insurance where insNo='003'";
    ResultSet rs3=stmt.executeQuery(sql3);
    while (rs3.next()){
        a3=Integer.parseInt(rs3.getString("全车盗抢险"));
    }
    String sql4="select count(*)司机座位责任险 From Insurance where insNo='004'";
    ResultSet rs4=stmt.executeQuery(sql4);
    while (rs4.next()){
        a4=Integer.parseInt(rs4.getString("司机座位责任险"));
    }
    String sql5="select count(*)乘客座位责任险 From Insurance where insNo='005'";
    ResultSet rs5=stmt.executeQuery(sql5);
    while (rs5.next()){
        a5=Integer.parseInt(rs5.getString("乘客座位责任险"));
    }
    String sql6="select count(*)不计免赔特约险 From Insurance where insNo='006'";
    ResultSet rs6=stmt.executeQuery(sql6);
    while (rs6.next()){
        a6=Integer.parseInt(rs6.getString("不计免赔特约险"));
    }
    String sql7="select count(*)玻璃单独破碎险 From Insurance where insNo='007'";
    ResultSet rs7=stmt.executeQuery(sql7);
    while (rs7.next()){
        a7=Integer.parseInt(rs7.getString("玻璃单独破碎险"));
    }
    String sql8="select count(*)自燃损失险 From Insurance where insNo='008'";
    ResultSet rs8=stmt.executeQuery(sql8);
    while (rs8.next()){
        a8=Integer.parseInt(rs8.getString("自燃损失险"));
    }
    String sql9="select count(*)车身刮痕损失险 From Insurance where insNo='009'";
    ResultSet rs9=stmt.executeQuery(sql9);
    while (rs9.next()){
        a9=Integer.parseInt(rs9.getString("车身刮痕损失险"));
    }


    /* 1、创建饼形图数据集对象 DefaultPieDataset */
    DefaultPieDataset dataset = new DefaultPieDataset();
    /* 2、往饼形图数据集对象 DefaultPieDataset 中添加数据 */
    dataset.setValue("交强险", a1);
    dataset.setValue("商业第三者责任险", a2);
    dataset.setValue("全车盗抢险", a3);
    dataset.setValue("司机座位责任险", a4);
    dataset.setValue("乘客座位责任险", a5);
    dataset.setValue("不计免赔特约险", a6);
    dataset.setValue("玻璃单独破碎险", a7);
    dataset.setValue("自燃损失险", a8);
    dataset.setValue("车身刮痕损失险", a9);



    /* 3、创建图形对象 JFreeChart：主标题的名称，图标显示的数据集合，是否显示子标题，是否生成提示的标签，是否生成URL链接 */
    String title = "各类型保险统计报表";
    JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, true);

    /* 4、处理乱码 */
    // 处理主标题的乱码
    chart.getTitle().setFont(new Font("宋体", Font.BOLD, 18));
    // 处理子标题乱码
    chart.getLegend().setItemFont(new Font("宋体", Font.BOLD, 15));
    /* 5、获取饼形图图表区域对象 PiePlot3D */
    PiePlot3D categoryPlot = (PiePlot3D) chart.getPlot();
    /* 6、处理图像上的乱码 */
    categoryPlot.setLabelFont(new Font("宋体", Font.BOLD, 15));
    /* 7、设置图形的生成数据格式为（张三 40 （40%）） */
    String format = "{0} {1} ({2})";
    categoryPlot.setLabelGenerator(new StandardPieSectionLabelGenerator(format));

    /* 8、生成相应的图片 */
//    File file = new File("I:/PieChart3D.JPEG");
    File file = new File("I:/PieChart3D.JPEG");
    try {
        ChartUtilities.saveChartAsJPEG(file, chart, 800, 600);
    } catch (IOException e) {
        e.printStackTrace();
    }

    /* 9、使用 ChartFrame 对象显示图像：title是标题，chart是前面程序JFreeChart定义的变量名，true表示是否设置滚动条 */
    title = "各类型保险统计报表";
    ChartFrame chartFrame = new ChartFrame(title, chart, true);
    // 图形是否可见
    chartFrame.setVisible(true);
    // 以合适的大小展现图形
    chartFrame.pack();
%>
</body>
</html>
