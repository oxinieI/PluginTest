package be.arsuup.plugintest;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PortalCommand implements CommandExecutor {

    private Location teleportLocation;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 4 && args[0].equalsIgnoreCase("destination")) {
                try {
                    double x = Double.parseDouble(args[1]);
                    double y = Double.parseDouble(args[2]);
                    double z = Double.parseDouble(args[3]);

                    // Stockage des coordonnées
                    teleportLocation = new Location(player.getWorld(), x, y, z);
                    player.sendMessage("Coordonnées de téléportation définies : " + teleportLocation.toString());
                } catch (NumberFormatException e) {
                    player.sendMessage("Les coordonnées doivent être des nombres.");
                    return false;
                }
            } else {
                player.sendMessage("Usage: /portal destination <x> <y> <z>");
                return false;
            }
        } else {
            sender.sendMessage("Cette commande ne peut être utilisée que par un joueur.");
            return false;
        }

        return true;
    }

    public Location getTeleportLocation() {
        return teleportLocation;
    }
}
