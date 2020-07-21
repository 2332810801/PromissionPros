<%--
  Created by IntelliJ IDEA.
  User: Joker_DJ
  Date: 2020/7/20
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/static/common/common.jsp"%>
    <script src="/static/js/employee.js"></script>
</head>
<body>
<div id="tb"><%--工具栏--%>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" id="add">添加</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" id="edit">编辑</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" id="delete">离职</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" id="reload">刷新</a>
    <input type="text" name="keyword" style="width: 200px; height: 30px;padding-left: 5px;">
    <a class="easyui-linkbutton" iconCls="icon-search" id="searchbtn">查询</a>
</div>

<%--数据表格--%>
<table id="dg"></table>
<%--对话框--%>
<div id="dialog">
    <form id="employeeForm">
        <%--隐藏域 编辑--%>
            <input type="hidden" name="id">
    <table align="center" style="border-spacing: 0px 10px">
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" class="easyui-validatebox" data-options="required:true"></td>
        </tr>
        <tr id="password">
            <td>用户密码:</td>
            <td><input type="password" name="password" class="easyui-validatebox"></td>
        </tr>
        <tr>
            <td>手机:</td>
            <td><input type="text" name="tel" class="easyui-validatebox"></td>
        </tr>
        <tr>
            <td>邮箱:</td>
            <td><input type="text" name="email" class="easyui-validatebox" <%--data-options="required:true,validType:'email'"--%> ></td>
        </tr>
        <tr>
            <td>入职日期:</td>
            <td><input type="text" name="inputtime" class="easyui-datebox" required="required"></td>
        </tr>
        <tr>
            <td>部门:</td>
            <td><input id="department" name="department.id" placeholder="请选择部门"></input></td>
        </tr>
        <tr>
            <td>是否管理员:</td>
            <td><input placeholder="是否为管理员" name="admin" id="state"></input></td>
        </tr>
    </table>
    </form>
</div>

</body>
</html>
