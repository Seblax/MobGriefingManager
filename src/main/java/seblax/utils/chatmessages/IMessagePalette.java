package seblax.utils.chatmessages;

public abstract class IMessagePalette {
        Class<? extends Enum<?>>  palette;

        public IMessagePalette(Class<? extends Enum<?>>  palette) {
                this.palette = palette;
        }

        public String getPaletteCode(String color) {
                color = color.toUpperCase();
                Enum<?> enumConstant = Enum.valueOf(palette.asSubclass(Enum.class), color);

                if (enumConstant instanceof PaletteConsole) {
                        return PaletteConsole.valueOf(color).getCode();
                } else if (enumConstant instanceof PaletteChat) {
                        return PaletteChat.valueOf(color).getCode();
                }
                return "";
        }
}