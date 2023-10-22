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
import models.Slots;

/**
 *
 * @author Dell
 */
public class SlotsRepository {

    public List<Slots> select() throws SQLException {

        List<Slots> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from Slots ");
        list = new ArrayList<>();
        while (rs.next()) {
            Slots slots = new Slots();
            slots.setSlotID(rs.getString("slotID"));
            slots.setDay1(rs.getString("day1"));
            slots.setDay2(rs.getString("day2"));
            slots.setStartTime(rs.getTime("starttime"));
            slots.setEndTime(rs.getTime("endtime"));
            list.add(slots);
        }
        con.close();
        return list;

    }

    public Slots read(String slotID) throws SQLException {
        Slots slots = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Slots where slotID = ? ");
        stm.setString(1, slotID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            slots = new Slots();
            slots.setSlotID(rs.getString("slotID"));
            slots.setDay1(rs.getString("day1"));
            slots.setDay2(rs.getString("day2"));
            slots.setStartTime(rs.getTime("starttime"));
            slots.setEndTime(rs.getTime("endtime"));
        }
        con.close();
        return slots;
    }

    public void create(Slots slots) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Slots values(?, ?, ?, ?, ?)");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        stm.setString(1, slots.getSlotID());
        stm.setString(2, slots.getDay1());
        stm.setString(3, slots.getDay2());
        stm.setString(4, sdf.format(slots.getStartTime()));
        stm.setString(5, sdf.format(slots.getEndTime()));
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Slots slots) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Slots set day1 = ?, day2 = ?, starttime = ?, endtime = ? where slotID = ?");
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        stm.setString(1, slots.getDay1());
        stm.setString(2, slots.getDay2());
        stm.setString(3, sdf.format(slots.getStartTime()));
        stm.setString(4, sdf.format(slots.getEndTime()));
        stm.setString(5, slots.getSlotID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(String slotID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from Slots where slotID = ? ");
        stm.setString(1, slotID);
        int count = stm.executeUpdate();
        con.close();
    }

}
