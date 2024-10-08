package net.civicraft.knockOnDoors;

import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

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
                    Set<String> woodenDoors = Set.of("OAK_DOOR", "BIRCH_DOOR", "SPRUCE_DOOR", "JUNGLE_DOOR", "ACACIA_DOOR", "DARK_OAK_DOOR", "WARPED_DOOR", "CRIMSON_DOOR", "MANGROVE_DOOR", "CHERRY_DOOR", "BAMBOO_DOOR");
                    Set<String> metallicDoors = Set.of("IRON_DOOR", "COPPER_DOOR", "OXIDIZED_COPPER_DOOR", "EXPOSED_COPPER_DOOR", "WEATHERED_COPPER_DOOR", "WAXED_COPPER_DOOR", "WAXED_EXPOSED_COPPER_DOOR", "WAXED_WEATHERED_COPPER_DOOR", "WAXED_OXIDIZED_COPPER_DOOR");
                    if (woodenDoors.contains(type.toUpperCase())) {
                        p.playSound(p.getLocation(), Sound.ENTITY_ARMOR_STAND_PLACE, 1.0f, 1.0f);
                    } else if (metallicDoors.contains(type.toUpperCase())) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NETHERITE_BLOCK_PLACE, 1.0f, 1.0f);
                    }
                }
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("No more knocking on doors.");
    }
}
