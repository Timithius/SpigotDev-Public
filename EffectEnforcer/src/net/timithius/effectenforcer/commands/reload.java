package net.timithius.effectenforcer.commands;

import net.timithius.effectenforcer.operator;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class reload implements CommandExecutor {
    private Plugin plugin = operator.getPlugin(operator.class);

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender.hasPermission("effectenforcer.reload")) {
            if (cmd.getName().equalsIgnoreCase("efen")) {
                if (args.length == 0) {
                    sender.sendMessage(ChatColor.AQUA + "[EE] " + ChatColor.GOLD + "EffectEnforcer is installed. Type '/efen reload' to reload the configuration file.");
                }

                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("reload")) {
                        plugin.reloadConfig();

                        sender.sendMessage(ChatColor.AQUA + "[EE] " + ChatColor.GOLD + "Reloaded config successfully! Changes will take effect immediately.");
                    } else {
                        sender.sendMessage(ChatColor.AQUA + "[EE] " + ChatColor.GOLD + "EffectEnforcer only has one command and argument: '/efen reload'.");
                    }
                }
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You do not have permission to preform this command.");
        }

        return false;
    }
}