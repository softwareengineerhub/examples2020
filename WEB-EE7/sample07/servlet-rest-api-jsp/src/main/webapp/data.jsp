<%@ page import="com.app.jsp.api.MyHelper" %><%--
  Created by IntelliJ IDEA.
  User: asusadmin
  Date: 10/13/2020
  Time: 7:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!--
this is comment
-->

<%--

--%>

<%! int n = 10; %>

<%!

        private MyHelper myHelper = new MyHelper();

        public int getIterationCount(){
            return n;
        }
%>





    <% for(int i=0;i<getIterationCount();i++){ %>


        <%=i %> Data; <%=myHelper.doAction()%>; <%=MyHelper.doAction2()%> <br>




    <% }%>

    <% String myParam = request.getParameter("myparam");
    if(myParam!=null){ %>
        Param is not null
        <br>
        <%=myParam%>
        <%=n%>
    <% }else{ %>
        Param is null
    <% } %>


</body>


</html>
