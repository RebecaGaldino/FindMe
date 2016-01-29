package findMe.domain;

import java.util.Date;

public class Person {
	
	private String id;
	private String cpf;
	private Date birth_dt;
	private String name;
	
	
	
	public Person(String id, String cpf, Date birth_dt, String name){
		setId(id);
		setCpf(cpf);
		setBirth_dt(birth_dt);
		setName(name);
	}
	
	public Person(String id){
		setId(id);
	}
	
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
	
	
}
