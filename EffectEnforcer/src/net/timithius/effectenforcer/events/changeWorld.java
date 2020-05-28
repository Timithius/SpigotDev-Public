package net.timithius.effectenforcer.events;

import net.timithius.effectenforcer.operator;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;

import java.util.List;

public class changeWorld implements Listener {
    private Plugin plugin = operator.getPlugin(operator.class);

    @EventHandler
    public void onPlayerChangeWorld(PlayerChangedWorldEvent playerCWE) {
        Player player = playerCWE.getPlayer();
        FileConfiguration config = plugin.getConfig();
        List<String> resetWorlds = config.getStringList("Reset-Worlds");

        if(playerCWE.getPlayer().getWorld().getName().equalsIgnoreCase(String.valueOf(resetWorlds))) {
            for (PotionEffect effect : player.getActivePotionEffects())
                player.removePotionEffect(effect.getType());
        }
    }
}
