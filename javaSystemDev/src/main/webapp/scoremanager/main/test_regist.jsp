<%@ page language="java" contentType="text/html;charset=UTF-8 "
    pageEncoding="UTF-8" %>
    <%@page import="java.time.LocalDate, java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/common/base.jsp">
<c:param name="title">
得点管理システム
</c:param>
 
<c:param name="scripts"></c:param>
 
<c:param name="content">
<section class="me-4">
<%
 int currentYear = LocalDate.now().getYear();
%>
  <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績管理</h2>
  <form action="${pageContext.request.contextPath}/scoremanager/main/TestRagist.action" method="get">
   <div class="row border mx-3 mb-3 py-2 align-items-end rounded" id="filter">
<div class="col-2">
    <label class="form-label" for="student-f1-select">入学年度</label>
    <select class="form-select" id="student-f1-select" name="f1">
     <option value="0">---------</option>
      <%
	   for (int i = currentYear -10; i <= currentYear; i++) {
	  %>

<option value="<%= i %>">
    <%= i %>
</option>

<%
}
%>
      
    </select>
</div>
    <div class="col-2">
     <label class="form-label" for="student-f2-select">クラス</label>
     <select class="form-select" id="student-f2-select" name="f2">
      <option value="0">--------</option>
      <c:forEach var="class_num" items="${class_num_set }">
       <%-- --%>
       <option value="${class_num }" <c:if test="${class_num==f2 }">selected</c:if>>${class_num }</option>
      </c:forEach>
     </select>
     </label>
    </div>
        <div class="col-3">
     <label class="form-label" for="student-f3-select">科目</label>
     <select class="form-select" id="student-f3-select" name="f3">
      <option value="0">--------</option>
      <c:forEach var="subject" items="${subject_set }">
       <%-- --%>
       <option value="${subject.cd }" <c:if test="${subject==f3 }">selected</c:if>>${subject.name }</option>
      </c:forEach>
     </select>
     </label>
    </div>
        <div class="col-2">
     <label class="form-label" for="student-f4-select">回数</label>
     <select class="form-select" id="student-f4-select" name="f4">
      <option value="0">--------</option>
       <option value="1">1</option>
       <option value="2">2</option>
     </select>
     </label>
    </div>
    
	<div class="col-2 text-center">
	 <button class="btn btn-secondary" id="filter-button">検索</button>
	</div>
	<div class="mt-2 text-warning">${errors.get("f1") }	</div>
   </div>
  </form>
  
</section>
</c:param>
</c:import>
 