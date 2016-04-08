package Schema;

import java.io.Serializable;
import java.lang.String;
import java.util.HashSet;
import java.util.Set;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

import Schema.Schedule.Type;

@Entity
@Access(AccessType.PROPERTY)
public class Event implements Serializable {

	private String Score;
	private String Location;
	private String Umpire;
	private String Round;
	private Date Date;
	private Time Time;
	private Set<Schedule> schedules = new HashSet<Schedule>();
	private Set<Comment> comments = new HashSet<Comment>();
	
	private long Id;
	private static final long serialVersionUID = -7706899318928004076L;
	
	@Id @GeneratedValue
	public long getId() {
		return this.Id;
	}
	public void setId(long Id) {
		this.Id = Id;
	}
	
	@Basic(optional=false)
	public String getScore() {
		return this.Score;
	}
	public void setScore(String Score) {
		this.Score = Score;
	}
	
	@Basic(optional=false)
	public String getLocation() {
		return this.Location;
	}
	public void setLocation(String Location) {
		this.Location = Location;
	}
	
	@Basic(optional=false)
	public String getUmpire() {
		return this.Umpire;
	}
	public void setUmpire(String Umpire) {
		this.Umpire = Umpire;
	}
	
	@Basic(optional=false)
	public String getRound() {
		return this.Round;
	}
	public void setRound(String Round) {
		this.Round = Round;
	}
	
	@Basic(optional=false)
	public Date getDate() {
		return this.Date;
	}
	public void setDate(Date Date) {
		this.Date = Date;
	}
	
	@Basic(optional=false)
	public Time getTime() {
		return this.Time;
	}
	public void setTime(Time Time) {
		this.Time = Time;
	}
	
	@OneToMany(mappedBy="plays")
	public Set<Schedule> getSchedules() {
		return this.schedules;
	}
	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}
	
	@OneToMany(mappedBy="queries")
	public Set<Comment> getComments() {
		return this.comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	public Event() {}
	public Event(String Score, String Location, String Umpire, String Round, Date Date, Time Time) {
		this.Score = Score;
		this.Location = Location;
		this.Umpire = Umpire;
		this.Round = Round;
		this.Date = Date;
		this.Time = Time;
	}
	
	public String toString() {
		String event = "";
		String home = "";
		String away = "";
		for(Schedule schedule: schedules) {
			if(schedule.getType()==Type.Home) {
				home = schedule.getIsPlayedBy().getName();
			}
			else {
				away = schedule.getIsPlayedBy().getName();
			}
		}
		event += "Home: " + home + "\n";
		event += "Away: " + away + "\n";
		event += "Score: " + this.Score + "\n";
		event += "Location: " + this.Location + "\n";
		event += "Umpire: " + this.Umpire + "\n";
		event += "Round: " + this.Round + "\n";
		event += "Score: " + this.Score + "\n";
		event += "Date: " + this.Date.toString() + "\n";
		event += "Time: " + this.Time.toString() + "\n";
		return event;
	}
	
	public String getInfo() {
		String info = "";
		info += "Match Id:" + this.Id + "	";
		String home = "";
		String away = "";
		for(Schedule schedule: schedules) {
			if(schedule.getType()==Type.Home) {
				home = schedule.getIsPlayedBy().getName();
			}
			else {
				away = schedule.getIsPlayedBy().getName();
			}
		}
		info += "Home: " + home + "    ";
		info += "Away: " + away + "\n";
		return info;
	}
}