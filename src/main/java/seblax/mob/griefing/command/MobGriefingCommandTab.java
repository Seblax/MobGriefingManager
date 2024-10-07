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
            Main.GriefingMobs.forEach(x -> res.add(x.toLowerCase()));
        }else if(index == 3 && strings[0].equals("set")) {
            res.add("true");
            res.add("false");
        }

        return res;
    }
}
