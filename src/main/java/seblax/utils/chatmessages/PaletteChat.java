package seblax.utils.chatmessages;

import org.bukkit.ChatColor;

public enum PaletteChat {
    ITALIC(ChatColor.ITALIC.toString()),
    MAGIC(ChatColor.MAGIC.toString()),
    STRIKETHROUGH(ChatColor.STRIKETHROUGH.toString()),
    DARKAQUA(ChatColor.DARK_AQUA.toString()),
    DARKBLUE(ChatColor.DARK_BLUE.toString()),
    DARKGRAY(ChatColor.DARK_GRAY.toString()),
    DARKGREEN(ChatColor.DARK_GREEN.toString()),
    DARKPURPLE(ChatColor.DARK_PURPLE.toString()),
    DARKRED(ChatColor.DARK_RED.toString()),
    GOLD(ChatColor.GOLD.toString()),
    GRAY(ChatColor.GRAY.toString()),

    BOLD(ChatColor.BOLD.toString()),
    UNDERLINE(ChatColor.UNDERLINE.toString()),
    AQUA(ChatColor.AQUA.toString()),
    BLACK(ChatColor.BLACK.toString()),
    BLUE(ChatColor.BLUE.toString()),
    GREEN(ChatColor.GREEN.toString()),
    LIGHTPURPLE(ChatColor.LIGHT_PURPLE.toString()),
    RED(ChatColor.RED.toString()),
    RESET(ChatColor.RESET.toString()),
    WHITE(ChatColor.WHITE.toString()),
    YELLOW(ChatColor.YELLOW.toString());

    private final String code;

    PaletteChat(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}