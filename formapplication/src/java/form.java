/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Phoenix
 */
@WebServlet(urlPatterns = {"/details"})
public class form extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nm=request.getParameter("nm").toString();
            int ag=getIntData("ag", request);
            String gen=request.getParameter("gen").toString();
            int hs=getIntData("hsc", request);
            int ss=getIntData("ssc", request);
            int st=getIntData("fsa", request);
            String[] tec=request.getParameterValues("tec");
            String ch1=request.getParameter("ch1");
            String ch2=request.getParameter("ch2");
            String ch3=request.getParameter("ch3");
            String ch4=request.getParameter("ch4");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet form</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet form at " + request.getContextPath() + "</h1>");
            out.println("<h1>Name: "+nm+"</h1>");
            out.println("<h2>"+ag+"</h2>");
            out.println("<p>HSC: "+hs+"<br/>"
                    + "SSC: "+ss+"</br>SY FY Average: "+st+"</br>Technologies: ");
            for (String string : tec) {
                out.println("<p>"+string+"</p>");
            }
            out.println("</br><p> Area of intrest"+ch1+","+ch2+","+ch3+","+ch4+"</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    public int getIntData(String tag,HttpServletRequest request) {
        try{
        return Integer.parseInt(request.getParameter(tag));
        }catch(Exception ex){
            return -1;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
