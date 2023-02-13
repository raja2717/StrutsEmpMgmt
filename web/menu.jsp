
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Employee Management</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <meta name="theme-color" content="#712cf9">

        <!-- Custom styles for this template -->
        <link href="css/header.css" rel="stylesheet">
        <!--<link href="css/carousel.css" rel="stylesheet">-->
    </head>
    <header class="p-3 text-bg-dark">
        <div class="container">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                    <img src="images/flower-logo.jpg" width="75" height="75"></img>
                </a>

                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                    <li><a href="<c:if test="${Loggedin!=null}">Home</c:if>" class="nav-link px-2 text-white">Home</a></li>
                    <li><a href="<c:if test="${Loggedin!=null}">FetchUrl</c:if>" class="nav-link px-2 text-white">Get-Info-From-RestAPI</a></li>
                    <li><a href="<c:if test="${Loggedin!=null}">CreateEmployee</c:if>" class="nav-link px-2 text-white text-decoration-underline">create employee</a></li>

                        <li><a href="<c:if test="${Loggedin!=null}">SearchEmployee</c:if>" class="nav-link px-2 text-white text-decoration-underline">Search employee</a></li>
                    <li><a href="<c:if test="${Loggedin!=null}">retrieveemployee.jsp</c:if>" class="nav-link px-2 text-white text-decoration-underline">Retrieve-Deleted-Employee</a></li>
                        <c:if test="${Loggedin!=null}">
                        <li><a href="#" class="nav-link px-2 text-white text-capitalize text-opacity-75">
                                welcome: ${Loggedin.firstName}  ${Loggedin.lastName}
                            </a></li>
                        </c:if>
                </ul>
                <c:if test="${Loggedin==null}">
                    <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
                        <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
                    </form>
                </c:if>

                <div class="text-end">
                    <% if (request.getSession().getAttribute("Loggedin") == null) {%>

                    <a href="login.jsp">
                        <button type="button" class="btn btn-outline-light me-2" >Login</button>
                    </a>
                    <a href="PreSignUp">
                        <button type="button" class="btn btn-warning">Sign-up</button>
                    </a>
                    <%
                    } else {%>

                    <a href="Logout">
                        <button type="button" class="btn btn-outline-light me-2" >Log Out</button>
                    </a>
                    <%
                        }
                    %>


                </div>
            </div>
        </div>
    </header>