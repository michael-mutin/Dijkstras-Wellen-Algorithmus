
/**
 * implementiert eine Verbindung zwischen 2 Knoten
 * 
 * @author Michael Mutin
 * @version 1.0
 */
public class Verbindung
{
    private Knoten _knoten1;
    private Knoten _knoten2;
    private int _gewicht;
    
    /**
     * erstellt eine Verbindung zwischen 2 Knoten. Die Verbindung hat ein Gewicht von 1
     * 
     * @param knoten1 der erste Knoten
     * @param knoten2 der zweite Knoten
     */
    public Verbindung(Knoten knoten1, Knoten knoten2)
    {
        _knoten1 = knoten1;
        _knoten2 = knoten2;
        _gewicht = 1;
    }
    
    /**
     * erstellet eine Verbindung zwischen 2 Knoten. Das Verbindungsgewicht ist mit anzugeben
     * 
     * @param knoten1 der erste Knoten
     * @param knoten2 der zweite Knoten
     * @param gewicht das Gewicht der Verbindung
     */
    public Verbindung(Knoten knoten1, Knoten knoten2, int gewicht)
    {
        _knoten1 = knoten1;
        _knoten2 = knoten2;
        _gewicht = gewicht;
    }
    
    /**
     * gibt das Gewicht der Verbindung zurück
     * 
     * @return das Gewicht der Verbindung
     */
    public int gibGewicht()
    {
        return _gewicht;
    }
    
    /**
     * gibt den ersten Knoten der Verbindung zurück
     * 
     * @return der erste Knoten der Verbindung
     */
    public Knoten gibKnoten1()
    {
        return _knoten1;
    }
    
    /**
     * gibt den zweiten Knoten der Verbindung zurück
     * 
     * @return der zweite Knoten der Verbindung
     */
    public Knoten gibKnoten2()
    {
        return _knoten2;
    }
}
