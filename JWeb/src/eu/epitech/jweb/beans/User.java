package eu.epitech.jweb.beans;

public class User
{
	private int		id;
	private String	firstName;
	private String	lastName;
	private String	email;
	private String	userName;
	private String	password;
	private String	address;
	private String	state;
	private String	city;
	private String	gender;
	private boolean admin;
	private boolean newsletter;
	
	public User()
	{
		
	}

	public User(int id, String firstName, String lastName, String email, String userName, String password, String adress, String state, String city, String gender, boolean admin, boolean newsletter)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.address = adress;
		this.state = state;
		this.city = city;
		this.gender = gender;
		this.setAdmin(admin);
		this.setNewsletter(newsletter);
	}

	public int		getId()	{
		return id;
	}
	
	public void		setId(int id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean newsletter) {
		this.newsletter = newsletter;
	}
}
