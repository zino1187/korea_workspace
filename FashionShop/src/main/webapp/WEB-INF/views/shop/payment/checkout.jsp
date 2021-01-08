<%@page import="com.koreait.fashionshop.model.common.Formatter"%>
<%@page import="com.koreait.fashionshop.model.domain.Cart"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	List<Cart> cartList = (List)request.getAttribute("cartList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Karl - Fashion Ecommerce Template | Home</title>
	<%@ include file="../inc/header.jsp" %>
	<script>
	function delCart(){
		if(confirm("장바구니를 모두 비우시겠습니까?")){
			location.href="/shop/cart/del";
		}	
	}
	
	function editCart(){
		if(confirm("주문 수량을 변경하시겠어요?")){
			$("#cart-form").attr({
				action:"/shop/cart/edit",
				method:"post"
			});
			$("#cart-form").submit();
		}	
		
	}
	
	</script>
</head>

<body>
    	<%@include file="../inc/top.jsp" %>
        <!-- ****** Top Discount Area End ****** -->
		
        <!-- ****** Checkout Area Start ****** -->
        <div class="checkout_area section_padding_100">
            <div class="container">
                <div class="row">

                    <div class="col-12 col-md-6">
                        <div class="checkout_details_area mt-50 clearfix">

                            <div class="cart-page-heading">
                                <h5>Billing Address</h5>
                                <p>Enter your cupone code</p>
                            </div>

                            <form action="#" method="post">
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <label for="first_name">주문고객 명<span>*</span></label>
                                        <input type="text" class="form-control" id="first_name" value="" required>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="last_name">연락처 <span>*</span></label>
                                        <input type="text" class="form-control" id="last_name" value="" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <label for="company">주소</label>
                                        <input type="text" class="form-control" id="company" value="">
                                    </div>
                                    
                                    <div class="col-md-6 mb-3">
                                        <label for="first_name">받으실분 이름<span>*</span></label>
                                        <input type="text" class="form-control" id="first_name" value="" required>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label for="last_name">연락처 <span>*</span></label>
                                        <input type="text" class="form-control" id="last_name" value="" required>
                                    </div>
                                    <div class="col-12 mb-3">
                                        <label for="company">받으실 주소</label>
                                        <input type="text" class="form-control" id="company" value="">
                                    </div>
                                    
                                    <div class="col-12 mb-3">
                                        <label for="country">결제방법 선택<span>*</span></label>
                                        <select class="custom-select d-block w-100" id="country">
                                        <option value="usa">United States</option>
                                        <option value="uk">United Kingdom</option>
                                        <option value="ger">Germany</option>
                                        <option value="fra">France</option>
                                    </select>
                                    </div>

                                    <div class="col-12">
                                        <div class="custom-control custom-checkbox d-block mb-2">
                                            <input type="checkbox" class="custom-control-input" id="customCheck1">
                                            <label class="custom-control-label" for="customCheck1">Terms and conitions</label>
                                        </div>
                                        <div class="custom-control custom-checkbox d-block mb-2">
                                            <input type="checkbox" class="custom-control-input" id="customCheck2">
                                            <label class="custom-control-label" for="customCheck2">Create an accout</label>
                                        </div>
                                        <div class="custom-control custom-checkbox d-block">
                                            <input type="checkbox" class="custom-control-input" id="customCheck3">
                                            <label class="custom-control-label" for="customCheck3">Subscribe to our newsletter</label>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>

                    <div class="col-12 col-md-6 col-lg-5 ml-lg-auto">
                        <div class="order-details-confirmation">

                            <div class="cart-page-heading">
                                <h5>Your Order</h5>
                                <p>The Details</p>
                            </div>

                            <ul class="order-details-form mb-4">
                                <li><span>Product</span> <span>Total</span></li>
                                <li><span>청바지외 2건</span> <span>$59.90</span></li>
                                <li><span>할인쿠폰</span> <span>-$10.90</span></li>
                                <li><span>최종 결제하실 금액</span> <span>$49.90</span></li>
                            </ul>


                            

                            <a href="#" class="btn karl-checkout-btn">Place Order</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <!-- ****** Checkout Area End ****** -->		
        	
        <!-- ****** Footer Area Start ****** -->
        <%@ include file="../inc/footer.jsp" %>
        <!-- ****** Footer Area End ****** -->
    </div>
    <!-- /.wrapper end -->
</body>

</html>