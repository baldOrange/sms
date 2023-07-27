<%--
  Created by IntelliJ IDEA.
  User: zyd
  Date: 2021/4/24
  Time: 16:20
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../include/header.jsp" %>
<%@ include file="../../include/search.jsp" %>
<%
    pageContext.setAttribute("APP_PATH", request.getContextPath());
%>

<div class="container">
    <%--路径导航--%>
    <div style="width: 100%; margin: 0 auto; ">
        <h3>收银台服务${sessionScope.user.isVip==true?" (当前会员95折)":""}</h3>
        <ol class="breadcrumb">
            <li><a href="${APP_PATH}/home">首页</a></li>
            <li class="active">结算系统</li>
        </ol>
    </div>

    <%--已购商品输入框--%>
    <div style="width: 100%;margin: 0 auto;height: 55px;border-radius: 5px;padding: 10px;background-color: #6486fa;color: #fff;">
        <form class="form-inline" action="${APP_PATH}/product/checkPlusPro" method="post">
            <div class="form-group">
                <label for="productId">商品编号</label>
                <input type="text" class="form-control" id="productId" name="productId" placeholder="输入商品编号">
            </div>
            &nbsp;
            <div class="form-group">
                <label for="productCount">购买数量</label>
                <input type="text" class="form-control" id="productCount" name="productNumber" placeholder="输入购买数量">
            </div>
            &nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-danger">
                <span class="glyphicon glyphicon-random" aria-hidden="true"></span>&nbsp;结算(Check)
            </button>
        </form>
    </div>
    <br/>

    <%--商品详细结算信息--%>
    <div style="width: 100%; margin: 0 auto; height: 100px;">
<%--        <h3>详细信息如下：</h3>--%>
        <c:if test="${checkObj.productNumber!=null}">
            <form action="addProductSale" method="post" class="form-inline">
                <div class="form-group">
                    <label class="label_css">商品ID</label>
                    <input class="form-control"  type="text" id="productId" name="productId" placeholder="商品ID" value="${checkObj.productId}" readonly>
                </div>
                <div class="form-group">
                    <label class="label_css">商品名称</label>
                    <input class="form-control"  type="text" id="productName" name="productName" placeholder="商品名称" value="${checkObj.productName}" readonly>
                </div>
                <div class="form-group">
                    <label class="label_css">销售单价</label>
                    <input class="form-control"  type="text" id="productSalePrice" name="productSalePrice" placeholder="销售单价" value="${checkObj.productSalePrice} " readonly>
                </div>
                <div class="form-group">
                    <label class="label_css">购买数量</label>
                    <input class="form-control"  type="text" id="productNumber" name="productNumber" placeholder="购买数量" value="${checkObj.productNumber}" readonly>
                </div>
                <div class="form-group">
                    <label class="label_css">是否VIP</label>
                    <input class="form-control"  type="text" id="isVip" name="isVip" placeholder="是否VIP" value="${sessionScope.user.isVip==false?"否":"是"}&nbsp;" readonly>
                </div>
                <div class="form-group">
                    <label class="label_css">应付金额</label>
                    <input class="form-control"  type="text" id="payableMoney" name="payableMoney" placeholder="应付金额" value="${checkObj.checkPrice*(sessionScope.user.isVip==true?vip.vipDiscount:1)}" readonly>
                </div>
                <div class="form-group">
                    <label class="label_css">实收金额</label>
                    <input class="form-control"  type="text" id="payMoney" name="payMoney" placeholder="输入实收金额">
                </div>
                <div class="form-group">
                    <label class="label_css">找零</label>
                    <input   type="button" onclick="checkMoney(${checkObj.checkPrice*(sessionScope.user.isVip==true?vip.vipDiscount:1)})" class="btn btn-primary" value="计算找零">
                </div>
                <h4 style="color: red" id="showReturnMoney">找零：xxx 元</h4>
                <input type="submit"  class="btn btn-primary" value="确认">
                <input type="button" onclick="" class="btn btn-primary" value="取消">
            </form>

            <%--        <form action="" method="post">--%>
            <%--                <h4>--%>
            <%--&lt;%&ndash;                    商品名称：${checkObj.productName} &nbsp;&nbsp;&nbsp;&ndash;%&gt;--%>
            <%--&lt;%&ndash;                    销售单价：${checkObj.productSalePrice} &nbsp;&nbsp;&nbsp;&ndash;%&gt;--%>
            <%--&lt;%&ndash;                    购买数量：${checkObj.productNumber}&ndash;%&gt;--%>
            <%--&lt;%&ndash;                    是否是VIP：${sessionScope.user.isVip==false?"否":"是"}&nbsp;&nbsp;&nbsp;&ndash;%&gt;--%>
            <%--                </h4>--%>
            <%--                <h4>--%>
            <%--&lt;%&ndash;                    应付金额${sessionScope.user.isVip==true?" (会员95折)":""}：${checkObj.checkPrice*(sessionScope.user.isVip==true?0.95:1)} &nbsp;&nbsp;&nbsp;&ndash;%&gt;--%>
            <%--&lt;%&ndash;                    <label for="payMoney"></label>&ndash;%&gt;--%>
            <%--&lt;%&ndash;                    <input type="text" id="payMoney" name="payMoney" placeholder="输入实收金额">&ndash;%&gt;--%>
            <%--                    <input type="button" onclick="checkMoney(${checkObj.checkPrice*(sessionScope.user.isVip==true?0.95:1)})" class="btn btn-primary"--%>
            <%--                           value="计算找零">--%>
            <%--                    <br/>--%>
            <%--                    <h4 style="color: red" id="showReturnMoney">找零：xxx 元</h4>--%>
            <%--                </h4>--%>
            <%--            </form>--%>
        </c:if>
    </div>
</div>

<script>
    // 用于计算找零服务
    function checkMoney(event) {
        let getMoney = document.getElementById("payMoney").value;
        document.getElementById("showReturnMoney").innerHTML = "找零：" + (getMoney - event) + " 元"
    }
</script>
<style>
    .label_css {
        width:56px;
        margin-bottom: 15px;
    }
</style>
<%@ include file="../../include/footer.jsp" %>
