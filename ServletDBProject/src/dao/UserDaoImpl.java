package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.MyConnection;
import pojo.User;

public class UserDaoImpl implements UserDao{
	
	Connection con=MyConnection.getConnection();
	
	@Override
	
	public String addUser(User user) {
	int res = 0;
		try {
			PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?,?,?)");
			ps.setInt(1,user.getUid());
			ps.setString(2,user.getPass());
			ps.setString(3,user.getUName());
			ps.setString(4, user.getCity());
			ps.setString(5,user.getCountry());
			ps.setInt(6,user.getAge());
		res=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (res>0)
		return "Success";

	return"Cannot add user";
	}

	@Override
	public String LoginUser(int uid, String pass) {
		
		return null;
	}

	@Override
	public String changePassword(int uid, String newPass, String oldPass) {
		// TODO Auto-generated method stub
		return null;
	}

}
