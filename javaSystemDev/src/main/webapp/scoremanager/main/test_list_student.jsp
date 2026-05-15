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
  <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績一覧(学生)</h2>
  <div class="my-2 text-end px-4">
 	<a href="${pageContext.request.contextPath}/scoremanager/main/TestList.action">成績一覧(学生)</a>
  </div>
  <form method="get">
   <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
    <div class="col-4">
    <br>
  <label>学生名</label>
   <input type="text" class="form-control" name="student" value="${ student}" required oninvalid ="this.setCustomValidity('このフィールドを入力してください')" oninput="this.setCustomValidity('')"/>
  <br>
 	<div class="col-2 text-center">
	 <button class="btn btn-secondary" id="filter-button">検索</button>
	</div>
	<div class="mt-2 text-warning">${errors.get("f1") }	</div>
   </div>
  </form> 
  <c:choose>
   <c:when test="${test.size()>0 && test != null }">
    <table class="table table-hover">
     <tr>
      <th>科目名</th>
      <th>科目コード</th>
      <th>回</th>
      <th>得点</th>
      <th></th>
      <th></th>
     </tr>
     <c:forEach var="test" items="${test }">
      <tr>
       <td>${test.name }</td>
       <td>${test.cd }</td>
       <td>${test.no }</td>
       <td>${test.point }</td>
     </tr>
    </c:forEach>
    </table>
   </c:when>   
   <c:otherwise>
    <div>成績情報が存在しませんでした。</div>
   </c:otherwise>
   </c:choose>
 </section>
 </c:param>
 </c:import>