/*
        __________________________________________________________
       / /                                                   / /\ \
       \_\___________________________________________________\_\/ /
       / /    _____    __            __                    / /
      / /    / ____\  / /           /_/          /\       / /
     / /    / /__    / /___  ___   __  ______ __/ /_     / /
    / /     \___ \  /   __/ / __\ / / / __  //_  __/    / /
   / /     ____/ / / /\ \  / /   / / / /_/ /  / /      / /
  / /     \_____/ /_/ /_/ /_/   /_/ / ____/  /_/      / /__
 / /    ========================== / / ==========    / / \ \
| |                               /_/               | |   | |
 \_\_________________________________________________\_\_/_/
*/

package me.CodeConduit.ChatFilter;

import me.CodeConduit.ChatFilter.files.PlayerData;
import me.CodeConduit.ChatFilter.listeners.CapsDetector;
import me.CodeConduit.ChatFilter.listeners.CussDetector;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    //Activates on startup
    public void onEnable() {
        enableListeners();
        if (!getDataFolder().exists())
            getDataFolder().mkdirs();
        new PlayerData(this);
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    //Activates on shutdown
    public void onDisable() {
        PlayerData.save();
    }

    //Enables all classes in the listener package
    public void enableListeners () {
        new CussDetector(this);
        new CapsDetector(this);
    }
}
