
/**
 * implementiert eine Kante, die 2 Knoten miteinander verbindet
 * 
 * @author Michael Mutin
 * @version 0.1
 */
public class Kante
{
    private Knoten _knoten1;
    private Knoten _knoten2;
    private int _gewicht;
    
    public Kante(Knoten knoten1, Knoten knoten2)
    {
        _knoten1 = knoten1;
        _knoten2 = knoten2;
        _gewicht = 1;
    }
    
    public Kante(Knoten knoten1, Knoten knoten2, int gewicht)
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
