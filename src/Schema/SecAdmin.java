package Schema;

import java.io.Serializable;
import javax.persistence.*;

import Schema.User;

@Entity
@Access(AccessType.PROPERTY)

public class SecAdmin extends User implements Serializable {
	
	private static final long serialVersionUID = -3290583263775342790L;
	
	public SecAdmin() {
		super();
	}
	public SecAdmin(String name, String password) {
		super(name, password);
	}
}