<%-- --%>
<%@ page language="java" contentType="text/html;charset=UTF-8 "
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/common/base.jsp">
<c:param name="title">
得点管理システム
</c:param>
 
<c:param name="scripts"></c:param>
 
<c:param name="content">
<section class="me=4">
	<h2 class="h3 mb-3 fw^norma bg-secondary bg-opacity-10 py-2 px-4">科目情報登録</h2> 
	<form action=createsubject method=post>
  	<label>科目コード</label>
	<input type="text" name="cd" maxlength="3" class="must" placeholder="科目コードを入力してください">
  	<label>科目名</label>
	<input type="text" name="name" maxlength="10" class="must" placeholder="科目名を入力してください">
	<button class="btn btn-secondary" id="submit-button" >登録</button>
	</form>
</section>
</c:param>
</c:import>