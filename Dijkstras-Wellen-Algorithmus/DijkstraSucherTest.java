

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Die Test-Klasse DijkstraSucherTest.
 *
 * @author  Michael Mutin
 */
public class DijkstraSucherTest
{
    /**
     * Konstruktor fuer die Test-Klasse DijkstraSucherTest
     */
    public DijkstraSucherTest()
    {
    }

    @Test
    public void dreiKnotenTest()
    {
        Graph dreiKnotenGraph = new Graph();
        
        Knoten alpha = new Knoten("alpha");
        Knoten beta = new Knoten("beta");
        Knoten gamma = new Knoten("gamma");
        Verbindung ab = new Verbindung(alpha,beta,7);
        Verbindung bg = new Verbindung(beta, gamma, 9);
        
        dreiKnotenGraph.knotenHinzufuegen(alpha);
        dreiKnotenGraph.knotenHinzufuegen(beta);
        dreiKnotenGraph.knotenHinzufuegen(gamma);
        dreiKnotenGraph.kanteHinzufuegen(ab);
        dreiKnotenGraph.kanteHinzufuegen(bg);
        
        DijkstraSucher triDij = new DijkstraSucher(dreiKnotenGraph, alpha, gamma);
        assertEquals(16, triDij.wegFinden());
    }
    
    @Test
    public void schnelltest()
    {
        Graph schnellGraph = new Graph();
        
        Knoten x = new Knoten("x");
        Knoten y = new Knoten("y");
        Verbindung xy = new Verbindung(x,y,3);
        
        schnellGraph.knotenHinzufuegen(x);
        schnellGraph.knotenHinzufuegen(y);
        schnellGraph.kanteHinzufuegen(xy);
        
        DijkstraSucher dijSchnell = new DijkstraSucher(schnellGraph, x, y);
        assertEquals(3, dijSchnell.wegFinden());
    }
    
    @Test
    public void vorlesungsbeispiel()
    {
        Graph testGraph = new Graph();
        
        Knoten a = new Knoten("a");
        Knoten b = new Knoten("b");
        Knoten c = new Knoten("c");
        Knoten d = new Knoten("d");
        Knoten e = new Knoten("e");
        Knoten f = new Knoten("f");
        Knoten g = new Knoten("g");
        Knoten h = new Knoten("h");
        Knoten i = new Knoten("i");
        Knoten s = new Knoten("s");
        Knoten z = new Knoten("z");
        
        testGraph.knotenHinzufuegen(a);
        testGraph.knotenHinzufuegen(b);
        testGraph.knotenHinzufuegen(c);
        testGraph.knotenHinzufuegen(d);
        testGraph.knotenHinzufuegen(e);
        testGraph.knotenHinzufuegen(f);
        testGraph.knotenHinzufuegen(g);
        testGraph.knotenHinzufuegen(h);
        testGraph.knotenHinzufuegen(i);
        testGraph.knotenHinzufuegen(s);
        testGraph.knotenHinzufuegen(z);
        
        Verbindung v1 = new Verbindung(s,a,14);
        Verbindung v2 = new Verbindung(s,c,13);
        Verbindung v3 = new Verbindung(a,c,9);
        Verbindung v4 = new Verbindung(a,b,6);
        Verbindung v5 = new Verbindung(c,b,11);
        Verbindung v6 = new Verbindung(a,d,17);
        Verbindung v7 = new Verbindung(c,f,8);
        Verbindung v8 = new Verbindung(c,g,10);
        Verbindung v9 = new Verbindung(b,f,17);
        Verbindung v10 = new Verbindung(g,i,22);
        Verbindung v11 = new Verbindung(i,z,8);
        Verbindung v12 = new Verbindung(z,h,9);
        Verbindung v13 = new Verbindung(f,e,9);
        Verbindung v14 = new Verbindung(h,e,7);
        Verbindung v15 = new Verbindung(d,e,6);
        Verbindung v16 = new Verbindung(h,d,12);
        
        testGraph.kanteHinzufuegen(v1);
        testGraph.kanteHinzufuegen(v2);
        testGraph.kanteHinzufuegen(v3);
        testGraph.kanteHinzufuegen(v4);
        testGraph.kanteHinzufuegen(v5);
        testGraph.kanteHinzufuegen(v6);
        testGraph.kanteHinzufuegen(v7);
        testGraph.kanteHinzufuegen(v8);
        testGraph.kanteHinzufuegen(v1);
        testGraph.kanteHinzufuegen(v10);
        testGraph.kanteHinzufuegen(v11);
        testGraph.kanteHinzufuegen(v12);
        testGraph.kanteHinzufuegen(v13);
        testGraph.kanteHinzufuegen(v14);
        testGraph.kanteHinzufuegen(v15);
        testGraph.kanteHinzufuegen(v16);
        
        DijkstraSucher dijSearch = new DijkstraSucher(testGraph, s, z);
        assertEquals(46, dijSearch.wegFinden());
    }
    
    /**
     *  Setzt das Testgerüst fuer den Test.
     *
     * Wird vor jeder Testfall-Methode aufgerufen.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Gibt das Testgerüst wieder frei.
     *
     * Wird nach jeder Testfall-Methode aufgerufen.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
