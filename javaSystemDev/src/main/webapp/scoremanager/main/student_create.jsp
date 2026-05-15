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
<%-- sessionを有効にする↓これによって他のページに遷移したときでも、ログイン情報は維持される --%>
  <% bean.Teacher user = (bean.Teacher)session.getAttribute("user"); %>
 <% if (user != null || user.isAuthenticated()){ %> 
  <form action="${pageContext.request.contextPath}/scoremanager/main/StudentCreateExecute.action" method="get">
  <label>入学年度</label>
  <div>
  <select class="form-select" name="ent_year">
   <option value = "0">--------</option>
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
  <c:if test="${yearError}">
         	<p style="color:orange;">入学年度を選択してください</p>
         	<br>
         </c:if>
  </div>
  <label>学生番号</label>
   <input type ="text" class="form-control" name="no" required oninvalid = "this.setCustomValidity('このフィールドを入力してください')" oninput="this.setCustomValidity('')"/>
  <br>
  <label>氏名</label>
   <input type="text" class="form-control" name="name" value="${ name}" required oninvalid ="this.setCustomValidity('このフィールドを入力してください')" oninput="this.setCustomValidity('')"/>
  <br>
  
  <label>クラス</label>

  <select name="class_num" class="form-select">
   <c:forEach var="s" items="${classList}">
    <option value="${s}">${s}</option>
   </c:forEach>
  </select><br>
    <button type ="submit" class="btn btn-secondary">登録して終了</button>
     </form>
   <% } else{ %>
  <a href="${pageContext.request.contextPath}/scoremanager/main/Login.action">この機能を使うにはログインしてください</a>
  <% } %>
</section>
</c:param>
</c:import>
