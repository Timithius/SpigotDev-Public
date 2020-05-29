package net.timithius.effectenforcer;

import net.timithius.effectenforcer.commands.reload;
import net.timithius.effectenforcer.events.changeWorld;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class operator extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new changeWorld(), this);

        this.getCommand("efen").setExecutor(new reload());

        try {
            FileConfiguration config = getConfig();
            File file_config = new File(getDataFolder(), "config.yml");
            File file_perms = new File(getDataFolder(), "permissions.txt");
            file_config.mkdir();
            file_perms.mkdir();
            config.options().copyDefaults(true);
            saveConfig();
        } catch (Exception configError) {
            configError.printStackTrace();
        }
    }

    @Override
    public void onDisable() {

    }
}
