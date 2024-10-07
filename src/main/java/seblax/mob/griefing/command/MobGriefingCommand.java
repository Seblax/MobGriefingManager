package seblax.mob.griefing.command;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import seblax.mob.griefing.Configuration;
import utils.chatmessages.*;

import java.util.Arrays;
import java.util.Random;

public class MobGriefingCommand implements CommandExecutor {
    Player p;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!Restrictions(strings)) {
            ToChat.of(ToChat.error()).add("Wrong command statement").red().send();
            return false;
        }

        strings[1] = strings[1].toUpperCase();

        if(commandSender instanceof Player){
            p = (Player)commandSender;

            if(!p.isOp()){
                NoOpPlayer();
                return false;
            }
        }

        Selector(strings);

        return false;
    }

    boolean Restrictions(String[] command){
        //[get, entity]
        boolean res1 = command.length > 1;
        boolean res2 = true;
        boolean res3 = true;

        if(res1) {
            res2 = command[0].equals("get") ||
                    command[0].equals("set") ||
                    command[0].equals("reset");

            res3 = Arrays.stream(EntityType.values())
                    .anyMatch(x -> x.name().equals(command[1].toUpperCase()));
        }
        return res1 && res2 && res3;
    }

    void Selector(String[] strings){

        switch (strings[0]){
            case "get":
                OnGet(strings[1]);
                break;
            case "set":
                if(strings.length < 3){
                    ToChat.of(ToChat.error()).add("Wrong Set statement: needs true or false").send();
                    return;
                }
                OnSet(strings[1],strings[2]);
                break;
            case "reset":
                OnReset(strings[1]);
                break;

        }
    }


    void OnSet(String entity, String b){
        if(b.equals("true") || b.equals("false")){
            OnSet(entity,Boolean.parseBoolean(b));
        }else {
            ToChat.of(ToChat.error()).add("Wrong Set statement: must be 'true' or 'false'").send();
        }
    }

    void OnSet(String entity, Boolean b){
        Configuration.SetMobConfig(entity,b);
        OnGet(entity);
    }

    void OnGet(String entity){
        Boolean config = Configuration.GetMobConfig(entity);
        ToChat.of(ToChat.config())
                .add(entity)
                .bold()
                .green()
                .add(" can break blocks: ")
                .white()
                .add( config ?
                        ToChat.of("Yes").green().toString() :
                        ToChat.of("No").red().toString()).send();

        if(p != null){
            if(config){
                EntityConfigYesParticles();
            }else {
                EntityConfigNoParticles();
            }
        }
    }

    void EntityConfigYesParticles(){
        Random r = new Random();
        p.playSound(p, Sound.ENTITY_VILLAGER_YES, SoundCategory.AMBIENT, 1, r.nextFloat(0.75f,2f), 1);
        p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, SoundCategory.AMBIENT, 1, 1, 1);

        p.spawnParticle(Particle.VILLAGER_HAPPY, p.getLocation().add(0, 1,0), 20, 0.5, 0.5, 0.5, 100);
    }

    void EntityConfigNoParticles(){
        Random r = new Random();
        p.playSound(p, Sound.ENTITY_VILLAGER_NO, SoundCategory.AMBIENT, 1, r.nextFloat(0,2), 1);
        p.playSound(p, Sound.ENTITY_PLAYER_LEVELUP, SoundCategory.AMBIENT, 1, 0, 1);

        p.spawnParticle(Particle.BLOCK_MARKER, p.getLocation().add(0, 1,0), 20, 0.5, 0.5, 0.5, 100, Material.BARRIER.createBlockData());
    }

    void OnReset(String entity){
        Configuration.SetMobGriefingOn(entity);
        OnGet(entity);
    }

    void NoOpPlayer(){
        EntityConfigNoParticles();
        p.sendMessage(
                ToChat.of(ToChat.error())
                        .add("You need to be an Operator to run this command.")
                        .red()
                        .toString());
    }
}
