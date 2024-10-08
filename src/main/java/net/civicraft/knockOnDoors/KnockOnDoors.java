package net.civicraft.knockOnDoors;

import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class KnockOnDoors extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("You can now knock on doors!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onDoorKnock(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            Player p = e.getPlayer();
                Block c = e.getClickedBlock();
                if (c != null) {
                    String type = c.getType().toString();
                    String[] doorTypes = {"OAK_DOOR", "BIRCH_DOOR", "SPRUCE_DOOR", "JUNGLE_DOOR", "ACACIA_DOOR", "DARK_OAK_DOOR", "IRON_DOOR", "WARPED_DOOR", "CRIMSON_DOOR"};
                    for (String doorType : doorTypes) {
                        if (type.equalsIgnoreCase(doorType)) {
                            p.playSound(p.getLocation(), Sound.ENTITY_ARMOR_STAND_PLACE, 1.0f, 1.0f);
                            break;
                        } else if (type.equalsIgnoreCase("IRON_DOOR")) {
                            p.playSound(p.getLocation(), Sound.BLOCK_NETHERITE_BLOCK_PLACE, 1.0f, 1.0f);
                            break;
                        }
                    }
                }
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("No more knocking on doors.");
    }
}
