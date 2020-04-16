<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Phrases</title>
    <jsp:include page="header.jsp" ></jsp:include>
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="menu.jsp" ></jsp:include>

        <div class="">
            <form action="/admin/addPhrase" method="post" class="row">
                <div class="col-6">
                    <div class="form-group">
                        <label for="phrase">Add a New Phrase:</label>
                        <input name="phrase" type="text" class="form-control"/>
                    </div>
                </div>
                <div class="col-6">
                    <div class="form-group">
                        <label for="count">Starting Count</label>
                        <input name="count" type="number" class="form-control">
                    </div>
                </div>
                <div class="col-12">
                    <button class="btn btn-success" type="submit">Save</button>
                    <hr>
                </div>
            </form>
        </div>

        <div class="row">
            <div class="col-12">
                <table class="table">
                    <thead>
                        <tr>
                            <td>Phrase</td>
                            <td>Count</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var='phrase' items='${phrases}'>
                            <tr>
                                <td>${phrase.phrase}</td>
                                <td>${phrase.count}</td>
                                <td>
                                    <a href="/admin/deletePhrase/${phrase.id}" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>