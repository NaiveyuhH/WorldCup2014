package UserInterface;

import java.util.*;
import UseCases.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test implements tools{

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
	    
	    while (true) {
	    	String input = in.nextLine();
	    	if(input=="1") {
	    		ShowCommands();
	    	}
	    	else if(input=="quit") return;
	    	else if(input=="event"){
	    		Queries.QueryEvent(factory, id);;
	    	}
	    	
	    	else tools.print("Sorry, no such command!");
	    }
	}
	
	public static void ShowCommands() {
		tools.print("signup: New users? Sign up to comment now!!");
		tools.print("event: See events");
		tools.print("player: Look for player by name");
		tools.print("performance: View performance of a player by name");
		tools.print("quit: See you my friend!");
	}
}