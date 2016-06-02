package restaurant;
public class Users {

	private String uid;
	private String lastName;
	private String firstName;
	private String email;
	private boolean admin;
	private String password;

	public Users() {
		
	}
	public Users(String userid){
		
		super();
		this.uid=userid;
		
	}
	public Users(String lastName, String firstName, String email,boolean admin, String password) {
		
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.admin = admin;
		this.password = password;
	}
	
	public Users(String uid, String lastName, String firstName, String email,boolean admin) {
		
		super();
		this.uid=uid;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.admin = admin;
		
	}

	public String getId() {
		System.out.println("Password Check id" );
		return uid;
	}
	
	public void setId(String id) {
		this.uid = id;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String pwd) {
		this.password = pwd;
	}

	
	@Override
	public String toString() {
		return firstName + " " + lastName;
	}
}

