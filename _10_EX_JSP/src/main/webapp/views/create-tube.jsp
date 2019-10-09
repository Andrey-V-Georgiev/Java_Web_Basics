<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:import url="head.jsp"/>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <div class="row">
            <div class="col col-md-12 d-flex justify-content-center">
                <h1>Create Tube!</h1>
            </div>
        </div>
        <hr/>

        <form action="/tubes/create" method="post">
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <label for="title-input">Title</label>
                </div>
                <div class="col col-md-12 d-flex justify-content-center">
                    <input id="title-input" name="title" type="text"/>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <label for="description-input">Description</label>
                </div>
                <div class="col col-md-12 d-flex justify-content-center">
                    <textarea name="description" id="description-input" cols="22" rows="4"></textarea>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <label for="youtube-input">YouTube Link</label>
                </div>
                <div class="col col-md-12 d-flex justify-content-center">
                    <input id="youtube-input" name="youtube_link" type="text"/>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <label for="uploader-input">Uploader</label>
                </div>
                <div class="col col-md-12 d-flex justify-content-center">
                    <input id="uploader-input" name="uploader" type="text"/>
                </div>
            </div>
            <hr/>

            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <input class="btn btn-primary" type="submit" value="Create Tube"/>
                </div>
            </div>
            <br/>
            <div class="row">
                <div class="col col-md-12 d-flex justify-content-center">
                    <a href="/">Back to Home</a>
                </div>
            </div>
        </form>

    </div>
    <div class="row">
        <div class="col col-md-12 d-flex justify-content-center">
            <c:import url="footer.jsp"/>
        </div>
    </div>
</div>
</body>
</html>
