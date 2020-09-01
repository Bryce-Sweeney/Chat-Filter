package me.CodeConduit.ChatFilter.files;

import me.CodeConduit.ChatFilter.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerData extends AbstractFile implements Listener {

    private PlayerData playerData;

    public PlayerData(Main plugin) {
        super(plugin, "playerdata.yml");
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public static void newPlayer(Player player) {
        config.set(player.getUniqueId().toString(), "test");
        save();
    }
}
