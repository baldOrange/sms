<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../include/header.jsp" %>
<%@ include file="../../include/search.jsp" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<div class="container" style="width: 50%; alignment: center">

    <%--中间部门内容--%>
    <div style="width: 100%; alignment: center;">

        <form class="form-horizontal" action="${APP_PATH}/vip/addVip">
            <%--会员名称--%>
            <div class="form-group">
                <label for="vipName" class="col-sm-4 control-label">会员名称</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="vipName" id="vipName" placeholder="会员名称">
                </div>
            </div>
            <%--会员则扣--%>
            <div class="form-group">
                <label for="vipDiscount" class="col-sm-4 control-label">会员则扣</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="vipDiscount" id="vipDiscount" placeholder="会员则扣">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-4">
                    <button type="reset" class="btn btn-primary">重置(Reset)</button>
                </div>
                <div class="col-sm-4">
                    <button type="submit" class="btn btn-danger">提交(Submit)</button>
                </div>
            </div>
        </form>
    </div>
</div>

<%@ include file="../../include/footer.jsp" %>