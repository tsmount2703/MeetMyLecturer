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
        ResultSet rs = stm.executeQuery("select * from Bookings as b ");
        list = new ArrayList<>();
        while (rs.next()) {
            Bookings bookings = new Bookings();
            bookings.setID(rs.getInt("ID"));
            bookings.setBookingID(rs.getString("bookingID"));
            bookings.setFreeSlotID(rs.getString("freeSlotID"));
            bookings.setStudentID(rs.getString("studentID"));
            bookings.setStatus(rs.getBoolean("status"));
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
        PreparedStatement stm = con.prepareStatement("insert into Bookings values(?, ?, ?, ?)");
        stm.setString(1, bookings.getBookingID());
        stm.setString(2, bookings.getStudentID());
        stm.setString(3, bookings.getFreeSlotID());
        stm.setBoolean(4, bookings.isStatus());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Bookings bookings) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Bookings set bookingID = ?, studentID = ?, freeSlotID = ?, status = ? where ID = ?");
        stm.setString(1, bookings.getBookingID());
        stm.setString(2, bookings.getStudentID());
        stm.setString(3, bookings.getFreeSlotID());
        stm.setBoolean(4, bookings.isStatus());
        stm.setInt(5, bookings.getID());
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
