import java.io.*;
import java.util.*;

//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
// neu in ueb18

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    
/**
 *    Die Klasse:  Lager.java
 *    Realisiert eine allgemeine Lager-Klasse fuer
 *    Artikel.
 *
 * @version 2.01 Beta 10.01.2023 erweitert 25.05.2023
 * @author  Wolfgang Pauly
 *
 */

public class Lager
{
//------------------Konstanten----------------------------------
  
  public  static final int     STANDARD_GROESSE = 10;
  public  static final String  STANDARD_LAGER_ORT = 
                               " (Ort noch nicht bestimmt) ";
  
  private static final String  DIMENSION_UNGUELTIG =
          "Ein zu konstruierendes Lager muss mindestens 1 Artikel aufnehmen koennen !";
  private static final String  LAGERORT_UNGUELTIG =
          "Der Lagerort-String muss initialisiert und nicht Leer sein !";

  private static final String  LAGER_KOMPLETT_BESETZT =
          "Im Lager sind schon alle Artikel-Lager-Plaetze besetzt !";
  private static final String  ARTIKEL_NICHT_IN_LAGER =
          "Verlangter Buchungs-Artikel nicht in Lager !!!!";
  private static final String  ARTIKEL_SCHON_IN_LAGER =
          "Anzulegender Artikel schon in Lager !!!!";
  
  private static final String  INDEX_UNGUELTIG =
          "Der Index ist zu gross oder zu klein !!!!";          
  
//------------------Attribute----------------------------------
  
  private  Artikel[] lager;
  private  int       letzterBesetzterIndex;
  private  String    lagerOrt;


  private Map<Integer, Artikel> artikelMap;

//------------------Konstruktoren-------------------------------


  /**
   *    Der Konstruktor zur Standard-Initialisierung 
   *    des Lagers
   *        
   */
  public Lager (){
   this( STANDARD_GROESSE, STANDARD_LAGER_ORT );
   artikelMap = new HashMap<>();
  }


  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einer maximalen Anzahl von Artikel-Lagerplaetzen
   *        
   *    @param groesse  == Anzahl der maximal im Lager fuehrbaren Artikel
   */
  public Lager (int groesse){
   this( groesse, STANDARD_LAGER_ORT );
   artikelMap = new HashMap<>();
  }


  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einem Lagerort und Standard-Artikel--Lagerplaetzen
   *        
   *    @param lagerOrt == Ort an dem das Lager existiert
   */
  public Lager (String lagerOrt){
   this( STANDARD_GROESSE, lagerOrt );
   artikelMap = new HashMap<>();
  }


  /**
   *    Der Konstruktor zur Initialisierung 
   *    eines Lagers mit einer maximalen Anzahl von Artikel-Lagerplaetzen
   *        
   *    @param groesse  == Anzahl der maximal im Lager fuehrbaren Artikel
   *    @param lagerOrt == Ort an dem das Lager existiert
   */
  public Lager (int groesse, String lagerOrt){
   checkArgument( (groesse <= 0), DIMENSION_UNGUELTIG );
   checkArgument( ( (lagerOrt == null) || (lagerOrt.trim().length() == 0)),
                  LAGERORT_UNGUELTIG 
            );

   this.lagerOrt = new String(lagerOrt); 

   lager = new Artikel[ groesse ];
   letzterBesetzterIndex = -1;

   for ( int lauf = 0; lauf < groesse; lauf++)
     {
      lager[lauf] = null;
     }
  }

//------------------ set-/get-lagerOrt---------------------------------

  /**
   *    gibt Lager-Attribut : lagerOrt zurueck
   *
   *    @return    lagerOrt
   */
  public String getLagerOrt ( ){
    return lagerOrt;
  }


  /**
   *    setzt Lager-Attribut :  lagerOrt
   *   
   *    @param lagerOrt     neuer Lager-Ort
   */
  public void setLagerOrt ( String lagerOrt ){
   checkArgument( ( (lagerOrt == null) || (lagerOrt.trim().length() == 0)), 
                  LAGERORT_UNGUELTIG
        );

   this.lagerOrt = lagerOrt.trim();
  }

//------------------Artikel anlegen  ---------------------------------


