<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<%@page import="java.util.logging.Logger"%>
<%@page import="java.util.logging.Level"%>
<%@page import="javax.faces.application.ViewExpiredException"%>
<%@page import="com.butterfill.opb.session.OpbSessionHelper"%>
<%@page import="com.butterfill.opb.web.faces.OpbMessageHelper"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Opb web demo error page</title>
    </head>
    <body>
        <%!
            public static final String CLASS_NAME = "errorPage.jsp";
            
            private static final Logger logger = Logger.getLogger(CLASS_NAME);
            
            private final OpbMessageHelper messageHelper = new OpbMessageHelper();
        %>
        <%
            Throwable ex = pageContext.getException();
            
            if (ex instanceof ViewExpiredException) {
                messageHelper.saveErrorMessage(
                        "You have been logged out because your session expired", 
                        null);
                
            } else {
                logger.logp(Level.SEVERE, CLASS_NAME, "scriptlet", 
                        "Unexpected Exception", ex);

                logger.logp(Level.SEVERE, CLASS_NAME, "scriptlet", 
                        "requestedURI={0}, servletName={1}, statusCode={2}", 
                        new Object[]{
                                pageContext.getErrorData().getRequestURI(),
                                pageContext.getErrorData().getServletName(),
                                pageContext.getErrorData().getStatusCode()});
                
                messageHelper.saveErrorMessage(
                        "You have been logged out due to an unexpected error", 
                        "For more information, please see the server's error log");
                
            }
        %>
        
        <%-- Redirect to the login page --%>
        <c:redirect url="/index.jsf" />

    </body>
</html>
