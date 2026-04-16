<%--うんこ --%>
<%-- コメントアウト、コンパイルすると消えるx --%>
<%@page contentType="text/html; charset=UTF-8" %>

<p>Hello!</p>
<p>こんにちは！</p>
<%-- htmlの中にプログラムを組み込む --%>
<p><% out.println(new java.util.Date()); %></p>

<!-- htmlのコメントの書き方、コンパイルしても残る -->