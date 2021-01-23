package fr.peaceandcube.pacpi.event;

import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerEventHandler implements Listener {

    @EventHandler
    public void onItemFramePlace(HangingPlaceEvent event) {
        if (event.getPlayer() != null && event.getEntity() instanceof ItemFrame) {
            ItemStack handItem = event.getPlayer().getInventory().getItemInMainHand();
            ItemFrame itemFrame = (ItemFrame) event.getEntity();

            if (handItem.getType() == Material.ITEM_FRAME && handItem.getItemMeta().getDisplayName().equalsIgnoreCase("invisible")) {
                itemFrame.setVisible(false);
            }
        }
    }
}
