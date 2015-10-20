<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Hashtable"%>
<%
    ArrayList<Hashtable<String,String>> listOfMap = new ArrayList<Hashtable<String,String>>();
  
 Hashtable<String,String> map;
 
 for(int i=0;i<3;i++){
  map = new Hashtable<String, String>();
  
  map.put("k1", "value1"+i);
  map.put("k2", "value2"+i);
  
  listOfMap.add(map);
 }
    
    request.setAttribute("listOfMap", listOfMap);
%>
<html>
<body>
    <c:forEach items="${listOfMap}" var="maps">
        <c:forEach items="${maps}" var="mapItem">
      ${mapItem.key} ${mapItem.value} <br/>
   </c:forEach>
    </c:forEach>
</body>
</html>