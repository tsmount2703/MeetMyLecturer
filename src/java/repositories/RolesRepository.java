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
import models.Roles;
import services.Services;

/**
 *
 * @author Dell
 */
public class RolesRepository {

    public List<Roles> select() throws SQLException {

        List<Roles> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from Roles as r");
        list = new ArrayList<>();
        while (rs.next()) {
            Roles roles = new Roles();
            roles.setRoleID(rs.getString("roleID"));
            roles.setRoleName(rs.getString("roleName"));
            list.add(roles);
        }
        con.close();
        return list;

    }

    public Roles read(int roleID) throws SQLException {
        Roles roles = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Roles where roleID = ? ");
        stm.setInt(1, roleID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            roles = new Roles();
            roles.setRoleID(rs.getString("roleID"));
            roles.setRoleName(rs.getString("roleName"));
        }
        con.close();
        return roles;
    }

    public void create(Roles roles) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Roles values(?, ?)");
        stm.setString(1, roles.getRoleID());
        stm.setString(2, roles.getRoleName());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Roles roles) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Roles set roleName = ? where roleID = ?");
        stm.setString(1, roles.getRoleName());
        stm.setString(2, roles.getRoleID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(int roleID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from Roles where roleID = ? ");
        stm.setInt(1, roleID);
        int count = stm.executeUpdate();
        con.close();
    }

}
