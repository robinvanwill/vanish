package me.robinnoob220.playervanish;

import lombok.Getter;
import me.robinnoob220.playervanish.vanishModule.VanishModule;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class PlayerVanish extends JavaPlugin {

    public static @Getter PlayerVanish instance;
    public final @Getter Logger logger = this.getLogger();
    public static @Getter VanishModule vanishModule;
    private long loadMS;

    @Override
    public void onEnable() {
        System.out.println("Debug 1");
        instance = this;
        loadMS = System.currentTimeMillis();

        logger.info(ChatColor.BLUE + "[PlayerVanish] Gestard met get laden van playerVanish V"+ this.getDescription().getVersion());
        //methode aan maken
        vanishModule = new VanishModule();
        logger.info(ChatColor.BLUE + "[PlayerVanish] Plugin succesvol geladen. Dit prosess duurde " + (System.currentTimeMillis() - loadMS) + " ms!");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
