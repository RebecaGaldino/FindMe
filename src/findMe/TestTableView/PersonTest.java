package findMe.TestTableView;

import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
/**
 * 
 * @author ViniFarias
 *
 */
public class PersonTest {
	
	private final SimpleStringProperty id;
	private final SimpleStringProperty name;
	
	public PersonTest(String id, String name){
		super();
		this.id = new SimpleStringProperty(id);
		this.name = new SimpleStringProperty(name);
	}
	
	
	/*---------------------------------------------------------------------------------------------------------*/
	
	public String getId() {
		return id.get();
	}
	
	public String getName() {
		return name.get();
	}
}
