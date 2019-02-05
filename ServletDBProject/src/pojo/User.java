package pojo;

public class User {
	int uid,age;
	String pass,UName,city,country;
	
	
	
	public User(int uid,String pass, String uName, String city,
			String country,int age) {
		super();
		this.uid = uid;
		this.age = age;
		this.pass = pass;
		UName = uName;
		this.city = city;
		this.country = country;
	}
	public int getUid() {
		return uid;
	}



	public int getAge() {
		return age;
	}



	public String getPass() {
		return pass;
	}



	public String getUName() {
		return UName;
	}



	public String getCity() {
		return city;
	}



	public String getCountry() {
		return country;
	}



	
	
	
	
	
	

}
