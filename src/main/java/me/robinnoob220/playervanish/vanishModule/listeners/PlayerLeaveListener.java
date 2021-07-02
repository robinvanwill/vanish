package me.robinnoob220.playervanish.vanishModule.listeners;

import me.robinnoob220.playervanish.vanishModule.VanishModule;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class PlayerLeaveListener implements Listener {
    /**
     * Event listener for the quit action of a player, here we check the following
     * if a player is currently vanished.
     * @param event the current event
     */

    @EventHandler
    public void PlayerLeaveEvent (PlayerQuitEvent event)
    {
        UUID playeruuid = event.getPlayer().getUniqueId();
        Player player = event.getPlayer();
        if (VanishModule.getVanishedPlayers().contains(playeruuid))
        {
            VanishModule.getVanishedPlayers().remove(playeruuid);
            VanishModule.getVanishBar().removePlayer(player);
        }
    }
}
