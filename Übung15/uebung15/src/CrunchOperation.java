/**
 * @author Leopold Mittelberger, Elisee Brand
 * @version 1.0
 * Schnittstelle für arithmetische Operationen an einem Float-Array
 */

public interface CrunchOperation {
    /**
     * Führt eine arithmetische Operation auf einem gegebenen Float-Array aus
     * @param zahlen das Float-Array, auf dem die Operation ausgeführt wird
     */
    public void crunch(float[] zahlen);
}