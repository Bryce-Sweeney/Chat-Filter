package me.CodeConduit.ChatFilter.listeners;

import me.CodeConduit.ChatFilter.Main;
import me.CodeConduit.ChatFilter.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CapsDetector implements Listener {
    //Standard constructor for listeners
    private Main plugin;

    public CapsDetector (Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    //Variables
    private double capsPercentageThreshold = 0.7;

    //Event for this class
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        //Restating event variables
        Player player = e.getPlayer();
        String message = e.getMessage();
        //New event variables
        char[] brokenMessage = message.toCharArray();
        double totalCharacters = brokenMessage.length;
        double capsCharacters = 0;
        double percentageUppercase;
        //Calculates percentage of caps
        for (char Letter : brokenMessage) {
            if (Character.isUpperCase(Letter)) {
                capsCharacters++;
            }
        }
        percentageUppercase = (capsCharacters/totalCharacters);
        if (percentageUppercase >= capsPercentageThreshold) {
            e.setMessage(message.toLowerCase());
            player.sendMessage(Utils.chat("&cPlease don't use so many caps!"));
        }
    }
}
