<%-- 
    Document   : login2
    Created on : 23/04/2012, 06:11:15 PM
    Author     : ECAMPOS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
			function formSubmit() {
                document.forms[0].submit();
            }
        </script>
    </head>
    <body>
        <form action="http://localhost:8087/intranet/login.htm" method="post">
        <%
        
  String userID = null;
  String password = null;

      // Assume not valid until proven otherwise

      boolean valid = false;

      // Get the Authorization header, if one was supplied

      String authHeader = request.getHeader("Authorization");
      if (authHeader != null) {
         java.util.StringTokenizer st = new java.util.StringTokenizer(authHeader);
         if (st.hasMoreTokens()) {
            String basic = st.nextToken();

            // We only handle HTTP Basic authentication

            if (basic.equalsIgnoreCase("Basic")) {
               String credentials = st.nextToken();

               // This example uses sun.misc.* classes.
               // You will need to provide your own
               // if you are not comfortable with that.

               sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
               String userPass =
                  new String(decoder.decodeBuffer(credentials));
//               String encoding = new sun.misc.BASE64Encoder().encode (userPassword.getBytes());


               // The decoded string is in the form
               // "userID:password".

               int p = userPass.indexOf(":");
               if (p != -1) {
                  userID = userPass.substring(0, p);
                  password = userPass.substring(p+1);

                  // Validate user ID and password
                  // and set valid true true if valid.
                  // In this example, we simply check
                  // that neither field is blank

                  if ((!userID.trim().equals("")) &&
                      (!password.trim().equals(""))) {
                     valid = true;
                  }
               }
            }
         }
      }

      // If the user was not validated, fail with a
      // 401 status code (UNAUTHORIZED) and
      // pass back a WWW-Authenticate header for
      // this servlet.
      //
      // Note that this is the normal situation the
      // first time you access the page.  The client
      // web browser will prompt for userID and password
      // and cache them so that it doesn't have to
      // prompt you again.

      if (!valid) {
         String s = "Basic realm=\"Login Test Servlet Users\"";
         response.setHeader("WWW-Authenticate", s);
         response.setStatus(401);
      }

      // Otherwise, proceed

      else {
         response.setContentType("text/html");
       	//out.println("<H3>Hello, " + userID + "</H3>");       
         %>
         <input name="id" type="hidden" value="<%=userID%>"/>
    	<%
       //out.println("<script>  window.location='http://200.48.4.150:8080/intranet/login.htm?id="+ userID+"';</script>");
       //out.println("<H3>you passe " + password+ "</H3>");
       //out.println("You are authorized to proceed.");
      }

  %>
   <script>  formSubmit(); </script>
  </form>
    </body>
</html>