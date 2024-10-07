package utils.chatmessages;

import org.bukkit.ChatColor;

public class ColorPaletteChat extends IMessagePalette {
    final ChatColor Italic = ChatColor.ITALIC;
    final ChatColor Magic = ChatColor.MAGIC;
    final ChatColor StrikeThrough = ChatColor.STRIKETHROUGH;

    final ChatColor DarkAqua = ChatColor.DARK_AQUA;
    final ChatColor DarkBlue = ChatColor.DARK_BLUE;
    final ChatColor DarkGray = ChatColor.DARK_GRAY;
    final ChatColor DarkGreen = ChatColor.DARK_GREEN;
    final ChatColor DarkPurple = ChatColor.DARK_PURPLE;
    final ChatColor DarkRed = ChatColor.DARK_RED;
    final ChatColor Gold = ChatColor.GOLD;
    final ChatColor Gray = ChatColor.GRAY;

    ColorPaletteChat() {
        super(
                ChatColor.BOLD.toString(),
                ChatColor.UNDERLINE.toString(),
                ChatColor.AQUA.toString(),
                ChatColor.BLACK.toString(),
                ChatColor.BLUE.toString(),
                ChatColor.GREEN.toString(),
                ChatColor.LIGHT_PURPLE.toString(),
                ChatColor.RED.toString(),
                ChatColor.RESET.toString(),
                ChatColor.WHITE.toString(),
                ChatColor.YELLOW.toString());
    }
}