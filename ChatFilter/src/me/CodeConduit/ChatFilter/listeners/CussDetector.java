package me.CodeConduit.ChatFilter.listeners;

import me.CodeConduit.ChatFilter.Main;
import me.CodeConduit.ChatFilter.Utils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import java.util.Date;
import java.util.Set;


public class CussDetector implements Listener {

    //Standard constructor for listeners
    private Main plugin;

    public CussDetector (Main plugin) {
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    //Variables
    String[] slurs = {"nigger", "n1gger", "nigga", "n1gga", "nibba", "n1bba", "nig", "n1g"};
    String[] mildSlurs = {"retard", "r3tard"};

    //Event for this class
    @EventHandler
    public void onChat(PlayerChatEvent e) {
        Player player = e.getPlayer();
        String message = e.getMessage().toLowerCase();
        //Compare message with list of slurs
        for ( String slur : slurs ) {
            if (message.contains(slur) || message.equals(slur)) {
                //Execute major punishment
                Date dateMajor = new Date(System.currentTimeMillis()+7*24*60*60*1000);
                Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), Utils.chat("&cYou were banned for saying " + slur + "&c!&e"), dateMajor, "ChatFilter");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick " + player.getName() + " " + Utils.chat("&cYou were banned for saying " + slur + "&c!&e"));
                e.setCancelled(true);
                break;
            }
        }
        //Compare message with list of mild slurs
        for ( String slur : mildSlurs) {
            if (message.contains(slur) || message.equals(slur)) {
                //Execute minor punishment
                Date dateMajor = new Date(System.currentTimeMillis()+2*24*60*60*1000);
                Bukkit.getBanList(BanList.Type.NAME).addBan(player.getName(), Utils.chat("&cYou were banned for saying " + slur + "&c!&e"), dateMajor, "ChatFilter");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "kick " + player.getName() + " " + Utils.chat("&cYou were banned for saying " + slur + "&c!&e"));
                e.setCancelled(true);
                break;
            }
        }
    }
}