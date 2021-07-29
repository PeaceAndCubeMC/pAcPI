package fr.peaceandcube.pacpi.player;

import org.bukkit.ChatColor;

public class PlayerMessages {

    // generic
    public static final String PLAYER_NOT_FOUND = error("Le joueur n'a pas �t� trouv�.");

    // removealltags command
    public static final String REMOVE_ALL_TAGS = "Tous les tags ont �t� supprim�s.";
    public static final String REMOVE_ALL_TAGS_EXCEPT = "Tous les tags sauf %s ont �t� supprim�s.";

    // chrono command
    public static final String CHRONO_STARTED = "Un chrono a �t� d�marr� pour %s.";
    public static final String CHRONO_ENDED = info("Tu as fait un temps de %s !");
    public static final String CHRONO_NOT_STARTED = error("%s n'a pas de chrono d�marr�.");

    // resourcepack command
    public static final String PACK_URL_INVALID = error("L'adresse du pack de ressources est invalide.");
    public static final String PACK_SENT = info("Un pack de ressources va �tre t�l�charg� !");

    public static String error(String msg) {
        return ChatColor.RED + msg;
    }

    public static String info(String msg) {
        return ChatColor.YELLOW + msg;
    }
}
