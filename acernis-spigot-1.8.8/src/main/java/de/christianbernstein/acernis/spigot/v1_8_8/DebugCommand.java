package de.christianbernstein.acernis.spigot.v1_8_8;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * @author Christian Bernstein
 */
public class DebugCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length >= 1){
            final String sub = strings[0];
            commandSender.sendMessage("incoming acernis sub command: " + sub);

            switch (sub){
                case "create-test":
                    // create a test world
                    commandSender.sendMessage("Creating test world...");

                    break;
                case "load-test":
                    // load a test world
                    commandSender.sendMessage("Loading test world...");

                    break;
                case "unload-test":
                    // unload a test world
                    commandSender.sendMessage("Unloading test world...");

                    break;
                case "delete-test":
                    // delete the test world
                    commandSender.sendMessage("Deleting test world...");

                    break;
                default:
                    commandSender.sendMessage("No sub command found for: " + sub);
                    break;
            }
        }
        return false;
    }
}
