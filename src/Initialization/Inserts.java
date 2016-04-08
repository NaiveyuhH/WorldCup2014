package Initialization;

import Schema.*;
import Schema.Schedule.Type;
import java.util.*;

/* Date, Time input format for all:
 * Date: "yyyy-mm-dd"
 * Time: "hh:mm" (24-hour system)
 */
public interface Inserts {
	public static Team InsertTeam(List<Object> InsertList,
			String Name, String Coach, int Points, int WonGames, int DrawnGames, int LostGames, int Rank) {
		Team team = new Team(Name, Coach, Points, WonGames, DrawnGames, LostGames, Rank);
		InsertList.add(team);
		return team;		
	}
	
	public static Player InsertPlayer (List<Object> InsertList, String Name, int Number, int Age) {
		Player player = new Player(Name, Number, Age);
		InsertList.add(player);
		return player;
	}
	
	public static PlayerPerformance InsertPlayerPerformance (List<Object> InsertList,
			String Date, int Time, String Round, int Goals) {
		java.sql.Date date = java.sql.Date.valueOf(Date);
		PlayerPerformance playerperformance = new PlayerPerformance(date, Time, Round, Goals);
		InsertList.add(playerperformance);
		return playerperformance;
	}
	
	public static Schedule InsertSchedule (List<Object> InsertList, String Type) {
		Type type;
		if (Type == "Home") type = Schedule.Type.Home;
		else type = Schedule.Type.Away;
		Schedule schedule = new Schedule(type);
		InsertList.add(schedule);
		return schedule;
	}
	
	public static Event InsertEvent (List<Object> InsertList,
			String Score, String Location, String Umpire, String Round, String Date, String Time) {
		java.sql.Date date = java.sql.Date.valueOf(Date);
		Time += ":00";
		java.sql.Time time = java.sql.Time.valueOf(Time); 
		Event event = new Event(Score, Location, Umpire, Round, date, time);
		InsertList.add(event);
		return event;
	}
	
	public static Admin InsertAdmin (List<Object> InsertList, String name, String password) {
		Admin admin = new Admin(name, password);
		InsertList.add(admin);
		return admin;
	}
	
	public static SecAdmin InsertSecAdmin (List<Object> InsertList, String name, String password) {
		SecAdmin secadmin = new SecAdmin(name, password);
		InsertList.add(secadmin);
		return secadmin;
	}
	
	public static GeneralUser InsertUser (List<Object> InsertList, String name, String password) {
		GeneralUser user = new GeneralUser(name, password);
		InsertList.add(user);
		return user;
	}
	
	public static Comment AddCommnet (String title, String content, User user, Event event) {
		Comment comment = new Comment(title, content);
		event.getComments().add(comment);
		comment.setQueries(event);
		user.getComments().add(comment);
		comment.setIsQueriedBy(user);
		return comment;
	}
}