  /**
   *    anlegen eines neuen Artikels und ins Lager einordnen
   *    
   *    @param artikel  der anzulegende Artikel
   */
  public void legeAnArtikel ( Artikel artikel ){
    artikelMap.put(artikel.getArtikelNr(), artikel);
  }


//------------------Artikel entfernen ----------------------------------

  /**
   *    entfernt den Artikel anhand seiner Artikel-Nummer aus dem Lager
   *    
   *    @param   artikelNr Nummer des zu loeschenden Artikels
   *             
   */
  public void entferneArtikel ( int artikelNr ){
    artikelMap.remove(artikelNr);
  }



//------------------ zugang buchen  --------------------------------

  /**
   *    bucht einen Zugang von Artikeln zu dem durch die Artikel-Nummer 
   *    identifizierten Artikel.
   *    
   *    @param   artikelNr Artikel-Nummer, des zu buchenden Artikels
   *    @param zugang hinzukommende Artikel-Anzahl
   */
  public void bucheZugang ( int artikelNr, int zugang ){
    int artikelIndex = sucheArtikel( artikelNr );

    checkArgument(  ( artikelIndex == -1 ), ARTIKEL_NICHT_IN_LAGER );

    lager[artikelIndex].bucheZugang( zugang );
  }


//------------------- abgang buchen  --------------------------------

  /**
   *    bucht einen Abgang von Artikeln von dem durch die Artikel-Nummer 
   *    identifizierten Artikel.
   *    
   *    @param   artikelNr Artikel-Nummer, des zu buchenden Artikels
   *    @param abgang weggehende Artikel-Anzahl
   */
  public void bucheAbgang ( int artikelNr, int abgang ){
    int artikelIndex = sucheArtikel( artikelNr );

    checkArgument(  ( artikelIndex == -1 ), ARTIKEL_NICHT_IN_LAGER );

    lager[artikelIndex].bucheAbgang( abgang );
  }



  /**
   *    aenderePreisEinesArtikels - erhoeht, vermindert den Preis
   *                               eines anzugebenden Lagerartikels
   *    
   *    @param artikelNr Artikel-Nummer, des zu bearbeitenden Artikels
   *    @param prozent positive Prozentzahl == Preiserhoehung, negative = Preisverminderung
   */
  public void aenderePreisEinesArtikels ( int artikelNr, double prozent ){
    int artikelIndex = sucheArtikel( artikelNr );

    checkArgument(  ( artikelIndex == -1 ), ARTIKEL_NICHT_IN_LAGER );

    lager[artikelIndex].aenderePreis( prozent );
  }




  /**
   *    aenderePreisAllerArtikel - erhoeht, vermindert die Preise
   *                               aller Lagerartikel
   *
   *    @param  prozent - positive Prozentzahl == Preiserhoehung, negative = Preisverminderung 
   */
  public void aenderePreisAllerArtikel ( double prozent ){
    for ( int lauf = 0; lauf <= letzterBesetzterIndex; lauf++ )
       {
        lager[lauf].aenderePreis( prozent );
       }
  }
 
//------------------- hilfs-Methoden --------------------------------


  /**
   *    sucheArtikel - sucht im Lager Array
   *               nach dem Vorkommen eines Artikels anhand 
   *               der Artikel-Nummer
   *
   *    @param suchArtikelNr - die zu suchende Artikelnummer
   *    @return Index des gefundenen Artikels oder -1, falls der Artikel nicht
   *            im Lager enthalten ist.
   */
  public int sucheArtikel (int suchArtikelNr){
   if (artikelMap.containsKey(suchArtikelNr)) {
            return suchArtikelNr;
        } else {
            return -1; 
        }
  }

  /**
   *    getLagerGroesse - liefert die Groesse des Lager Array
   *    Hilfsmethode fuer die Testklasse LagerTest
   *    @author  Iris Ebner
   *
   *    @return lager.length == Anzahl der maximal im Lager fuehrbaren Artikel
   */
  public int getLagerGroesse (){
    return lager.length;    
  }

