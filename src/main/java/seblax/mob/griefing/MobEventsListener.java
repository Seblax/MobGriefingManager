package seblax.mob.griefing;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import utils.chatmessages.ToChat;
import utils.chatmessages.ToConsole;

public class MobEventsListener implements Listener {

    @EventHandler
    public void DestroyingOrMovingBlocks(EntityExplodeEvent event){
        Entity entity = event.getEntity();

        if(!Configuration.GetMobConfig(entity.getType())){
            event.blockList().clear();

            ToConsole.of(ToConsole.data())
                    .add(entity.getName()).green()
                    .add(" tried to blow up blocks, but the action was cancelled.")
                    .yellow()
                    .send();
        }
    }

    @EventHandler
    public void DestroyingOrMovingBlocks(EntityChangeBlockEvent event){
        Entity entity = event.getEntity();

        ToChat.of(Configuration.GetMobConfig(entity.getType()).toString());

        if(!Configuration.GetMobConfig(entity.getType())){
            event.setCancelled(true);

            ToConsole.of(ToConsole.data())
                    .add(entity.getName()).green()
                    .add(" tried to destroy or move a block, but the action was cancelled.")
                    .yellow()
                    .send();
        }
    }
}
