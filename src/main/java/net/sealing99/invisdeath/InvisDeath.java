package net.sealing99.invisdeath;

import net.sealing99.invisdeath.listener.DeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class InvisDeath extends JavaPlugin {
    public static final String HUMAN_READABLE_PLUGIN_ID = "Invisible Death Messages";

    @Override
    public void onEnable() {
        getLogger().info("Enabling death listener for " + HUMAN_READABLE_PLUGIN_ID);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
    }

    @Override
    public void onDisable() {

    }
}
