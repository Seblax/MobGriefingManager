package utils.chatmessages;

public class ToConsole extends IMessage {

    ToConsole(String t){
        super(t, new ColorPaletteConsole());
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
        return of("").messageColors.error;
    }

    public static String data(){
        return of("").messageColors.data;
    }

    public static String config(){
        return of("").messageColors.config;
    }

}