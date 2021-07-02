package me.robinnoob220.playervanish.vanishModule;

import lombok.Getter;
import me.robinnoob220.playervanish.PlayerVanish;
import me.robinnoob220.playervanish.vanishModule.commands.VanishComands;
import me.robinnoob220.playervanish.vanishModule.listeners.PlayerJoinListener;
import me.robinnoob220.playervanish.vanishModule.listeners.PlayerLeaveListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;

import java.util.ArrayList;
import java.util.UUID;

public class VanishModule {

    public static @Getter VanishModule vanishModule;
    public final static @Getter ArrayList<UUID> vanishedPlayers = new ArrayList<>();
    public final static @Getter BossBar vanishBar = Bukkit.getServer().createBossBar(ChatColor.WHITE + "" + ChatColor.BOLD + "Vanished", BarColor.BLUE, BarStyle.SOLID);
    private PlayerVanish plugin = PlayerVanish.getInstance();

    public VanishModule(){
        vanishModule = this;

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), plugin);
        Bukkit.getPluginManager().registerEvents(new PlayerLeaveListener(), plugin);
        plugin.getCommand("vanish").setExecutor(new VanishComands());
        plugin.getLogger().info(ChatColor.LIGHT_PURPLE + "Vanish module opgestard");

    }
}
