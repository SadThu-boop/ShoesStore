
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <c:url value="/view/client/static" var="url"></c:url>
      
 <div class="navbar navbar-default mega-menu" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}\login">
                        <img id="logo-header" src="${url}/img/logo_PTIT.png" alt="Logo" style="width: 50px; height: 50px;">
                    </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-responsive-collapse">
                    <!-- Shopping Cart -->
                   <jsp:include page="/view/client/view/cart.jsp"></jsp:include>
                    <!-- End Shopping Cart -->

                    <!-- Nav Menu -->
                    <ul class="nav navbar-nav">
                        <!-- Men -->
                        <li class="dropdown active">
                            <a href="${pageContext.request.contextPath }/product/category?cate_id=1">
                                Men
                            </a>
                            
                        </li>
                        <!-- End Men -->

                        <!-- Women -->
                        <li class="dropdown">
                            <a href="${pageContext.request.contextPath }/product/category?cate_id=2">
                                Women
                            </a>
             
                        </li>
                        <!-- End Women -->


                        <!-- Kid -->
                        <li class="dropdown mega-menu-fullwidth">
                            <a href="${pageContext.request.contextPath }/product/category?cate_id=3">
                                Kid
                            </a>
                        </li>
                        <!-- End Kid -->
                    </ul>
                    <!-- End Nav Menu -->                    
                </div>
            </div>    
        </div>            