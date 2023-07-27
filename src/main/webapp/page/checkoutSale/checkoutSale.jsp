<%--
  Created by IntelliJ IDEA.
  User: zyd
  Date: 2021/4/24
  Time: 16:36
  Description: 结算记录功能页面
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../include/header.jsp" %>
<%@ include file="../../include/search.jsp" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<%--中间内容部分--%>
<div class="container">
    <%--路径导航与搜索框--%>
    <div style="width: 100%; margin: 0 auto;">
        <%--路径导航--%>
        <ol class="breadcrumb">
            <li><a href="${APP_PATH}/home">首页</a></li>
            <li class="active">统计信息</li>
        </ol>
        <div class="amountCss">上月销售额 : ${getTransactionAmount}元</div>
        <div class="amountCss">上月进货额 : ${getPurchaseAmount}元</div>
    </div>
</div>

<style>
    .amountCss {
        border: 1px solid #eee;
        width: 25%;
        background-color: #6486fa;
        height: 100px;
        color: #fff;
        border-radius: 10px;
        text-align: center;
        font-size: 25px;
        padding-top: 30px;
        margin: 10px;
        float: left;
    }
</style>
<%@ include file="../../include/footer.jsp" %>