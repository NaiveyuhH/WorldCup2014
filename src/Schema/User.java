package Schema;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Access(AccessType.PROPERTY)
public class User implements Serializable {

	private String name;
	private String password;
	private Set<Comment> comments = new HashSet<Comment>();
	private long Id;
	private static final long serialVersionUID = -8279607063963711953L;
	
	@Id @GeneratedValue
	public long getId() {
		return this.Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
	
	@Basic(optional=false)  
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}   
	
	@Basic(optional=false)
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(mappedBy="isQueriedBy")
	public Set<Comment> getComments() {
		return this.comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	public User() {}
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
}