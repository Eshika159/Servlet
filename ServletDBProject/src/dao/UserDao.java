package dao;
import pojo.User;


public interface UserDao {

	String addUser(User user);
	String LoginUser(int uid,String pass);
	String changePassword(int uid,String newPass,String oldPass);
}
