package fr.peaceandcube.pacpi;

import fr.peaceandcube.pacpi.command.ResourcePackCommand;
import fr.peaceandcube.pacpi.event.PlayerEventHandler;
import org.bukkit.plugin.java.JavaPlugin;

import fr.peaceandcube.pacpi.command.ChronoCommand;
import fr.peaceandcube.pacpi.command.RemoveAllTagsCommand;

public class pAcPI extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("removealltags").setExecutor(new RemoveAllTagsCommand());
		this.getCommand("chrono").setExecutor(new ChronoCommand());
		this.getCommand("resourcepack").setExecutor(new ResourcePackCommand());

		this.getServer().getPluginManager().registerEvents(new PlayerEventHandler(), this);
	}
}
