import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import prog2.model.*;
import prog2.vista.ExcepcioCamping;

public class LlistaAllotjamentsTest {
    private LlistaAllotjaments llistaAll;
    private Parcela parc;
    private Bungalow bung;

    // Inicialitza la llista amb alguns allotjaments
    @BeforeEach
    public void inicialitzar() throws ExcepcioCamping {
        llistaAll = new LlistaAllotjaments();
        parc = new Parcela("Parcel·la Nord", "ALL1", 5, 3, true, "100", 64, true);
        bung = new Bungalow("Bungalow Nord", "ALL3", 7, 5, true, "50", 22, 2, 4, 1, true, true, true);
        llistaAll.afegirAllotjament(parc);
    }

    // Comprova que es pot afegir un nou allotjament
    @Test
    public void testAfegirAllotjament() throws ExcepcioCamping {
        llistaAll.afegirAllotjament(bung);
        assertEquals(bung, llistaAll.getAllotjament("ALL3"));
    }

    // Comprova que no es poden afegir duplicats
    @Test
    public void testAfegirDuplicat() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAll.afegirAllotjament(parc);
        });
    }

    // Comprova la recuperació d'un allotjament existent
    @Test
    public void testGetAllotjament() throws ExcepcioCamping {
        assertEquals(parc, llistaAll.getAllotjament("ALL1"));
    }

    // Comprova que es llença excepció si no existeix
    @Test
    public void testGetAllotjamentInexistent() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAll.getAllotjament("ALL99");
        });
    }

    // Comprova que es poden llistar tots els allotjaments
    @Test
    public void testLlistarTots() throws ExcepcioCamping {
        String resultat = llistaAll.llistarAllotjaments(true) + llistaAll.llistarAllotjaments(false);
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    // Comprova que hi ha allotjaments operatius
    @Test
    public void testLlistarOperatius() throws ExcepcioCamping {
        String resultat = llistaAll.llistarAllotjaments(true);
        assertNotNull(resultat);
        assertFalse(resultat.isEmpty());
    }

    // Comprova que si no hi ha no operatius es llença excepció
    @Test
    public void testLlistarNoOperatius() {
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAll.llistarAllotjaments(false);
        });
    }

    // Comprova el comportament amb la llista buida
    @Test
    public void testLlistaBuida() {
        llistaAll.buidar();
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAll.llistarAllotjaments(true);
        });
    }

    // Comprova si hi ha almenys un allotjament operatiu
    @Test
    public void testContainsOperatiu() {
        assertTrue(llistaAll.containsAllotjamentOperatiu());
    }

    // Comprova si la llista conté un allotjament concret
    @Test
    public void testContainsAllotjament() {
        assertTrue(llistaAll.contains(parc));
    }

    // Comprova que buidar elimina els allotjaments
    @Test
    public void testBuidarLlista() {
        llistaAll.buidar();
        assertThrows(ExcepcioCamping.class, () -> {
            llistaAll.getAllotjament("ALL1");
        });
    }
}