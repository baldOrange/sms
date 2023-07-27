<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../include/header.jsp" %>
<%@ include file="../../include/search.jsp" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<div class="container" style="width: 50%; alignment: center">

    <%--中间部门内容--%>
    <div style="width: 100%; alignment: center;">
        <%--        <div class="col-sm-4 col-sm-offset-4" style="width: 100%; alignment: center">--%>
        <%--            <h3>添加、修改商品详情页</h3>--%>
        <%--        </div>--%>

        <form class="form-horizontal" action="${APP_PATH}/vip/updateVipByVipId">
            <%--商品id--%>
            <%--如果想要属性不被修改, 这里要设置readonly, disable会导致不可读, 读不到数据后端根据id更新个锤子--%>
            <div class="form-group">
                <label for="id" class="col-sm-4 control-label">会员id</label>
                <div class="col-sm-8">
                    <input type="text" readonly="readonly" class="form-control" name="id" id="id"
                           placeholder="${selectedProVip.id}"
                           value="${selectedVip.id}">
                </div>
            </div>

            <%--会员名称--%>
            <div class="form-group">
                <label for="vipName" class="col-sm-4 control-label">会员名称</label>
                <div class="col-sm-8">
                    <input type="text" class="form-control" name="vipName" id="vipName"
                           placeholder="${selectedVip.vipName}"
                           value="${selectedVip.vipName}">
                </div>
            </div>

            <%--会员折扣--%>
                <div class="form-group">
                    <label for="vipName" class="col-sm-4 control-label">会员折扣</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" name="vipDiscount" id="vipDiscount"
                               placeholder="${selectedVip.vipDiscount}"
                               value="${selectedVip.vipDiscount}">
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