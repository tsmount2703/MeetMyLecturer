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
import models.Requests;
import models.Users;
import services.Services;

/**
 *
 * @author Dell
 */
public class UsersRepository {

    public Users login(String userEmail, String password) throws SQLException {
        Users users = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Users as u join Roles as r on u.roleID = r.roleID\n"
                + "where u.userEmail = ?\n"
                + "and u.password = ?");
        stm.setString(1, userEmail);
        stm.setString(2, password);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            users = new Users();
            users.setUserID(rs.getString("userID"));
            users.setUserName(rs.getString("userName"));
            users.setUserEmail(rs.getString("userEmail"));
            users.setRoleID(rs.getString("roleID"));
            users.setPassword(rs.getString("password"));
            users.setRoleName(rs.getString("roleName"));
            users.setUserStatus(rs.getBoolean("userStatus"));
        }
        con.close();
        return users;
    }

    public List<Users> select() throws SQLException {

        List<Users> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select * from Users as u join Roles as r on u.roleID = r.roleID");
        list = new ArrayList<>();
        while (rs.next()) {
            Users users = new Users();
            users.setUserID(rs.getString("userID"));
            users.setUserName(rs.getString("userName"));
            users.setUserEmail(rs.getString("userEmail"));
            users.setRoleID(rs.getString("roleID"));
            users.setPassword(rs.getString("password"));
            users.setRoleName(rs.getString("roleName"));
            users.setUserStatus(rs.getBoolean("userStatus"));
            users.setStatusText(Services.getStatusOfUsers(rs.getBoolean("userStatus")));
            list.add(users);
        }
        con.close();
        return list;
    }

    public Users read(String userID) throws SQLException {
        Users users = null;
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("select * from Users as u join Roles as r on u.roleID = r.roleID where userID = ? ");
        stm.setString(1, userID);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            users = new Users();
            users.setUserID(rs.getString("userID"));
            users.setUserName(rs.getString("userName"));
            users.setUserEmail(rs.getString("userEmail"));
            users.setRoleID(rs.getString("roleID"));
            users.setPassword(rs.getString("password"));
            users.setRoleName(rs.getString("roleName"));
            users.setUserStatus(rs.getBoolean("userStatus"));
        }
        con.close();
        return users;
    }

    public void create(Users users) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("insert into Users values(?, ?, ?, ?, ?, ?)");
        stm.setString(1, users.getUserID());
        stm.setString(2, users.getUserName());
        stm.setString(3, users.getUserEmail());
        stm.setBoolean(4, users.isUserStatus());
        stm.setString(5, users.getRoleID());
        stm.setString(6, users.getPassword());
        int count = stm.executeUpdate();
        con.close();
    }

    public void update(Users users) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("update Users set userName = ?, userEmail = ?, userStatus = ?, roleID = ?, password = ? where userID=?  ");
        stm.setString(1, users.getUserName());
        stm.setString(2, users.getUserEmail());
        stm.setBoolean(3, users.isUserStatus());
        stm.setString(4, users.getRoleID());
        stm.setString(5, users.getPassword());
        stm.setString(6, users.getUserID());
        int count = stm.executeUpdate();
        con.close();
    }

    public void delete(String userID) throws SQLException {
        Connection con = DBContext.getConnection();
        PreparedStatement stm = con.prepareStatement("delete from Users where userID = ? ");
        stm.setString(1, userID);
        int count = stm.executeUpdate();
        con.close();

    }

    public boolean isActive(boolean userStatus) {
        return userStatus == true;
    }

}
