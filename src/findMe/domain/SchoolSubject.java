package findMe.domain;

public class SchoolSubject {
	private String name;
	private String id;
	
	public SchoolSubject(String name, String id){
		setName(name);
		setId(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}