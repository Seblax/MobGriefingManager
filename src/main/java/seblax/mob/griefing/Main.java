package seblax.mob.griefing;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import seblax.mob.griefing.command.MobGriefingCommand;
import seblax.mob.griefing.command.MobGriefingCommandTab;
import seblax.utils.chatmessages.ToChat;
import seblax.utils.chatmessages.ToConsole;

import java.util.Arrays;
import java.util.List;

public final class Main extends JavaPlugin {

//    public static final List<String> GriefingMobs = Arrays.asList(
//            EntityType.ZOMBIE.name(),
//            EntityType.HUSK.name(),
//            EntityType.ZOMBIFIED_PIGLIN.name(),
//            EntityType.CREEPER.name(),
//            EntityType.GHAST.name(),
//            EntityType.ENDERMAN.name(),
//            EntityType.WITHER.name(),
//            EntityType.WITHER_SKULL.name(),
//            EntityType.WARDEN.name()
//    );
//
    public static final List<String> GriefingMobs = Arrays.stream(EntityType.values()).sorted().map(Enum::name).toList();


    public void onEnable() {
//        GriefingMobs.sort(String::compareTo);

        getCommand("mobgriefing").setExecutor(new MobGriefingCommand());
        getCommand("mobgriefing").setTabCompleter(new MobGriefingCommandTab());

        new Configuration(this);
        Bukkit.getPluginManager().registerEvents(new MobEventsListener(), this);

        ToConsole.of(ToConsole.data()).send();
        ToConsole.of(ToConsole.config()).send();
        ToConsole.of(ToConsole.error()).send();


        ToChat.of(ToChat.data()).send();
        ToChat.of(ToChat.config()).send();
        ToChat.of(ToChat.error()).send();
    }

}
