package serviceLayer;

import pojo.User;
import dao.UserDaoImpl;

public class UserServiceLayer {
	
	UserDaoImpl ud=new UserDaoImpl();

	public String addUser(User user) {
	String result=ud.addUser(user);
		return result;
	}

	
	public String LoginUser(int uid, String pass) {
		String loginstatus=ud.LoginUser(uid, pass);
		return loginstatus;
	}

	
	public String changePassword(int uid, String newPass, String oldPass) {
		String passStatus=ud.changePassword(uid, newPass, oldPass);
		return passStatus;
	}
	

}
