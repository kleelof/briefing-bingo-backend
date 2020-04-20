<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Phrases</title>
    <jsp:include page="header.jsp" ></jsp:include>
    <link rel="stylesheet" href="/css/phrases.css" />
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="menu.jsp" ></jsp:include>

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

        <div class="row">
            <div class="col-12">
                <table class="table">
                    <thead>
                        <tr>
                            <td>Phrase</td>
                            <td>Issued Count</td>
                            <td>Checked Count</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var='phrase' items='${phrases}'>
                            <form action="/admin/phrase/update/${phrase.id}" method="GET">
                                <tr>
                                    <td>
                                        <input type="text" name="phrase" value="${phrase.phrase}" />
                                    </td>
                                    <td>${phrase.count}</td>
                                    <td>${phrase.checkedCount}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${phrase.inactive}">
                                                <a href="/admin/phrase/activate/${phrase.id}" class="btn btn-warning">Activate</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a href="/admin/phrase/deactivate/${phrase.id}" class="btn btn-danger">Deactivate</a>
                                            </c:otherwise>
                                        </c:choose>
                                        <button class="btn btn-success">Update</button>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>