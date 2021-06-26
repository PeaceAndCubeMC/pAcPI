package fr.peaceandcube.pacpi.event;

import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class PlayerEventHandler implements Listener {
    private static final List<Material> ITEM_FRAMES = List.of(Material.ITEM_FRAME, Material.GLOW_ITEM_FRAME);

    @EventHandler
    public void onItemFramePlace(HangingPlaceEvent event) {
        if (event.getPlayer() != null && event.getEntity() instanceof ItemFrame) {
            ItemStack handItem = event.getPlayer().getInventory().getItemInMainHand();
            ItemFrame itemFrame = (ItemFrame) event.getEntity();

            if (ITEM_FRAMES.contains(handItem.getType()) && handItem.getItemMeta().getDisplayName().equalsIgnoreCase("invisible")) {
                itemFrame.setVisible(false);
            }
        }
    }
}
