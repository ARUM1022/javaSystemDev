%-- --%>
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
  <h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">成績検索</h2>
  <div class="my-2 text-end px-4">
 	<a href="TestList.action">成績検索</a>
  </div>
    <form method="get">
   <div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
    <div class="col-4">
     <label class="form-label" for="student-f1-select">入学年度</label>
     <select class="form-select" id="student-f1-select" name="1">
      <option value="0">---------</option>
      <c:forEach var="year" items="${entYearSet }">
		<%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
       <option value="${year }" <c:if test="${year==f1 }">selected</c:if>>${year } </option>
       </c:forEach>
     </select>
    </div>
    <div class="col-4">
     <label class="from-label" for="student-f2-select">クラス</label>
     <select class="form-select" id="student-f2-select" name="f2">
      <option value="0">--------</option>
      <c:forEach var="num" items="${classNumSet }">
       <%-- --%>
       <option value="${num }" <c:if test="${num==f2 }">selected</c:if>>${num }</option>
      </c:forEach>
     </select>
    </div>
   <div class="col-4">
     <label class="from-label" for="student-f2-select">科目</label>
     <select class="form-select" id="student-f2-select" name="f2">
      <option value="0">--------</option>
      <c:forEach var="num" items="${subjectSet }">
       <%-- --%>
       <option value="${subject }" <c:if test="${subject==f3 }">selected</c:if>>${subject }</option>
      </c:forEach>
     </select>
    </div>

	<div class="col-2 text-center">
	 <button class="btn btn-secondary" id="filter-button">検索</button>
	</div>
	<div class="mt-2 text-warning">${errors.get("f1") }	</div>
   </div>
  </form>
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
   <c:when tests="${tests.size()>0 && tests != null }">
    <table class="table table-hover">
     <tr>
      <th>科目名</th>
      <th>科目コード</th>
      <th>回</th>
      <th>得点</th>
      <th></th>
      <th></th>
     </tr>
     <c:forEach var="test" items="${tests }">
      <tr>
       <td>${subjectName }</td>
       <td>${subjectCd }</td>
       <td>${no }</td>
       <td>${point }</td>
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
  <c:choose>