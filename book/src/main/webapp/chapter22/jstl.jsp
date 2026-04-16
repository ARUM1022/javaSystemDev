
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%-- jstlを使う準備 --%>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%-- タグで拡張for文を記述する --%>
<c:forEach var="p" items="${list}">
	${p.id}：${p.name}：${p.price}<br>
</c:forEach>

<%@include file="../footer.html" %>
