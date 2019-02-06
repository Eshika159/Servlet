package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		String pass2 = null;
		try {
			PreparedStatement ps=con.prepareStatement("select Pass from user where Uid=?");
			ps.setInt(1,uid);
			ResultSet res=ps.executeQuery();
			if(res.next()){
			 pass2=res.getString(1);
			
			if(pass2.equals(pass))
				return "success";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "fail";
	}

	@Override
	public String changePassword(int uid, String newPass, String oldPass) {
		String pass2 = null;
		try {
			PreparedStatement ps=con.prepareStatement("select Pass from user where Uid=?");
			ps.setInt(1,uid);
			ResultSet res=ps.executeQuery();
			if(res.next()){
			 pass2=res.getString(1);
			
			if(pass2.equals(oldPass))
			{
				PreparedStatement ps2=con.prepareStatement("update user set Pass=? where Uid=?");
				ps2.setString(1,newPass);
				ps2.setInt(2,uid);
				int rows=ps2.executeUpdate();
				if(rows>0)
					return "success";
			}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "fail";
		
	}

}
