<%@ page import="app.models.view_models.TubeViewModel" %>
<%@ page import="app.models.view_models.TitleViewModel" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Stream" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% List<TitleViewModel> allTitleViewModels = (List<TitleViewModel>) request.getAttribute("allTitleViewModels");%>
<html>
<head>
    <c:import url="base/head.jsp"/>
    <title>All Tubes</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <div class="row">
            <div class="col col-md-12 d-flex justify-content-center">
                <h1>All Tubes</h1>
            </div>
        </div>
        <hr/>
        <div class="row">
            <div class="col col-md-12 d-flex justify-content-center">
                <h3>Check our tubes below</h3>
            </div>
        </div>
        <hr/>

        <div class="row">
            <div class="col col-md-12 d-flex justify-content-center">
                <% if(allTitleViewModels.size() == 0) {%>
                <p>"No tubes - <a href="/tubes/create">Create some!</a>"</p>
                <% } else {%>
                <ul>
                    <% for (TitleViewModel viewModel : allTitleViewModels) { %>
                    <li>
                        <a href="<%= String.format("/tubes/details?name=%s", viewModel.getName())%>"><%= viewModel.getName() %></a>
                    </li>
                    <% } %>
                </ul>
                <% } %>
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
