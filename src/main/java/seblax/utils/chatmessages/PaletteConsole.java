package seblax.utils.chatmessages;

public enum PaletteConsole {
    BOLD("\u001B[1m"),
    UNDERLINE("\u001B[4m"),
    AQUA("\u001B[36m"),
    BLACK("\u001B[30m"),
    BLUE("\u001B[34m"),
    GREEN("\u001B[32m"),
    LIGHTPURPLE("\u001B[35m"),
    RED("\u001B[31m"),
    RESET("\u001B[0m"),
    WHITE("\u001B[37m"),
    YELLOW("\u001B[33m");

    private final String code;

    PaletteConsole(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
