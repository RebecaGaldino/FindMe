package findMe.domain;

import java.util.Date;
/**
 * 
 * @author thayanneLuiza, ViniFarias, RebecaGaldino
 *
 */
public class Person {
	
	private String id;
	private String cpf;
	private Date birth_dt;
	private String name;
	private String password;
	private String sex;
	private String rg;
	private String email;
	
	
	/**
	 * Person's constructor
	 * @param id
	 * @param cpf
	 * @param birth_dt
	 * @param name
	 * @param password
	 * @param sex
	 * @param rg
	 * @param email
	 */
	public Person(String id, String cpf, Date birth_dt, String name, String password, String sex, String rg, String email){
		setId(id);
		setCpf(cpf);
		setBirth_dt(birth_dt);
		setName(name);
		setPassword(password);
		setSex(sex);
		setRg(rg);
		setEmail(email);
	}
	
	/**
	 * Person's default constructor
	 */
	public Person(){
		setId("0");
		setCpf("0");
		Date dt = null;
		setBirth_dt(dt);
		setName("0");
		setPassword("000");
		setSex("0");
		setRg("example@example.com");
	}
	
	/*---------------------------------------------------------------------------------------------------------*/
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getBirth_dt() {
		return birth_dt;
	}
	
	public void setBirth_dt(Date birth_dt) {
		this.birth_dt = birth_dt;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		sex = sex;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
