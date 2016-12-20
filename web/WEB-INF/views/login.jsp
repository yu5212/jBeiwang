<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="st" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<html>
<head>
    <title>用户注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/assets/bootstrap/css/bootstrap.css" rel="stylesheet" />
    <link href="/assets/css/main.css" rel="stylesheet" />
    <script src="/assets/bootstrap/js/jquery.min.js"></script>
    <script src="/assets/bootstrap/js/bootstrap.js"></script>
    <script src="/assets/js/beiwang/main.js"></script>
</head>
<body>
<div style="width:1200px; margin:0px auto;">
    <div style="padding:10px;" class="row">
        <div class="col-xs-6">
            <img src="/assets/images/logo.png" style="width:270px; height:90px; ">
        </div>
        <div class="col-xs-6" style="text-align:right;">
            <ul class="nav nav-pills" role="tablist">
                <li role="presentation"><a href="#">Home <span class="badge">42</span></a></li>
                <li role="presentation"><a href="#">Profile</a></li>
                <li role="presentation"><a href="#">Messages <span class="badge">3</span></a></li>
            </ul>
        </div>
    </div>
    <div class="jumbotron" style="padding:20px;">
        <h1>莫失莫忘</h1>
        <p>${welcome}</p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
    </div>
    <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
            <input type="text" id="txt_email" name="txt_email" class="form-control" placeholder="电子信箱">
        </div>
        <div class="form-group">
            <input type="text" id="txt_password" name="txt_password" class="form-control" placeholder="密码">
        </div>
        <button type="button" name="btn_login" class="btn btn-default" onclick="fnLogin();">登录</button>
        <button type="button" name="btn_reg" class="btn btn-default">注册</button>
    </form>
</div>
<div style="clear:both;"></div>
<div style="width:1200px; margin:0px auto;">
    <div style="text-align:left; font-weight: bold;">
        <h3>一步一个脚印</h3>
    </div>
<ul class="record">
    <c:forEach items="${headline}" var="hl">
        <li><span class="content">${hl.title}</span><span class="date"><fmt:formatDate value="${hl.date}" pattern="yyyy-MM-dd"/></span><span class="by">@<i>${hl.author}</i></span></li>
    </c:forEach>
</ul>
</div>
</body>
</html>