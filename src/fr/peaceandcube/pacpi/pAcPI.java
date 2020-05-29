package fr.peaceandcube.pacpi;

import org.bukkit.plugin.java.JavaPlugin;

import fr.peaceandcube.pacpi.command.RemoveAllTagsCommand;

public class pAcPI extends JavaPlugin {
	
	@Override
	public void onEnable() {
		this.getCommand("removealltags").setExecutor(new RemoveAllTagsCommand());
	}
}
