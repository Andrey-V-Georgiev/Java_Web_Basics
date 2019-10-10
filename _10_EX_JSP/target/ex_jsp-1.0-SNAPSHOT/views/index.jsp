<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="base/head.jsp"/>
    <title>Index</title>
</head>
<body>
<div class="container">
        <div class="jumbotron">
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <h1>Welcome to MeTube!</h1>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <h3>Cool app in beta version</h3>
                </div>
            </div>
            <hr/>
            <div class="row">
                <div class="col col-md-6 d-flex justify-content-center">
                    <a href="/tubes/create" class="btn btn-primary" role="button" aria-pressed="true">Create Tube</a>
                </div>
                <div class="col col-md-6 d-flex justify-content-center">
                    <a href="/tubes/all" class="btn btn-primary" role="button" aria-pressed="true">All Tubes</a>
                </div>
            </div>
        </div>
    <div class="row">
        <div class="col col-md-12 d-flex justify-content-center">
            <c:import url="base/footer.jsp"/>
        </div>
    </div>
</div>
</body>
</html>
