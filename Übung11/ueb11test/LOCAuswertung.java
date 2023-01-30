import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class LOCAuswertung {
    private static final Pattern COMMENT_PATTERN = Pattern.compile("^\s*//");
    private static final Pattern BLANK_PATTERN = Pattern.compile("^\s*$");

    private File[] filesArray;

    private int codeLines = 0;
    private int totCodeLines = 0;
    private int numberOfFile = 0;

    public static void main(String[] args) {
        LOCAuswertung loc = new LOCAuswertung();
        loc.run(args);
    }

    public void run(String[] args) {
        collectFiles(args);
        readFiles();
        outputResult();
    }


    public void collectFiles(String[] args) {
        try {
            if (args == null || args.length == 0) {
                throw new LOCError("Es wurde kein Datei gegeben.");
            }
        } catch (LOCError e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        filesArray = new File[args.length];
        int i = 0;
        ArrayList<String> readableFiles = new ArrayList<String>();
        ArrayList<String> notReadableFiles = new ArrayList<String>();
        ArrayList<String> notJavaFiles = new ArrayList<String>();
        ArrayList<String> doesNotExistFiles = new ArrayList<String>();
        ArrayList<String> notAFile = new ArrayList<String>();
        for ( String arg : args) {
            File file = new File(arg);
            if (file.isFile()) {
                if (file.exists()) {
                    if (file.getName().endsWith(".java") && file.canRead()) {
                        if (file.canRead()) {
                            readableFiles.add(file.getName());
                            filesArray[i] = file;
                            i++;
                        } else {
                            notReadableFiles.add(file.getName());
                        }
                    } else {
                        notJavaFiles.add(file.getName());
                    }
                } else {
                    doesNotExistFiles.add(file.getName());
                }
            } else {
                notAFile.add(file.getName());
            }
        }
        if (readableFiles.size() == 0) {
            System.out.println("\nEs gibt keine Datei, die gelesen werden kann.");
            System.exit(1);
        } else {
            System.out.println("\nDie folgenden Dateien werden gelesen:");
            printArrayList(readableFiles);
        }
        if (notReadableFiles.size() > 0) {
            System.out.println("\nDie folgenden Dateien sind nicht lesbar:");
            printArrayList(notReadableFiles);
        }
        if (notJavaFiles.size() > 0) {
            System.out.println("\nDie folgenden Dateien sind keine Java-Dateien:");
            printArrayList(notJavaFiles);
        }
        if (doesNotExistFiles.size() > 0) {
            System.out.println("\nDie folgenden Dateien existieren nicht:");
            printArrayList(doesNotExistFiles);
        }
        if (notAFile.size() > 0) {
            System.out.println("\nDie folgenden Dateien sind keine Dateien:");
            printArrayList(notAFile);
        }
    }


    public void readFiles() {
        System.out.println("\nAuswertung Lines of Code (LOC)");
        for (int i = 0; i < filesArray.length; i++) {
            if (filesArray[i] != null) {
                codeLines = 0;
                numberOfFile++;
                linesOfCode(filesArray[i]);
                System.out.println(filesArray[i].getName() + ": " + codeLines);
            }
        }
    }

    public void linesOfCode(File file) {
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                Matcher commentMatcher = COMMENT_PATTERN.matcher(line);
                Matcher blankMatcher = BLANK_PATTERN.matcher(line);
                if (!commentMatcher.find() && !blankMatcher.find()) {
                    codeLines++;
                }
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        totCodeLines += codeLines;
    }

    public void outputResult() {
        System.out.println("\nGesamt:");
        System.out.println( numberOfFile + " Dateien " + totCodeLines + " LOC");
    }

    public void printArrayList(ArrayList list) {
        for (Object file : list) {
            System.out.println(file);
        }
    }
}