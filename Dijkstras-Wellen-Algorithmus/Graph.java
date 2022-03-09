 import java.util.*;
/**
 * implementiert einen Graphen mit Kanten und Knoten
 * 
 * @author Michael Mutin 
 * @version 1.0
 */
public class Graph
{
    private HashSet<Knoten> _knotenmenge;
    private HashSet<Verbindung> _kantenmenge;
    
    /**
     * erstellt einen leeren Graphen
     */
    public Graph()
    {
        _knotenmenge = new HashSet();
        _kantenmenge = new HashSet();
    }
    
    /**
     * fügt einen Knoten hinzu, falls dieser noch nicht Teil des Graphen ist
     * 
     * @param kn Knoten, der hinzugefügt werden soll
     */
    public void knotenHinzufuegen(Knoten kn)
    {
        _knotenmenge.add(kn);
    }
    
    /**
     * entfernt einen Knoten aus dem Graphen
     * 
     * @param kn Knoten, der entfernt werden soll
     */
    public void knotenEntfernen(Knoten kn)
    {
        _knotenmenge.remove(kn);

        for(Verbindung k : _kantenmenge)
        {
            if(k.gibKnoten1() == kn || k.gibKnoten2() == kn)
            {
                kanteEntfernen(k);
            }
        }
    }
    
    /**
     * fügt eine Kante hinzu, falls zwischen den jeweiligen Knoten noch keine Kante existiert
     * 
     * @param ka Kante, die hinzugefügt werden soll
     */
    public void kanteHinzufuegen(Verbindung ka)
    {
        boolean kanteBereitsEnthalten = false;
        
        for(Verbindung k : _kantenmenge)
        {
            if(k.gibKnoten1() == ka.gibKnoten1() && k.gibKnoten2() == ka.gibKnoten2() || k.gibKnoten1() == ka.gibKnoten2() && k.gibKnoten2() == ka.gibKnoten1())
            {
                kanteBereitsEnthalten = true;
                break;
            }
        }
        
        if(!kanteBereitsEnthalten)
        {
            _kantenmenge.add(ka);
            ka.gibKnoten1().fuegeNachbarHinzu(ka.gibKnoten2());
            ka.gibKnoten2().fuegeNachbarHinzu(ka.gibKnoten1());
        }
    }
    
    /**
     * entfernt eine Kante
     * 
     * @param Kante, die entfernt werden soll
     */
    public void kanteEntfernen(Verbindung ka)
    {
        if(_kantenmenge.remove(ka))
        {
            ka.gibKnoten1().entferneNachbarn(ka.gibKnoten2());
            ka.gibKnoten2().entferneNachbarn(ka.gibKnoten1());
        }
    }

    /**
     * gibt die Menge der Knoten zurück
     * 
     * @return die Knotenmenge
     */
    public HashSet<Knoten> gibKnotenmenge()
    {
        return _knotenmenge;
    }
    
    /**
     * gibt die Menge der Kanten zurück
     * 
     * @return die Kantenmenge
     */
    public HashSet<Verbindung> gibKantenmenge()
    {
        return _kantenmenge;
    }
}
