import java.io.File;

public class LOCExceptions extends RuntimeException{
    public LOCExceptions(String message){
        super(message);
    }
    public LOCExceptions(){
        super();
    }

    public static void checkJavaDatei(String[] args){
        for(int i = 0; i < args.length; i++){
            if(!args[i].endsWith(".java")){
                throw new IllegalArgumentException("Datei: " + args[i] + " ist kein java datei");
            }
        }
    }

    public static void checkSelbeDatei(String[] args){
        for(int i = 0; i < args.length; i++){
            for(int j = 0; j < args.length; j++){
                if(args[i] == args[j]){
                    throw new IllegalArgumentException("Datei: " + args[i] + " ist verdoppelt");
                }
            }
        }
    }
    public static void checkMindestensEinDatei(String[] args){
        if(args.length == 0){
            throw new IllegalArgumentException("Es gibt als Argument kein Datei");
        }
    }
    public static void checkDateiExistiert(String[] args){
        for(int i = 0; i < args.length; i++){
            File file = new File(args[i]);
            if(!file.exists()){
                throw new IllegalArgumentException("Datei: " + args[i] + " existiert nicht");
            }
        }
    }
}