  /**
   *    getArtikelAnzahl - liefert die Anzahl der Artikel im Lager Array
   *    
   *
   *    @return Anzahl der momentan im Lager gefuehrten Artikel
   */
  public int getArtikelAnzahl (){
    return letzterBesetzterIndex + 1;    
  }
  
  /**
   *    getArtikel - liefert den Artikel aus dem Lager, der an der Stelle 
   *    Index gefuert wird
   *    Hilfsmethode fuer die Testklasse LagerTest
   *    @author  Iris Ebner
   *
   *    @param index - der Index des zurueckzugebenden Artikels
   *    @return der Artikel, der an der Stelle Index im Lager gefuehrt wird 
   */  
  // public Map<Integer, Artikel> getArtikel() {
  //       return artikelMap;
  //   }


//------------------ ausgebenBestandsListe --------------------------

  /**
   *    erzeugt einen String, der eine Bestandsliste repraesentiert
   *
   *    @return die String-Repraesentation der Lager-Bestandsliste
   */
  public void ausgebenBestandsListe() {
        for (Map.Entry<Integer, Artikel> entry : artikelMap.entrySet()) {
            int artikelNummer = entry.getKey();
            Artikel artikel = entry.getValue();
            System.out.println("Artikelnummer: " + artikelNummer + ", Artikel: " + artikel);
        }
    }


//------------------ toString  --------------------------------------

