<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
        <meta name="generator" content="Hugo 0.104.2">
        <title>Sign in - Employee Management</title>

        <link href="css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

        <meta name="theme-color" content="#712cf9">


        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.6.3.js" 
                            integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM="crossorigin="anonymous">

        </script>

    </head>
    <script>
        function fetchContent(selectedId, targetId)
                {
            //            alert("'#"+selectedId.name+"'");
                           
                            $.ajax({
                                    url: 'PreSignUp',
                                    data: {
                                            [selectedId]: $("#" + selectedId).val()
                                    },
                                    success: function (responseText) {
                    //                        alert(responseText);
                                            $("#" + targetId).html(responseText);
                                    }
                            });
                           
                }
    </script>
    <body class="text-center">


        <main class="form-signin w-100 m-auto">
            <form action="SignUp" id="signUpForm" method="post">
                <img class="mb-4" src="images/flower-logo.jpg" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">Please provide below information</h1>

                <div class="form-floating">
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="emailAddress" value="${User.emailAddress}">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password" value="${User.password}">
                    <label for="floatingPassword">Password</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="firstName" placeholder="first name" name="firstName" value="${User.firstName}">
                    <label for="firstName">First Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="lastName" placeholder="last name" name="lastName" value="${User.lastName}">
                    <label for="firstName">Last Name</label>
                </div>
                <div class="form-floating">
                    <input type="text" class="form-control" id="address" placeholder="Address" name="address" value="${User.address}">
                    <label for="address">Address</label>
                </div>
                <div class="form-floating">
                    <select name="countryCode" class="form-control" id="countryCode" onchange="fetchContent('countryCode', 'provinceCode')">
                        <option value="0">--select country--</option>

                        <c:forEach items="${CountryList}" var="country">
                            <option value="${country.countryCode}"<c:if test="${country.countryCode == User.countryCode}">selected</c:if>>
                                ${country.countryName}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-floating">
                    <select name="provinceCode" class="form-control" id="provinceCode"  onchange="fetchContent('provinceCode', 'distCode')" >
                        <option value="0">--select state--</option>

                        </option>

                    </select>
                </div>
                <div class="form-floating">
                    <select name="distCode" class="form-control" id="distCode">
                        <option value="0">--select district--</option>

                        </option>
                    </select>
                </div>


                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me" disabled="true"> Remember me
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary mb-2" type="submit">Sign Up</button>
                <a href="landingPage.jsp">
                    <button type="button" class="w-100 btn btn-lg btn-warning">Cancel</button>
                </a>
                <p class="mt-5 mb-3 text-muted">&copy; 2019 r._a_j_a_ 2023</p>
            </form>
        </main>
    </body>
</html>
