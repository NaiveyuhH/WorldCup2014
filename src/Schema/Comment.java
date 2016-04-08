package Schema;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Comment implements Serializable {

	private String Title;
	private String Content;
	private User isQueriedBy;
	private Event queries;
	private long Id;
	private static final long serialVersionUID = 5369226108410004371L;
  
	@Id @GeneratedValue
	public long getId() {
		return this.Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
	
	@Basic(optional=false) 
	public String getTitle() {
		return this.Title;
	}
	public void setTitle(String Title) {
		this.Title = Title;
	}
	
	@Basic(optional=false)
	public String getContent() {
		return this.Content;
	}
	public void setContent(String Content) {
		this.Content = Content;
	}

	@ManyToOne
	@JoinColumn(name="isQueriedBy", nullable=false)
	public User getIsQueriedBy() {
		return this.isQueriedBy;
	}
	public void setIsQueriedBy(User isQueriedBy) {
		this.isQueriedBy = isQueriedBy;
	}
	
	@ManyToOne
	@JoinColumn(name="queries", nullable=false)
	public Event getQueries() {
		return this.queries;
	}
	public void setQueries(Event queries) {
		this.queries = queries;
	}
	
	public Comment() {}
	public Comment(String Title, String Content) {
		this.Title = Title;
		this.Content = Content;
	}
	
	public String toString() {
		String comment = null;
		comment += "User: " + this.isQueriedBy.getName() + "\n";
		comment += "Title: " + this.Title + "\n";
		comment += "Content: " + this.Content + "\n";
		return comment;
	}
}
