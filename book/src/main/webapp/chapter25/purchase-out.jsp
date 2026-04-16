<%--
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>
<hr>

<table style="border-collapse:separate;border-spacing:10px;">
<c:forEach var="item" items="${cart}">
	<tr>
	<td>商品${item.product.id}</td>
	<td><img src="image/${item.product.id}.jpg" height="96"></td>
	<td>${item.product.name}</td>
	<td>${item.product.price}円</td>
	<td>${item.count}個</td>
	</tr>
</c:forEach>
</table>
<hr>
購入手続きが完了しました。

<%@include file="../footer.html" %>--%>
<%@page contentType="text/html; charset=UTF-8" %>

<%@ page import="java.util.List,bean.Item" %>
<%@include file="../header.html" %>
<%@include file="menu.jsp" %>

<%
List<Item> cart = (List<Item>)request.getAttribute("cart");
%>

<table>
<tr>
<th>商品</th><th>価格</th><th>個数</th>
</tr>

<% for(Item item : cart){ %>
<tr>
<td><%= item.getProduct().getName() %></td>
<td><%= item.getProduct().getPrice() %>円</td>
<td><%= item.getCount() %>個</td>
<td><img src="image/<%= item.getProduct().getId() %>.jpg" height="96"></td><% } %>
</table>

<p>購入手続きが完了しました。</p>
<%@include file="../footer.html" %>
