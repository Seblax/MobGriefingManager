package seblax.utils.chatmessages;

import org.bukkit.ChatColor;

public class IMessage {
    protected IMessagePalette messageColors;
    protected String message;

    String recursiveMessage = "";

    public IMessage(String message, IMessagePalette messageColors) {
        this.message = message;
        this.messageColors = messageColors;
    }

    public IMessage add(String m){
        recursiveMessage += message;
        message = m;
        return this;
    }

    String getMessage(){
        return recursiveMessage + message + messageColors.getPaletteCode("Reset");
    }

    IMessage modifyMessage(String mod){
        message = mod + message;
        return this;
    }

    public IMessage bold(){
        return modifyMessage(messageColors.getPaletteCode("Bold"));
    }

    public IMessage underline(){
        return modifyMessage(messageColors.getPaletteCode("Underline"));
    }

    public IMessage aqua(){
        return modifyMessage(messageColors.getPaletteCode("Aqua"));
    }

    public IMessage black(){
        return modifyMessage(messageColors.getPaletteCode("Black"));
    }

    public IMessage blue(){
        return modifyMessage(messageColors.getPaletteCode("Blue"));
    }

    public IMessage green(){
        return modifyMessage(messageColors.getPaletteCode("Green"));
    }

    public IMessage lightPurple(){
        return modifyMessage(messageColors.getPaletteCode("LightPurple"));
    }

    public IMessage red() {
        return modifyMessage(messageColors.getPaletteCode("Red"));
    }

    public IMessage yellow(){
        return modifyMessage(messageColors.getPaletteCode("Yellow"));
    }

    public IMessage white(){
        return modifyMessage(messageColors.getPaletteCode("White"));
    }

    public static String error(){
        return ChatColor.RESET + "[" +
                ChatColor.RED + "ERROR" +
                ChatColor.RESET + "]: ";
    }

    public static String data(){
        return ChatColor.RESET + "[" +
                ChatColor.GREEN + "DATA" +
                ChatColor.RESET + "]: ";
    }

    public static String config(){
        return ChatColor.RESET + "[" +
                ChatColor.YELLOW + "CONF" +
                ChatColor.RESET + "]: ";
    }

    public IMessage send(){
        System.out.println(getMessage());
        return this;
    }

    @Override
    public String toString(){
        return getMessage();
    }
}