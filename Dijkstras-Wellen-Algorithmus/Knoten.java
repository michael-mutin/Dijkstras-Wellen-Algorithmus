import java.util.HashSet;
/**
 * implementiert einen Knoten eines Graphen
 * 
 * @author Michael Mutin 
 * @version 1.0
 */
public class Knoten
{
    private HashSet<Knoten> _direkteNachbarn;
    
    /**
     * erstellt einen Knoten ohne Nachbarn
     */
    public Knoten()
    {
        _direkteNachbarn = new HashSet();
    }
    
    /**
     * fügt einen Nachbarn hinzu
     * 
     * @param nachbar Nachbar, der hinzugefügt werden soll
     */
    public void fuegeNachbarHinzu(Knoten nachbar)
    {
        _direkteNachbarn.add(nachbar);
    }
    
    /**
     * entfernt einen Nachbarn
     * 
     * @param nachbar Nachbar, der entfernt werden soll
     */
    public void entferneNachbarn(Knoten nachbar)
    {
        _direkteNachbarn.remove(nachbar);
    }
    
    /**
     * gibt die Menge der Nachbarn zurück
     * 
     * @return die Menge der Nachbarn
     */
    public HashSet<Knoten> gibDirekteNachbarn()
    {
        return _direkteNachbarn;
    }
    
    /*
    public boolean hatKanteMit(Knoten kn)
    {
        for(Knoten nachbar : _direkteNachbarn)
        {
            if(kn == nachbar)
            {
                return true;
            }
        }
        return false;
    }
    */
}
