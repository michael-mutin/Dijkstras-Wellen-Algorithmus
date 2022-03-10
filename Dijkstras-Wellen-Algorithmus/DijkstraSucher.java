import java.util.HashSet;
import java.util.LinkedList;
import java.util.Collections;
/**
 * DijkstraSucher findet mithilfe von Dijkstras Wellen-Algorithmus die kürzeste Verbindung zwischen 2 Knoten
 * 
 * @author Michael Mutin
 * @version 1.0.1
 */
public class DijkstraSucher
{
    private final Graph _zuUntersuchenderGraph;
    private Knoten _startknoten;
    private Knoten _zielknoten;
    
    private HashSet<Verbindung> _gewaehltMenge;
    private LinkedList<Verbindung> _randliste;
    private HashSet<Knoten> _unerreichteKnotenMenge;
    
    private HashSet<Knoten> _gewaehlteKnotenMenge;
    private HashSet<Knoten> _randknotenmenge;
    private Verbindung _aktuelleVerbindung;

    /**
     * DijkstraSucher-Konstruktor
     * 
     * @param zuUntersuchenderGraph der Graph, der untersucht werden muss
     * @param startknoten der Startknoten
     * @param zielknoten der Knoten, zu dem der kürzeste Weg gefunden werden muss
     */
    public DijkstraSucher(Graph zuUntersuchenderGraph, Knoten startknoten, Knoten zielknoten)
    {
        _zuUntersuchenderGraph = zuUntersuchenderGraph;
        _startknoten = startknoten;
        _zielknoten = zielknoten;
        _gewaehltMenge = new HashSet();
        _randliste = new LinkedList();
        _unerreichteKnotenMenge = new HashSet();
        _randknotenmenge = new HashSet();
        _gewaehlteKnotenMenge = new HashSet();
    }
    
    /**
     * findet den kürzesten Weg vom Startknoten zum Zielknoten
     * 
     * @return Weglänge des kürzesten Weges
     */
    public int wegFinden()
    {
        algorithmusStartInitialisieren();
        while(!_randknotenmenge.isEmpty())
        {
            _aktuelleVerbindung = _randliste.removeFirst();
            Knoten nextRandknoten = _aktuelleVerbindung.gibKnoten1();
            _randknotenmenge.remove(nextRandknoten);
            _gewaehltMenge.add(_aktuelleVerbindung);
            _gewaehlteKnotenMenge.add(_aktuelleVerbindung.gibKnoten1());
            if(nextRandknoten == _zielknoten)
            {
                int weglaenge = _aktuelleVerbindung.gibGewicht();
                gibWegAus();
                return weglaenge;
            }
            else
            {
                randlisteAktualisieren();
            }
        }
        System.out.println("Kein Weg gefunden");
        return -1;
    }
    
    /**
     * schreibt den Weg auf die Konsole
     */
    private void gibWegAus()
    {
        String wegString = " Gesamtlaenge: " + _aktuelleVerbindung.gibGewicht();
        Knoten aktuellerKnoten = _aktuelleVerbindung.gibKnoten1();
        Knoten vorgaengerKnoten = _aktuelleVerbindung.gibKnoten2();
        
        while(aktuellerKnoten != vorgaengerKnoten)
        {
            wegString = " --" + sucheNachKantengewicht(aktuellerKnoten, vorgaengerKnoten) + "-- " + aktuellerKnoten.gibName() + wegString;
            aktuellerKnoten = vorgaengerKnoten;
            
            for(Verbindung gewaehlteVerbindung : _gewaehltMenge)
            {
                if(gewaehlteVerbindung.gibKnoten1() == aktuellerKnoten)
                {
                    _aktuelleVerbindung = gewaehlteVerbindung;
                    vorgaengerKnoten = _aktuelleVerbindung.gibKnoten2();
                    break;
                }
            }
        }
        
        wegString = aktuellerKnoten.gibName() + wegString;
        System.out.println(wegString);
    }
    
    /**
     * Anfang des Wellen-Algorithmus
     */
    private void algorithmusStartInitialisieren()
    {
        for(Knoten kn : _zuUntersuchenderGraph.gibKnotenmenge())
        {
            if(kn != _startknoten) _unerreichteKnotenMenge.add(kn);
        }
        
        Verbindung initialVerbindung = new Verbindung(_startknoten, _startknoten, 0);
        _gewaehltMenge.add(initialVerbindung);
        _gewaehlteKnotenMenge.add(_startknoten);
        _aktuelleVerbindung = initialVerbindung;
        
        randlisteAktualisieren();
    }
    
    /**
     * aktualisiert die Randliste -- fügt eventuell neue Knoten hinzu
     */
    private void randlisteAktualisieren()
    {
        Knoten aktuellerKnoten = _aktuelleVerbindung.gibKnoten1();
        
        for(Knoten nachbar : aktuellerKnoten.gibDirekteNachbarn())
        {
            if(!_gewaehlteKnotenMenge.contains(nachbar))
            {
                int verbindungsgewicht = sucheNachKantengewicht(nachbar, aktuellerKnoten) + _aktuelleVerbindung.gibGewicht();
                if(istInRandknotenmenge(nachbar))
                {
                    for(Verbindung randVerbindung : _randliste)
                    {
                        if(randVerbindung.gibKnoten1() == nachbar)
                        {
                            if(randVerbindung.gibGewicht() > verbindungsgewicht)
                            {
                                Verbindung kuerzereVerbindung = new Verbindung(nachbar, aktuellerKnoten, verbindungsgewicht);
                                int austauschStelle = _randliste.indexOf(randVerbindung);
                                _randliste.set(austauschStelle, kuerzereVerbindung);
                            }
                            break;
                        }
                }
                }
                else
                {
                    _randknotenmenge.add(nachbar);
                    _randliste.add(new Verbindung(nachbar, aktuellerKnoten, verbindungsgewicht));
                }
            }
            
            randlisteSortieren();
        }
    }
    
    /**
     * sortiert die Randliste in aufsteigender Reihenfole
     */
    private void randlisteSortieren()
    {
        Collections.sort(_randliste, new VerbindungsComparator());
    }
    
    /**
     * sucht das Kantengewicht zwischen zwei Knoten, die miteinander verbunden sind
     * 
     * @param knoten1 der erste Knoten der Kante
     * @param knoten2 der zweite Knoten der Kante
     * 
     * @return das Kantengewicht
     */
    private int sucheNachKantengewicht(Knoten knoten1, Knoten knoten2)
    {
        for(Verbindung ka : _zuUntersuchenderGraph.gibKantenmenge())
        {
            if(knoten1 == ka.gibKnoten1() && knoten2 == ka.gibKnoten2() || knoten1 == ka.gibKnoten2() && knoten2 == ka.gibKnoten1())
            {
                return ka.gibGewicht();
            }
        }
        return -1;
    }
    
    /**
     * guckt, ob ein Knoten in der Randknotenmenge ist
     * 
     * @param kn Knoten, bei dem man sich fragt, ob dieser in der Randknotenmenge ist
     * 
     * @return ob der Knoten in der Randknotenmenge ist
     */
    private boolean istInRandknotenmenge(Knoten kn)
    {
        for(Knoten randknoten : _randknotenmenge)
        {
            if(kn == randknoten)
            {
                return true;
            }
        }
        return false;
    }
}
