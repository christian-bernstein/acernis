package de.christianbernstein.acernis.spigot.v1_8_8;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Christian Bernstein
 */
@SuppressWarnings("unused")
public class AcernisPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        Bukkit.getPluginCommand("acernis").setExecutor(new DebugCommand());
    }
}
