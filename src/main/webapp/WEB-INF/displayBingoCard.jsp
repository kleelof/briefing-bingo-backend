<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Briefing Bingo!</title>
    <jsp:include page="fragments.jsp" ></jsp:include>
    <link rel="stylesheet" href="/css/displayBingoCard.css" />
</head>
<body>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="col-12 text-center">
                <img src="/images/iGotBingo.png" alt="I GotBingo"/>
            </div>
            <div class="col-12 col-md-7">
                <div class="row">
                    <div class="grid">
                        <c:forEach var="phrase" items="${card.phrases}" varStatus="loop">
                            <c:choose>
                                <c:when test="${loop.index == 12}">
                                    <div class="square">
                                        <div class="inner">
                                            <img src="/images/flag.gif" alt="flag" />
                                            <span id="freedom-square">Freedom Square</span>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                           <c:choose>
                                <c:when test="${fn:contains(card.checkedPhraseIDs, phrase.id)}">
                                    <div class="marker">
                                        X
                                    </div>
                                </c:when>
                            </c:choose>
                            <div class="square">
                                <div class="inner">
                                    ${phrase.phrase}
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <a href="www.briefingbingo.com">PLAY!</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>