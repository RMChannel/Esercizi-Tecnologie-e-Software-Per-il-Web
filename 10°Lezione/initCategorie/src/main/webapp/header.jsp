<%--
  Created by IntelliJ IDEA.
  User: robbe
  Date: 04/04/2025
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%
HttpSession session1=request.getSession();
if(session1.getAttribute("username")==null) {%>
<h4>Fai il <a href="login.jsp">Login</a> oppure <a href="register.jsp">Registrati</a></h4>
<%
}
else {%>
<h4>Loggato come <%=session1.getAttribute("username")%> con email <%=session1.getAttribute("email")%></h4>
<form method="post" action="logout"><input type="submit" value="Logout" name="logout"></form>
<%
}
%>