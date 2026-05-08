<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
 <%@page import="java.time.LocalDate, java.time.format.DateTimeFormatter" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/common/base.jsp">
 <c:param name="title">
 得点管理システム
 </c:param>
 <c:param name="scripts"></c:param>
 <c:param name="content">
 <section class="me-4">
  <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">科目変更</h2>
<%-- ここまでがテンプレ --%>
<%-- ここからが天ぷら --%>

<%
 int currentYear = LocalDate.now().getYear();
%>
<%-- ↑年月日をfmtに格納 --%>
<%-- sessionを有効にする↓これによって他のページに遷移したときでも、ログイン情報は維持される --%>
  <% bean.User user = (bean.User)session.getAttribute("user"); %>
 <%-- <% if (user != null && user.isAuthenticated()){ %> --%>
  <form action="SubjectCreateExecute.action" method="post">
  <label>科目コード {$subject.cd }</label>

  <label>科目名</label>
   <input type="text" class="form-control" name="name" value="${ name}" required oninvalid ="this.setCustomValidity('このフィールドを入力してください')" oninput="this.setCustomValidity('')"/>
  <br>
    <button  class="btn btn-secondary" action ="submit">変更</button>
  <%--<% } else{--%>--%>
  <a href="Login.action">この機能を使うにはログインしてください</a>
  <%--<% } --%> --%>
  </form>
</section>
</c:param>
</c:import>