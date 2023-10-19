/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.Requests;
import models.Roles;
import models.Semesters;
import models.Users;
import repositories.RequestsRepository;
import repositories.RolesRepository;
import repositories.SemestersRepository;
import repositories.UsersRepository;
import services.Services;

/**
 *
 * @author Dell
 */
@WebServlet(name = "RequestsController", urlPatterns = {"/requests"})
public class RequestsController extends HttpServlet {

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
        System.out.println("action " + action);
        switch (action) {
            case "list":
                try {
                    list(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("message", e.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;

            case "search":
                try {

                    search(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("message", e.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;

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

            default:
                break;
        }
    }

    protected void list(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            RequestsRepository rf = new RequestsRepository();
            List<Requests> list = rf.select();
            HttpSession session = request.getSession();
            List<Requests> listSearch = (List<Requests>) session.getAttribute("listSearch");
            if (listSearch != null && !listSearch.isEmpty()) {
                list = listSearch;
            }
            request.setAttribute("list", list);
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        } catch (SQLException ex) {
            ex.printStackTrace();
            request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
        }
    }

    protected void search(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String op = request.getParameter("op");
        HttpSession session = request.getSession();
        String select = request.getParameter("select");
        System.out.println("Select:" + select);
        switch (select) {
            case "subjectCode": {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String semester = (String) request.getParameter("semester");
                    String subjectCode = (String) request.getParameter("ID");
                    RequestsRepository rf = new RequestsRepository();
                    SemestersRepository sr = new SemestersRepository();
                    List<Requests> listSearch = rf.searchBySubjectCode(subjectCode);
                    List<Requests> listSearchBySC = new ArrayList<>();
                    List<Semesters> listSemester = sr.select();
                    for (Semesters s : listSemester) {
                        if (semester.equals(s.getSemesterID())) {
                            for (Requests rs : listSearch) {
                                if (rs.getStartTime().compareTo(s.getStartDay()) >= 0 && rs.getEndTime().compareTo(s.getEndDay()) <= 0) {
                                    listSearchBySC.add(rs);
                                    session.setAttribute("listSearch", listSearchBySC);
                                    System.out.println(rs.getStartTime());
                                } else {
                                    System.out.println("no");
                                }
                            }
                        } else {
                            System.out.println("NO RESULTS");
                        }
                    }
                    if (listSearchBySC.isEmpty()) {
                        System.out.println("Empty");
                        request.setAttribute("msg", "NO RESULTS");
                        request.getRequestDispatcher("/requests/list.do").forward(request, response);
                    } else {
                        System.out.println("listSearch" + listSearchBySC);
                        response.sendRedirect(request.getContextPath() + "/requests/list.do");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }

            case "student": {
                try {
                    String studentID = (String) request.getParameter("ID");
                    String semester = (String) request.getParameter("semester");
                    RequestsRepository rf = new RequestsRepository();
                    SemestersRepository sr = new SemestersRepository();
                    List<Requests> listSearch = rf.searchByStudentID(studentID);
                    List<Requests> listSearchByS = new ArrayList<>();
                    List<Semesters> listSemester = sr.select();
                    for (Semesters s : listSemester) {
                        if (semester.equals(s.getSemesterID())) {
                            for (Requests rs : listSearch) {
                                if (rs.getStartTime().compareTo(s.getStartDay()) >= 0 && rs.getEndTime().compareTo(s.getEndDay()) <= 0) {
                                    listSearchByS.add(rs);
                                    session.setAttribute("listSearch", listSearchByS);

                                } else {
                                    System.out.println("OTP");
                                }
                            }
                        } else {
                            System.out.println("PLE");
                        }
                    }
                    if (listSearchByS.isEmpty()) {
                        System.out.println("Empty");
                        request.setAttribute("msg", "NO RESULTS");
                        request.getRequestDispatcher("/requests/list.do").forward(request, response);
                    } else {
                        System.out.println("listSearch" + listSearchByS);
                        response.sendRedirect(request.getContextPath() + "/requests/list.do");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }

            case "lecturer": {
                try {
                    String lecturerID = (String) request.getParameter("ID");
                    String semester = (String) request.getParameter("semester");
                    SemestersRepository sr = new SemestersRepository();
                    RequestsRepository rf = new RequestsRepository();
                    List<Requests> listSearch = rf.searchByLecturerID(lecturerID);
                    List<Requests> listSearchByL = new ArrayList<>();
                    List<Semesters> listSemester = sr.select();
                    for (Semesters s : listSemester) {
                        if (semester.equals(s.getSemesterID())) {
                            for (Requests rs : listSearch) {
                                if (rs.getStartTime().compareTo(s.getStartDay()) >= 0 && rs.getEndTime().compareTo(s.getEndDay()) <= 0) {
                                    listSearchByL.add(rs);
                                    session.setAttribute("listSearch", listSearchByL);

                                } else {
                                    System.out.println("Min Min");
                                }
                            }
                        } else {
                            System.out.println("Son Son");
                        }
                    }
                    if (listSearchByL.isEmpty()) {
                        System.out.println("Empty");
                        request.setAttribute("msg", "NO RESULTS");
                        request.getRequestDispatcher("/requests/list.do").forward(request, response);
                    } else {
                        System.out.println("listSearch" + listSearchByL);
                        response.sendRedirect(request.getContextPath() + "/requests/list.do");
                    }

                } catch (SQLException ex) {
                    //Hien trang thong bao loi
                    ex.printStackTrace();//In thông báo chi tiết cho developer
                    request.setAttribute("message", ex.getMessage());
                    request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            }
            default: {
            }
            break;
        }
        request.setAttribute("select", select);

    }

    protected void create(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/layouts/main.jsp").forward(request, response);
    }

    protected void create_handler(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestsRepository rr = new RequestsRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "create": {
                try {
                    Boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    String subjectCode = request.getParameter("subjectCode");
                    String day = request.getParameter("day");
                    String start = request.getParameter("start");
                    String startTime1 = day + " " + start;
                    Date startTime = Services.sdfDateTime.parse(request.getParameter(startTime1));
                    String end = request.getParameter("end");
                    String endTime1 = day + " " + end;
                    Date endTime = Services.sdfDateTime.parse(request.getParameter(endTime1));
                    String description = request.getParameter("description");
                    String studentID = request.getParameter("studentID");
                    String lecturerID = request.getParameter("lecturerID");
                    Requests requests = new Requests(status, subjectCode, startTime, endTime, description, studentID, lecturerID);
                    request.setAttribute("requests", requests);
                    rr.create(requests);
                    response.sendRedirect(request.getContextPath() + "/requests/list.do");
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
                response.sendRedirect(request.getContextPath() + "/requests/list.do");
                break;
            }
        }
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestsRepository rr = new RequestsRepository();
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            Requests requests = rr.read(ID);
            request.setAttribute("requests", requests);
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
        RequestsRepository rr = new RequestsRepository();
        String op = request.getParameter("op");
        switch (op) {
            case "update":
                try {
                    int ID = Integer.parseInt(request.getParameter("ID"));
                    Boolean status = Boolean.parseBoolean(request.getParameter("status"));
                    String subjectCode = request.getParameter("subjectCode");
                    String day = request.getParameter("day");
                    String start = request.getParameter("start");
                    String startTime1 = day + " " + start;
                    Date startTime = Services.sdfDateTime.parse(request.getParameter(startTime1));
                    String end = request.getParameter("end");
                    String endTime1 = day + " " + end;
                    Date endTime = Services.sdfDateTime.parse(request.getParameter(endTime1));
                    String description = request.getParameter("description");
                    String studentID = request.getParameter("studentID");
                    String lecturerID = request.getParameter("lecturerID");
                    Requests requests = new Requests(ID, status, subjectCode, startTime, endTime, description, studentID, lecturerID);
                    request.setAttribute("requests", requests);
                    rr.update(requests);
                    response.sendRedirect(request.getContextPath() + "/requests/list.do");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message", ex.getMessage());
                    request.setAttribute("controller", "error");
                    request.setAttribute("action", "error");
                    request.getRequestDispatcher("WEB-INF/layouts/main.jsp").forward(request, response);
                }
                break;
            case "cancel":
                response.sendRedirect(request.getContextPath() + "/requests/list.do");
        }
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestsRepository rr = new RequestsRepository();
        try {
            int ID = Integer.parseInt(request.getParameter("ID"));
            rr.delete(ID);
            response.sendRedirect(request.getContextPath() + "/requests/list.do");
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
