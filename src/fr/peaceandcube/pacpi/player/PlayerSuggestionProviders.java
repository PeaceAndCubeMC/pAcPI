package fr.peaceandcube.pacpi.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.google.common.collect.Lists;

public class PlayerSuggestionProviders {

	/**
	 * Gets names of online players that start with a prefix.
	 * @param prefix a prefix
	 * @return a list of player names
	 */
	public static List<String> getOnlinePlayers(String prefix) {
		List<String> players = new ArrayList<String>();
		for (Player player : Bukkit.getOnlinePlayers()) {
			if (player.getName().toLowerCase().startsWith(prefix.toLowerCase())) {
				players.add(player.getName());
			}
		}
		return players;
	}
	
	/**
	 * Gets names of online players.
	 * @return a list of player names
	 */
	public static List<String> getOnlinePlayers() {
		return getOnlinePlayers("");
	}
	
	/**
	 * Gets all scoreboard tags online players have.
	 * @return a list of scoreboard tags
	 */
	public static List<String> getAllTags() {
		Set<String> tags = new HashSet<String>();
		for (Player player : Bukkit.getOnlinePlayers()) {
			tags.addAll(player.getScoreboardTags());
		}
		return Lists.newArrayList(tags);
	}
}
