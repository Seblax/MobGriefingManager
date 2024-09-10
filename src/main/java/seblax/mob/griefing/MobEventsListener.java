package seblax.mob.griefing;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class EndermanPickUpListener implements Listener {

    @EventHandler
    public void DestroyingOrMovingBlocks(EntityChangeBlockEvent event){
        Entity entity = event.getEntity();

        if(entity instanceof Monster && !Configuration.getMobConfig(entity)){
            event.setCancelled(true);
            System.out.println(ChatColor.GRAY + entity.getName() + " tried to destroy or move a block, but the action was cancelled.");
        }
    }

}
