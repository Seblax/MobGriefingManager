package seblax.mob.griefing;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;
import utils.chatmessages.ToConsole;

import java.io.File;
import java.util.Arrays;

public class Configuration {
    private Plugin plugin;
    private static File file;
    private static YamlConfiguration modifyFile;

    public Configuration(Plugin plugin){
        try {
            this.plugin = plugin;
            initiateFile("config.yml");

        }catch (Exception e){
            ToConsole.of(ToConsole.error())
                    .add("Error when try to create config.yml file.")
                    .red()
                    .send();
            e.printStackTrace();
        }
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    void initiateFile(String name) throws Exception{
        File directory = new File( plugin.getDataFolder().toString());
        file = new File( plugin.getDataFolder().toString(),name);


        if(!directory.exists()){
            directory.mkdirs();
            file.createNewFile();
            DefaultConfiguration(file);
        }

        modifyFile = YamlConfiguration.loadConfiguration(file);
    }

    static void DefaultConfiguration(File fie){
        modifyFile = YamlConfiguration.loadConfiguration(file);

        DefaultConfiguration();
    }

    public static void DefaultConfiguration(){
        ToConsole.of(ToConsole.config()).add("Set 'Mob Griefing' to its default configuration.").send();
        try{
            for (var i : EntityType.values()){
                modifyFile.set(i.name(),true);
            }

            modifyFile.save(file);
        }catch (Exception e){
            ToConsole.of(ToConsole.error()).add("Error trying to set the default configuration.").red().send();
            e.printStackTrace();
        }
    }

    public static void SetMobConfig(String mobName, boolean b){
        EntityType mob = MobTypeParser(mobName);
        SetMobConfig(mob,b);
    }

    public static void SetMobConfig(EntityType mob, boolean b){
        String name = mob.name();

        try{
            modifyFile.set(name, b);
            modifyFile.save(file);
        }catch (Exception e){
            ToConsole.of(ToConsole.error())
                    .add("Error changing ")
                    .red()
                    .add(name)
                    .white()
                    .add(" to current value: ")
                    .add(b ?
                            ToConsole.of("True").green().toString() :
                            ToConsole.of("False").red().toString());
            e.printStackTrace();
        }
    }

    public static void SetMobGriefingOff(String mobName){
        EntityType mob = MobTypeParser(mobName);
        SetMobGriefingOff(mob);
    }

    public static void SetMobGriefingOff(EntityType mob){
        SetMobConfig(mob,false);
    }

    public static void SetMobGriefingOn(String mobName){
        EntityType mob = MobTypeParser(mobName);
        SetMobGriefingOn(mob);
    }

    public static void SetMobGriefingOn(EntityType mob){
        SetMobConfig(mob, true);
    }

    public static Boolean GetMobConfig(String mobName){
        EntityType mob = MobTypeParser(mobName);
        return GetMobConfig(mob);
    }

    public static Boolean GetMobConfig(EntityType mob){
        Boolean res = null;
        String name = mob.name();

        try {
            res = modifyFile.getBoolean(name);
        }catch (Exception e){
            ToConsole.of(ToConsole.error())
                    .add("Error trying get ")
                    .red()
                    .add(name)
                    .white()
                    .add(" configuration")
                    .red();
            e.printStackTrace();
        }
        return res;
    }

    static EntityType MobTypeParser(String mobName){
        return Arrays.stream(EntityType.values())
                .filter(x -> x.name().equals(mobName))
                .findFirst()
                .get();
    }
}