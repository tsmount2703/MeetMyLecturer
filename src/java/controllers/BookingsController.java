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
import models.Bookings;
import repositories.BookingsRepository;

/**
 *
 * @author Dell
 */
@WebServlet(name = "BookingsController", urlPatterns = {"/bookings"})
public class BookingsController extends HttpServlet {

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
            BookingsRepository br = new BookingsRepository();
            List<Bookings> list = br.select();
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
        BookingsRepository br = new BookingsRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create": {
                try {
                    String bookingID = request.getParameter("bookingID");
                    String studentID = request.getParameter("studentID");
                    String freeSlotID = request.getParameter("freeSlotID");
                    Boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    Bookings bookings = new Bookings(bookingID, studentID, freeSlotID, status);
                    request.setAttribute("bookings", bookings);
                    br.create(bookings);
                    response.sendRedirect(request.getContextPath() + "/bookings/list.do");
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
                response.sendRedirect(request.getContextPath() + "/bookings/list.do");
                break;
            }
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookingsRepository br = new BookingsRepository();
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            Bookings bookings = br.read(ID);
            request.setAttribute("bookings", bookings);
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
        BookingsRepository br = new BookingsRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    int ID = Integer.parseInt(request.getParameter("ID"));
                    String bookingID = request.getParameter("bookingID");
                    String studentID = request.getParameter("studentID");
                    String freeSlotID = request.getParameter("freeSlotID");
                    Boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    Bookings bookings = new Bookings(ID, bookingID, studentID, freeSlotID, status);
                    request.setAttribute("bookings", bookings);
                    br.update(bookings);
                    response.sendRedirect(request.getContextPath() + "/bookings/list.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/bookings/list.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookingsRepository br = new BookingsRepository();
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            br.delete(ID);
            response.sendRedirect(request.getContextPath() + "/bookings/list.do");
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
