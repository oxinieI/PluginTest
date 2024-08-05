package be.arsuup.plugintest;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private PortalCommand portalCommand;

    @Override
    public void onEnable() {
        portalCommand = new PortalCommand();
        getServer().getPluginManager().registerEvents(new Portal(portalCommand), this);
        this.getCommand("portal").setExecutor(portalCommand);
    }

    @Override
    public void onDisable() {
        //
    }
}