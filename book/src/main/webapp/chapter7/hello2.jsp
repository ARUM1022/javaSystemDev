<%--うんこ --%>
<%-- コメントアウト、コンパイルすると消えるx --%>
<%@page contentType="text/html; charset=UTF-8" %>

<%@ include file = "../header.html" %>
<p>Hello!</p>
<p>こんにちは！</p>
<%-- htmlの中にプログラムを組み込む --%>
<p><% out.println(new java.util.Date()); %></p>
<%@include file="../footer.html" %>
<!-- htmlのコメントの書き方、コンパイルしても残る -->