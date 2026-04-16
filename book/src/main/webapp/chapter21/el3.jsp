<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

${Math.random()<0.5 ? "あたり" : "はずれ"}
<%-- 三項演算子をELで記述する --%>
<%@include file="../footer.html" %>
