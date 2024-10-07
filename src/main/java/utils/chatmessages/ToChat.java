package utils.chatmessages;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class ToChat extends IMessage {
    private static final ColorPaletteChat ColorPaletteChat = new ColorPaletteChat();

    ToChat(String t){
        super(t, ColorPaletteChat);
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
        return modifyMessage(ColorPaletteChat.Italic);
    }

    public IMessage magic(){
        return modifyMessage(ColorPaletteChat.Magic);
    }

    public IMessage strikethrough(){
        return modifyMessage(ColorPaletteChat.StrikeThrough);
    }

    public IMessage darkAqua(){
        return modifyMessage(ColorPaletteChat.DarkAqua);
    }

    public IMessage darkBlue(){
        return modifyMessage(ColorPaletteChat.DarkBlue);
    }

    public IMessage darkGreen(){
        return modifyMessage(ColorPaletteChat.DarkGreen);
    }

    public IMessage darkGrey(){
        return modifyMessage(ColorPaletteChat.DarkGray);
    }

    public IMessage darkPurple(){
        return modifyMessage(ColorPaletteChat.DarkPurple);
    }

    public IMessage darkRed(){
        return modifyMessage(ColorPaletteChat.DarkRed);
    }

    public IMessage gold(){
        return modifyMessage(ColorPaletteChat.Gold);
    }

    public IMessage gray(){
        return modifyMessage(ColorPaletteChat.Gray);
    }

    public static String error(){
        return of("").messageColors.error;
    }

    public static String data(){
        return of("").messageColors.data;
    }

    public static String config(){
        return of("").messageColors.config;
    }

    public IMessage customChatColor(String hexColor){
        hexColor = hexColor.trim();
        try{
            return add(net.md_5.bungee.api.ChatColor.of(hexColor).toString());
        }catch (Exception e){
            System.out.printf("%s Error trying to create a chat color with: %s",
                    ToConsole.of().error(),
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