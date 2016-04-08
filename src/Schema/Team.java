package Schema;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class Team implements Serializable {

	private String Name;
	private String Coach;
	private int Points;
	private int WonGames;
	private int DrawnGames;
	private int LostGames;
	private int Rank;
	private Set<Player> players = new HashSet<Player>();
	private Set<Schedule> schedules = new HashSet<Schedule>();
	private long Id;
	private static final long serialVersionUID = 7968555776722382952L;

	@Id @GeneratedValue
	public long getId() {
		return this.Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
	
	@Basic(optional=false)
	public String getName() {
		return this.Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	
	@Basic(optional=false)
	public String getCoach() {
		return this.Coach;
	}
	public void setCoach(String Coach) {
		this.Coach = Coach;
	}
	
	@Basic(optional=false)
	public int getPoints() {
		return this.Points;
	}
	public void setPoints(int Points) {
		this.Points = Points;
	}
	
	@Basic(optional=false)
	public int getWonGames() {
		return this.WonGames;
	}
	public void setWonGames(int WonGames) {
		this.WonGames = WonGames;
	}
	
	@Basic(optional=false)
	public int getDrawnGames() {
		return this.DrawnGames;
	}
	public void setDrawnGames(int DrawnGames) {
		this.DrawnGames = DrawnGames;
	}
	
	@Basic(optional=false)
	public int getLostGames() {
		return this.LostGames;
	}
	public void setLostGames(int LostGames) {
		this.LostGames = LostGames;
	}
	
	@Basic(optional=false)
	public int getRank() {
		return this.Rank;
	}
	public void setRank(int Rank) {
		this.Rank = Rank;
	}   
	
	@OneToMany(mappedBy="team")
	public Set<Player> getPlayers() {
		return this.players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	
	@OneToMany(mappedBy="isPlayedBy")
	public Set<Schedule> getSchedules() {
		return this.schedules;
	}
	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}
	
	public Team() {}
	public Team(String Name, String Coach, int Points, int WonGames, int DrawnGames, int LostGames, int Rank) {
		this.Name = Name;
		this.Coach = Coach;
		this.Points = Points;
		this.WonGames = WonGames;
		this.DrawnGames = DrawnGames;
		this.LostGames = LostGames;
		this.Rank = Rank;
	}
	
	public String toString() {
		String team = "";
		team += "Country: " + this.Name + "\n";
		team += "Coach: " + this.Coach + "\n";
		team += "Points: " + this.Points + "\n";
		team += "WonGames: " + this.WonGames + "\n";
		team += "DrawnGames: " + this.DrawnGames + "\n";
		team += "LostGames: " + this.LostGames + "\n";
		team += "Rank: " + this.Rank + "\n";
		team += "\n" + "Players:" + "\n";
		for(Player player: this.players) {
			team += player.getName() + "\n";
		}
		return team;
	}
}
