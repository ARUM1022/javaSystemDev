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
   <form action="Login.action" method="post">
    <div class="mb-3">
      <label for="input_name" class="form-label">ID</label>
      <input type="text" class="form-control" placeholder="半角でご入力ください" name="name" id="input_name" maxlength="30">
    </div>
    <div class="mb-3">
      <label for="input_pass" class="form-label">パスワード</label>
      <input type="password" class="form-control" placeholder="パスワード" id="input_pass" name="input_pass" maxlength="30">
    </div>
    <div class="mb-3">
      <input type="submit" name="login" value="ログイン" class="btn btn-primary">
    </div>
   </form>
  </section>
  </c:param>
</c:import>