package fr.peaceandcube.pacpi.player;

import org.bukkit.ChatColor;

public class PlayerMessages {

    // generic
    public static final String PLAYER_NOT_FOUND = error("Le joueur n'a pas été trouvé.");

    // removealltags command
    public static final String REMOVE_ALL_TAGS = "Tous les tags ont été supprimés.";
    public static final String REMOVE_ALL_TAGS_EXCEPT = "Tous les tags sauf %s ont été supprimés.";

    // chrono command
    public static final String CHRONO_STARTED = "Un chrono a été démarré pour %s.";
    public static final String CHRONO_ENDED = info("Tu as fait un temps de %s !");
    public static final String CHRONO_NOT_STARTED = error("%s n'a pas de chrono démarré.");

    public static String error(String msg) {
        return ChatColor.RED + msg;
    }

    public static String info(String msg) {
        return ChatColor.YELLOW + msg;
    }
}
