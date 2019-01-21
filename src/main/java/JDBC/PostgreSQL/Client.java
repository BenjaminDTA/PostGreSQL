package JDBC.PostgreSQL;

public class Client {
	private Integer id;
	private String lastname;
	private String firstname;
	private String gender;
	private Integer id_livrepref;
	
	
	
	
	public Client(String lastname, String firstname, String gender, Integer livrepref) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		this.id_livrepref = livrepref;
		
	}
	public Integer getId_livrepref() {
		return id_livrepref;
	}
	public void setId_livrepref(Integer id_livrepref) {
		this.id_livrepref = id_livrepref;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	

}
