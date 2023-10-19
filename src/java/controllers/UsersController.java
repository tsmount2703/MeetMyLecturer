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
import javax.servlet.http.HttpSession;
import models.Roles;
import models.Users;
import repositories.RolesRepository;
import repositories.UsersRepository;

/**
 *
 * @author Dell
 */
@WebServlet(name = "UsersController", urlPatterns = {"/users"})
public class UsersController extends HttpServlet {

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
            case "login": {
                request.getRequestDispatcher("/WEB-INF/views/users/login.jsp").forward(request, response);
                break;
            }
            case "login_handler": {
                login_handler(request, response);
                break;
            }
            case "logout": {
                logout(request, response);
                break;
            }

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

    protected void login_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        switch (op) {
            case "login": {
                try {
                    String userEmail = request.getParameter("userEmail");
                    String password = request.getParameter("password");
                    UsersRepository ur = new UsersRepository();
                    Users u = ur.login(userEmail, password);
                    if (u != null) {
                        if (ur.isActive(u.isUserStatus())) {
                            HttpSession session = request.getSession();
                            session.setAttribute("users", u);
                        } else {
                            request.setAttribute("message", "Your account is currently unactive. Contact the service for more details.");
                        }

                    } else {
                        request.setAttribute("message", "Wrong Email or password!!!");
                    }

                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }
            default: {
                break;
            }

        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("/WEB-INF/views/users/login.jsp").forward(request, response);

    }

    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            UsersRepository ur = new UsersRepository();
            List<Users> list = ur.select();
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
        UsersRepository ur = new UsersRepository();
        RolesRepository rr = new RolesRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create": {
                try {
                    String userID = request.getParameter("userID");
                    String userName = request.getParameter("userName");
                    String userEmail = request.getParameter("userEmail");
                    Boolean userStatus = Boolean.parseBoolean(request.getParameter("userStatus"));
                    String roleID = request.getParameter("roleID");
                    String password = request.getParameter("password");
                    Users users = new Users(userID, userName, userEmail, userStatus, roleID, password);
                    request.setAttribute("users", users);
                    List<Roles> list = rr.select();
                    request.setAttribute("list", list);
                    ur.create(users);
                    response.sendRedirect(request.getContextPath() + "/users/list.do");
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
                response.sendRedirect(request.getContextPath() + "/users/list.do");
                break;
            }
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersRepository ur = new UsersRepository();
        try {
            String userID = request.getParameter("userID");
            Users users = ur.read(userID);
            request.setAttribute("users", users);
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
        UsersRepository ur = new UsersRepository();
        RolesRepository rr = new RolesRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    String userID = request.getParameter("userID");
                    String userName = request.getParameter("userName");
                    String userEmail = request.getParameter("userEmail");
                    Boolean userStatus = Boolean.parseBoolean(request.getParameter("userStatus"));
                    String roleID = request.getParameter("roleID");
                    String password = request.getParameter("password");
                    Users users = new Users(userID, userName, userEmail, userStatus, roleID, password);
                    request.setAttribute("users", users);
                    List<Roles> list = rr.select();
                    request.setAttribute("list", list);
                    ur.update(users);
                    response.sendRedirect(request.getContextPath() + "/users/list.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/users/list.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsersRepository ur = new UsersRepository();
        try {
            String userID = request.getParameter("userID");
            ur.delete(userID);
            response.sendRedirect(request.getContextPath() + "/users/list.do");
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
