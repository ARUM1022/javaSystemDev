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
	<!-- 1. methodをpostに変更 -->
	<form action="LoginExecute.action" method="post">
	    
	    <div class="mb-3">
	        <label>ID</label>
	        <!-- 2. nameを "login" に固定 -->
	        <input type="text" name="login" class="form-control" value= "${ id}">
	    </div>
	    
	    <div class="mb-3">
	        <label>パスワード</label>
	        <!-- 3. nameを "password" に固定 -->
	        <input type="password" name="password" class="form-control" value= "${ password}">
	    </div>
	    
	    <div class="mb-3">
	        <!-- 4. ボタンの name="login" を削除（valueだけにすればURLに混ざらない） -->
	        <input type="submit" value="ログイン" class="btn btn-primary">
	    </div>
	</form>
  </section>
  </c:param>
</c:import>