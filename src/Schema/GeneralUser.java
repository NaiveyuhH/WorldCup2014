package Schema;

import java.io.Serializable;
import javax.persistence.*;

import Schema.User;

@Entity
@Access(AccessType.PROPERTY)

public class GeneralUser extends User implements Serializable {
	
	private static final long serialVersionUID = -7375181875317297527L;

	public GeneralUser() {
		super();
	}
	public GeneralUser(String name, String password) {
		super(name, password);
	}
}