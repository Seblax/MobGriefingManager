package utils.chatmessages;

public abstract class IMessagePalette {
        protected String Bold;
        protected String Underline;
        protected String Black;
        protected String Red;
        protected String Green;
        protected String Yellow;
        protected String Blue;
        protected String LightPurple;
        protected String Aqua;
        protected String White;
        protected String Reset;


        protected String config;
        protected String error;
        protected String data;

        IMessagePalette(
                String Bold,
                String Underline,
                String Aqua,
                String Black,
                String Blue,
                String Green,
                String LightPurple,
                String Red,
                String Reset,
                String White,
                String Yellow){

                this.Bold= Bold;
                this.Underline= Underline;
                this.Black= Black;
                this.Red=Red;
                this.Green=Green;
                this.Yellow=Yellow;
                this.Blue=Blue;
                this.LightPurple=LightPurple;
                this.Aqua=Aqua;
                this.White=White;
                this.Reset=Reset;


                config = Reset + "[" + Yellow + "CONFIG" + Reset + "]: ";
                error = Reset + "[" + Red + "ERROR" + Reset + "]: " ;
                data = Reset + "[" + Green + "DATA" + Reset + "]: ";
        }
}