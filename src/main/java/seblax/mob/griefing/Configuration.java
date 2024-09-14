package seblax.mob.griefing;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.Plugin;
import utils.ToConsole;

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
            System.out.printf("%s %s %n",
                    ToConsole.error,
                    ToConsole.of("Error a la hora de crear el archivo").red());
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

        System.out.printf("%s Set 'Mob Griefing' to its default configuration.%n",
                ToConsole.config);
        try{
            for (var i : EntityType.values()){
                modifyFile.set(i.name(),true);
            }

            modifyFile.save(file);
        }catch (Exception e){
            System.out.printf("%s %s %n",
                    ToConsole.error,
                    ToConsole.of("Error trying to set the default configuration.").red());
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

            System.out.printf("[%s] %s can break blocks: %s.%n",
                    ToConsole.config,
                    ToConsole.of(name).bold().green(),
                    b ? ToConsole.of("Yes").green(): ToConsole.of("No").red());

        }catch (Exception e){
            System.out.printf("%s %s. %n",
                    ToConsole.error,
                    ToConsole.of("Error changing " + name +  " to current value: " + b));
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

    public static Boolean getMobConfig(EntityType mob){
        Boolean res = null;
        String name = mob.getName();

        try {
            res = modifyFile.getBoolean(name);
        }catch (Exception e){
            System.out.printf("%s %s. %n",
                    ToConsole.error,
                    "Error trying get " + name + " configuration");
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