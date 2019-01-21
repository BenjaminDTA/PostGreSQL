package jdbc.postgresql;

public class Client {
	private Integer id;
	private String lastname;
	private String firstname;
	private String gender;
	private Integer idLivrePref;

	public Client(String lastname, String firstname, String gender, Integer livrepref) {
		super();
		this.lastname = lastname;
		this.firstname = firstname;
		this.gender = gender;
		this.idLivrePref = livrepref;

	}

	public Integer getidLivrePref() {
		return idLivrePref;
	}

	public void setidLivrePref(Integer idLivrePref) {
		this.idLivrePref = idLivrePref;
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
