<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="/common/base.jsp">
<c:param name="title">
得点管理システム
</c:param>

<c:param name="scripts"></c:param>
<c:param name="content">
  <section class="me-4">
  <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">ログアウト</h2>
  <p class="d-flex align-items-center justify-content-center h10 mb-3 fw-norma bg-success bg-opacity-50 py-0.5 px-2">ログアウトしました</p>
  <a href="login.jsp" class="h10 mb-3 fw-norma py-0.5 px-2 position-relative"style="top: 15px">ログイン</a>
  </section>
  </c:param>
</c:import>