/**
 * Dies ist die Ausnahmeklasse von LOCAuswertung die von Exception abgeleitet ist.
 * @author Elisee Brand, Leopold Mittelberger
 */
public class LOCExceptions extends Exception {
    /**
     * Erste konstruktor
     * @param message ist ein string der die Fehler kennt
     */
    public LOCExceptions(String message){
        super(message);
    }
    /**
     * Standard konstruktor
     */
    public LOCExceptions(){
        super();
    }
}
