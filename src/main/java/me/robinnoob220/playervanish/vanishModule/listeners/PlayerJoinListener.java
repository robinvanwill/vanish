package me.robinnoob220.playervanish.vanishModule.listeners;

import me.robinnoob220.playervanish.PlayerVanish;
import me.robinnoob220.playervanish.vanishModule.VanishModule;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoinListener implements Listener {

    private VanishModule vanishModule = VanishModule.getVanishModule();
    private PlayerVanish plugin = PlayerVanish.getInstance();

    /**
     * A eventlistener for the join action of a player, here we do the following
     * make the currently vanished players invisable for the joined player.
     * @param event the current event
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        for (UUID vanished : vanishModule.getVanishedPlayers())
        {
            player.hidePlayer(plugin, Bukkit.getPlayer(vanished));
        }
    }
}
