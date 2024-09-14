package seblax.mob.griefing.command;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class MobGriefingCommand implements CommandExecutor {
    Player p;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(commandSender instanceof Player){
            p = (Player)commandSender;

            if(!p.isOp()){
                NoOpPlayer();
                return false;
            }

            String message = "Se ha seleccionado:";

            switch (strings[0]){
                case "get":
                    message += "get";
                    Bukkit.broadcastMessage(message);
                    break;
                case "set":
                    message += "set";
                    Bukkit.broadcastMessage(message);
                    break;
                case "reset":
                    message += "reset";
                    Bukkit.broadcastMessage(message);
                    break;

            }
        }

        return false;
    }

    void NoOpPlayer(){
        String message = String.format("%s You need to be an Operator to run this command."
                , ChatColor.DARK_RED);

        Random r = new Random();
        p.playSound(p, Sound.ENTITY_VILLAGER_NO, SoundCategory.AMBIENT, 1, r.nextFloat(0,2), 1);
        p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, SoundCategory.AMBIENT, 1, 0, 1);

        p.spawnParticle(Particle.BLOCK_MARKER, p.getLocation().add(0, 2,0), 20, 0.5, 0.5, 0.5, 100, Material.BARRIER.createBlockData());

        p.sendMessage(message);
    }

    void OnSet(String entity){

    }

    void OnGet(){

    }

    void OnReset(){

    }
}
