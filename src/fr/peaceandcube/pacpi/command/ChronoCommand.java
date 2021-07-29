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

import com.google.common.collect.ImmutableList;

import fr.peaceandcube.pacpi.date.Chrono;
import fr.peaceandcube.pacpi.player.PlayerSuggestionProviders;

public class ChronoCommand implements CommandExecutor, TabExecutor {
	private static final List<String> OPERATIONS = ImmutableList.of("start", "end");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("pacpi.chrono")) {
			if (args.length == 2) {
				Player player = Bukkit.getPlayer(args[1]);
				
				switch (args[0]) {
				case "start":
					Chrono chrono = new Chrono(player);
					chrono.start();
					sender.sendMessage(String.format(PlayerMessages.CHRONO_STARTED, args[1]));
					return true;
				case "end":
					Chrono c = Chrono.PLAYER_CHRONOS.get(player);
					if (c != null) {
						c.end();
						player.sendMessage(String.format(PlayerMessages.CHRONO_ENDED, c.getTime()));
						c.remove(player);
					} else {
						sender.sendMessage(String.format(PlayerMessages.CHRONO_NOT_STARTED, args[1]));
					}
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("pacpi.chrono")) {
			switch (args.length) {
			case 1:
				List<String> ops = new ArrayList<String>();
				for (String op : OPERATIONS) {
					if (op.toLowerCase().startsWith(args[0].toLowerCase())) {
						ops.add(op);
					}
				}
				return ops;
			case 2:
				return PlayerSuggestionProviders.getOnlinePlayers(args[1]);
			}
		}
		return new ArrayList<>();
	}
}
