/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Semesters;
import models.Slots;
import repositories.SlotsRepository;
import services.Services;

/**
 *
 * @author Dell
 */
@WebServlet(name = "SlotsController", urlPatterns = {"/slots"})
public class SlotsController extends HttpServlet {

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
            SlotsRepository slr = new SlotsRepository();
            List<Slots> list = slr.select();
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
        SlotsRepository slr = new SlotsRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create": {
                try {
                    String slotID = request.getParameter("slotID");
                    String day1 = request.getParameter("day1");
                    String day2 = request.getParameter("day2");
                    Date startTime = Services.sdfTime.parse(request.getParameter("startTime"));
                    Date endTime = Services.sdfTime.parse(request.getParameter("endTime"));
                    Slots slots = new Slots(slotID, day1, day2, startTime, endTime);
                    request.setAttribute("slots", slots);
                    slr.create(slots);
                    response.sendRedirect(request.getContextPath() + "/slots/list.do");
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
                response.sendRedirect(request.getContextPath() + "/slots/list.do");
                break;
            }
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlotsRepository slr = new SlotsRepository();
        try {
            String slotID = request.getParameter("slotID");
            Slots slots = slr.read(slotID);
            request.setAttribute("slots", slots);
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
        SlotsRepository slr = new SlotsRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    String slotID = request.getParameter("slotID");
                    String day1 = request.getParameter("day1");
                    String day2 = request.getParameter("day2");
                    Date startTime = Services.sdfTime.parse(request.getParameter("startTime"));
                    Date endTime = Services.sdfTime.parse(request.getParameter("endTime"));
                    Slots slots = new Slots(slotID, day1, day2, startTime, endTime);
                    request.setAttribute("slots", slots);
                    slr.update(slots);
                    response.sendRedirect(request.getContextPath() + "/slots/list.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/slots/list.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SlotsRepository slr = new SlotsRepository();
        try {
            String slotID = request.getParameter("slotID");
            slr.delete(slotID);
            response.sendRedirect(request.getContextPath() + "/slots/list.do");
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
