package UseCases;

import java.util.*;
import javax.persistence.*;
import Schema.*;

public interface Queries extends tools{
	
	public static void QueryPlayer (EntityManagerFactory factory, Scanner in) {
		
		tools.print("Enter Player Name:");
		String name = in.nextLine();
		if(name.equals("back")) return;
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		String qry = "select p from Player p where p.name = " + "'" + name + "'";
		Query q = em.createQuery(qry);
		List rs = q.getResultList();
		
		String result = null;
		if(rs.isEmpty()) result = "Sorry, player does not exist!" + "\n";
		
		Player player = (Player) rs.get(0);
		result = player.toString();
		
		try {
			tx.commit();
		}
		catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
			tools.print(result);
		}
	}
	
	public static void QueryPerformance (EntityManagerFactory factory, Scanner in) {
		
		tools.print("Enter Player Name:");
		String name = in.nextLine();
		if(name.equals("back")) return;
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		String qry = "select p from PlayerPerformance p where p.player.name = " + "'" + name + "'";
		Query q = em.createQuery(qry);
		List rs = q.getResultList();
		
		String result = "";
		if(rs.isEmpty()) {
			result = "Sorry, there is no performance data for this player!" + "\n";
		}
		
		for(Object obj: rs) {
			PlayerPerformance performance = (PlayerPerformance) obj;
			result += performance.toString() + "\n";
		}
		
		try {
			tx.commit();
		}
		catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
			tools.print(result);
		}
	}
	
	public static void GetEventInfo (EntityManagerFactory factory, Scanner in) {
		
		tools.print("Enter Round:");
		tools.print("1: Round of 16");
		tools.print("2: Quarter-finals");
		tools.print("3: Semi-finals");
		tools.print("4: Final");
		String round = in.nextLine();
		if(round.equals("1")) round = "Round of 16";
		else if(round.equals("2")) round = "Quarter-finals";
		else if(round.equals("3")) round = "Semi-finals";
		else if(round.equals("4")) round = "Final";
		else return;
		
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		String qry = "select e from Event e where e.round = " + "'" + round + "'";
		Query q = em.createQuery(qry);
		List rs = q.getResultList();
		
		String result = "";
		if(rs.isEmpty()) result = "Sorry, no such match!" + "\n";
		
		for(Object obj: rs) {
			Event event = (Event) obj;
			result += event.getInfo() + "\n";
		}
		
		try {
			tx.commit();
		}
		catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
			tools.print(result);
		}
	}
	
	public static void QueryEvent (EntityManagerFactory factory, int id) {
	
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		String qry = "select e from Event e where e.id = " + "'" + id + "'";
		Query q = em.createQuery(qry);
		List rs = q.getResultList();
		
		String result = "";
		if(rs.isEmpty()) result = "Sorry, no such match!" + "\n";
		
		Event event = (Event) rs.get(0);
		result += event.toString() + "\n";
		
		try {
			tx.commit();
		}
		catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
			tools.print(result);
		}
	}

	public static void QueryTeam (EntityManagerFactory factory, Scanner in) {
	
		tools.print("Enter Country Name:");
		String name = in.nextLine();
	
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
	
		String qry = "select t from Team t where t.name = " + "'" + name + "'";
		Query q = em.createQuery(qry);
		List rs = q.getResultList();
	
		String result = "";
		if(rs.isEmpty()) result = "Sorry, team does not exist!" + "\n";
		
		Team team = (Team) rs.get(0);
		result = team.toString();
	
		try {
			tx.commit();
		}
		catch (RollbackException e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
			tools.print(result);
		}
	}
}