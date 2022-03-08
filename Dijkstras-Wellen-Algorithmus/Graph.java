import java.util.*;
/**
 * implementiert einen Graphen mit Kanten und Knoten
 * 
 * @author Michael Mutin 
 * @version 0.2
 */
public class Graph
{
    private HashSet<Knoten> _knotenmenge;
    private HashSet<Verbindung> _kantenmenge;
    
    public Graph()
    {
        _knotenmenge = new HashSet();
        _kantenmenge = new HashSet();
    }
    
    public void knotenHinzufügen(Knoten kn)
    {
        _knotenmenge.add(kn);
    }
    
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
    
    public void kanteHinzufügen(Verbindung ka)
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
    
    public void kanteEntfernen(Verbindung ka)
    {
        if(_kantenmenge.remove(ka))
        {
            ka.gibKnoten1().entferneNachbarn(ka.gibKnoten2());
            ka.gibKnoten2().entferneNachbarn(ka.gibKnoten1());
        }
    }
    
    public HashSet<Knoten> gibKnotenmenge()
    {
        return _knotenmenge;
    }
    
    public HashSet<Verbindung> gibKantenmenge()
    {
        return _kantenmenge;
    }
}
