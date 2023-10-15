/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import config.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.Semesters;

/**
 *
 * @author Dell
 */
public class SemestersRepository {
    public List<Semesters> select() throws SQLException {

        List<Semesters> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from [dbo].[Semesters]");
        list = new ArrayList<>();
        while (rs.next()) {
            Semesters semesters = new Semesters();
            semesters.setSemesterID(rs.getString("semesterID"));
            semesters.setSemesterName(rs.getString("semesterName"));
            semesters.setStartDay(rs.getTimestamp("startDay"));
            semesters.setEndDay(rs.getTimestamp("endDay"));
            list.add(semesters);
        }
        con.close();
        return list;
    }
}
