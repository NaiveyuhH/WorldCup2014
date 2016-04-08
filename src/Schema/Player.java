package Schema;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Player implements Serializable {

	private String Name;
	private int Number;
	private int Age;
	private Team team;
	private long id;
	private Set<PlayerPerformance> performance = new HashSet<PlayerPerformance>();
	private static final long serialVersionUID = 8425757248319161850L;
	
	@Id @GeneratedValue
	public long getId() {
		return this.id;
	}
	public void setId(long Id) {
		this.id = Id;
	}
	
	@Basic(optional=false)
	public String getName() {
		return this.Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	@Basic(optional=false)
	public int getNumber() {
		return this.Number;
	}
	public void setNumber(int Number) {
		this.Number = Number;
	}   
	
	@Basic(optional=false)
	public int getAge() {
		return this.Age;
	}
	public void setAge(int Age) {
		this.Age = Age;
	}
	
	@OneToMany(mappedBy="player")
	public Set<PlayerPerformance> getPerformance() {
		return this.performance;
	}
	public void setPerformance(Set<PlayerPerformance> performance) {
		this.performance = performance;
	}
	
	@ManyToOne
	@JoinColumn(name="team", nullable=false)
	public Team getTeam() {
		return this.team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	public Player() {}
	public Player(String Name, int Number, int Age) {
		this.Name = Name;
		this.Number = Number;
		this.Age = Age;
	}
	
	public String toString() {
		String player = "";
		player += "Name: " + this.Name + "\n";
		player += "Age: " + this.Age + "\n";
		player += "Team: " + this.team.getName() + "\n";
		player += "Number: " + this.Number + "\n";
		return player;
	}
}
