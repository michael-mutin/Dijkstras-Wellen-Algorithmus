import java.util.HashSet;
/**
 * implementiert einen Knoten eines Graphen
 * 
 * @author Michael Mutin 
 * @version 1.0.1
 */
public class Knoten
{
    private HashSet<Knoten> _direkteNachbarn;
    private String _name;
    
    /**
     * erstellt einen Knoten ohne Nachbarn
     * 
     * @param name Bezeichnung des Knotens
     */
    public Knoten(String name)
    {
        _name = name;
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
    
    /**
     * gib den Namen des Knotens zurück
     * 
     * @return der Name
     */
    public String gibName()
    {
        return _name;
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
