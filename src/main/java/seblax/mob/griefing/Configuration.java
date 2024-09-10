package org.example.enderman_griefing;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityCategory;
import org.bukkit.entity.Monster;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class Configuration {
    private Plugin plugin;
    private static File file;
    private static YamlConfiguration modifyFile;

    public Configuration(Plugin plugin){
        try {
            this.plugin = plugin;
            initiateFile("config.yml");

        }catch (Exception e){
            System.out.println("Error a la hora de crear el archivo");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    void initiateFile(String name) throws Exception{
        file = new File( plugin.getDataFolder() + File.separator + "enderman griefing",name);

        if(!file.exists()){
            file.mkdir();
        }

        modifyFile = YamlConfiguration.loadConfiguration(file);

        DefaultConfiguration();
    }

    public static void DefaultConfiguration(){
        try{
            for (var i : EntityCategory.values()){
                modifyFile.set(i.name(),true);
            }
        }catch (Exception e){
            System.out.println(ChatColor.RED + "Error trying to set the default configuration.");
            e.printStackTrace();
        }
    }

    public static void SetMobConfig(Entity mob, boolean b){
        try{
            modifyFile.set(mob.getName(), b);
        }catch (Exception e){
            System.out.println(ChatColor.RED + "Error changing " + mob.getName() + " to current value " + b);
        }
    }

    public static void SetMobGriefingOff(Entity mob){
        SetMobConfig(mob,false);
    }

    public static void SetMobGriefingOn(Entity mob){
        SetMobConfig(mob, true);
    }

    public static Boolean getMobConfig(Entity mob){
        Boolean res = null;

        try {
            res = modifyFile.getBoolean(mob.getName());
        }catch (Exception e){
            System.out.println(ChatColor.RED + "Error trying get " + mob.getName() + " configuration.");
            e.printStackTrace();
        }
        return res;
    }
}