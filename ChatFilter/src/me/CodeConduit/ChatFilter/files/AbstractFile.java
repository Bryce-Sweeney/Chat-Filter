package me.CodeConduit.ChatFilter.files;

import me.CodeConduit.ChatFilter.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class AbstractFile {
    //Variables
    private static File file;
    protected static FileConfiguration config;
    protected Main plugin;

    //Advanced constructor
    public AbstractFile (Main plugin, String filename) {
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), filename);
        //If file does not exist
        if (!file.exists()) {
            try {
                //Try to make one
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    //Save method
    public static void save() {
        try {
            config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
