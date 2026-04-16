<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%@page import="java.util.List, java.util.ArrayList" %>
<%@page import="java.util.Map, java.util.HashMap" %>

<%
int[] array={0, 1, 2};
request.setAttribute("array", array);
List<String> list=new ArrayList<>();
list.add("zero");
list.add("one");
list.add("two");
request.setAttribute("list", list);
Map<String, String> map=new HashMap<>();
map.put("zero", "零");
map.put("one", "壱");
map.put("two", "弐");
request.setAttribute("map", map);
%>

${array[1]}<br><%-- 1が出力される --%>
${list[2]}<br><%-- twoが出力される --%>
${map["one"]}<br><%-- 壱が出力される --%>
${map.two}<%-- 弐が出力される --%>

<%@include file="../footer.html" %>
