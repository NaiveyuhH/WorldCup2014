package Schema;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Schedule implements Serializable {

	public enum Type {Home, Away};
	private Type Type;
	private Team isPlayedBy;
	private Event plays;
	private long Id;
	private static final long serialVersionUID = 746281735492284827L;
	
	@Id @GeneratedValue
	public long getId() {
		return this.Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
	
	@Basic(optional=false)
	public Type getType() {
		return this.Type;
	}
	public void setType(Type Type) {
		this.Type = Type;
	}   
	
	@ManyToOne
	@JoinColumn(name="isPlayedBy", nullable=false)
	public Team getIsPlayedBy() {
		return this.isPlayedBy;
	}
	public void setIsPlayedBy(Team isPlayedBy) {
		this.isPlayedBy = isPlayedBy;
	}
	
	@ManyToOne
	@JoinColumn(name="plays", nullable=false)
	public Event getPlays() {
		return this.plays;
	}
	public void setPlays(Event plays) {
		this.plays = plays;
	}	
	public Schedule() {}
	public Schedule(Type Type) {
		this.Type = Type;
	}
}
