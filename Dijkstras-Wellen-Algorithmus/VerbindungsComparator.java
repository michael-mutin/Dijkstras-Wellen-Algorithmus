import java.util.Comparator;

/**
 * vergleicht Verbindungen nach ihrem Gewicht
 * 
 * @author Michael Mutin
 * @version 1.0
 */
public class VerbindungsComparator implements Comparator<Verbindung>
{
    public VerbindungsComparator()
    {
        
    }
    
    @Override
    public int compare(Verbindung v1, Verbindung v2)
    {
        int gewichtsDifferenz = v1.gibGewicht() - v2.gibGewicht();
        return gewichtsDifferenz;
    }
}
