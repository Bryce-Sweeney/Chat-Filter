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

import me.CodeConduit.ChatFilter.listeners.CapsDetector;
import me.CodeConduit.ChatFilter.listeners.CussDetector;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    //Activates on startup
    public void onEnable() {
        enableListeners();
    }

    //Enables all classes in the listener package
    public void enableListeners () {
        new CussDetector(this);
        new CapsDetector(this);
    }
}
