<%@ page import="app.models.view_models.TubeViewModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% TubeViewModel tubeViewModel = (TubeViewModel) request.getAttribute("tubeViewModel"); %>
<html>
<head>
    <c:import url="base/head.jsp"/>
    <title>Details Tube</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <div class="row">
            <div class="col col-md-12 d-flex justify-content-center">
                <h1><%= tubeViewModel.getName() %></h1>
            </div>
        </div>
        <hr/>
        <div class="row">
            <div class="col col-md-12 d-flex justify-content-center">
                <h3><%= tubeViewModel.getYoutubeLink() %></h3>
            </div>
        </div>
        <hr/>
        <div class="row">
            <div class="col col-md-6 d-flex justify-content-center">
                <a href="<%= tubeViewModel.getYoutubeLink() %>">Link to Video</a>
            </div>
            <div class="col col-md-6 d-flex justify-content-center">
                <p><%= tubeViewModel.getUploader() %></p>
            </div>
        </div>
        <hr/>
        <br/>
        <div class="row">
            <div class="col col-md-12 d-flex justify-content-center">
                <a href="/">Back to Home</a>
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
