public interface PersonIterator {

    /**
     * Gibt true zurück, wenn der Iterator weitere Elemente enthält
     * ansonsten false
     * @return true, wenn der Iterator weitere Elemente enthält
     */
     boolean hasNext();

    /**
     * gibt das nächste Person-Objekt zurück
     * @return das nächste Person-Objekt
     */
     Person next();
}
