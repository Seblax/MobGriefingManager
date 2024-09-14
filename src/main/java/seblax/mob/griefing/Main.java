package seblax.mob.griefing;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import seblax.mob.griefing.command.MobGriefingCommand;
import seblax.mob.griefing.command.MobGriefingCommandTab;

import java.util.Arrays;
import java.util.List;

public final class Main extends JavaPlugin {

    public static final List<String> GriefingMobs = Arrays.asList(
            EntityType.ZOMBIE.name(),
            EntityType.HUSK.name(),
            EntityType.ZOMBIFIED_PIGLIN.name(),
            EntityType.CREEPER.name(),
            EntityType.GHAST.name(),
            EntityType.ENDERMAN.name(),
            EntityType.WITHER.name(),
            EntityType.WARDEN.name()
            );

    public void onEnable() {
        GriefingMobs.sort(String::compareTo);

        getCommand("mobgriefing").setExecutor(new MobGriefingCommand());
        getCommand("mobgriefing").setTabCompleter(new MobGriefingCommandTab());

        new Configuration(this);
        Bukkit.getPluginManager().registerEvents(new MobEventsListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
