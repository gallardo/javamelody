<%
    HttpServletResponse toplevelResponse = (HttpServletResponse)request.getAttribute(
            de.agallardo.testjm.MyServlet.TOPLEVEL_RES);

    // Always ignored (OK)
    response.setContentType("html/csv"); 
    response.addHeader("Content-Disposition", "attachment; filename=testid.csv;");
    
    // XXX: This should affect the web server output
    // but current behaviour depends on javamelody's
    // CounterServletResponseWrapper implementation!
    toplevelResponse.setContentType("html/csv");
    toplevelResponse.addHeader("Content-Disposition", "attachment; filename=testid.csv;");
%>top11,top12,top13
top21,top22,top23