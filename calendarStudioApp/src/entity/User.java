package entity;

public class User {
	private String user;
	private String pswd;
	
	public User() {
		super();
	}
	public User(String user, String pswd) {
		super();
		this.user = user;
		this.pswd = pswd;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	

}
