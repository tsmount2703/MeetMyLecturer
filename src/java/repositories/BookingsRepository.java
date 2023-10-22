/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import models.Bookings;
import services.Services;

/**
 *
 * @author Dell
 */
public class BookingsRepository {

    public List<Bookings> select() throws SQLException {

        List<Bookings> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select b.ID, b.bookingID, b.studentID, b.freeSlotID, b.status,fs.startTime ,fs.endTime ,fs.subjectCode, fs.lecturerID\n"
                + "from Bookings as b join FreeSlots as fs on b.freeSlotID = fs.freeSlotID");
        list = new ArrayList<>();
        while (rs.next()) {
            Bookings bookings = new Bookings();
            bookings.setID(rs.getInt("ID"));
            bookings.setBookingID(rs.getString("bookingID"));
            bookings.setFreeSlotID(rs.getString("freeSlotID"));
            bookings.setStudentID(rs.getString("studentID"));
            bookings.setStatus(rs.getBoolean("status"));
            bookings.setStartTime(rs.getDate("startTime"));
            bookings.setEndTime(rs.getDate("endTime"));
            bookings.setSubjectCode(rs.getString("subjectCode"));
            bookings.setSubjectCode(rs.getString("lecturerID"));
            list.add(bookings);
        }
        con.close();
        return list;

    }

    public List<Bookings> searchByStudentID(String studentID) throws SQLException {

        List<Bookings> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select b.ID, b.bookingID, b.studentID, b.freeSlotID, b.status,fs.startTime ,fs.endTime ,fs.subjectCode, fs.lecturerID\n"
                + "from Bookings as b join FreeSlots as fs on b.freeSlotID = fs.freeSlotID\n"
                + "where studentID = ?");
        stm.setString(1, studentID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Bookings bookings = new Bookings();
            bookings.setID(rs.getInt("ID"));
            bookings.setBookingID(rs.getString("bookingID"));
            bookings.setFreeSlotID(rs.getString("freeSlotID"));
            bookings.setStudentID(rs.getString("studentID"));
            bookings.setStatus(rs.getBoolean("status"));
            bookings.setStartTime(rs.getDate("startTime"));
            bookings.setEndTime(rs.getDate("endTime"));
            bookings.setSubjectCode(rs.getString("subjectCode"));
            bookings.setSubjectCode(rs.getString("lecturerID"));
            list.add(bookings);
        }
        con.close();
        return list;
    }

    public List<Bookings> searchBySubjectCode(String subjectCode) throws SQLException {

        List<Bookings> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select b.ID, b.bookingID, b.studentID, b.freeSlotID, b.status,fs.startTime ,fs.endTime ,fs.subjectCode, fs.lecturerID\n"
                + "from Bookings as b join FreeSlots as fs on b.freeSlotID = fs.freeSlotID\n"
                + "where subjectCode = ?");
        stm.setString(1, subjectCode);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Bookings bookings = new Bookings();
            bookings.setID(rs.getInt("ID"));
            bookings.setBookingID(rs.getString("bookingID"));
            bookings.setFreeSlotID(rs.getString("freeSlotID"));
            bookings.setStudentID(rs.getString("studentID"));
            bookings.setStatus(rs.getBoolean("status"));
            bookings.setStartTime(rs.getDate("startTime"));
            bookings.setEndTime(rs.getDate("endTime"));
            bookings.setSubjectCode(rs.getString("subjectCode"));
            bookings.setSubjectCode(rs.getString("lecturerID"));
            list.add(bookings);
        }
        con.close();
        return list;
    }

    public List<Bookings> searchByLecturerID(String lecturerID) throws SQLException {

        List<Bookings> list = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select b.ID, b.bookingID, b.studentID, b.freeSlotID, b.status,fs.startTime ,fs.endTime ,fs.subjectCode, fs.lecturerID\n"
                + "from Bookings as b join FreeSlots as fs on b.freeSlotID = fs.freeSlotID\n"
                + "where lecturerID = ?");
        stm.setString(1, lecturerID);
        ResultSet rs = stm.executeQuery();
        list = new ArrayList<>();
        while (rs.next()) {
            Bookings bookings = new Bookings();
            bookings.setID(rs.getInt("ID"));
            bookings.setBookingID(rs.getString("bookingID"));
            bookings.setFreeSlotID(rs.getString("freeSlotID"));
            bookings.setStudentID(rs.getString("studentID"));
            bookings.setStatus(rs.getBoolean("status"));
            bookings.setStartTime(rs.getDate("startTime"));
            bookings.setEndTime(rs.getDate("endTime"));
            bookings.setSubjectCode(rs.getString("subjectCode"));
            bookings.setSubjectCode(rs.getString("lecturerID"));
            list.add(bookings);
        }
        con.close();
        return list;
    }

    public Bookings read(int ID) throws SQLException {
        Bookings bookings = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Bookings where ID = ? ");
        stm.setInt(1, ID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            bookings = new Bookings();
            bookings.setID(rs.getInt("ID"));
            bookings.setBookingID(rs.getString("bookingID"));
            bookings.setStudentID(rs.getString("studentID"));
            bookings.setFreeSlotID(rs.getString("freeSlotID"));
            bookings.setStatus(rs.getBoolean("status"));
        }
        con.close();
        return bookings;
    }

    public void create(Bookings bookings) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Bookings values(?, ?, ?)");
//        stm.setString(1, bookings.getBookingID());
        stm.setString(1, bookings.getStudentID());
        stm.setString(2, bookings.getFreeSlotID());
        stm.setBoolean(3, bookings.isStatus());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Bookings bookings) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Bookings set studentID = ?, freeSlotID = ?, status = ? where ID = ?");
//        stm.setString(1, bookings.getBookingID());
        stm.setString(1, bookings.getStudentID());
        stm.setString(2, bookings.getFreeSlotID());
        stm.setBoolean(3, bookings.isStatus());
        stm.setInt(4, bookings.getID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int ID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from Bookings where ID = ? ");
        stm.setInt(1, ID);
        int count = stm.executeUpdate();
        con.close();
    }

}
