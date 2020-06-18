package fr.peaceandcube.pacpi.date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.bukkit.entity.Player;

public class Chrono {
	public static final Map<Player, Chrono> PLAYER_CHRONOS = new HashMap<Player, Chrono>();
	private long startTime;
	private long endTime;
	
	public Chrono(Player player) {
		PLAYER_CHRONOS.put(player, this);
	}
	
	public void start() {
		this.startTime = System.currentTimeMillis();
	}
	
	public void end() {
		this.endTime = System.currentTimeMillis();
	}
	
	public void remove(Player player) {
		PLAYER_CHRONOS.remove(player);
	}
	
	public String getTime() {
		long time = this.endTime - this.startTime;
		Date date = new Date(time);
		SimpleDateFormat format = new SimpleDateFormat("HH'h' mm'm' ss,SSS's'");
		format.setTimeZone(TimeZone.getTimeZone("Greenwich"));
		return format.format(date);
	}
}
