package utils.chatmessages;

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
        return recursiveMessage + message + messageColors.Reset;
    }

    IMessage modifyMessage(String mod){
        message = mod + message;
        return this;
    }

    public IMessage bold(){
        return modifyMessage(messageColors.Bold);
    }

    public IMessage underline(){
        return modifyMessage(messageColors.Underline);
    }

    public IMessage aqua(){
        return modifyMessage(messageColors.Aqua);
    }

    public IMessage black(){
        return modifyMessage(messageColors.Black);
    }

    public IMessage blue(){
        return modifyMessage(messageColors.Blue);
    }

    public IMessage green(){
        return modifyMessage(messageColors.Green);
    }

    public IMessage lightPurple(){
        return modifyMessage(messageColors.LightPurple);
    }

    public IMessage red() {
        return modifyMessage(messageColors.Red);
    }

    public IMessage yellow(){
        return modifyMessage(messageColors.Yellow);
    }

    public IMessage white(){
        return modifyMessage(messageColors.White);
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