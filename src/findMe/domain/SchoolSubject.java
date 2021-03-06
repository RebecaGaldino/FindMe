package findMe.domain;

public class SchoolSubject {
	private String name;
	private String id;
	
	/**
	 * SchoolSubject's constructor
	 * @param name
	 * @param id
	 */
	public SchoolSubject(String name, String id){
		setName(name);
		setId(id);
	}
	
	
	/**
	 * SchoolSubject's default constructor
	 */
	public SchoolSubject(){
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	
	
	/**
	 * Method that checks whether a schoolSubject is equal to another schoolSubject
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SchoolSubject other = (SchoolSubject) obj;
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
		return true;
	}
	
	
}
