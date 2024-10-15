package seblax.utils.chatmessages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ToChat extends IMessage {

    ToChat(String t){
        super(t, new IMessagePalette(PaletteChat.class){});
    }

    public static ToChat of(IMessage s){
        return  of(s.toString());
    }

    public static ToChat of(){
        return  of("");
    }

    public static ToChat of(String s){
        return new ToChat(s);
    }
    IMessage modifyMessage(ChatColor mod){
        return modifyMessage(mod.toString());
    }

    public IMessage italic(){
        return modifyMessage(PaletteChat.ITALIC.getCode());
    }

    public IMessage magic(){
        return modifyMessage(PaletteChat.MAGIC.getCode());
    }

    public IMessage strikethrough(){
        return modifyMessage(PaletteChat.STRIKETHROUGH.getCode());
    }

    public IMessage darkAqua(){
        return modifyMessage(PaletteChat.DARKAQUA.getCode());
    }

    public IMessage darkBlue(){
        return modifyMessage(PaletteChat.DARKBLUE.getCode());
    }

    public IMessage darkGreen(){
        return modifyMessage(PaletteChat.DARKGREEN.getCode());
    }

    public IMessage darkGrey(){
        return modifyMessage(PaletteChat.DARKGRAY.getCode());
    }

    public IMessage darkPurple(){
        return modifyMessage(PaletteChat.DARKPURPLE.getCode());
    }

    public IMessage darkRed(){
        return modifyMessage(PaletteChat.DARKRED.getCode());
    }

    public IMessage gold(){
        return modifyMessage(PaletteChat.GOLD.getCode());
    }

    public IMessage gray(){
        return modifyMessage(PaletteChat.GRAY.getCode());
    }

    public IMessage customChatColor(String hexColor){
        hexColor = hexColor.trim();
        try{
            return add(net.md_5.bungee.api.ChatColor.of(hexColor).toString());
        }catch (Exception e){
            System.out.printf("%s Error trying to create a chat color with: %s",
                    ToConsole.of(ToConsole.error()),
                    hexColor);
            e.printStackTrace();
            return this;
        }
    }

    @Override
    public IMessage send() {
        Bukkit.broadcastMessage(getMessage());
        return this;
    }
}