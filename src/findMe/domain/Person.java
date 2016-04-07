package findMe.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author thayanneLuiza, ViniFarias, RebecaGaldino
 *
 */
public class Person {
	
	private String id;
	private String cpf;
	private String birth_dt;
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
	public Person(String id, String cpf, String birth_dt, String name, String password, String sex, 
			String rg, String email){
		
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
		setBirth_dt("00/00/0000");
		setName("0");
		setPassword("000");
		setSex("0");
		setRg("123123");
		setEmail("example@example.com");
	}
	
	
	/*---------------------------------------------------------------------------------------------------------*/
	
	/**
	 * Returns the id of the person
	 * @return
	 */
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	
	/**
	 * Returns the id of the person
	 * @return
	 */
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	/**
	 * Returns the id of the person
	 * @return
	 */
	public String getBirth_dt() {
		return birth_dt;
	}
	
	public void setBirth_dt(String birth_dt) {
		this.birth_dt = birth_dt;
	}
	
	
	/**
	 * Returns the name of the person
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * Returns the password of the person
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	/**
	 * Returns the sex of the person
	 * @return
	 */
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	/**
	 * Returns the rg of the person
	 * @return
	 */
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
	
	/**
	 * Returns the email of the person
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birth_dt == null) ? 0 : birth_dt.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}
	
	/**
	 * Method that checks whether a person is equal to another person
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (birth_dt == null) {
			if (other.birth_dt != null)
				return false;
		} else if (!birth_dt.equals(other.birth_dt))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
	
	
}