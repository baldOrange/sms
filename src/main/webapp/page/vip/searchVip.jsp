<%--
  Created by IntelliJ IDEA.
  User: zyd
  Date: 2021/4/30
  Time: 2:13
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../include/header.jsp" %>
<%@ include file="../../include/search.jsp" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<script>
    function deleteVip(productId, vipName) {
        if (confirm("您确定要删除 【" + vipName + "】 吗？")) {
            // 访问路径
            location.href = "${APP_PATH}/vip/deleteVip?vipId=" + productId;
        }
    }

    function submitWithForm() {
        location.href = "../..";
    }
</script>

<%--中间内容部分--%>
<div class="container">
    <%--路径导航与搜索框--%>
    <div style="width: 100%; margin: 0 auto; height: 100px;">
        <%--路径导航--%>
            <ol class="breadcrumb">
                <li><a href="${APP_PATH}/home">首页</a></li>
                <li><a href="${APP_PATH}/vip/vipList">会员名称</a></li>
                <li class="active">搜索页面</li>
            </ol>
        <%--表单搜索框--%>
        <%--这里我理解错的地方, 并不是说两个表单输入, 根据是否有值来提交到不同的Controller, 这里是一个整体
        获取所有表单上的值去查询, 是一个sql语句去处理的... ...
        --%>
        <form class="form-inline" action="${APP_PATH}/vip/searchPro" method="post">
            <div class="form-group">
                <label for="vipName">会员名称</label>
                <input type="text" name="vipNameInForm" class="form-control" id="vipName" placeholder="输入会员名称">
            </div>
            &nbsp;&nbsp;&nbsp;

            <button type="submit" class="btn btn-success">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>&nbsp;开始查找
            </button>
            &nbsp;&nbsp;&nbsp;
            <a href="${APP_PATH}/vip/toAddVipPage" class="btn btn-primary">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;新增会员
            </a>
        </form>
    </div>

    <%--商品库存信息表格--%>
    <div style="width: 100%; margin: 0 auto; height: 400px;">

        <%--表格样式: 基础表格、带边框、悬浮隔行变色--%>
        <table class="table table-bordered table-hover">
            <thead>
            <tr style="background: #f1f1ef; alignment: center">
                <th>编号</th>
                <th>名称</th>
                <th>则扣</th>
                <th>创建日期</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="vip">
                <tr style="font-size: xx-small">
                    <td>${vip.id}</td>
                    <td>${vip.vipName}</td>
                    <td>${vip.vipDiscount}</td>
                    <td>${vip.createDate}</td>
                        <%--这两处操作的难点就是, 如何将选中的条目的obj对象的id获得并传出去以便按照id删除--%>
                    <td>
                        <a type="button" class="btn btn-primary btn-sm" aria-label="Left Align"
                           href="${APP_PATH}/vip/toUpdateVipPage?productId=${vip.id}">
                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> 修改
                        </a>
                        <a type="button" class="btn btn-danger btn-sm" aria-label="Left Align"
                           href="javascript:deleteVip(`${vip.id}`,`${vip.vipName}`);">
                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <%--分页信息--%>
        <div class="row">
            <%--分页数据显示--%>
            <div class="col-md-4">
                <b>当前第 ${pageInfo.pageNum} 页, 总 ${pageInfo.pages} 页, 总 ${pageInfo.total} 条记录</b>
            </div>
            <%--分页条--%>
            <%--原因: 点击分页, 如第二页, 未能把表单数据提交上去--%>
            <div class="col-md-4 col-md-offset-4">
                <nav aria-label="Page navigation">
                    <ul class="pagination">

                        <%--自定义添加首页末页--%>
                        <li><a href="${APP_PATH}/vip/searchPro?pn=1">首页</a></li>
                        <c:if test="${pageInfo.hasPreviousPage}">
                            <li>
                                <a href="${APP_PATH}/vip/searchPro?pn=${pageInfo.pageNum-1}"
                                   aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                        </c:if>

                        <%--分页条BAR--%>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
                            <c:if test="${page_Num==pageInfo.pageNum}">
                                <li class="active"><a href="#">${page_Num}</a></li>
                            </c:if>
                            <c:if test="${page_Num!=pageInfo.pageNum}">
                                <li><a href="${APP_PATH}/vip/searchPro?pn=${page_Num}">${page_Num}</a></li>
                            </c:if>
                        </c:forEach>

                        <c:if test="${pageInfo.hasNextPage}">
                            <li>
                                <a href="${APP_PATH}/vip/searchPro?pn=${pageInfo.pageNum+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </c:if>
                        <li><a href="${APP_PATH}/vip/searchPro?pn=${pageInfo.pages}">末页</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>

<%@ include file="../../include/footer.jsp" %>
