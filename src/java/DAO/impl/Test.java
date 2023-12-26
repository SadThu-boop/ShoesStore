/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.impl;

import DAO.UserDao;
import JDBC.JDBCConnection;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author phucl
 */
public class Test extends JDBCConnection  {
    public List<User> getAll() {
		List<User> userList = new ArrayList<User>();
		String sql = "SELECT * FROM [User]";
		Connection conn = JDBCConnection.getJDBCConnection();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAvatar(rs.getString("avatar"));
				//user.setRoleId(Integer.parseInt(rs.getString("role_id")));
                                user.setRoleId(rs.getInt("role_id"));

				userList.add(user);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}

		return userList;
	}
    public static void main(String[]args){
        Test c = new Test();
        List<User> list=c.getAll();
        System.out.println(list.get(0).getEmail());
        
    }
}


