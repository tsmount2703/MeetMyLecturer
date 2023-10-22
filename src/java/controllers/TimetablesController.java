/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Timetables;
import repositories.TimetablesRepository;

/**
 *
 * @author Dell
 */
@WebServlet(name = "TimetablesController", urlPatterns = {"/timetables"})
public class TimetablesController extends HttpServlet {

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
        String controller = (String) request.getAttribute("controller");
        String action = (String) request.getAttribute("action");
        switch (action) {
            case "list": {
                list(request, response);
                break;
            }

            case "update": {
                update(request, response);
                break;
            }

            case "update_handler": {
                update_handler(request, response);
                break;
            }

            case "create": {
                create(request, response);
                break;
            }

            case "create_handler": {
                create_handler(request, response);
                break;
            }
             case "delete": {
                delete(request, response);
                break;
            }
            
            default: {
                break;
            }

        }
    }

    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            TimetablesRepository ttr = new TimetablesRepository();
            List<Timetables> list = ttr.select();
            request.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TimetablesRepository ttr = new TimetablesRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create": {
                try {
                    String subjectCode = request.getParameter("subjectCode");
                    String slotID = request.getParameter("slotID");
                    String lecturerID = request.getParameter("lecturerID");
                    String semesterID = request.getParameter("semesterID");
                    Timetables timetables = new Timetables(subjectCode, slotID, lecturerID, semesterID);
                    request.setAttribute("timetables", timetables);
                    ttr.create(timetables);
                    response.sendRedirect(request.getContextPath() + "/timetables/list.do");
                } catch (Exception ex) {
                    //Hiện lại create form để nhập lại dữ liệu
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("action", "create");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }

            case "cancel": {
                response.sendRedirect(request.getContextPath() + "/timetables/list.do");
                break;
            }
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TimetablesRepository ttr = new TimetablesRepository();
        try {
            String subjectCode = request.getParameter("subjectCode");
            String slotID = request.getParameter("slotID");
            String lecturerID = request.getParameter("lecturerID");
            String semesterID = request.getParameter("semesterID");
            Timetables timetables = ttr.read(subjectCode, slotID, lecturerID, semesterID);
            request.setAttribute("timetables", timetables);
            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void update_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TimetablesRepository ttr = new TimetablesRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    String subjectCode = request.getParameter("subjectCode");
                    String slotID = request.getParameter("slotID");
                    String lecturerID = request.getParameter("lecturerID");
                    String semesterID = request.getParameter("semesterID");
                    Timetables timetables = new Timetables(subjectCode, slotID, lecturerID, semesterID);
                    request.setAttribute("timetables", timetables);
                    ttr.update(timetables);
                    response.sendRedirect(request.getContextPath() + "/timetables/list.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/timetables/list.do");
        }
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TimetablesRepository ttr = new TimetablesRepository();
        try {
            String subjectCode = request.getParameter("subjectCode");
            String slotID = request.getParameter("slotID");
            String lecturerID = request.getParameter("lecturerID");
            String semesterID = request.getParameter("semesterID");
            ttr.delete(subjectCode, slotID, lecturerID, semesterID);
            response.sendRedirect(request.getContextPath() + "/timetables/list.do");
//            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.setAttribute("controller", "error");
            request.setAttribute("action", "error");
            request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
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
