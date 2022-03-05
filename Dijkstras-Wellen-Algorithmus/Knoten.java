import java.util.*;
/**
 * implementiert einen Knoten eines Graphen
 * 
 * @author Michael Mutin 
 * @version 0.1
 */
public class Knoten
{
    private HashSet<Knoten> _direkteNachbarn;
    
    public Knoten()
    {
        _direkteNachbarn = new HashSet();
    }
    
    public void fuegeNachbarHinzu(Knoten nachbar)
    {
        _direkteNachbarn.add(nachbar);
    }
    
    public void entferneNachbarn(Knoten nachbar)
    {
        _direkteNachbarn.remove(nachbar);
    }
}
