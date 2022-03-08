
/**
 * implementiert eine Verbindung zwischen 2 Knoten
 * 
 * @author Michael Mutin
 * @version 0.2
 */
public class Verbindung
{
    private Knoten _knoten1;
    private Knoten _knoten2;
    private int _gewicht;
    
    public Verbindung(Knoten knoten1, Knoten knoten2)
    {
        _knoten1 = knoten1;
        _knoten2 = knoten2;
        _gewicht = 1;
    }
    
    public Verbindung(Knoten knoten1, Knoten knoten2, int gewicht)
    {
        _knoten1 = knoten1;
        _knoten2 = knoten2;
        _gewicht = gewicht;
    }
    
    public int gibGewicht()
    {
        return _gewicht;
    }
    
    public Knoten gibKnoten1()
    {
        return _knoten1;
    }
    
    public Knoten gibKnoten2()
    {
        return _knoten2;
    }
}
