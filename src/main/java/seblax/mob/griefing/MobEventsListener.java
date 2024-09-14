package seblax.mob.griefing;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import utils.ToConsole;

public class MobEventsListener implements Listener {

    @EventHandler
    public void DestroyingOrMovingBlocks(EntityChangeBlockEvent event){
        Entity entity = event.getEntity();

        if(!Configuration.getMobConfig(entity.getType())){
            event.setCancelled(true);
            System.out.printf("%s %s",
                    entity.getName(),
                    ToConsole.of("tried to destroy or move a block, but the action was cancelled.").yellow());
        }
    }

}
