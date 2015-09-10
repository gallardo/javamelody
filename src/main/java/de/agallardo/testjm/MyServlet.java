package de.agallardo.testjm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class MyServlet extends HttpServlet {

    public static final String TOPLEVEL_RES = "TOPLEVEL_RES";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Wrapp to avoid Tomcat inserting the ApplicationHttpResponse in front of the top level response
        ServletResponse wRes = new HttpServletResponseWrapper(response);

        // Store the top level response to allow for changing headers later on
        request.setAttribute(TOPLEVEL_RES, response);
        
        // Include in a wrapped response, to not alter the top level response
        request.getRequestDispatcher("top.jsp").include(request, wRes);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}