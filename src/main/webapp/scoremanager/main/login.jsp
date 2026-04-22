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
   <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">ログイン</h2>
  <p>ID<input type="text" name="id" value="${id}"></p>
  <label for="input_color">パスワード</label>
  <input type="password" id="input_pass" name="input_pass" value="">
<p><input type="submit" name="login" value="ログイン"></p>
  </section>
  </c:param>
</c:import>