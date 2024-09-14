package seblax.mob.griefing.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import seblax.mob.griefing.Main;

import java.util.ArrayList;
import java.util.List;

public class MobGriefingCommandTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> res = new ArrayList<>();

        int index = strings.length;

        if(index == 1){
            res.add("get");
            res.add("set");
            res.add("reset");
        }else if(index == 2) {
            res = Main.GriefingMobs;
        }

        return res;
    }
}
