package Initialization;

import Schema.*;

public interface Links {
	public static void LinkPlayerAndPerformance(Player player, PlayerPerformance performance) {
		player.getPerformance().add(performance);
		performance.setPlayer(player);
	}
	
	public static void LinkTeamAndPlayer(Team team, Player player) {
		team.getPlayers().add(player);
		player.setTeam(team);
	}
	
	public static void LinkScheduleAndTeam(Schedule schedule, Team team) {
		team.getSchedules().add(schedule);
		schedule.setIsPlayedBy(team);
	}
	
	public static void LinkScheduleAndEvent(Schedule schedule, Event event) {
		event.getSchedules().add(schedule);
		schedule.setPlays(event);
	}
}