package utils;

public class ToConsole {
    static final String Bold = "\u001B[1m";

    static final String Black = "\u001B[30m";
    static final String Red = "\u001B[31m";
    static final String Green= "\u001B[32m";
    static final String Yellow= "\u001B[33m";
    static final String Blue= "\u001B[34m";
    static final String Magenta= "\u001B[35m";
    static final String Cyan= "\u001B[36m";
    static final String White = "\u001B[37m";
    static final String Default= "\u001B[39m";
    static final String Reset= "\u001B[0m";

    String text;

    ToConsole(String text){
        this.text = text;
    }

    public String Bold(){
        return Bold + text;
    }


}
