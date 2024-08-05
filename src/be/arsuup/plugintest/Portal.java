package be.arsuup.plugintest;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Portal implements Listener {

    private final PortalCommand portalCommand;

    public Portal(PortalCommand portalCommand) {
        this.portalCommand = portalCommand;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Location loc = event.getPlayer().getLocation();
        if (loc.getBlock().getType() == Material.NETHER_PORTAL) {
            Location teleportLocation = portalCommand.getTeleportLocation();
            if (teleportLocation != null) {
                event.getPlayer().teleport(teleportLocation);
                event.getPlayer().sendMessage("Vous avez été téléporté !");
            } else {
                event.getPlayer().sendMessage("Les coordonnées de téléportation ne sont pas définies.");
            }
        }
    }
}