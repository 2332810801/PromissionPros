<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户权限管理系统</title>
    <link href="./static/css/base.css" rel="stylesheet">
    <link href="./static/css/login.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/static/plugins/easyui/uimaker/easyui.css">
    <link rel="stylesheet" type="text/css" href="/static/plugins/easyui/uimaker/icon.css">
    <script type="text/javascript" src="/static/plugins/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/static/plugins/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/static/plugins/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="/static/base.js"></script>
    <script type="text/javascript" src="static/plugins/easyui/jquery.min.js"></script>
    <script src="static/plugins/easyui/jquery.easyui.min.js"></script>

</head>
<body class="white">
<div class="login-hd">
    <div class="left-bg"></div>
    <div class="right-bg"></div>
    <div class="hd-inner">
        <span class="logo"></span>
        <span class="split"></span>
        <span class="sys-name">用户权限管理系统</span>
    </div>
</div>
<div class="login-bd">
    <div class="bd-inner">
        <div class="inner-wrap">
            <div class="lg-zone">
                <div class="lg-box">
                    <div class="lg-label"><h4>用户登录</h4></div>

                    <form id="form">
                        <div class="lg-username input-item clearfix">
                            <i class="iconfont"></i>
                            <input type="text" value="itlike" name="username" placeholder="请用户名">
                        </div>
                        <div class="lg-password input-item clearfix">
                            <i class="iconfont"></i>
                            <input type="password" value="1234" name="password"  placeholder="请输入密码">
                        </div>

                        <div class="enter">
                            <a href="javascript:;" class="purchaser" id="loginBtn">点击登录</a>
                        </div>

                    </form>
                    <div class="line line-y"></div>
                    <div class="line line-g"></div>
                </div>
            </div>
            <div class="lg-poster"></div>
        </div>
    </div>
</div>
<div class="login-ft">
    <div class="ft-inner">
        <div class="about-us">
            <a href="javascript:;">关于我们</a>
            <a href="https://www.cnblogs.com/joker-dj">Joker_dj</a>
            <a href="javascript:;">服务条款</a>
            <a href="javascript:;">联系方式</a>
        </div>
        <div class="address"> 课程内容版权均归 Joker_dj 所有 &nbsp;编号：210019&nbsp;&nbsp;Copyright&nbsp;©&nbsp;2019&nbsp;-&nbsp;2020&nbsp;撩课&nbsp;版权所有</div>
        <div class="other-info">建议使用IE8及以上版本浏览器&nbsp;沪ICP备&nbsp;18036896号&nbsp;E-mail：itlike@126.com</div>
    </div>
</div>


<script type="text/javascript">
$(function () {
    $("#loginBtn").click(function () {
        /*发送post请求*/
        /*ajax没有办法实现服务器的跳转*/
        $.post("/login",$("#form").serialize(),function (data) {
            data=$.parseJSON(data)
            if(data.success){//认证成功
                /*跳转首页*/
                window.location.href="/index.jsp"
            }else{
                $.messager.alert("提示",data.msg);
            }
        })
    })
})
</script>
</body>
</html>
