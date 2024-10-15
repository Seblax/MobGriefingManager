package seblax.utils.chatmessages;

public class ToConsole extends IMessage {

    ToConsole(String t){
        super(t, new IMessagePalette(PaletteConsole.class) {
        });
    }

    public static ToConsole of(){
        return of("");
    }
    public static ToConsole of(IMessage s){
        return of(s.toString());
    }

    public static ToConsole of(String s){
        return new ToConsole(s);
    }

    public static String error(){
        return PaletteConsole.RESET.getCode() + "[" +
                PaletteConsole.RED.getCode() + "ERROR" +
                PaletteConsole.RESET.getCode() + "]: ";
    }

    public static String data(){
        return PaletteConsole.RESET.getCode() + "[" +
                PaletteConsole.GREEN.getCode() + "DATA" +
                PaletteConsole.RESET.getCode() + "]: ";
    }

    public static String config(){
        return PaletteConsole.RESET.getCode() + "[" +
                PaletteConsole.YELLOW.getCode() + "CONF" +
                PaletteConsole.RESET.getCode() + "]: ";
    }
}