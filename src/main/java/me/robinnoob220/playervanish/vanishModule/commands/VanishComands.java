package me.robinnoob220.playervanish.vanishModule.commands;

import me.robinnoob220.playervanish.PlayerVanish;
import me.robinnoob220.playervanish.vanishModule.VanishModule;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class VanishComands implements CommandExecutor {

    private VanishModule vanishModule = VanishModule.getVanishModule();
    private PlayerVanish plugin = PlayerVanish.getInstance();

    @Override
    public boolean onCommand( CommandSender sender, Command command,  String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            UUID playerUUID = player.getUniqueId();
            if(player.hasPermission("playervanish.command.use")){
                if(vanishModule.getVanishedPlayers().contains(playerUUID)){
                    for(Player onlinePlayers: Bukkit.getOnlinePlayers()){
                        onlinePlayers.showPlayer(plugin, player);
                    }
                    player.sendMessage(ChatColor.WHITE + "Je bent weer zichtbaar geworden!");
                    vanishModule.getVanishedPlayers().remove(playerUUID);
                    vanishModule.getVanishBar().removePlayer(player);
                }
                else{
                    for(Player onlinePlayers: Bukkit.getOnlinePlayers()){
                        if(!onlinePlayers.hasPermission("playervanish.other.see")){
                            onlinePlayers.hidePlayer(plugin, player);
                        }
                    }
                    player.sendMessage(ChatColor.WHITE + "Je bent onzichtbaar geworden!");
                    vanishModule.getVanishedPlayers().add(playerUUID);
                    vanishModule.getVanishBar().addPlayer(player);
                }
            }
            else{
                player.sendMessage(ChatColor.RED + "Je hebt geen permission om deze command te gebruiken!");
            }
        }
        return true;
    }
}
