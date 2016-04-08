package UserInterface;

import java.util.*;
import javax.persistence.*;
import Schema.*;
import UseCases.*;
import Initialization.*;

public class Execute {
	public static void main(String[] args) {

		java.util.Map<Object,Object> map = new java.util.HashMap<Object,Object>();
		map.put("openjpa.ConnectionUserName", "root");
		map.put("openjpa.ConnectionPassword", "");
		map.put("openjpa.ConnectionURL", "jdbc:mysql://127.0.0.1/FIFA2014");
		map.put("openjpa.ConnectionDriverName", "com.mysql.jdbc.Driver");
		map.put("openjpa.jdbc.SynchronizeMappings", "buildSchema");
		
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("FIFA2014", map);
	    
	    Scanner in=new Scanner(System.in);
	    
	    tools.print("*****Welcome to FIFA2014 Database*****" + "\n");
	    tools.print("WE ~~~ ARE ~~~ THE ~~~ CHAMPIONS ~~~ MY FRIENDS ~~~" +"\n");
	    tools.print("Enter 1 to see commands");
	    
	    User curuser = new User();
	    
	    while (true) {
	    	tools.print("\n" + "Enter command:");
	    	String input = in.nextLine();
	    	if(input.equals("1")) ShowCommands();
	    	else if(input.equals("quit")) return;
	    	else if(input.equals("match")){
	    		Queries.GetEventInfo(factory, in);
	    		tools.print("Enter match Id:");
	    		String next = in.nextLine();
	    		if(input.equals("back")) continue;
	    		else {
	    			int id = 0;
	    			try {
	    				id = Integer.parseInt(next);
	    			} 
	    			catch (NumberFormatException e) {
	    			    tools.print("Please input a INTEGER!");
	    			    next = in.nextLine();
	    			    if(input.equals("back")) continue;
	    			    id = Integer.parseInt(next);
	    			}
	    			Queries.QueryEvent(factory, id);
	    			tools.print("Can't wait to comment?");
	    			tools.print("1: Yes");
	    			tools.print("2: No");
	    			next = in.nextLine();
	    			if(next.equals("1")) {
	    				
	    			}
	    			else continue;
	    		}
	    	}
	    	else if(input.equals("player")) Queries.QueryPlayer(factory, in);
	    	else if(input.equals("team")) Queries.QueryTeam(factory, in);
	    	else if (input.equals("performance")) Queries.QueryPerformance(factory, in);
	    	else if(input.equals("back")) continue;
	    	else tools.print("Sorry, no such command!" + "\n");
	    }
	}
	
	public static void ShowCommands() {
		tools.print("signup: New users? Sign up and join us!!");
		tools.print("login: Login in to comment now!!");
		tools.print("logout: Logout");
		tools.print("match: See a match");
		tools.print("player: Look for player by name");
		tools.print("team: View a team by country name");
		tools.print("performance: View performance of a player by name");
		tools.print("back: Exit current command");
		tools.print("quit: See you my friend!");
	}
}