  /**
   *    erzeugt einen String, der alle, fuer den Klassenbenutzer
   *    wichtigen, Lager-Merkmale enthaelt
   *   
   *    @return die String-Repraesentation des Lagers
   */
  @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Artikel> entry : artikelMap.entrySet()) {
            int artikelNummer = entry.getKey();
            Artikel artikel = entry.getValue();
            sb.append("Artikelnummer: ").append(artikelNummer).append(", Artikel: ").append(artikel).append("\n");
        }
        return sb.toString();
    }


 /**
  *    wirft bei Fehlersituation eine RuntimeException
  *    
  *    
  *    @param  fehler  -> true  == Fehlersituation
  *                    -> false == KEINE Fehlersituation
  *    @param  meldung -> Fehlermeldungstext zur Fehlersituation
  */
  private void   checkArgument( boolean fehler, String meldung ){
   if ( fehler )
     {
      throw new RuntimeException( meldung );
     }
  }


 //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
 // neue Funktionen ueb18
 //vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv


  //------------------ getSorted  --------------------------------------
  /**
   * Gibt die Artikel im Lager als sortiertes Array zurück. 
   * Das Sortierkriterium wird als Parameter an die Methode übergeben.
   * 
   * @param sortKrit - ein Prädikat-Objekt, welches das Sortierkriterium implementiert  
   * @return ein sortiertes Array der Artikel im Lager 
   */
  public Artikel[] getSorted(BiPredicate<Artikel, Artikel> sortKrit){
     Artikel[] result = lager.clone();

     sort(sortKrit, result);

     return result;
    }
  
  /**
   * Hilfsmethode zum Sortieren eines übergebenen Arrays
   * 
   * @param sortKrit - ein Prädikat-Objekt, welches das Sortierkriterium implementiert
   * @param a - das zu sortierende Array
   */
  private void sort(BiPredicate<Artikel, Artikel> sortKrit, Artikel[] a){
      //Zum Sortieren wird der Bubblesort-Algorithmus verwendet. 
      //Dies ist nicht sehr effizient, jedoch einfach zu implementieren: 
      for (int i=a.length; i>0; i--)
         {
          for (int j=0; j<a.length-1; j++)
	     {
              if (sortKrit.test(a[j],a[j+1]))
	        {
                 swap(j, j+1, a);
                } 
             }
         }
    }
  
  //------------------ getSorted  --------------------------------------
  /**
   * Alternative Implementierung der getSorted Methode, 
   * unter Nutzung der sort Methode des List-Interfaces.
   * @param comp - ein Comparator-Objekt zum Vergleich zweier Artikel
   * @return eine sortierte Liste der Artikel im Lager
   */
  public List<Artikel> getSorted(Comparator<Artikel> comp){
      List<Artikel> result = Arrays.asList(lager);

      result.sort(comp);

      return result;
    }
  
  //------------------ swap  --------------------------------------
  /**
   * Hilfsmethode zum Sortieren eines Arrays. Die Methode vertauscht 
   * die beiden Elemente mit den Indizes i und j eines übergebenen Arrays. 
   * 
   * @param i - Index des ersten Elements
   * @param j - Index des zweiten Elements
   * @param a - Array für die Vertauschung 
   */
  private void swap(int i, int j, Artikel[] a){
      Artikel tmp = a[i];
      a[i] = a[j];
      a[j] = tmp;		
    }
  
  //------------------ applyToArticles  --------------------------------------
  /**
   * wendet eine übergebene Operation auf alle Artikel im Lager an 
   * 
   * @param consum - ein Consumer der die auf die Artikel anzuwendende Operation implementiert
   */
  public void applyToArticles(Consumer<Artikel> consum){
      for (int i=0; i<lager.length; i++){
          consum.accept(lager[i]); 
         }
    }

  
  //------------------ filter  --------------------------------------
  /**
   * Filtert die Artikel im Lager nach einem an die Methode übergebenen Filterkriterium. 
   * 
   * @param filterKrit - ein Prädikat-Objekt, welches das Filterkriterium implementiert
   * @return eine Liste alle Artikel im Lager, die das Filterkriterium erfüllen. 
   */
  public List<Artikel> filter(Predicate<Artikel> filterKrit){
      List<Artikel> result = new ArrayList<Artikel>();

      for (int i=0; i<lager.length; i++){
        if ( filterKrit.test(lager[i]) ){
            result.add(lager[i]);
        }
      }
      return result; 
    }

  //------------------ applyToSomeArticles  --------------------------------------
  /**
   * wendet eine übergebene Operation auf alle Artikel, welche ein Filterkriterium erfüllen an
   *
   * @param f - ein Prädikat-Objekt, welches das Filterkriterium implementiert
   * @param c - ein Consumer der die auf die Artikel anzuwendende Operation implementiert
   */
  public void applyToSomeArticles(Predicate<Artikel> f, Consumer<Artikel> c){
      for ( Artikel a : filter(f) ){
          c.accept(a);
        }
    }

  //------------------ getArticles  --------------------------------------
  /**
   * liefert eine sortierte Liste der Artikel, die ein gegebenes Filterkriterium erfüllen
   *
   * @param f - ein Prädikat-Objekt, welches das Filterkriterium implementiert
   * @param c - ein Prädikat-Objekt, welches das Sortierkriterium implementiert
   * @return eine sortierte Liste der gefilterten Artikel
   */
  public Map<Integer, Artikel> getArtikel() {
        return artikelMap;
    }

  //------------------ filterAll  --------------------------------------
  /**
   * Filtert die Artikel im Lager nach den an die Methode übergebenen Filterkriterien. 
   * 
   * @param fKriterien - Prädikat-Objekte, welche die Filterkriterien implementieren
   * @return eine Liste alle Artikel im Lager, die alle Filterkriterien erfüllen. 
   */
  public Artikel[]  filterAll(Predicate<Artikel>... fKriterien){
      List<Artikel> zuFiltern = Arrays.asList(lager);
      ArrayList<Artikel> geFiltert = new ArrayList<Artikel>();

      for (int k = 0; k < fKriterien.length; k++)
         {
          for ( Artikel a : zuFiltern )
             {
               if ( fKriterien[k].test(a) )
	         {
                   geFiltert.add(a);
	         }
             }

          zuFiltern = new ArrayList<Artikel>(geFiltert);

          if ( k < fKriterien.length -1 )
            {
              geFiltert = new ArrayList<Artikel>();
            }
         }
      return geFiltert.toArray(new Artikel[geFiltert.size()]); 
    }

 //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 // neue Funktionen ueb18
 //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}

