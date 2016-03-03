package findMe.domain;

public class Supervisor_SchoolSubject {
	
	private int id;
	private Supervisor supervisor;
	private SchoolSubject schoolSubject;
	
	
	public Supervisor_SchoolSubject(int id, Supervisor supervisor, SchoolSubject schoolSubject) {
		setId(id);
		setSupervisor(supervisor);
		setSchoolSubject(schoolSubject);
	}
	
	/*------------------------------------------------------*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Supervisor getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}

	public SchoolSubject getSchoolSubject() {
		return schoolSubject;
	}

	public void setSchoolSubject(SchoolSubject schoolSubject) {
		this.schoolSubject = schoolSubject;
	}

}
