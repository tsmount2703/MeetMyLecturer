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
import models.Timetables;

/**
 *
 * @author Dell
 */
public class TimetablesRepository {

    public List<Timetables> select() throws SQLException {

        List<Timetables> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from Timetables ");
        list = new ArrayList<>();
        while (rs.next()) {
            Timetables timetables = new Timetables();
            timetables.setSubjectCode(rs.getString("subjectCode"));
            timetables.setSlotID(rs.getString("slotID"));
            timetables.setLecturerID(rs.getString("lecturerID"));
            timetables.setSemesterID(rs.getString("semesterID"));
            list.add(timetables);
        }
        con.close();
        return list;

    }

    public Timetables read(String subjectCode, String slotID, String lecturerID, String semesterID) throws SQLException {
        Timetables timetables = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Timetables where subjectCode = ? and slotID = ? and lecturerID = ? and semesterID = ? ");
        stm.setString(1, subjectCode);
        stm.setString(2, slotID);
        stm.setString(3, lecturerID);
        stm.setString(4, semesterID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            timetables = new Timetables();
            timetables.setSubjectCode(rs.getString("subjectCode"));
            timetables.setSlotID(rs.getString("slotID"));
            timetables.setLecturerID(rs.getString("lecturerID"));
            timetables.setSemesterID(rs.getString("semesterID"));
        }
        con.close();
        return timetables;
    }

    public void create(Timetables timetables) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Timetables values(?, ?, ?, ?)");
        stm.setString(1, timetables.getSubjectCode());
        stm.setString(2, timetables.getSlotID());
        stm.setString(3, timetables.getLecturerID());
        stm.setString(4, timetables.getSemesterID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Timetables timetables) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Timetables set subjectCode = ?, slotID = ?, lecturerID = ?, semesterID = ?  where subjectCode = ? and slotID = ? and lecturerID = ? and semesterID = ? ");
        stm.setString(1, timetables.getSubjectCode());
        stm.setString(2, timetables.getSlotID());
        stm.setString(3, timetables.getLecturerID());
        stm.setString(4, timetables.getSemesterID());
        stm.setString(5, timetables.getSubjectCode());
        stm.setString(6, timetables.getSlotID());
        stm.setString(7, timetables.getLecturerID());
        stm.setString(8, timetables.getSemesterID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(String subjectCode, String slotID, String lecturerID, String semesterID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from Timetables where subjectCode = ? and slotID = ? and lecturerID = ? and semesterID = ? ");
        stm.setString(1, subjectCode);
        stm.setString(2, slotID);
        stm.setString(3, lecturerID);
        stm.setString(4, semesterID);
        int count = stm.executeUpdate();
        con.close();
    }
}
