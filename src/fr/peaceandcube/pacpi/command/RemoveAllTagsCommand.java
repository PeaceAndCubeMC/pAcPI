package fr.peaceandcube.pacpi.command;

import java.util.ArrayList;
import java.util.List;

import fr.peaceandcube.pacpi.player.PlayerMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import fr.peaceandcube.pacpi.player.PlayerSuggestionProviders;

public class RemoveAllTagsCommand implements CommandExecutor, TabExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("pacpi.removealltags")) {
			if (args.length >= 1) {
				String target = args[0];
				if (Bukkit.getOnlinePlayers().contains(Bukkit.getPlayer(target))) {
					Player player = Bukkit.getPlayer(target);
					if (args.length == 2) {
						PlayerSuggestionProviders.getAllTags().forEach(tag -> {
							if (!tag.equals(args[1])) {
								player.removeScoreboardTag(tag);
							}
						});
						sender.sendMessage(String.format(PlayerMessages.REMOVE_ALL_TAGS_EXCEPT, args[1]));
					} else {
						PlayerSuggestionProviders.getAllTags().forEach(tag -> player.removeScoreboardTag(tag));
						sender.sendMessage(PlayerMessages.REMOVE_ALL_TAGS);
					}
				} else {
					sender.sendMessage(PlayerMessages.PLAYER_NOT_FOUND);
				}
				return true;
			}
		}
		return false;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("pacpi.removealltags")) {
			if (args.length == 1) {
				return PlayerSuggestionProviders.getOnlinePlayers(args[0]);
			} else if (args.length == 2) {
				return PlayerSuggestionProviders.getAllTags();
			}
		}
		return new ArrayList<>();
	}
}
