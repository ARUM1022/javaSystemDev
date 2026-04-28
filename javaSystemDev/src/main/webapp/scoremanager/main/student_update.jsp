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
     <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">メニュー</h2>
    <form action="StudentUpdateExecute.action" method="get">
    	<label textalign="left">入学年度</label><br>
    	<input name="ent_year" value="${ent_year}" readonly><br>
    	<label>学生番号</label><br>
    	<input name="no" value="${no}" readonly> <br>
    	<label>氏名</label><br>
    	<input name="name" value="${name}" maxlength="10" required oninvalid = "このフィールドを入力してください" oninput="this.setCustomValidity('')">
    	<br><label>クラス</label><br>
    	<select name="class_num" type="select">
    	 <c:forEach var="s" items="${classList}">
    	  <option value="${s}">${s}</option>
   		 </c:forEach> 
    	</select><br>
    	<label>在学中</label>
    	<input class="form-check-input" type="checkbox" name = "is_attend">
    	<br>
    	<button type="submit" class="btn btn-secondary">変更</button>
    </form>
 </div>
 </section>
 </c:param>
 </c:import>
