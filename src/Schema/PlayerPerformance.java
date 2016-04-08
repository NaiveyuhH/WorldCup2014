package Schema;

import java.io.Serializable;
import java.lang.String;
import java.sql.Date;
import javax.persistence.*;

@Entity
@Access(AccessType.PROPERTY)
public class PlayerPerformance implements Serializable {

	private Date Date;
	private int Time;
	private String Round;
	private int Goals;
	private Player player;
	private long Id;
	private static final long serialVersionUID = 4710662250279616175L;
    
	@Id @GeneratedValue
	public long getId() {
		return this.Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
	
	@Basic(optional=false)
	public Date getDate() {
		return this.Date;
	}
	public void setDate(Date Date) {
		this.Date = Date;
	}
	
	@Basic(optional=false)
	public int getTime() {
		return this.Time;
	}
	public void setTime(int Time) {
		this.Time = Time;
	}
	
	@Basic(optional=false)
	public String getRound() {
		return this.Round;
	}
	public void setRound(String Round) {
		this.Round = Round;
	}
	
	@Basic(optional=false)
	public int getGoals() {
		return this.Goals;
	}
	public void setGoals(int Goals) {
		this.Goals = Goals;
	}
	
	@ManyToOne
	@JoinColumn(name="player", nullable=false)
	public Player getPlayer() {
		return this.player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public PlayerPerformance() {} 
	public PlayerPerformance(Date Date, int Time, String Round, int Goals) {
		this.Date = Date;
		this.Time = Time;
		this.Round = Round;
		this.Goals = Goals;
	}
	
	public String toString() {
		String performance = "";
		performance += "Date: " + this.Date.toString() + "\n";
		performance += "Round: " + this.Round + "\n";
		performance += "Goals: " + this.Goals + "\n";
		performance += "Playing time: " + this.Time + "min" + "\n";
		return performance;
	}
}