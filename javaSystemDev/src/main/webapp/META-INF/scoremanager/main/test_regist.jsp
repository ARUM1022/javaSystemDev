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
  <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績管理</h2>
  <div class="my-2 text-end px-4">
  <a href="StudentCreate.action">新規登録</a>
  </div>
  <form method="get">
   <div class="row border mx-3 mb-3 py-2 align-items-end rounded" id="filter">
<div class="col-2">
    <label class="form-label" for="student-f1-select">入学年度</label>
    <select class="form-select" id="student-f1-select" name="f1"> <option value="0">---------</option>
        <c:forEach var="year" items="${ent_year_set}">
            <option value="${year}" <c:if test="${year == f1}">selected</c:if>>${year}</option>
        </c:forEach>
    </select>
</div>
    <div class="col-2">
     <label class="from-label" for="student-f2-select">クラス</label>
     <select class="form-select" id="student-f2-select" name="f2">
      <option value="0">--------</option>
      <c:forEach var="num" items="${class_num_set }">
       <%-- --%>
       <option value="${num }" <c:if test="${num==f2 }">selected</c:if>>${num }</option>
      </c:forEach>
     </select>
      <c:if test="${!empty f3 }">checked</c:if>
     </label>
    </div>
        <div class="col-3">
     <label class="from-label" for="student-f2-select">科目</label>
     <select class="form-select" id="student-f2-select" name="f2">
      <option value="0">--------</option>
      <c:forEach var="num" items="${class_num_set }">
       <%-- --%>
       <option value="${num }" <c:if test="${num==f2 }">selected</c:if>>${num }</option>
      </c:forEach>
     </select>
      <c:if test="${!empty f3 }">checked</c:if>
     </label>
    </div>
        <div class="col-2">
     <label class="from-label" for="student-f2-select">回数</label>
     <select class="form-select" id="student-f2-select" name="f2">
      <option value="0">--------</option>
      <c:forEach var="num" items="${class_num_set }">
       <%-- --%>
       <option value="${num }" <c:if test="${num==f2 }">selected</c:if>>${num }</option>
      </c:forEach>
     </select>
      <c:if test="${!empty f3 }">checked</c:if>
     </label>
    </div>
    
	<div class="col-2 text-center">
	 <button class="btn btn-secondary" id="filter-button">絞込み</button>
	</div>
	<div class="mt-2 text-warning">${errors.get("f1") }	</div>
   </div>
  </form>
  
</section>
</c:param>
</c:import>
 