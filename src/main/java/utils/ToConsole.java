package utils;

public class ToConsole {
    static final String Bold = "\u001B[1m";
    static final String Underline = "\u001B[4m";

    static final String Black = "\u001B[30m";
    static final String Red = "\u001B[31m";
    static final String Green= "\u001B[32m";
    static final String Yellow= "\u001B[33m";
    static final String Blue= "\u001B[34m";
    static final String Magenta= "\u001B[35m";
    static final String Cyan= "\u001B[36m";
    static final String White = "\u001B[37m";
    static final String Reset= "\u001B[0m";

    public static String config = "[" + Yellow + "CONFIG" + Reset + "]";
    public static String error = "[" + Red + "ERROR" + Reset + "]";

    String text;

    ToConsole(String t){
        this.text = t;
    }

    public static ToConsole of(String text){
        return new ToConsole(text);
    }

    public ToConsole bold(){
        this.text = Bold + text;
        return this;
    }

    public ToConsole underline(){
        this.text = Underline + text;
        return this;
    }

    public ToConsole black(){
        this.text = Black + text;
        return this;
    }

    public ToConsole red(){
        this.text = Red + text;
        return this;
    }

    public ToConsole green(){
        this.text = Green + text;
        return this;
    }

    public ToConsole yellow(){
        this.text = Yellow + text;
        return this;
    }

    public ToConsole magenta(){
        this.text = Magenta + text;
        return this;
    }

    public ToConsole blue(){
        this.text = Blue + text;
        return this;
    }

    public ToConsole white(){
        this.text = White + text;
        return this;
    }

    public ToConsole cyan(){
        this.text = Cyan + text;
        return this;
    }

    @Override
    public String toString(){
        return text + Reset;
    }

    public static void Test(){
        System.out.println(ToConsole.of("This is a test").bold());
        System.out.println(ToConsole.of("This is a test").underline());
        System.out.println("===========Colours==========");
        System.out.println(ToConsole.of("This is a test").black());
        System.out.println(ToConsole.of("This is a test").red());
        System.out.println(ToConsole.of("This is a test").green());
        System.out.println(ToConsole.of("This is a test").yellow());
        System.out.println(ToConsole.of("This is a test").magenta());
        System.out.println(ToConsole.of("This is a test").blue());
        System.out.println(ToConsole.of("This is a test").white());
        System.out.println(ToConsole.of("This is a test").cyan());
    }
}