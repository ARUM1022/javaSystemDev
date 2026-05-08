<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>

<c:import url="/common/base.jsp">
 <c:param name="title">
 得点管理システム
 </c:param>

 <c:param name="content">
  <section class="me-4">

<p>${error.message}</p>
  </section>
 </c:param>
=======
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
  <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">エラー</h2>
<%-- ここまでがテンプレ --%>
<%-- ここからが天ぷら --%>

<%
 int currentYear = LocalDate.now().getYear();
%>
<%-- ↑年月日をfmtに格納 --%>
<%-- sessionを有効にする↓これによって他のページに遷移したときでも、ログイン情報は維持される --%>
  <% bean.User user = (bean.User)session.getAttribute("user"); %>
 <%-- <% if (user != null && user.isAuthenticated()){ %> --%>
  <label>エラーが発生しました</label>

</section>
</c:param>
>>>>>>> branch 'master' of https://github.com/ARUM1022/javaSystemDev.git
</c:import>