<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cards</title>
    <jsp:include page="header.jsp" ></jsp:include>
</head>
<body>
    <div class="container-fluid">
        <jsp:include page="menu.jsp" ></jsp:include>

       <div class="row">
            <div class="col-12">
                <table class="table">
                    <thead>
                        <tr>
                            <td>Date (${DTO.numberOfCardsIssued} cards issued)</td>
                            <td>Bingo (${DTO.numberOfBingos})</td>
                            <td>Shared (${DTO.numberOfShares})</td>
                            <td></td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="card" items='${DTO.cards}'>
                            <fmt:formatDate value="${card.createdAt}" pattern="E yyyy-MM-dd HH:mm:ss" var="date" />
                            <tr>
                                <td>${date}</td>
                                <td>${card.hasBingo}</td>
                                <td>${card.shared}</td>
                                <td>
                                    <a href="/bingo/${card.playId}" class="btn btn-success" target="=_blank">View</a>
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