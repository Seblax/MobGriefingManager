package utils.chatmessages;

public class ColorPaletteConsole extends IMessagePalette{

    ColorPaletteConsole() {
        super("\u001B[1m",
                "\u001B[4m",
                "\u001B[36m",
                "\u001B[30m",
                "\u001B[34m",
                "\u001B[32m",
                "\u001B[35m",
                "\u001B[31m",
                "\u001B[0m",
                "\u001B[37m",
                "\u001B[33m");
    }
}
