package com.caps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.caps.beans.User;

public class UserDAOImpl implements UserInfoDAO{
	public UserDAOImpl() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	public static final String DBURL="jdbc:mysql://localhost:3306/caps_htd"
			+ "?user=root&password=root";
	@Override
	public boolean createProfile(User u) {
		String sql = "INSERT INTO users_info VALUES(?,?,?,?)";
		try(Connection con = DriverManager.getConnection(DBURL);
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setString(1, u.getUid());
			pstmt.setString(2, u.getUname());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getPassword());

			int count = pstmt.executeUpdate();

			if(count > 0) {
				System.out.println("Profile Created....");
				return true;
			}else {
				System.out.println("Something Went Worng....");
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Something Went Worng....");
			e.printStackTrace();
			return false; 
		}
	}
	@Override
	public User loginServ(String userid, String passwd) {
		String sql = "SELECT * FROM users_info"
				+ " WHERE user_id=? AND password=?";
		try(Connection con = DriverManager.getConnection(DBURL);
				PreparedStatement pstmt = con.prepareStatement(sql)){
			User u = new User();
			pstmt.setString(1, userid);
			pstmt.setString(2, passwd);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					u.setUid(rs.getString("user_id"));
					u.setUname(rs.getString("user_name"));
					u.setEmail(rs.getString("email"));
					return u;
				}else {
					System.out.println("Worng Credentials....");
				}
			}

		} catch (Exception e) {
			System.out.println("Something went Worng...");
			e.printStackTrace();
		}
		return null;
	}

}
