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
import models.Subjects;

/**
 *
 * @author Dell
 */
public class SubjectsRepository {

    public List<Subjects> select() throws SQLException {

        List<Subjects> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from Subjects ");
        list = new ArrayList<>();
        while (rs.next()) {
            Subjects subjects = new Subjects();
            subjects.setSubjectCode(rs.getString("subjectCode"));
            subjects.setSubjectName(rs.getString("subjectName"));
            list.add(subjects);
        }
        con.close();
        return list;

    }

    public Subjects read(String subjectCode) throws SQLException {
        Subjects subjects = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Subjects where subjectCode = ? ");
        stm.setString(1, subjectCode);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            subjects = new Subjects();
            subjects.setSubjectCode(rs.getString("subjectCode"));
            subjects.setSubjectName(rs.getString("subjectName"));
        }
        con.close();
        return subjects;
    }

    public void create(Subjects subjects) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Subjects values(?, ?)");
        stm.setString(1, subjects.getSubjectCode());
        stm.setString(2, subjects.getSubjectName());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Subjects subjects) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Subjects set subjectName = ? where subjectCode = ?");
        stm.setString(1, subjects.getSubjectName());
        stm.setString(2, subjects.getSubjectCode());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(String subjectCode) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from Subjects where subjectCode = ? ");
        stm.setString(1, subjectCode);
        int count = stm.executeUpdate();
        con.close();
    }
}
