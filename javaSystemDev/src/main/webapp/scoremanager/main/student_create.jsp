<%@page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
 <%@page import="java.time.LocalDate, java.time.format.DateTimeFormatter" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<c:import url="/common/base.jsp">
 <c:param name="title">
 得点管理システム
 </c:param>
 <c:param name="scripts"></c:param>
 <c:param name="content">
 <section class="me-4">
  <h2 class="h3 mb-3 fw-normal bg-secondary bg-opacity-10 py-2 px-4">学生情報登録</h2>
<%-- ここまでがテンプレ --%>
<%-- ここからが天ぷら --%>
<%
 int currentYear = LocalDate.now().getYear();
%>
<%-- ↑年月日をfmtに格納 --%>
  <% bean.User user = (bean.User)session.getAttribute("user"); %>
  <% if (user != null && user.isAuthenticated()){ %>
  <form action="StudentCreate.action">
  <label>入学年度</label>
  <select class="form-select" name="ent_year">
   <option value=0>--------</option>
         <%
         for (int i = currentYear -10;i <= currentYear;i++){
         %>
         <option value="<%= i %>">
          <%= i %>
         </option>
         <%
         }
         %>
  </select><br>
  <label>学生番号</label>
   <input type ="text" class="form-control" name="no" value="${ no}" required oninvalid = "this.setCustomValidity('このフォームには入力が必須です')" oninput="this.setCustomValidity('')"/>
  <br>
  <label>氏名</label>
   <input type="text" class="form-control" name="name" value="${ name}" required oninvalid ="this.setCustomValidity('このフォームには入力が必須です')" oninput="this.setCustomValidity('')"/>
  <br>
  
  <label>クラス</label>

  <select name="class_num" class="form-select">
   <c:forEach var="s" items="${students}">
    <option value=""></option>
   </c:forEach>
  </select><br>
    <button  class="btn btn-secondary" action ="submit">登録して終了</button>
  <% } else{%>
  <a href="Logint.action">この機能を使うにはログインしてください</a>
  <% } %>
  </form>
</section>
</c:param>
</c:import>
