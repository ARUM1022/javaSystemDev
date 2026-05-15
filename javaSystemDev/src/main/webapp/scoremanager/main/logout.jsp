<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/common/base.jsp">
 <c:param name="title">
 得点管理システム
 </c:param>
 <c:param name="scripts"></c:param>
 <c:param name="content">
 <section class="me-4">
  <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">ログアウト</h2>
  
  <p class="d-flex align-items-center justify-content-center h10 mb-3 fw-normal bg-success bg-opacity-50 py-0.5 px-2">ログアウトしました</p>
  
<div class="d-flex align-items-end gap-3" style="height: 200px;">
  <a href="${pageContext.request.contextPath}/scoremanager/main/Login.action" class="">ログイン</a>
  </div>
  </section>
  </c:param>
  </c:import>
  