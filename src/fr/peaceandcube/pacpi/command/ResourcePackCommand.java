package fr.peaceandcube.pacpi.command;

import fr.peaceandcube.pacpi.player.PlayerMessages;
import fr.peaceandcube.pacpi.player.PlayerSuggestionProviders;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ResourcePackCommand implements CommandExecutor, TabExecutor {
    public static final Plugin PLUGIN = Bukkit.getPluginManager().getPlugin("pAcPI");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("pacpi.resourcepack")) {
            switch (args[0]) {
                case "send":
                    if (args.length == 3) {
                        Player player = Bukkit.getPlayer(args[1]);
                        String url = args[2];

                        try {
                            new URL(url);
                        } catch (MalformedURLException e) {
                            sender.sendMessage(PlayerMessages.PACK_URL_INVALID);
                            return true;
                        }

                        if (!Bukkit.getOnlinePlayers().contains(player)) {
                            sender.sendMessage(PlayerMessages.PLAYER_NOT_FOUND);
                            return true;
                        }

                        player.sendMessage(PlayerMessages.PACK_SENT);
                        Bukkit.getScheduler().runTaskLaterAsynchronously(PLUGIN, new Runnable() {
                            @Override
                            public void run() {
                                player.setResourcePack(url);
                            }
                        }, 2 * 20);

                        return true;
                    }
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> options = new ArrayList<>();

        if (sender.hasPermission("pacpi.resourcepack")) {
            switch (args.length) {
                case 1:
                    options.add("send");
                    break;
                case 2:
                    return PlayerSuggestionProviders.getOnlinePlayers(args[1]);
            }
        }

        return options;
    }
}
