import java.io.File;

public class ErrorCheck {
    public static void checkJavaDatei(String[] args){
        for(int i = 0; i < args.length; i++){
            if(!args[i].endsWith(".java")){
                System.out.println("Datei: " + args[i] + " ist kein java datei");
            }
        }
    }

    public static void checkSelbeDatei(String[] args){
        for(int i = 0; i < args.length; i++){
            for(int j = 0; j < args.length; j++){
                if(args[i] == args[j]){
                    System.out.println("Datei: " + args[i] + " ist verdoppelt");
                }
            }
        }
    }
    public static void checkMindestensEinDatei(String[] args){
        if(args.length == 0){
            System.out.println("Es gibt als Argument kein Datei");
        }
    }
    public static void checkDateiExistiert(String[] args){
        for(int i = 0; i < args.length; i++){
            File file = new File(args[i]);
            if(!file.exists()){
                System.out.println("Datei: " + args[i] + " existiert nicht");
            }
        }
    }
}
